package cn.bugstack.springframework.utils;

/**
 * @description:    获取类加载器工具类
 * @author：邓兴
 * @date: 2022/11/20
 * @Copyright： 参考地址：https://gitee.com/shodaw
 */
public class ClassUtils {

    public static ClassLoader getDefaultClassLoader(){
        ClassLoader classLoader = null;
        try {
            classLoader = Thread.currentThread().getContextClassLoader();
        }catch (Exception ex){
            // Cannot access thread context ClassLoader - falling back to system class loader...
        }
        if (classLoader == null){
            //classLoader = ClassUtils.getDefaultClassLoader();
            classLoader = ClassUtils.class.getClassLoader();
        }
        return classLoader;
    }
}
