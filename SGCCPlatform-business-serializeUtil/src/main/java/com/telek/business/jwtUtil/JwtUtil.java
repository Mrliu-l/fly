package com.telek.business.jwtUtil;

import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.MACVerifier;
import net.minidev.json.JSONObject;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author liu_l
 * @email: liu_lei_programmer@163.com
 * @time 2018/12/20 20:06
 * @Description: 描述:tooken传输校验类：jwtUtil
 */
public class JwtUtil {
    /**
     * 描述 :生成签名的秘钥：TELEK20181221，经过AES加密（不可泄露）
     */
    protected static final byte[] SECRET = "113d4432456d21ae8ab1561582fbd62e".getBytes();

    /**
     * 描述 :初始化head部分的数据为{"alg":"HS256"};加密算法采用：HS256
     */
    protected static final JWSHeader header = new JWSHeader(JWSAlgorithm.HS256);

    /**
     * 描述 :设置tooken过期时间，过期时间为1天
     */
    protected static final int calendarField = Calendar.MINUTE;

    /**
     * 描述 :获取tooken过期时间，默认为10分钟不操作失效
     */
    protected static final int calendarInterval = 10;

    /**
     * @author liu_l
     * @created 2018/12/20 20:12
     * @email: liu_lei_programmer@163.com
     * @param payloadMap：uid:用户id_uap生产的cookie; userid:登录账号； logincompcode：登录单位； compcode：查询单位
     * @return java.lang.String ： oken字符串,若失败则返回null
     * TODO 简要描述方法的作用:
    生成Token
     * TODO(这里描述这个方法的注意事项 – 可选)
    该方法只在用户登录成功后调用一次
     */
    public static String createToken(JSONObject payloadMap) throws JOSEException {
        //1、构建完整的负载Payload;置入过期时间
        payloadMap.put("exp", getExpTime());
        //2、建立一个载荷Payload
        Payload payload = new Payload(payloadMap);
        //3、将头部和载荷结合在一起
        JWSObject jwsObject = new JWSObject(header, payload);
        //4、建立一个密匙
        JWSSigner jwsSigner = new MACSigner(SECRET);
        //5、签名
        jwsObject.sign(jwsSigner);
        //6、生成token
        return jwsObject.serialize();
    }

    /**
     * @author liu_l
     * @created 2018/12/20 20:18
     * @email: liu_lei_programmer@163.com
     * @param token
     * @return java.util.Map<java.lang.String,java.lang.Object> ：返回Map集合,集合中主要包含：state状态码,载荷json对象
     * TODO 简要描述方法的作用：
    校验token是否合法；data鉴权成功后从token中提取的数据，校验其它信息是否合法
     * TODO(这里描述这个方法适用条件 – 可选)
    该方法在过滤器中调用，每次请求API时都校验
     * TODO(这里描述这个方法的执行流程 – 可选)
    1、解析token
    2、获取到载荷
    3、建立解锁密匙
    4、核实token是否合法
     * TODO(这里描述这个方法的注意事项 – 可选)
    业务人员请勿修改
     */
    public static Map<String, Object> validToken(String token) {
        Map<String, Object> rtnMap = new HashMap<>();
        //默认初始校验状态为通过
        CheckJwtResultType validTokenState = null;
        try {
            //1、解析token
            JWSObject jwsObject = JWSObject.parse(token);
            //2、获取到载荷
            Payload payload = jwsObject.getPayload();
            //3、建立解锁密匙
            JWSVerifier verifier = new MACVerifier(SECRET);
            //4、核实token是否合法
            if (jwsObject.verify(verifier)) {
                //载荷的数据解析成json对象
                JSONObject jsonOBj = payload.toJSONObject();
                rtnMap.put("payload", jsonOBj);
                //校验是否过期、违法
                validTokenState = checkExpired(jsonOBj);
            } else {
                // 校验失败：设置状态：tooken不合法
                validTokenState = CheckJwtResultType.INVALID;
            }

        } catch (Exception e) {
            // token格式不合法导致的异常
            validTokenState =  CheckJwtResultType.INVALID;
        }
        rtnMap.put("checkresult", validTokenState);
        return rtnMap;
    }

    /**
     * @author liu_l
     * @created 2018/12/21 11:28
     * @email: liu_lei_programmer@163.com
     * @param jsonOBj: token载荷
     * @return boolean ：校验通过返回true
     * TODO 简要描述方法的作用：
    校验token是否过期
     */
    private static CheckJwtResultType checkExpired(JSONObject jsonOBj){
        //校验载荷中必含字段
        if(!checkPayload(jsonOBj)){
            return CheckJwtResultType.INVALID;
        }
        // 若payload包含exp过期字段，则校验是否过期
        if (jsonOBj.containsKey("exp")) {
            long expTime = Long.valueOf(jsonOBj.get("exp").toString());
            long curTime = new Date().getTime();
            if (curTime > expTime) {// 过期
                return CheckJwtResultType.EXPIRED;
            }
        }
        //如果不包含过期时间，则为登陆后首次访问，无需校验过期时间
        return CheckJwtResultType.OK;
    }

    /**
     * @author liu_l
     * @created 2018/12/21 10:47
     * @email: liu_lei_programmer@163.com
     * @return  ：返回过期时间戳
     * TODO 简要描述方法的作用：获取tooken过期时间，默认为10分钟不操作失效
     */
    protected static long getExpTime(){
        Calendar nowTime = Calendar.getInstance();
        nowTime.add(calendarField, calendarInterval);
        long expiresTime = nowTime.getTime().getTime();
        return expiresTime;
    }

    /**
     * @author liu_l
     * @created 2018/12/21 16:13
     * @email: liu_lei_programmer@163.com
     * @param jsonOBj : token载荷
     * @return boolean ：校验通过返回true
     * TODO 简要描述方法的作用：
    校验token中载荷必须还有字段

     */
    protected static boolean checkPayload(JSONObject jsonOBj){
        if(!jsonOBj.containsKey("cookie") || !jsonOBj.containsKey("userName")){
            return false;
        }
        return true;
    }

}
