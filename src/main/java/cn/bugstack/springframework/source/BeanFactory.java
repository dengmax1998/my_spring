package cn.bugstack.springframework.source;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @description:    bean容器
 * @author：邓兴
 * @date: 2022/10/31
 * @Copyright： https://github.com/dengmax1998
 */
public class BeanFactory {

    private Map<String,BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();

    public Object getBean(String name){
        return beanDefinitionMap.get(name).getBean();
    }

    public void registerBeanDefinition(String name,BeanDefinition beanDefinition){
        beanDefinitionMap.put(name,beanDefinition);
    }
}
