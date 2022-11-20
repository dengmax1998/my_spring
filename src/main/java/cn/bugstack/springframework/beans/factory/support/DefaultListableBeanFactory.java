package cn.bugstack.springframework.beans.factory.support;



import cn.bugstack.springframework.beans.BeansExecption;
import cn.bugstack.springframework.beans.factory.config.BeanDefinition;

import java.util.HashMap;

/**
 * @description:
 * @author：邓兴
 * @date: 2022/11/4
 * @Copyright： 参考博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 */
public class DefaultListableBeanFactory extends AbstractAutowireCapabkeBeanFactory  implements BeanDefinitionRegistry{

    private HashMap<String, BeanDefinition> beanDefinitionHashMap = new HashMap<>();

    @Override
    protected BeanDefinition getBeanDefinition(String name) {
        BeanDefinition beanDefinition = beanDefinitionHashMap.get(name);
        if (null == beanDefinition){
            throw new BeansExecption("No bean named '"+name+"'is defined");
        }
        return beanDefinition;
    }

    @Override
    public void registryBeanDefinition(String name, BeanDefinition beanDefinition) {
        beanDefinitionHashMap.put(name,beanDefinition);
    }
}
