package cn.bugstack.springframework.source.factory.support;

import cn.bugstack.springframework.source.factory.BeansExecption;
import cn.bugstack.springframework.source.factory.config.BeanDefinition;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;

import java.lang.reflect.Constructor;

/**
 * @description:
 * @author：邓兴
 * @date: 2022/11/7
 * @Copyright： 参考博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 */
public class CglibSubclassingInstantiationStrategy implements InstantiationStrategy{
    @Override
    public Object instantiate(String beanName, BeanDefinition beanDefinition, Constructor constructor, Object[] args) throws BeansExecption {
        //创建一个代理类
        Enhancer enhancer = new Enhancer();
        //设置要代理的对象
        enhancer.setSuperclass(beanDefinition.getBeanClass());
        //设置代理的回调，Cglib的实现类
        enhancer.setCallback(new NoOp() {
            @Override
            public int hashCode() {
                return super.hashCode();
            }
        });
        //创建并返回代理对象
        if(null == constructor){
            return enhancer.create();
        }
        return enhancer.create(constructor.getParameterTypes(),args);
    }
}
