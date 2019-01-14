package cn.liueleven.test.v1;

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
        ApplicationContext ctx =  new ClassPathXmlApplicationContenxt();
        PetStoreService petStore = (PetStoreService) ctx.getBean();
        Assert.assertNotNull(petStore);
    }
}
