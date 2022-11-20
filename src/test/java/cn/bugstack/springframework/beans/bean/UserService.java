package cn.bugstack.springframework.beans.bean;

/**
 * @description:
 * @author：邓兴
 * @date: 2022/10/31
 * @Copyright： 参考博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 */
public class UserService {

    private String  uId;

    private UserDao userDao;

    public void queryUserInfo(){
        System.out.println("查询用户信息:"+userDao.queryUserName(uId));
    }


    public UserService() {
    }

    @Override
    public String toString() {
        return "UserService{" +
                "uId='" + uId + '\'' +
                '}';
    }
}
