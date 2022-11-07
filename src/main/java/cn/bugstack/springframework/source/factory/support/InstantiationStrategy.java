package cn.bugstack.springframework.source.factory.support;

import cn.bugstack.springframework.source.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * @description:
 * @author：邓兴
 * @date: 2022/11/7
 * @Copyright： 参考博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 */
public interface InstantiationStrategy {

    /**
     * @param beanName bean名字
     * @param beanDefinition bean定义
     * @param constructor 构造函数
     * @param args 具体入参
     * @return 实例化的bean对象
     */
    Object instantiate(String beanName , BeanDefinition beanDefinition, Constructor constructor, Object[] args);
}
