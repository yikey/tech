package com.util;

import org.bouncycastle.util.encoders.Base64;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.Key;
import java.security.Security;

/**
 * @author zhgq
 * @date Aug 06 11:14:28 CST 2014
 */

public class AES256Encryption {

    /**
     * 密钥算法
     * bouncycastle支持64位
     */
    public static final String KEY_ALGORITHM = "AES";

    /**
     * 加密/解密算法/工作模式/填充方式
     * <p>
     * JAVA6支持PKCS5Padding填充方式
     * Bouncy castle支持PKCS7Padding填充方式
     */
    public static final String CIPHER_ALGORITHM = "AES/ECB/PKCS7Padding";

    /**
     * 生成密钥，
     *
     * @return byte[] 二进制密钥
     */
    public static byte[] initKey() throws Exception {
        //实例化密钥生成器
        Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
        KeyGenerator kg = KeyGenerator.getInstance(KEY_ALGORITHM, "BC");
//
//     //初始化密钥生成器，AES要求密钥长度为128位、192位、256位
       kg.init(256);
//     kg.init(128);
//     //生成密钥
       SecretKey secretKey=kg.generateKey();
//     //获取二进制密钥编码形式
     return secretKey.getEncoded();

//       //为了便于测试，这里我把key写死了，如果大家需要自动生成，可用上面注释掉的代码
//       return new byte[]{0x08, 0x08, 0x04, 0x0b, 0x02, 0x0f, 0x0b, 0x0c,
//                0x01, 0x03, 0x09, 0x07, 0x0c, 0x03, 0x07, 0x0a, 0x04, 0x0f,
//                0x06, 0x0f, 0x0e, 0x09, 0x05, 0x01, 0x0a, 0x0a, 0x01, 0x09,
//                0x06, 0x07, 0x09, 0x0d};
    }

    /**
     * 转换密钥
     *
     * @param key 二进制密钥
     * @return key 密钥
     */
    public static Key toKey(byte[] key) throws Exception {
        //实例化DES密钥
        //生成密钥
        SecretKey secretKey = new SecretKeySpec(key, KEY_ALGORITHM);
        return secretKey;
    }

    /**
     * 加密数据
     *
     * @param data 待加密数据
     * @param key  密钥
     * @return byte[] 加密后的数据
     */
    public static byte[] encrypt(byte[] data, byte[] key) throws Exception {
        //还原密钥
        Key k = toKey(key);
        /**
         * 实例化
         * 使用 PKCS7Padding 填充方式，按如下方式实现，就是调用bouncycastle组件实现
         * Cipher.getInstance(CIPHER_ALGORITHM,"BC")
         */
        Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
        Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM, "BC");
        //初始化，设置为加密模式
        cipher.init(Cipher.ENCRYPT_MODE, k);
        //执行操作
        return cipher.doFinal(data);
    }

    /**
     * 解密数据
     *
     * @param data 待解密数据
     * @param key  密钥
     * @return byte[] 解密后的数据
     */
    public static byte[] decrypt(byte[] data, byte[] key) throws Exception {
        //欢迎密钥
        Key k = toKey(key);
        /**
         * 使用 PKCS7Pading 填充方式，按如下方式实现，就是调用bouncycastle组件实现
         * Cipher.getInstance(CIPHER_ALGORITHM,"BC")
         */

        Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM, "BC");
        //初始化，设置为解密模式
        cipher.init(Cipher.DECRYPT_MODE, k);

        //执行操作
        return cipher.doFinal(data);
    }


    /**
     * @param args
     * @throws UnsupportedEncodingException
     * @throws Exception
     */
    public static void main(String[] args) {

        String str = "abcdefghijklmnopqrstuvwxyz";
        System.out.println("明文是" + str);
        byte[] encryptData = str.getBytes();
        System.out.print("加密前：");
        for (int i = 0; i < encryptData.length; i++) {
            System.out.printf("%x", encryptData[i]);
        }
        System.out.println();

        //初始化密钥
        byte[] key;
        try {
            key = AES256Encryption.initKey();
            String keyStr = org.apache.commons.codec.binary.Hex.encodeHexString(key);
            System.out.println("\n密钥Str:"+keyStr);
            key = org.apache.commons.codec.binary.Hex.decodeHex(keyStr);
            System.out.print("---");
            for (int i = 0; i < key.length; i++) {
                System.out.printf("%x", key[i]);
            }
            //加密数据
            byte[] encryptedData = AES256Encryption.encrypt(str.getBytes(), key);
            System.out.print("\n加密后：");
            for (int i = 0; i < encryptedData.length; i++) {
                System.out.printf("%x", encryptedData[i]);
            }
            System.out.println();

            //加密后byte[]转base64
            String encryptedDataBase64Str = Base64.toBase64String(encryptedData);
            System.out.println("加密后byte[]转base64 ：" + encryptedDataBase64Str);

            //base64转byte[]
            byte[] encryptedDataByte = Base64.decode(encryptedDataBase64Str);
            System.out.print("base64转byte[] ：");
            for (int i = 0; i < encryptedDataByte.length; i++) {
                System.out.printf("%x", encryptedDataByte[i]);
            }

            //解密数据
            byte[] decryptedData = AES256Encryption.decrypt(encryptedDataByte, key);
            System.out.print("\n解密后：");
            for (int i = 0; i < decryptedData.length; i++) {
                System.out.printf("%x", decryptedData[i]);
            }
            System.out.println();
            System.out.println("解密后：" + new String(decryptedData));
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
