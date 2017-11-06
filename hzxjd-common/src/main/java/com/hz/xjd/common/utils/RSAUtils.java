package com.hz.xjd.common.utils;

import java.math.BigInteger;
import java.security.InvalidParameterException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Signature;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.RSAPublicKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.sql.SQLException;
import java.util.Date;

import javax.crypto.Cipher;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

/**
 * RSA算法加密/解密工具类。
 */
public class RSAUtils
{

    //private static final Logger LOGGER = LoggerFactory.getLogger(RSAUtils.class);

    /**
     * 算法名称
     */
    private static final String ALGORITHOM = "RSA";

    public static final String SIGNATURE_ALGORITHM="MD5withRSA";

    /**
     * 密钥大小
     */
    private static final int KEY_SIZE = 1024;

    /**
     * 默认的安全服务提供者
     */
    private static final Provider DEFAULT_PROVIDER = new BouncyCastleProvider();

    private static KeyPairGenerator keyPairGen = null;

    private static KeyFactory keyFactory = null;

    /**
     * 缓存的密钥对。
     */
    private static KeyPair oneKeyPair = null;

    public static String defaul_pubK = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCsWfzUXB6HbSBibS9GxUOuJGtaF3Ui0jHSg/tJeFS0qDVKA4O9XldU2YoUqH+ka4x6NXH2eLdDQi6qXG28bWc2J6Kh5quQdYR6muEnm6IKSBd/VI1M5q73Ct1AE0ocTfjhylNC0xstttbCzPhBRXJ3jddIyuPVXixvUNF6GdbVewIDAQAB";
    public static String defaul_priK = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAKxZ/NRcHodtIGJtL0bFQ64ka1oXdSLSMdKD+0l4VLSoNUoDg71eV1TZihSof6RrjHo1cfZ4t0NCLqpcbbxtZzYnoqHmq5B1hHqa4SebogpIF39UjUzmrvcK3UATShxN+OHKU0LTGy221sLM+EFFcneN10jK49VeLG9Q0XoZ1tV7AgMBAAECgYEAqyZRY7B2wJUla5hxMh4CL5QK5tQUhhelUh+uEi9kLmI7SNxknlBo+OFttUX+OxBx14nrOY52rluya4qNjmg17HbfSyHs8chkwgrUjTMl1tq+8BDe/CVx/LC6Kb6Ar1/QBCNPkbdloOOqZNfpkKnEimEy/aPTLM1RCTB5AXljcYECQQDij3eZ404eAbA5DPBnnvYiPYp90IxndurVnoGrRLj+7srDBF507OMRjFzlAfC/jTHs2+LgytgX8pvdOysGt7wpAkEAwr9C10bgK02BB5TeVgSc4NEybKCxgBNw3dQuHle4FYxLAI8p0u7pduR31ZcuffHn/HDwcgpShZTXEIOj38a5AwJAZgsUZX2Z264K/0cyqJlSZw2s6QobkyZekyS3ZrqnUDuhm8DGAogHpgnAdW0wUDZ6PCK1x2XVesPNLBHQSVBMMQJAJtpnqHFwedMtoeiWbwzei4/RApEQuJ+oTeluBgm0JUBnGkZ1rqqRk3HDYq6VzPS9NsUFg4sBqbrnKVlKEXQhJwJAQwk86j+oWQ/HiAMC3wOfJNspeV/1TCWIg4x2BH9eJfcDJvoRJ0O0fkQui3zGPL3+fti+3z21ZOVkGnys6F3epg==";

    private static PublicKey rsaPublicKey;
    private static PrivateKey rsaPrivateKey;

    static
    {
        try
        {
            keyPairGen = KeyPairGenerator.getInstance(ALGORITHOM, DEFAULT_PROVIDER);
            keyFactory = KeyFactory.getInstance(ALGORITHOM, DEFAULT_PROVIDER);
            setRsaKey();

        }
        catch (NoSuchAlgorithmException ex)
        {
            System.err.println(ex.getMessage());
        }
    }

