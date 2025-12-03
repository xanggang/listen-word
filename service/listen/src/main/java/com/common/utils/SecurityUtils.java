package com.common.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * 安全工具类，提供密码加密和验证等功能
 */
public class SecurityUtils {

    private static final BCryptPasswordEncoder PASSWORD_ENCODER = new BCryptPasswordEncoder();

    /**
     * 对密码进行BCrypt加密
     * @param rawPassword 原始明文密码
     * @return 加密后的密码字符串
     */
    public static String encryptPassword(String rawPassword) {
        if (rawPassword == null || rawPassword.isEmpty()) {
            throw new IllegalArgumentException("Password cannot be null or empty");
        }
        return PASSWORD_ENCODER.encode(rawPassword);
    }

    /**
     * 验证密码是否匹配
     * @param rawPassword 原始明文密码
     * @param encodedPassword 加密后的密码
     * @return 如果密码匹配返回true，否则返回false
     */
    public static boolean matchesPassword(String rawPassword, String encodedPassword) {
        if (rawPassword == null || encodedPassword == null) {
            return false;
        }
        return PASSWORD_ENCODER.matches(rawPassword, encodedPassword);
    }

    public  static String generateToken(String userid) {
        return "token:A111";
    }
}
