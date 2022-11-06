package cn.bugstack.springframework.source.factory.support;

import cn.bugstack.springframework.source.factory.BeansExecption;

/**
 * @description:
 * @author：邓兴
 * @date: 2022/11/3
 * @Copyright： 参考博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 */
public interface BeanFactory {

    Object getBean(String beanName) throws BeansExecption, InstantiationException, IllegalAccessException;
}
