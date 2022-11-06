package cn.bugstack.springframework.source.factory.support;


import cn.bugstack.springframework.source.factory.config.BeanDefinition;

/**
 * @description:
 * @author：邓兴
 * @date: 2022/11/3
 * @Copyright： 参考博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry  implements BeanFactory {

    @Override
    public Object getBean(String beanName) throws InstantiationException, IllegalAccessException {
        Object singleton = getSingleton(beanName);
        if (null != singleton){
            return singleton;
        }
        BeanDefinition beanDefinition = getBeanDefinition(beanName);
        Object bean = creatBean(beanName, beanDefinition);

        return bean;
    }
    protected abstract BeanDefinition getBeanDefinition(String beanName);

    protected abstract Object creatBean(String beanName, BeanDefinition beanDefinition) throws InstantiationException, IllegalAccessException;
}