    private RSAUtils()
    {
    }

    /**
     * 生成并返回RSA密钥对。
     */
    private static KeyPair generateKeyPair()
    {
        try
        {
            keyPairGen.initialize(KEY_SIZE,
                new SecureRandom(DateFormatUtils.format(new Date(), "yyyyMMdd").getBytes()));
            oneKeyPair = keyPairGen.generateKeyPair();
            return oneKeyPair;
        }
        catch (InvalidParameterException ex)
        {
            System.err.println("KeyPairGenerator does not support a key length of " + KEY_SIZE + "."+ ex.getMessage());
        }
        catch (NullPointerException ex)
        {
            System.err.println("RSAUtils#KEY_PAIR_GEN is null, can not generate KeyPairGenerator instance."+ ex.getMessage());
        }
        return null;
    }

    /**
     * 返回RSA密钥对。
     */
    public static KeyPair getKeyPair()
    {
        // 直接强制生成密钥对文件，并存入数据库。
        return generateKeyPair();
    }

    /**
     * 根据给定的系数和专用指数构造一个RSA专用的公钥对象。
     *
     * @param modulus        系数。
     * @param publicExponent 专用指数。
     * @return RSA专用公钥对象。
     */
    public static RSAPublicKey generateRSAPublicKey(byte[] modulus, byte[] publicExponent)
    {
        RSAPublicKeySpec publicKeySpec = new RSAPublicKeySpec(new BigInteger(modulus),
            new BigInteger(publicExponent));
        try
        {
            return (RSAPublicKey)keyFactory.generatePublic(publicKeySpec);
        }
        catch (InvalidKeySpecException ex)
        {
            System.err.println("RSAPublicKeySpec is unavailable."+ ex.getMessage());
        }
        catch (NullPointerException ex)
        {
            System.err.println("RSAUtils#KEY_FACTORY is null, can not generate KeyFactory instance."+ ex.getMessage());
        }
        return null;
    }

    /**
     * 根据给定的系数和专用指数构造一个RSA专用的私钥对象。
     *
     * @param modulus         系数。
     * @param privateExponent 专用指数。
     * @return RSA专用私钥对象。
     */
    protected static RSAPrivateKey generateRSAPrivateKey(byte[] modulus, byte[] privateExponent)
    {
        RSAPrivateKeySpec privateKeySpec = new RSAPrivateKeySpec(new BigInteger(modulus),
            new BigInteger(privateExponent));
        try
        {
            return (RSAPrivateKey)keyFactory.generatePrivate(privateKeySpec);
        }
        catch (InvalidKeySpecException ex)
        {
            System.err.println("RSAPrivateKeySpec is unavailable."+ ex.getMessage());
        }
        catch (NullPointerException ex)
        {
            System.err.println("RSAUtils#KEY_FACTORY is null, can not generate KeyFactory instance."+ ex.getMessage());
        }
        return null;
    }

    /**
     * 根据给定的16进制系数和专用指数字符串构造一个RSA专用的私钥对象。
     *
     * @param hexModulus         系数。
     * @param hexPrivateExponent 专用指数。
     * @return RSA专用私钥对象。
     */
    protected static RSAPrivateKey getRSAPrivateKey(String hexModulus, String hexPrivateExponent)
    {
        if (StringUtils.isBlank(hexModulus) || StringUtils.isBlank(hexPrivateExponent))
        {
            System.err.println("hexModulus and hexPrivateExponent cannot be empty. RSAPrivateKey value is null to return.");
        }
        byte[] modulus = null;
        byte[] privateExponent = null;
        try
        {
            modulus = Hex.decodeHex(hexModulus.toCharArray());
            privateExponent = Hex.decodeHex(hexPrivateExponent.toCharArray());
        }
        catch (DecoderException ex)
        {
            System.err.println("hexModulus or hexPrivateExponent value is invalid. return null(RSAPrivateKey).");
        }
        if (modulus != null && privateExponent != null)
        {
            return generateRSAPrivateKey(modulus, privateExponent);
        }
        return null;
    }

