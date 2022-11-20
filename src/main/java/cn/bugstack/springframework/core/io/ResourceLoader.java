package cn.bugstack.springframework.core.io;

/**
 * @description:    获取资源接口，用于把不同的资源加载方式集中到统一的类服务下进行处理，里面传递 location 地址即可。
 * @author：邓兴
 * @date: 2022/11/20
 * @Copyright： 参考地址：https://gitee.com/shodaw
 */
public interface ResourceLoader {

    String CLASSPATH_URL_PREFIX = "classpath:";

    Resource getResource(String location);
}
