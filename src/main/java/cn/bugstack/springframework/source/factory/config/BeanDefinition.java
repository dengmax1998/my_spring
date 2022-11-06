package cn.bugstack.springframework.source.factory.config;

/**
 * @description:
 * @author：邓兴
 * @date: 2022/10/31
 * @Copyright： 参考博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 */
public class BeanDefinition {

    private Class beanClass;

    public Class getBeanClass() {
        return beanClass;
    }

    public BeanDefinition(Class beanClass) {
        this.beanClass = beanClass;
    }
}
