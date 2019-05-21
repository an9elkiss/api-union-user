package com.an9elkiss.api.user.util;

import org.springframework.util.DigestUtils;

/**
 * 
 * @ClassName: MD5Utils
 * @Description: md5加密工具类
 * @author: yucheng.yao
 * @date: 2019年5月21日 下午5:39:12
 * 
 * @Copyright: 2019
 */
public class MD5Utils{

    /**
     * 对str进行MD5加密
     * @param str
     * @return
     */
    public static String md5DigestAsHex(String str){

        String string = "";

        try{
            string = DigestUtils.md5DigestAsHex(str.getBytes());

        }catch (Exception e){
            return string;
        }
        return string;
    }
}
