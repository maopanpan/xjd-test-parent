package com.hz.xjd.common.utils;

import java.sql.Date;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;

public class EncryptUtil {
	private static final String prefix = "hzxjd";

	/**
	 * md5加密
	 * @param input
	 * @return
	 */
	public static String md5(String input){
		return DigestUtils.md5Hex(input.getBytes());
	}

	/**
	 * md5加密
	 * @param input
	 * @param key
	 * @return
	 */
	public static String md5(String input, String key) {
		return DigestUtils.md5Hex((input + key).getBytes());
	}

	/**
	 * SHA-1加密
	 * @param input
	 * @return
	 */
	@SuppressWarnings("deprecation")
	public static String sha(String input) {
		return DigestUtils.shaHex(input.getBytes());
	}

	/**
	 * SHA-256加密
	 * @param input
	 * @return
	 */
	public static String sha256(String input) {
		return DigestUtils.sha256Hex(input.getBytes());
	}

	/**
	 * SHA-384加密
	 * @param input
	 * @return
	 */
	public static String sha384(String input) {
		return DigestUtils.sha384Hex(input.getBytes());
	}

	/**
	 * SHA-512加密
	 * @param input
	 * @return
	 */
	public static String sha512(String input) {
		return DigestUtils.sha512Hex(input.getBytes());
	}

	/**
	 * Base64加密
	 * @param input
	 * @return
	 */
	public static String base64Encode(String input) {
		return Base64.encodeBase64String(input.getBytes()).trim();
	}

	/**
	 * Base64解密
	 * @param input
	 * @return
	 */
	public static String base64Decode(String input) {
		return new String(Base64.decodeBase64(input));
	}

	/**
	 * Base64加密
	 * @param input
	 * @return
	 */
	public static String encode(String input) {
		long millis = System.currentTimeMillis();//当前时间
		input = base64Encode(prefix + input + millis);//添加时间戳后的密文
		byte[] bytes = input.getBytes();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < bytes.length; i++) {
			String s = Integer.toHexString(bytes[i] + 18);
			sb.append(s.charAt(1)+ ""+ s.charAt(0));
		}
		//倒序
		return reverse(sb.toString());
	}

	/**
	 * 倒序
	 * @param input
	 * @return
	 */
	private static String reverse(String input) {
		byte[] bytes1 = input.getBytes();
		byte[] bytes2 = new byte[bytes1.length];
		for (int i = 0; i < bytes1.length; i++)
		bytes2[i] = bytes1[(bytes1.length - 1 - i)];
		byte byte0 = bytes2[0];
		byte byte1 = bytes2[1];
		bytes2[0] = bytes2[(bytes2.length - 1)];
		bytes2[1] = bytes2[(bytes2.length - 2)];
		bytes2[(bytes2.length - 1)] = byte0;
		bytes2[(bytes2.length - 2)] = byte1;
		return new String(bytes2);
	}

	/**
	 * Base64加密
	 * @param input
	 * @return [明文,时间戳]
	 */
	public static String[] decode(String input) {
		try{
			if (input.length() % 2 != 0) {
				return null;
			}
			//倒序
			input = reverse(input);
			byte[] bytes = new byte[input.length() / 2];
			for (int i = 0; i <= input.length() - 2; i += 2) {
				String hexString = input.substring(i + 1, i + 2) + input.substring(i, i + 1);
				if (!hexString.matches("[0-9a-fA-F]+")) {
					return null;
				}
				bytes[(i / 2)] = (byte)(Integer.parseInt(hexString, 16) - 18);
			}
			String s = new String(bytes);
			//解密
			s = base64Decode(s);
			String s1 = s.substring(0, prefix.length());
			String s3 = s.substring(s.length() - 13);
			if ((!s1.equals(prefix)) || (!s3.matches("\\d+"))) {//解密后，最后13位非时间戳
				return null;
			}

			return new String[] { s.substring(prefix.length(), s.length() - 13), s3 };
		} catch (Exception e) {
		}
		return null;
	}
	  public static void main(String[] args)
	  {
	    System.out.println(new Date(9999999999999L));
	    System.out.println(base64Decode("Ac/6L9OYytU2H1drQ9KIGy9sjP236g=="));
	    System.out.println(encode("jdbc:oracle:thin:@192.168.7.203:1521:orcl"));
	    System.out.println(decode("37578c608b7d7c608c538c5f4579565f435756747c5c457448577c5f43577c618c537c5f87757c5e466b665f875b66618a537d61877e59734282666c8560696b8b4b7f617c5c596c83647f7346825af4")[0]);
	    //System.out.println(decode("c65366601c1f8b67566147757c5f435f56608a89446b8b4b7f618a5b66608a818c5f895b7c5e4546556144577c5e8b7d665f53827c74827a5976486759747c587f7588828c6b7b647f738047696c867e5954")[0]);
	  }
}
