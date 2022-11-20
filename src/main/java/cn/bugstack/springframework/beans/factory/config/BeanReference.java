package cn.bugstack.springframework.beans.factory.config;

/**
 * @description:
 * @author：邓兴
 * @date: 2022/11/10
 * @Copyright： 参考地址：https://gitee.com/shodaw
 */
public class BeanReference {

    String beanName;

    public BeanReference(String beanName) {
        this.beanName = beanName;
    }

    public String getBeanName() {
        return beanName;
    }

    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }
}
