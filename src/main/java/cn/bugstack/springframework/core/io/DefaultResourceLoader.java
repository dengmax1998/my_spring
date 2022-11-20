package cn.bugstack.springframework.core.io;

import cn.hutool.core.lang.Assert;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @description:    资源获取类，包装资源加载器
 * @author：邓兴
 * @date: 2022/11/20
 * @Copyright： 参考地址：https://gitee.com/shodaw
 */
public class DefaultResourceLoader implements ResourceLoader{
    @Override
    public Resource getResource(String location) {
        //校验location参数
        Assert.notNull(location,"location must not be null");
        //如果传入地址location以CLASSPATH_URL_PREFIX的值开头的话
        if (location.startsWith(CLASSPATH_URL_PREFIX)){
            //获取根目录资源加载器
            return new ClassPathResourrce(location.substring(CLASSPATH_URL_PREFIX.length()));
        }else {
            try {
                //获取url资源加载器
                URL url = new URL(location);
                return new UrlResource(url);
            } catch (MalformedURLException e) {
                //location不是url类型的参数，获取file加载器
                return new FileSystemResource(location);
            }
        }
    }
}
