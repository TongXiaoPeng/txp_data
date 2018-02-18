package com.data.web.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpServletRequest;


public class ApiUtil {
	
	public static String getRequestContent(HttpServletRequest request){
		StringBuilder sb = new StringBuilder();
		try {
			Reader reader = request.getReader();
			BufferedReader br = new BufferedReader(reader);
			 String line = null;  
		    while((line = br.readLine())!=null){  
		        sb.append(line);  
		    }  
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sb.toString();
	}
	
	
	public static String MD5Encode(String userid, Long timestamp, String token) throws Exception{
		String encode = null;
		encode = getMD5("user_id=" + userid + "&timestamp=" + timestamp
				+ "&token=" + token);
		return encode;
	}
	
	public static String getMD5(String str) throws Exception{
		MessageDigest md5 = MessageDigest.getInstance("MD5");
		byte[] md5Bytes = md5.digest(str.getBytes("UTF-8"));
		return bytesToHex(md5Bytes);
	}
	
	private static final char[] HEX = { '0', '1', '2', '3', '4', '5', '6', '7',
		'8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
	
	private static final String HEX_DIGITS = "0123456789abcdef";

	private static String bytesToHex(byte[] input) {
		int len = input.length;
		char[] result = new char[len * 2];
		int index = 0;
		for (int i = 0; i < len; i++) {
			byte b = input[i];
			result[index++] = HEX[b >>> 4 & 0xf];
			result[index++] = HEX[b & 0xf];
		}
		return new String(result, 0, result.length);
	}
	
	public static String SHA1(String str){
		str = "DYhG93b0qyJfIxfs2guVo111WwvniR2G0FgaC9mi" + str;
		try {
			MessageDigest digest = java.security.MessageDigest
					.getInstance("SHA-1");
			digest.update(str.getBytes());
			byte messageDigest[] = digest.digest();
			// Create Hex String
			
			StringBuilder sb = new StringBuilder(messageDigest.length * 2);
		    for (int i = 0; i < messageDigest.length; i++) {
		        int b = messageDigest[i] & 0xFF;
		        sb.append(HEX_DIGITS.charAt(b >>> 4)).append(HEX_DIGITS.charAt(b & 0xF));
		    }
		    return sb.toString();
			// 瀛楄妭鏁扮粍杞崲涓�鍗佸叚杩涘埗 鏁�
//			for (int i = 0; i < messageDigest.length; i++) {
//				String shaHex = Integer.toHexString(messageDigest[i] & 0xFF);
//				if (shaHex.length() < 2) {
//					hexString.append(0);
//				}
//				hexString.append(shaHex);
//			}
//			return hexString.toString();

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return "";
		
	}
	
	public static String SHA1ForBaie(String str){
		try {
			MessageDigest digest = java.security.MessageDigest
					.getInstance("SHA-1");
			digest.update(str.getBytes());
			byte messageDigest[] = digest.digest();
			// Create Hex String
			
			StringBuilder sb = new StringBuilder(messageDigest.length * 2);
		    for (int i = 0; i < messageDigest.length; i++) {
		        int b = messageDigest[i] & 0xFF;
		        sb.append(HEX_DIGITS.charAt(b >>> 4)).append(HEX_DIGITS.charAt(b & 0xF));
		    }
		    return sb.toString();
			// 瀛楄妭鏁扮粍杞崲涓�鍗佸叚杩涘埗 鏁�
//			for (int i = 0; i < messageDigest.length; i++) {
//				String shaHex = Integer.toHexString(messageDigest[i] & 0xFF);
//				if (shaHex.length() < 2) {
//					hexString.append(0);
//				}
//				hexString.append(shaHex);
//			}
//			return hexString.toString();

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return "";
		
	}
	
	
	public static String getBaseUrl(HttpServletRequest request){
		String baseUrl = request.getScheme()+"://" + request.getServerName() //鏈嶅姟鍣ㄥ湴鍧� 
                + ":"   
                + request.getServerPort();           //绔彛鍙� 
		
		//TODO 鍙嶅悜浠ｇ悊鍩熷悕璁剧疆锛岀敓浜ф椂闇�墜鍔ㄨ皟鏁�
		if(request.getHeader("x-forwarded-for") != null){
//			baseUrl = "https://dev.bianla.cn";
			baseUrl = "https://api.bianla.cn"; 
		}
		return baseUrl;
		
	}
	
	public static String getPicServerUrl(){
		String baseUrl = "https://pic.bianla.cn";
		
		return baseUrl;
	}
	
	
	
	public static String getWebRootDir(){
		String webRootDir = null;
		webRootDir = ApiUtil.class.getResource("/").getPath();
		webRootDir = webRootDir.substring(0, webRootDir.lastIndexOf("/"));
		webRootDir = webRootDir.substring(0, webRootDir.lastIndexOf("/"));
		webRootDir = webRootDir.substring(0, webRootDir.lastIndexOf("/"));
		return webRootDir;
	}
	
	
	
	
}