    /**
     * 根据给定的16进制系数和专用指数字符串构造一个RSA专用的公钥对象。
     *
     * @param hexModulus        系数。
     * @param hexPublicExponent 专用指数。
     * @return RSA专用公钥对象。
     */
    public static RSAPublicKey getRSAPublidKey(String hexModulus, String hexPublicExponent)
    {
        if (StringUtils.isBlank(hexModulus) || StringUtils.isBlank(hexPublicExponent))
        {
            System.err.println("hexModulus and hexPublicExponent cannot be empty. return null(RSAPublicKey).");
        }
        byte[] modulus = null;
        byte[] publicExponent = null;
        try
        {
            modulus = Hex.decodeHex(hexModulus.toCharArray());
            publicExponent = Hex.decodeHex(hexPublicExponent.toCharArray());
        }
        catch (DecoderException ex)
        {
            System.err.println("hexModulus or hexPublicExponent value is invalid. return null(RSAPublicKey).");
        }
        if (modulus != null && publicExponent != null)
        {
            return generateRSAPublicKey(modulus, publicExponent);
        }
        return null;
    }

    /**
     * 使用指定的公钥加密数据。
     *
     * @param publicKey 给定的公钥。
     * @param data      要加密的数据。
     * @return 加密后的数据。
     */
    public static byte[] encrypt(PublicKey publicKey, byte[] data)
        throws Exception
    {
        Cipher ci = Cipher.getInstance(ALGORITHOM, DEFAULT_PROVIDER);
        ci.init(Cipher.ENCRYPT_MODE, publicKey);
        return ci.doFinal(data);
    }

    /**
     * 使用指定的私钥解密数据。
     *
     * @param privateKey 给定的私钥。
     * @param data       要解密的数据。
     * @return 原数据。
     */
    public static byte[] decrypt(PrivateKey privateKey, byte[] data)
        throws Exception
    {
        Cipher ci = Cipher.getInstance(ALGORITHOM, DEFAULT_PROVIDER);
        ci.init(Cipher.DECRYPT_MODE, privateKey);
        return ci.doFinal(data);
    }

    /**
     * 使用给定的公钥加密给定的字符串。
     * <p/>
     * 若 {@code publicKey} 为 {@code null}，或者 {@code plaintext} 为 {@code null} 则返回 {@code
     * null}。
     *
     * @param publicKey 给定的公钥。
     * @param plaintext 字符串。
     * @return 给定字符串的密文。
     */
    public static String encryptString(PublicKey publicKey, String plaintext)
    {
        if (publicKey == null || plaintext == null)
        {
            return null;
        }
        byte[] data = plaintext.getBytes();
        try
        {
            byte[] en_data = encrypt(publicKey, data);
            return new String(Hex.encodeHex(en_data));
        }
        catch (Exception ex)
        {
            System.err.println(ex.getCause().getMessage());
        }
        return null;
    }

    /**
     * 使用默认的公钥加密给定的字符串。
     * <p/>
     * 若{@code plaintext} 为 {@code null} 则返回 {@code null}。
     *
     * @param plaintext 字符串。
     * @return 给定字符串的密文。
     */
    public static String encryptString(String plaintext)
    {
        if (plaintext == null)
        {
            return null;
        }
        byte[] data = plaintext.getBytes();
        try
        {
            byte[] en_data = encrypt(rsaPublicKey, data);
            return new String(Hex.encodeHex(en_data));
        }
        catch (NullPointerException ex)
        {
            System.err.println("keyPair cannot be null.");
        }
        catch (Exception ex)
        {
            System.err.println(ex.getCause().getMessage());
        }
        return null;
    }

