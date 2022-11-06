package cn.bugstack.springframework.source.factory.support;



import cn.bugstack.springframework.source.factory.config.SingletonBeanRegistry;

import java.util.HashMap;

/**
 * @description:
 * @author：邓兴
 * @date: 2022/11/4
 * @Copyright： 参考博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 */
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {

    private final HashMap<String,Object> singletonObjects = new HashMap<>();

    @Override
    public Object getSingleton(String beanName) {
        return singletonObjects.get(beanName);
    }

    public void addSingleton(String beanName, Object singletonObject){
        singletonObjects.put(beanName,singletonObject);
    }
}
