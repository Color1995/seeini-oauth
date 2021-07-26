package com.seeini.common.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

/**
 * @Author Vincent
 * @Date 2021/7/26 14:07
 * @Version 1.0
 * @Description
 */
public class JwtUtil {
    /**
     * 获得token中的信息无需secret解密也能获得
     * @return token中包含的签发时间
     */
    public static LocalDateTime getIssueAt(String token){
        DecodedJWT jwt = JWT.decode(token);
        java.util.Date date = jwt.getIssuedAt();
        Instant instant = date.toInstant();
        ZoneId zone = ZoneId.systemDefault();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zone);
        return localDateTime;
    }

    /**
     * 获得token中的信息无需secret解密也能获得
     * @return token中包含的用户名
     */
    public static String getUsername(String token){
        DecodedJWT jwt = JWT.decode(token);
        return jwt.getClaim("username").asString();
    }

    /**
     * 生成签名,expireTime后过期
     * @param username 用户名
     * @param expireTime 过期时间s
     * @return 加密的token
     */
    public static String sign(String username, String salt, long expireTime) {
        Date date = new Date(System.currentTimeMillis()+expireTime*1000);
        Algorithm algorithm= Algorithm.HMAC256(salt);
        //
        return JWT.create()
                .withClaim("username",username)
                .withExpiresAt(date)
                .withIssuedAt(new Date())
                .sign(algorithm);
    }

    /**
     * token是否过期
     * @return true：过期
     */
    public static boolean isTokenExpired(String token){
        Date now = Calendar.getInstance().getTime();
        DecodedJWT jwt = JWT.decode(token);
        return jwt.getExpiresAt().before(now);
    }

    /**
     * 生成随机盐,长度32位
     * @return
     */
    public static String generateSalt(){
        SecureRandomNumberGenerator secureRandom = new SecureRandomNumberGenerator();
        String hex = secureRandom.nextBytes(16).toHex();
        return hex;
    }
}
