package cn.liueleven.test.v1;

import cn.liueleven.core.io.ClassPathResource;
import cn.liueleven.core.io.FileSystemResource;
import cn.liueleven.core.io.Resource;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @description: 一定要写注释啊
 * @date: 2019-01-15 22:53
 * @author: 十一
 */
public class ResourceTest {

    @Test
    public void testClassPathResource() throws IOException {
        Resource r = new ClassPathResource("petstore-v1.xml");
        InputStream is = null;
        try {
            is = r.getInputStream();
            Assert.assertNotNull(is);
        }finally {
            if(is != null) {
                is.close();
            }
        }
    }

    @Test
    public void testFileSystemResource() throws IOException{
        Resource r = new FileSystemResource("/temp/litespring/petstore-v1.xml");
        InputStream is = null;
        try {
            is = r.getInputStream();
            Assert.assertNotNull(is);
        }finally {
            if(is != null) {
                is.close();
            }
        }
    }
}
