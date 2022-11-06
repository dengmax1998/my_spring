package cn.bugstack.springframework.source.factory.support;
import cn.bugstack.springframework.source.factory.config.BeanDefinition;

/**
 * @description:
 * @author：邓兴
 * @date: 2022/11/4
 * @Copyright： 参考博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 */
public abstract class AbstractAutowireCapabkeBeanFactory extends AbstractBeanFactory{

    @Override
    protected Object creatBean(String beanName, BeanDefinition beanDefinition) throws InstantiationException, IllegalAccessException {
        Object bean;
        bean = beanDefinition.getBeanClass().newInstance();
        addSingleton(beanName,bean);
        return bean;
    }
}
