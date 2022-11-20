package cn.bugstack.springframework.beans.factory.support;


import cn.bugstack.springframework.beans.BeansExecption;
import cn.bugstack.springframework.beans.factory.BeanFactory;
import cn.bugstack.springframework.beans.factory.config.BeanDefinition;

/**
 * @description:
 * @author：邓兴
 * @date: 2022/11/3
 * @Copyright： 参考博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry  implements BeanFactory {

    @Override
    public Object getBean(String beanName) throws BeansExecption, InstantiationException, IllegalAccessException {
        return doGetBean(beanName,null);
    }

    @Override
    public Object getBean(String beanName, Object...args) throws BeansExecption, InstantiationException, IllegalAccessException {
        return doGetBean(beanName,args);
    }

    public <T> T doGetBean(String beanName,final Object[] args) throws InstantiationException, IllegalAccessException {
        Object bean = getSingleton(beanName);
        if (null != bean){
            return (T) bean;
        }
        BeanDefinition beanDefinition = getBeanDefinition(beanName);

        return creatBean(beanName, beanDefinition, args);
    }
    protected abstract BeanDefinition getBeanDefinition(String beanName);

    protected abstract <T> T creatBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws InstantiationException, IllegalAccessException;
}
