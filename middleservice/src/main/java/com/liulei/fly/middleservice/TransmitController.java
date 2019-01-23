package com.liulei.fly.middleservice;

import com.nimbusds.jose.JOSEException;
import com.telek.business.jwtUtil.JwtUtil;
import com.telek.business.message.Param;
import com.telek.business.protoUtil.SerializeUtil;
import net.minidev.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author liu_l
 * @email: liu_lei_programmer@163.com
 * @time 2019/1/21 17:00
 * @Description: 描述:
 */
@Controller
public class TransmitController {

    private static final Log log = LogFactory.getLog(TransmitController.class);

    private static final String charssetName = "ISO-8859-1";

    @ResponseBody
    @RequestMapping(path = "/transmit")
    public String transmit(@RequestBody Map<String, String> map) throws IOException, NoSuchFieldException, IllegalAccessException {
        long s0 = System.currentTimeMillis();
        String ip = map.get("ip");
        int port = Integer.valueOf(map.get("port"));
        MyHttpClient myHttpClient = new MyHttpClient(ip, port);
        try {
            myHttpClient.setCookies(getCookie(map));
        } catch (JOSEException e) {
            log.error("创建cookie失败");
            e.printStackTrace();
        }
        Map<String,String> paras = new HashMap<String,String>();
        String param = getParam(map);
        paras.put("param", param);
        String url = map.get("url");
        long s1 = System.currentTimeMillis();
        String result = myHttpClient.doPost(url,paras);
        return "中间服务器耗时：" + (s1 - s0) + "||服务器返回数据为：" + result;
    }

    private static String getCookie(Map<String, String> map) throws JOSEException {
        JSONObject payload=new JSONObject();
        Date date=new Date();
        payload.put("cookie", map.get("cookie"));//用户id
        payload.put("userName", map.get("userName"));//登录账号
        payload.put("loginCompCode", map.get("loginCompCode"));//查询单位
        payload.put("compCode", map.get("compCode"));//查询单位
        map.remove("cookie");
        map.remove("userName");
        map.remove("loginCompCode");
        map.remove("compCode");
        payload.put("ext",date.getTime()+1000*60*60);//过期时间1小时
        String token=JwtUtil.createToken(payload);
        return token;
    }

    private static String getParam(Map<String, String> map) throws UnsupportedEncodingException, IllegalAccessException, NoSuchFieldException {
        SerializeUtil.initProtoParam(false);
        Param param = new Param();
        //param.setLoginCompCode(map.get("loginCompCode"));
        //param.setCompCode(map.get("compCode"));
        //param.setItemCode(map.get("itemCode"));
        //param.setItemName(map.get("itemName"));
        //param.setYear(map.get("year"));
        //param.setPlanYear(map.get("planYear"));
        //param.setVolLevel(map.get("volLevel"));
        Class clazz = Param.class;
        Map<String, Object> paramMap = new HashMap<>();
        for(String key : map.keySet()){
            Field declaredField = null;
            try {
                declaredField = clazz.getDeclaredField(key);
                declaredField.setAccessible(true);
                declaredField.set(param,map.get(key));
            } catch (NoSuchFieldException e) {
                paramMap.put(key, map.get(key));
            }
        }
        if(paramMap.size() > 0){
            //没有该字段，则放入map中
            Field declaredField = clazz.getDeclaredField("map");
            declaredField.setAccessible(true);
            declaredField.set(param, paramMap);
        }
        byte[] bytes = SerializeUtil.serialize(param);
        String bytes2String = new String(bytes, charssetName);
        return bytes2String;
    }
}
