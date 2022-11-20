package cn.bugstack.springframework.source.factory.support;

import cn.bugstack.springframework.source.BeansExecption;
import cn.bugstack.springframework.source.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @description: JDK实例化
 * @author：邓兴
 * @date: 2022/11/7
 * @Copyright： https://gitee.com/shodaw
 * */
public class SimpleInstantiationStrategy implements InstantiationStrategy{

    @Override
    public Object instantiate(String beanName, BeanDefinition beanDefinition, Constructor constructor, Object[] args) throws BeansExecption {
        Class clazz = beanDefinition.getBeanClass();
        try {
            if (constructor != null){
                return clazz.getDeclaredConstructor(constructor.getParameterTypes()).newInstance(args);
            }
                return clazz.getDeclaredConstructor().newInstance();
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e){
            throw new BeansExecption("fail to instantiate["+clazz.getName()+"]", e);
        }
    }
}
