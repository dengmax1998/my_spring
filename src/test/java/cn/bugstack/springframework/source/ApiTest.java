package cn.bugstack.springframework.source;

import cn.bugstack.springframework.source.factory.config.BeanDefinition;
import cn.bugstack.springframework.source.factory.support.BeanFactory;
import cn.bugstack.springframework.source.factory.support.DefaultListableBeanFactory;
import org.junit.Test;
import cn.bugstack.springframework.source.bean.UserService;

/**
 * @description:
 * @author：邓兴
 * @date: 2022/10/31
 * @Copyright： 参考博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 */
public class ApiTest {

    @Test
    public void testBean() throws InstantiationException, IllegalAccessException {

        //获取bean工厂
        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();

        //注册bean
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
        defaultListableBeanFactory.registryBeanDefinition("userService",beanDefinition);

        //第一次获取bean
        UserService userService = (UserService)defaultListableBeanFactory.getBean("userService");
        userService.queryUserInfo();
        System.out.println(userService);

        //第二次获取bean
        UserService userService_singleton = (UserService)defaultListableBeanFactory.getBean("userService");
        userService_singleton.queryUserInfo();
        System.out.println(userService_singleton);

        //比较两个bean是否是同一个bean
        System.out.println(userService==userService_singleton);
    }
}
