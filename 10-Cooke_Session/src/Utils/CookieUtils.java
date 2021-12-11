package Utils;

import javax.servlet.http.Cookie;

public class CookieUtils {

    /**
     * 查询制定名称的Cookie对象并返回
     * @param name
     * @param cookies
     * @return
     */
    public static Cookie findCookie(String name, Cookie[] cookies){
        Cookie iwantCookie = null;
        
        if(name == null || cookies == null || cookies.length == 0){
            return null;
        }

        for (Cookie cookie : cookies) {
            if(name.equals(cookie.getName())){
                return cookie;
            }
        }
        
        return null;
    }   
    
}
