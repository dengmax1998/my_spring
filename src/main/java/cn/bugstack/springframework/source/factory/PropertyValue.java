package cn.bugstack.springframework.source.factory;

/**
 * @description:
 * @author：邓兴
 * @date: 2022/11/8
 * @Copyright： 参考博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 */
public class PropertyValue {

    private String name;

    private Object value;


    public String getName() {
        return name;
    }

    public PropertyValue(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
