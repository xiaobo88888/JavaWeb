package utils;

import bean.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public class WebUtils {

    /**
     * 把 Map 中的值注入到对应的 JavaBean 属性中。
     * @param map
     * @param bean
     * @param <T>
     * @return 传过来的对象
     * 这里使用Map而不是使用HttpServletRequest，是为了减少耦合度，因为
     * HttpServletRequest是Service层的，而bean是Dao层的，二者耦合了，而Map
     * 在三个层中都可以使用
     */
    public static <T> T copyParamToBean(Map map, T bean){
        try {
            System.out.println("注入之前：" + bean);

            /**
             * 把所有请求的参数都注入到user对象中
             */
            BeanUtils.populate(bean, map);
            System.out.println("注入之后：" + bean);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }


    /**
     * 将字符串转换成int类型的数据
     * @param strInt
     * @param defaultValue
     * @return
     */
    public static int parseInt(String strInt, int defaultValue){
        try {
            return Integer.parseInt(strInt);
        }catch (Exception e){
            e.printStackTrace();
        }
        return defaultValue;
    }
    
}
