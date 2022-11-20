package cn.bugstack.springframework.core.io;

import java.io.*;

/**
 * @description:    文件路径资源加载器，通过指定文件路径的方式读取文件信息
 * @author：邓兴
 * @date: 2022/11/20
 * @Copyright： 参考地址：https://gitee.com/shodaw
 */
public class FileSystemResource implements Resource{

    //指定文件
    private final File file;

    //指定路径
    private final String path;

    public FileSystemResource(File file) {
        this.file = file;
        this.path = file.getPath();
    }

    public FileSystemResource(String path) {
        this.file = new File(path);
        this.path = path;
    }


    @Override
    public InputStream getInputStream() throws IOException {
        return new FileInputStream(this.file);
    }

    public final String getPath() {
        return path;
    }
}
