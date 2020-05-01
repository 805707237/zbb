package com.course.utills;

import com.course.model.InterfaceName;
import java.util.Locale;
import java.util.ResourceBundle;

public class ConfigFile {
    private static ResourceBundle bundle=ResourceBundle.getBundle("application", Locale.CHINA);

    public static String getUrl(InterfaceName name){
        String url=bundle.getString("test.url");
        if(name==InterfaceName.GETUSERLIST){
            url=url+bundle.getString("getuserList.uri");
        }
        if(name==InterfaceName.LOGIN){
            url=url+bundle.getString("login.uri");
        }
        if(name==InterfaceName.UPDATEUSERINFO){
            url=url+bundle.getString("updataUserInfo.uri");
        }
        if(name==InterfaceName.GERUSERINFO){
            url=url+bundle.getString("getUserInfo.uri");
        }
        if(name==InterfaceName.ADDUSERINFO){
            url=url+bundle.getString("addUser.uri");
        }
        else {
            return "参数错误";
        }
        return url;
    }
}
