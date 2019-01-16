package cn.liueleven.core.io;

import cn.liueleven.util.ClassUtils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * @description: 一定要写注释啊
 * @date: 2019-01-15 23:00
 * @author: 十一
 */
public class ClassPathResource implements Resource {

    private String path;

    private ClassLoader classLoader;

    public ClassPathResource(String path) {
        this(path,(ClassLoader)null);
    }

    public ClassPathResource(String path, ClassLoader classLoader) {
        this.path = path;
        this.classLoader = (classLoader != null ? classLoader : ClassUtils.getDefaultClassLoader());
    }

    @Override
    public InputStream getInputStream() throws IOException {
        InputStream is = this.classLoader.getResourceAsStream(this.path);
        if(is == null) {
            throw new FileNotFoundException(this.path + "cannot be opend");
        }
        return is;
    }

    @Override
    public String getDescription() {
        return this.path;
    }
}
