package cn.liueleven.core.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * @description: 一定要写注释啊
 * @date: 2019-01-15 22:58
 * @author: 十一
 */
public interface Resource {

    public InputStream getInputStream() throws IOException;

    public String getDescription();
}
