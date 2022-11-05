package cn.bugstack.springframework.source;

/**
 * @description:    定义bean信息
 * @author：邓兴
 * @date: 2022/10/31
 * @Copyright： https://github.com/dengmax1998
 */
public class BeanDefinition {

    private Object bean;

    public BeanDefinition(Object bean) {
        this.bean = bean;
    }

    public Object getBean() {
        return bean;
    }
}
