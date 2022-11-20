package cn.bugstack.springframework.source;

import cn.bugstack.springframework.source.PropertyValue;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author：邓兴
 * @date: 2022/11/8
 * @Copyright： 参考博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 */
public class PropertyValues {

    private List<PropertyValue> propertyValueList = new ArrayList<>();

    public void addPropertyValue(PropertyValue propertyValue){
        this.propertyValueList.add(propertyValue);
    }

    public PropertyValue[] getPropertyValues(){
        return this.propertyValueList.toArray(new PropertyValue[0]);
    }

    public PropertyValue getPropertyValue(String propertyName){
        for (PropertyValue p :this.propertyValueList) {
            if (p.getName().equals(propertyName)){
                return p;
            }
        }
        return null;
    }


}
