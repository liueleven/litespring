package cn.liueleven.core.io;

import cn.liueleven.util.Assert;

import java.io.*;

/**
 * @description: 一定要写注释啊
 * @date: 2019-01-15 23:06
 * @author: 十一
 */
public class FileSystemResource implements Resource {



    private String path;

    private File file;

    public FileSystemResource(String path) {
        Assert.notNull(path,"Path must not be null");
        this.file = new File(path);
        this.path = path;
    }



    @Override
    public InputStream getInputStream() throws IOException {
        return new FileInputStream(this.file);
    }

    @Override
    public String getDescription() {
        return "file [ " + this.file.getAbsolutePath() + "]";
    }
}
