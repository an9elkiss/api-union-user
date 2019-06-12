package com.an9elkiss.api.user.util;

import java.util.regex.Pattern;

/**
 * 
 * @ClassName: PasswordRegularMatchUtils
 * @Description: 密码复杂度校验
 * @author: yucheng.yao
 * @date: 2019年5月30日 下午4:42:43
 * 
 * @Copyright: 2019
 */
public class PasswordRegularMatchUtils{

    /**
     * 对密码进行复杂度校验
     * 用于匹配的正则表达式为"^(?![^A-Za-z]+$)(?![^0-9]+$)(?=.*[^\\w\\s]+).{6,12}$"
     * 
     * @param password
     * @return
     */
    public static boolean regularMatchPassword(String password){
        return Pattern.compile("^(?![^A-Za-z]+$)(?![^0-9]+$)(?=.*[^\\w\\s]+).{6,12}$").matcher(password).matches();
    }
}
