package cn.bugstack.springframework.beans;

/**
 * @description:
 * @author：邓兴
 * @date: 2022/10/31
 * @Copyright： 参考博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 */
public class BeansExecption extends RuntimeException{

    public BeansExecption(String message) {
        super(message);
    }

    public BeansExecption(String message, Throwable cause) {
        super(message, cause);
    }
}
