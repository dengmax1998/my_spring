package cn.bugstack.springframework.source.factory.support;


import cn.bugstack.springframework.source.factory.config.BeanDefinition;

/**
 * @description:
 * @author：邓兴
 * @date: 2022/11/4
 * @Copyright： 参考博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 */
public interface BeanDefinitionRegistry {

    void registryBeanDefinition(String name, BeanDefinition beanDefinition);
}
