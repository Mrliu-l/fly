package com.telek.business.jwtUtil;

import com.auth0.jwt.JWTSigner;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.internal.com.fasterxml.jackson.databind.ObjectMapper;
import com.telek.business.message.Token;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liu_l
 * @email: liu_lei_programmer@163.com
 * @time 2019/1/24 15:16
 * @Description: 描述:
 */
public class JwtUtil {
    private static final String SECRET = "113d4432456d21ae8ab1561582fbd62e";

    private static final String EXP = "exp";

    private static final String PAYLOAD = "payload";

    /**
     * 描述 :获取tooken过期时间，默认为10分钟不操作失效
     */
    protected static final int calendarInterval = 10*60*1000;

    //加密，传入一个对象和有效期
    public static String createToken(Token token) {
        try {
            final JWTSigner signer = new JWTSigner(SECRET);
            final Map<String, Object> claims = new HashMap<String, Object>();
            ObjectMapper mapper = new ObjectMapper();
            String jsonString = mapper.writeValueAsString(token);
            claims.put(PAYLOAD, jsonString);
            claims.put(EXP, System.currentTimeMillis() + calendarInterval);
            return signer.sign(claims);
        } catch(Exception e) {
            return null;
        }
    }

    //解密，传入一个加密后的token字符串和解密后的类型
    public static Token validToken(String jwt) {
        final JWTVerifier verifier = new JWTVerifier(SECRET);
        Token token = new Token();
        try {
            final Map<String,Object> claims= verifier.verify(jwt);
            if (claims.containsKey(EXP) && claims.containsKey(PAYLOAD)) {
                long exp = (Long)claims.get(EXP);
                long currentTimeMillis = System.currentTimeMillis();
                if (exp > currentTimeMillis) {
                    String json = (String)claims.get(PAYLOAD);
                    ObjectMapper objectMapper = new ObjectMapper();
                    token = objectMapper.readValue(json, Token.class);
                    token.setCheckJwtResultType(CheckJwtResultType.OK);
                }else{
                    token.setCheckJwtResultType(CheckJwtResultType.EXPIRED);
                }
            }else{
                token.setCheckJwtResultType(CheckJwtResultType.INVALID);
            }
        } catch (Exception e) {
            token.setCheckJwtResultType(CheckJwtResultType.INVALID);
        }
        return token;
    }
}
