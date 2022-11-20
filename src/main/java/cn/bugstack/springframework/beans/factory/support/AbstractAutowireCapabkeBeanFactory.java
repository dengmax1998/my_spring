package cn.bugstack.springframework.beans.factory.support;
import cn.bugstack.springframework.beans.BeansExecption;
import cn.bugstack.springframework.beans.PropertyValue;
import cn.bugstack.springframework.beans.PropertyValues;
import cn.bugstack.springframework.beans.factory.config.BeanDefinition;
import java.lang.reflect.Constructor;
import cn.hutool.core.bean.BeanUtil;
import cn.bugstack.springframework.beans.factory.config.BeanReference;
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
            addPropertyValues(beanName,bean,beanDefinition);
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

    protected void addPropertyValues(String beanName, Object bean, BeanDefinition beanDefinition) throws InstantiationException, IllegalAccessException {
        PropertyValues propertyValues = beanDefinition.getPropertyValues();
        for (PropertyValue p: propertyValues.getPropertyValues()) {
            String name = p.getName();
            Object value = p.getValue();
            if (value instanceof BeanReference){
                BeanReference beanReference = (BeanReference) value;
                value = getBean(beanReference.getBeanName());
            }
            BeanUtil.setFieldValue(bean, name, value);
        }
    }

    public InstantiationStrategy getInstantiationStrategy() {
        return instantiationStrategy;
    }

    public void setInstantiationStrategy(InstantiationStrategy instantiationStrategy) {
        this.instantiationStrategy = instantiationStrategy;
    }

}
