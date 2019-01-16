package cn.liueleven.test.v1;

import cn.liueleven.context.ApplicationContext;
import cn.liueleven.context.support.ClassPathXmlApplicationContext;
import cn.liueleven.context.support.FileSystemXmlApplicationContext;
import cn.liueleven.service.v1.PetStoreService;
import org.junit.Assert;
import org.junit.Test;

/**
 * @description: 一定要写注释啊
 * @date: 2019-01-13 20:53
 * @author: 十一
 */
public class ApplicationContextTest {

    @Test
    public void testGetBean() {
        ApplicationContext ctx =  new ClassPathXmlApplicationContext("petstore-v1.xml");
        PetStoreService petStore = (PetStoreService) ctx.getBean("petStore");
        Assert.assertNotNull(petStore);
    }

    @Test
    public void testGetBeanFromFileSystemContext() {
        ApplicationContext ctx =  new FileSystemXmlApplicationContext("/temp/litespring/petstore-v1.xml");
        PetStoreService petStore = (PetStoreService) ctx.getBean("petStore");
        Assert.assertNotNull(petStore);
    }
}
