package cn.bugstack.springframework.core.io;

import cn.bugstack.springframework.utils.ClassUtils;
import cn.hutool.core.lang.Assert;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * @description:    根目录资源加载类，读取ClassPath 下的文件信息
 * @author：邓兴
 * @date: 2022/11/20
 * @Copyright： 参考地址：https://gitee.com/shodaw
 */
public class ClassPathResourrce implements Resource{

    //资源加载路径
    private final String path;

    //类加载器
    private ClassLoader classLoader;

    public ClassPathResourrce(String path) {
        this(path ,(ClassLoader)null);
    }

    public ClassPathResourrce(String path, ClassLoader classLoader) {
        Assert.notNull(path, "path must not be null");
        this.path = path;
        this.classLoader = (classLoader != null ? classLoader : ClassUtils.getDefaultClassLoader());
    }

    @Override
    public InputStream getInputStream() throws IOException {
        InputStream resourceAsStream = classLoader.getResourceAsStream(path);
        if (resourceAsStream == null) {
            throw new FileNotFoundException(
                    this.path + "cannot be opened because file is not exist");
        }
        return resourceAsStream;
    }
}
