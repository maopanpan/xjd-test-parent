/*
 * 文 件 名:  AESPlus.java
 * 版    权:  © 2013 dimeng. All rights reserved.
 * 描    述:  <描述>
 * 修 改 人:  tiger
 * 修改时间:  2014年6月26日
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.hz.xjd.app.abilitys.encryptors;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

import com.hz.xjd.app.utils.DecryptPropertyPlaceholderConfigurer;

/**
 * AES加密解密类
 * <功能详细描述>
 *
 * @author  tiger
 * @version  [版本号, 2014年6月26日]
 */
public class AESPlus
{

    //密钥算法
    private static String send = null;

    private static SecretKeySpec skeySpec = null;

    private static Cipher cipherEncrypt;

    private static Cipher cipherDecrypt;

    private static IvParameterSpec iv;
    static
    {
        try
        {
            send = new String(RSAEncryptor.decryptByPublicKey(
                Base64.decodeBase64(((String)DecryptPropertyPlaceholderConfigurer.getProperties("aes.send"))),
                Base64.decodeBase64((String)DecryptPropertyPlaceholderConfigurer.getProperties("rsa.publicKey"))));
            skeySpec = new SecretKeySpec(send.getBytes("utf-8"), "AES");
            cipherEncrypt = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipherDecrypt = Cipher.getInstance("AES/CBC/PKCS5Padding");
            iv = new IvParameterSpec(new String(RSAEncryptor.decryptByPublicKey(
                Base64.decodeBase64((String)DecryptPropertyPlaceholderConfigurer.getProperties("aes.iv")),
                Base64.decodeBase64((String)DecryptPropertyPlaceholderConfigurer.getProperties("rsa.publicKey"))))
                    .getBytes("utf-8"));
            cipherEncrypt.init(Cipher.ENCRYPT_MODE, skeySpec, iv);
            cipherDecrypt.init(Cipher.DECRYPT_MODE, skeySpec, iv);
        }
        catch (NoSuchAlgorithmException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (NoSuchPaddingException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (InvalidKeyException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (InvalidAlgorithmParameterException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (UnsupportedEncodingException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (Exception e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    /**
     * 加密
     * <功能详细描述>
     * @param sSrc
     * @return
     * @throws Exception
     */
    public static String encrypt(String sSrc)
    {
        try
        {
            return Base64.encodeBase64String(cipherEncrypt.doFinal(sSrc.getBytes("utf-8")));
        }
        catch (IllegalBlockSizeException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (BadPaddingException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (UnsupportedEncodingException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 解密
     * <功能详细描述>
     * @param sSrc
     * @return
     */
    public static String decrypt(String sSrc)
        throws Exception
    {
        try
        {
            return new String(cipherDecrypt.doFinal(Base64.decodeBase64(sSrc)));
        }
        catch (Exception ex)
        {
            return null;
        }
    }

    /**
     * 解密
     * <功能详细描述>
     * @param sSrc
     * @return
     */
    public static String decryptUtf8(String sSrc)
        throws Exception
    {
        try
        {
            return new String(cipherDecrypt.doFinal(Base64.decodeBase64(sSrc)), "utf-8");
        }
        catch (Exception ex)
        {
            return null;
        }
    }
}
