package cn.bugstack.springframework.source.factory.support;
import cn.bugstack.springframework.source.factory.BeansExecption;
import cn.bugstack.springframework.source.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @description:
 * @author：邓兴
 * @date: 2022/11/4
 * @Copyright： 参考博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 */
public abstract class AbstractAutowireCapabkeBeanFactory extends AbstractBeanFactory{

    private InstantiationStrategy instantiationStrategy = new CglibSubclassingInstantiationStrategy();

    private Logger logger = LoggerFactory.getLogger(AbstractAutowireCapabkeBeanFactory.class);



    @Override
    protected Object creatBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws InstantiationException, IllegalAccessException {
        Object bean = null;
        try {
            bean = creatBeanInstance(beanName,beanDefinition,args);
            logger.info("输出bean{}",bean.toString());
        }catch (Exception e){
            throw new BeansExecption("Instantiation of bean failed", e);
        }
        addSingleton(beanName,bean);
        return bean;
    }

    protected Object creatBeanInstance(String beanName, BeanDefinition beanDefinition, Object[] args) throws BeansExecption{
        Constructor constructorToUse = null;
        Class<?> beanClass = beanDefinition.getBeanClass();
        Constructor<?>[] declaredConstructors = beanClass.getDeclaredConstructors();
        for (Constructor cons : declaredConstructors){
            if (args != null && cons.getParameterTypes().length == args.length){
                constructorToUse =cons;
                break;
            }
        }
        Object instantiate = getInstantiationStrategy().instantiate(beanName, beanDefinition, constructorToUse, args);
        return instantiate;
    }

    public InstantiationStrategy getInstantiationStrategy() {
        return instantiationStrategy;
    }

    public void setInstantiationStrategy(InstantiationStrategy instantiationStrategy) {
        this.instantiationStrategy = instantiationStrategy;
    }

}
