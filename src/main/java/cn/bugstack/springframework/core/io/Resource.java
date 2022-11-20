package cn.bugstack.springframework.core.io;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * @description:    资源加载接口
 * @author：邓兴
 * @date: 2022/11/20
 * @Copyright： 参考地址：https://gitee.com/shodaw
 */
public interface Resource {

    InputStream getInputStream() throws IOException;
}