    /**
     * 使用给定的私钥解密给定的字符串。
     * <p/>
     * 若私钥为 {@code null}，或者 {@code encrypttext} 为 {@code null}或空字符串则返回 {@code null}。
     * 私钥不匹配时，返回 {@code null}。
     *
     * @param privateKey  给定的私钥。
     * @param encrypttext 密文。
     * @return 原文字符串。
     */
    public static String decryptString(PrivateKey privateKey, String encrypttext)
    {
        if (privateKey == null || StringUtils.isBlank(encrypttext))
        {
            return null;
        }
        try
        {
            byte[] en_data = Hex.decodeHex(encrypttext.toCharArray());
            byte[] data = decrypt(privateKey, en_data);
            return new String(data);
        }
        catch (Exception ex)
        {
            System.err.println(String.format("\"%s\" Decryption failed. Cause: %s", encrypttext, ex.getCause().getMessage()));
        }
        return null;
    }

    /**
     * 使用默认的私钥解密给定的字符串。
     * <p/>
     * 若{@code encrypttext} 为 {@code null}或空字符串则返回 {@code null}。
     * 私钥不匹配时，返回 {@code null}。
     *
     * @param encrypttext 密文。
     * @return 原文字符串。
     */
    public static String decryptString(String encrypttext)
    {
        if (StringUtils.isBlank(encrypttext))
        {
            return null;
        }
        try
        {
            byte[] en_data = Hex.decodeHex(encrypttext.toCharArray());
            byte[] data = decrypt(rsaPrivateKey, en_data);
            return new String(data);
        }
        catch (NullPointerException ex)
        {
            System.err.println("keyPair cannot be null.");
        }
        catch (Exception ex)
        {
            System.err.println(String.format("\"%s\" Decryption failed. Cause: %s", encrypttext, ex.getMessage()));
        }
        return null;
    }

    /**
     * 使用默认的私钥解密由JS加密（使用此类提供的公钥加密）的字符串。
     *
     * @param encrypttext 密文。
     * @return {@code encrypttext} 的原文字符串。
     * @throws Exception
     * @throws SQLException
     */
    public static String decryptStringByJs(String encrypttext)
        throws Exception
    {
        String isSSL = SystemConfig.getProperty("IS_SSL");
        // 如果是SSL请求，则直接返回
        if(!StringUtils.isBlank(isSSL) && Boolean.valueOf(isSSL))
        {
            return encrypttext;
        }
        if (StringUtils.isBlank(encrypttext))
        {
            return null;
        }
        byte[] en_data = Hex.decodeHex(encrypttext.toCharArray());
        byte[] data = decrypt(rsaPrivateKey, en_data);
        return StringUtils.reverse(new String(data));
    }

    private static void setRsaKey() {
    	String publicKey = SystemConfig.getProperty("rsa.publicKey", defaul_pubK);
    	String privateKey = SystemConfig.getProperty("rsa.privateKey", defaul_priK);
    	byte[] pubkeyBytes;
    	byte[] prikeyBytes;
    	pubkeyBytes = Base64.decodeBase64(publicKey);
    	prikeyBytes = Base64.decodeBase64(privateKey);
    	X509EncodedKeySpec pubKeySpec = new X509EncodedKeySpec(pubkeyBytes);
    	X509EncodedKeySpec priKeySpec = new X509EncodedKeySpec(prikeyBytes);
    	KeyFactory keyFactory;
		try {
			keyFactory = KeyFactory.getInstance(ALGORITHOM);
	    	rsaPublicKey = keyFactory.generatePublic(pubKeySpec);
	    	rsaPrivateKey = keyFactory.generatePrivate(priKeySpec);
		} catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	//***************************签名和验证*******************************
    public static byte[] sign(byte[] data) throws Exception{
    	Signature sig = Signature.getInstance(SIGNATURE_ALGORITHM);
    	sig.initSign(rsaPrivateKey);
    	sig.update(data);
    	return sig.sign();
    }
    public static boolean verify(byte[] data,byte[] sign) throws Exception {
    	Signature sig = Signature.getInstance(SIGNATURE_ALGORITHM);
    	sig.initVerify(rsaPublicKey);
    	sig.update(data);
    	return sig.verify(sign);
    }


}
