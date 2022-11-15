package cn.bugstack.springframework.source;

import cn.bugstack.springframework.source.bean.UserDao;
import cn.bugstack.springframework.source.factory.PropertyValue;
import cn.bugstack.springframework.source.factory.PropertyValues;
import cn.bugstack.springframework.source.factory.config.BeanDefinition;
import cn.bugstack.springframework.source.factory.config.BeanReference;
import cn.bugstack.springframework.source.factory.support.BeanFactory;
import cn.bugstack.springframework.source.factory.support.DefaultListableBeanFactory;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;
import org.junit.Test;
import cn.bugstack.springframework.source.bean.UserService;

import java.lang.reflect.Constructor;

/**
 * @description:
 * @author：邓兴
 * @date: 2022/10/31
 * @Copyright： 参考博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 */
public class ApiTest {

//    @Test
//    public void testBean() throws InstantiationException, IllegalAccessException {
//
//        //获取bean工厂
//        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
//
//        //注册bean
//        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
//        defaultListableBeanFactory.registryBeanDefinition("userService",beanDefinition);
//
//        //第一次获取bean
//        UserService userService = (UserService)defaultListableBeanFactory.getBean("userService","小傅哥");
//        userService.queryUserInfo();
//        System.out.println(userService);
//
////        //第二次获取bean
////        UserService userService_singleton = (UserService)defaultListableBeanFactory.getBean("userService");
////        userService_singleton.queryUserInfo();
////        System.out.println(userService_singleton);
////
////        //比较两个bean是否是同一个bean
////        System.out.println(userService==userService_singleton);
//    }
    //测试类的注册，实例化和获取



    //实例化策略测试
//    @Test
//    public void test_BeanFactory() throws InstantiationException, IllegalAccessException {
//        // 1.初始化 BeanFactory
//        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
//
//        // 3. 注入bean
//        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
//        beanFactory.registryBeanDefinition("userService", beanDefinition);
//
//        // 4.获取bean
//        UserService userService = (UserService) beanFactory.getBean("userService", "小傅哥");
//        userService.queryUserInfo();
//        System.out.println(userService);
//    }
//
//    //无构造函数
//    @Test
//    public void test_newInstance() throws IllegalAccessException, InstantiationException {
//        UserService userService = UserService.class.newInstance();
//        System.out.println(userService);
//    }
//
//    //有构造函数
//    @Test
//    public void test_constructor() throws Exception {
//        Class<UserService> userServiceClass = UserService.class;
//        Constructor<UserService> declaredConstructor = userServiceClass.getDeclaredConstructor(String.class);
//        UserService userService = declaredConstructor.newInstance("小傅哥");
//        System.out.println(userService);
//    }
//
//
//    //测试Cglib实例化
//    @Test
//    public void test_Cglib(){
//        Enhancer enhancer = new Enhancer();
//        enhancer.setSuperclass(UserService.class);
//        enhancer.setCallback(new NoOp() {
//            @Override
//            public int hashCode() {
//                return super.hashCode();
//            }
//        });
//        Object o = enhancer.create(new Class[]{String.class}, new Object[]{"小傅哥"});
//        System.out.println(o);
//    }

    @Test
    public void test_BeanFactory() throws InstantiationException, IllegalAccessException {
        // 1.初始化 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 2. UserDao 注册
        beanFactory.registryBeanDefinition("userDao", new BeanDefinition(UserDao.class));

        // 3. UserService 设置属性[uId、userDao]
        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("uId", "10001"));
        propertyValues.addPropertyValue(new PropertyValue("userDao",new BeanReference("userDao")));

        // 4. UserService 注入bean
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class, propertyValues);
        beanFactory.registryBeanDefinition("userService", beanDefinition);

        // 5. UserService 获取bean
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();
    }
}
