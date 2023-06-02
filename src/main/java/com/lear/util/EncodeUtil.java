package com.lear.util;

import com.lear.exception.Exceptions;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.tomcat.util.codec.binary.Base64;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * 加解码工具类
 * @author 天狗
 */
public class EncodeUtil {

    private static final String DEFAULT_URL_ENCODING = "UTF-8";
    private static final char[] BASE62 = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".toCharArray();

    public EncodeUtil() {
    }

    public static String encodeHex(byte[] input) {
        return new String(Hex.encodeHex(input));
    }

    public static byte[] decodeHex(String input) {
        try {
            return Hex.decodeHex(input.toCharArray());
        } catch (DecoderException var2) {
            throw Exceptions.unchecked(var2);
        }
    }

    public static String encodeBase64(byte[] input) {
        return new String(Base64.encodeBase64(input));
    }

    public static String encodeBase64(String input) {
        try {
            return new String(Base64.encodeBase64(input.getBytes("UTF-8")));
        } catch (UnsupportedEncodingException var2) {
            return "";
        }
    }

    public static byte[] decodeBase64(String input) {
        return Base64.decodeBase64(input.getBytes());
    }

    public static String decodeBase64String(String input) {
        try {
            return new String(Base64.decodeBase64(input.getBytes()), "UTF-8");
        } catch (UnsupportedEncodingException var2) {
            return "";
        }
    }

    public static String encodeBase62(byte[] input) {
        char[] chars = new char[input.length];

        for(int i = 0; i < input.length; ++i) {
            chars[i] = BASE62[(input[i] & 255) % BASE62.length];
        }

        return new String(chars);
    }

    public static String escapeHtml(String html) {
        return StringEscapeUtils.escapeHtml4(html);
    }

    public static String unescapeHtml(String htmlEscaped) {
        return StringEscapeUtils.unescapeHtml4(htmlEscaped);
    }

    public static String escapeXml(String xml) {
        return StringEscapeUtils.escapeXml10(xml);
    }

    public static String unescapeXml(String xmlEscaped) {
        return StringEscapeUtils.unescapeXml(xmlEscaped);
    }

    public static String urlEncode(String part) {
        try {
            return URLEncoder.encode(part, "UTF-8");
        } catch (UnsupportedEncodingException var2) {
            throw Exceptions.unchecked(var2);
        }
    }

    public static String urlDecode(String part) {
        try {
            return URLDecoder.decode(part, "UTF-8");
        } catch (UnsupportedEncodingException var2) {
            throw Exceptions.unchecked(var2);
        }
    }


}
