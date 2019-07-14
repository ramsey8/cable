package cn.cyf.user.shiro;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

/**
 * @author tongyao
 */
public class ShiroMd5Util {
    /**
     * 添加user的密码加密方法
     * @param pwd
     * @return
     */
    public static String encrypt(String username, String pwd) {
        String hashAlgorithmName = "MD5";//加密方式
        Object crdentials = pwd;
        ByteSource salt = ByteSource.Util.bytes(username);//以账号作为盐值
        int hashIterations = 2;//加密1024次
        SimpleHash hash = new SimpleHash(hashAlgorithmName,crdentials,salt,hashIterations);
        return hash.toString();
    }  
}