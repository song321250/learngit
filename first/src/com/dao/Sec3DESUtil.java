package com.dao;

import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import javax.crypto.spec.IvParameterSpec;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

@SuppressWarnings("restriction")
public class Sec3DESUtil {

	private static String secretKey = "YWJjZGVmZ2hpamtsbW5vcHFyc3R1dnd4";
	private static String iv = "lqb999ss";
	private static String encoding = "UTF-8";

	/**
	 * ECB加密,不要IV
	 * 
	 * @param key
	 *            密钥
	 * @param data
	 *            明文
	 * @return Base64编码的密文
	 * @throws Exception
	 */
	public static byte[] des3EncodeECB(byte[] key, byte[] data) throws Exception {
		Key deskey = null;
		DESedeKeySpec spec = new DESedeKeySpec(key);
		SecretKeyFactory keyfactory = SecretKeyFactory.getInstance("desede");
		deskey = keyfactory.generateSecret(spec);
		Cipher cipher = Cipher.getInstance("desede" + "/ECB/PKCS5Padding");
		cipher.init(Cipher.ENCRYPT_MODE, deskey);
		byte[] bOut = cipher.doFinal(data);
		return bOut;
	}

	/**
	 * ECB解密,不要IV
	 * 
	 * @param key
	 *            密钥
	 * @param data
	 *            Base64编码的密文
	 * @return 明文
	 * @throws Exception
	 */
	public static byte[] des3DecodeECB(byte[] key, byte[] data) throws Exception {
		Key deskey = null;
		DESedeKeySpec spec = new DESedeKeySpec(key);
		SecretKeyFactory keyfactory = SecretKeyFactory.getInstance("desede");
		deskey = keyfactory.generateSecret(spec);
		Cipher cipher = Cipher.getInstance("desede" + "/ECB/PKCS5Padding");
		cipher.init(Cipher.DECRYPT_MODE, deskey);
		byte[] bOut = cipher.doFinal(data);
		return bOut;
	}

	/**
	 * CBC加密
	 * 
	 * @param key
	 *            密钥
	 * @param keyiv
	 *            IV
	 * @param data
	 *            明文
	 * @return Base64编码的密文
	 * @throws Exception
	 */
	public static byte[] des3EncodeCBC(byte[] key, byte[] keyiv, byte[] data) throws Exception {
		Key deskey = null;
		DESedeKeySpec spec = new DESedeKeySpec(key);
		SecretKeyFactory keyfactory = SecretKeyFactory.getInstance("desede");
		deskey = keyfactory.generateSecret(spec);
		Cipher cipher = Cipher.getInstance("desede" + "/CBC/PKCS5Padding");
		IvParameterSpec ips = new IvParameterSpec(keyiv);
		cipher.init(Cipher.ENCRYPT_MODE, deskey, ips);
		byte[] bOut = cipher.doFinal(data);
		return bOut;
	}

	/**
	 * CBC解密
	 * 
	 * @param key
	 *            密钥
	 * @param keyiv
	 *            IV
	 * @param data
	 *            Base64编码的密文
	 * @return 明文
	 * @throws Exception
	 */
	public static byte[] des3DecodeCBC(byte[] key, byte[] keyiv, byte[] data) throws Exception {
		Key deskey = null;
		DESedeKeySpec spec = new DESedeKeySpec(key);
		SecretKeyFactory keyfactory = SecretKeyFactory.getInstance("desede");
		deskey = keyfactory.generateSecret(spec);
		Cipher cipher = Cipher.getInstance("desede" + "/CBC/PKCS5Padding");
		IvParameterSpec ips = new IvParameterSpec(keyiv);
		cipher.init(Cipher.DECRYPT_MODE, deskey, ips);
		byte[] bOut = cipher.doFinal(data);
		return bOut;
	}

	/**
	 * 编码
	 * @param encodeStr
	 * @return
	 * @throws Exception
	 */
	public static String encode(String encodeStr) throws Exception {
		byte[] secretKeyInfo = secretKey.getBytes();
		byte[] keyiv = iv.getBytes();
		byte[] data = encodeStr.getBytes(encoding);
		byte[] encodeStrInfo = des3EncodeCBC(secretKeyInfo,keyiv,data);
		return new BASE64Encoder().encode(encodeStrInfo);
	}
	
	/**
	 * 解码
	 * @param encodeStr
	 * @return
	 * @throws Exception
	 */
	public static String decode(String encodeStr) throws Exception {
		byte[] data = new BASE64Decoder().decodeBuffer(encodeStr);
		byte[] secretKeyInfo = secretKey.getBytes();
		byte[] keyiv = iv.getBytes();
		byte[] decodeStrInfo = des3DecodeCBC(secretKeyInfo,keyiv,data);
		
		return new String(decodeStrInfo,encoding);
	}

	public static void main(String[] args) throws Exception {
		
		System.out.println("加密前:"+"测试3DES");
		
//		String encode = "550E8400E29B11D4A716446655440000";
//		encode =Sec3DESUtil.encode(encode);
//		System.out.println("加密后:"+encode);

        String decode =Sec3DESUtil.decode("e2qVlCOcZjk8ySoyBqyppR6B2WcNd/jB25721UBYUSAVISks3sVmig==");
		
		System.out.println("解密后:"+decode);
	}
	
	@SuppressWarnings("unused")
	private void test() throws Exception{
		byte[] key = new BASE64Decoder().decodeBuffer(secretKey);
		byte[] keyiv = { 1, 2, 3, 4, 5, 6, 7, 8 };

		byte[] data = "中国ABCabc123".getBytes(encoding);

		System.out.println("ECB加密解密");
		byte[] str3 = des3EncodeECB(key, data);
		byte[] str4 = des3DecodeECB(key, str3);
		System.out.println(new BASE64Encoder().encode(str3));
		System.out.println(new String(str4, encoding));
		System.out.println("-----------------------------");
		System.out.println("CBC加密解密");
		byte[] str5 = des3EncodeCBC(key, keyiv, data);
		byte[] str6 = des3DecodeCBC(key, keyiv, str5);
		System.out.println(new BASE64Encoder().encode(str5));
		System.out.println(new String(str6, encoding));
	}
}
