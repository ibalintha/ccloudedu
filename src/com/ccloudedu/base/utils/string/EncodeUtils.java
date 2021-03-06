package com.ccloudedu.base.utils.string;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;

/**
 * 封装Md5加密与校验、各种格式的编码解码工具类.
 * 1.MD5加密与校验
 * 2.Commons-Codec的 hex/base64 编码
 * 3.JDK提供的URLEncoder
 */
public class EncodeUtils {

	private static final String DEFAULT_URL_ENCODING = "UTF-8";
	
	/**
	 * md5加密
	 * @param raw 明文
	 * @return
	 */
	public static String encodeMd5(String raw){
		return Md5Encodes.encodeMd5(raw);
	}

	/**
	 * 验证Md5加密
	 * @param enc 密文
	 * @param raw 明文
	 * @return
	 */
	public static boolean isValidMd5(String enc, String raw){
		return Md5Encodes.isValidMd5(enc, raw);
	}
	
	/**
	 * Hex编码.
	 */
	public static String encodeHex(byte[] input) {
		return Hex.encodeHexString(input);
	}

	/**
	 * Hex解码.
	 */
	public static byte[] decodeHex(String input) {
		try {
			return Hex.decodeHex(input.toCharArray());
		} catch (DecoderException e) {
		}
		return null;
	}

	/**
	 * Base64编码.
	 */
	public static String encodeBase64(byte[] input) {
		return Base64.encodeBase64String(input);
	}

	/**
	 * Base64解码.
	 */
	public static byte[] decodeBase64(String input) {
		return Base64.decodeBase64(input);
	}

	/**
	 * URL 编码, Encode默认为UTF-8. 
	 */
	public static String urlEncode(String part) {
		try {
			return URLEncoder.encode(part, DEFAULT_URL_ENCODING);
		} catch (UnsupportedEncodingException e) {
			//throw Exceptions.unchecked(e);
		}
		return "";
	}

	/**
	 * URL 解码, Encode默认为UTF-8. 
	 */
	public static String urlDecode(String part) {

		try {
			return URLDecoder.decode(part, DEFAULT_URL_ENCODING);
		} catch (UnsupportedEncodingException e) {
			//throw new Exception("");
		}
		return "";
	}
	
	/**
	 * MD5 加密算法
	 * MD5是著名的不可逆算法，
	 * 如果密码丢失，返回给用户的密码为新生成的随机密码，并非其原有的密码
	 * 
	 * @author wade
	 */
	public static class Md5Encodes{  
		
		//种子源
		private  static final String salt = "WADE";
		
		public Md5Encodes(){}
		
		/**
		 * md5加密
		 */
		public static String encodeMd5(String raw) {
			String salted = mergeAndSalt(raw, salt, false);
			MessageDigest messageDigest = getMessageDigest();
			byte[] digest;
			try {
				digest = messageDigest.digest(salted.getBytes("UTF-8"));
			} catch (UnsupportedEncodingException e) {
				throw new IllegalStateException("UTF-8 not supported!");
			}
			return new String(Hex.encodeHex(digest));
		}

		/**
		 * 检查明文和密文是否一样
		 */
		public static boolean isValidMd5(String enc, String raw) {
			return enc.equals(encodeMd5(raw));
		}

		/**
		 * MessageDigest 提供了消息摘要算法，如 MD5 或 SHA，的功能。
		 * 消息摘要是安全单向散列函数，它采用任意大小的数据并输出一个固定长度的散列值。 
	     * 象 Java 安全性中的其它基于算法的类一样，MessageDigest 有两个主要的组件：
		 * @return
		 */
		private static MessageDigest getMessageDigest() {
			//md5加密，16位     SHA:20位
			String algorithm = "MD5";
			try {
				return MessageDigest.getInstance(algorithm);
			} catch (NoSuchAlgorithmException e) {
				throw new IllegalArgumentException("No such algorithm ["+ algorithm + "]");
			}
		}

		private static String mergeAndSalt(String raw, Object salt,boolean strict) {
			if (raw == null) {
				raw = "";
			}
			if (strict && (salt != null)) {
				if ((salt.toString().lastIndexOf("{") != -1)|| (salt.toString().lastIndexOf("}") != -1)) {
					throw new IllegalArgumentException("Cannot use { or } in salt.toString()");
				}
			}
			if ((salt == null) || "".equals(salt)) {
				return raw;
			} else {
				return raw + "{" + salt.toString() + "}";
			}
		}
	} 
}
