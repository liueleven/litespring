package cn.liueleven.test.v1;

import cn.liueleven.beans.BeanCreateException;
import cn.liueleven.beans.BeanDefinitionStoreException;
import cn.liueleven.beans.factory.BeanFactory;
import cn.liueleven.beans.factory.support.DefaultBeanFactory;
import cn.liueleven.beans.factory.xml.XmlBeanDefinitionReader;
import cn.liueleven.service.v1.PetStoreService;
import cn.liuleven.beans.BeanDefinition;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @description: 一定要写注释啊
 * @date: 2019-01-13 16:50
 * @author: 十一
 */
public class BeanFactoryTest {

    DefaultBeanFactory factory = null;
    XmlBeanDefinitionReader reader = null;

    @Before
    public void setup() {
        factory = new DefaultBeanFactory();
        reader = new XmlBeanDefinitionReader(factory);
    }
    @Test
    public void testGetBean() {

        reader.loadBeanDefinitions("petstore-v1.xml");


        BeanDefinition bd = factory.getBeanDefinition("petStore");

        Assert.assertEquals("cn.liueleven.service.v1.PetStoreService",bd.getBeanClassName());

        PetStoreService petStore = (PetStoreService) factory.getBean ("petStore");

        Assert.assertNotNull(petStore);
    }

    @Test
    public void testInvalidBean() {
        reader.loadBeanDefinitions("petstore-v1.xml");
        try {
            Object invalidBean = factory.getBean("invalidBean");
        }catch (BeanCreateException e) {
            return;
        }
        Assert.fail("except BeanCreateException");
    }

    @Test
    public void testInvalidXML() {
        try {
            reader.loadBeanDefinitions("petstore-22v1.xml");
        }catch (BeanDefinitionStoreException e) {
            return;
        }
        Assert.fail("except BeanDefinitionStoreException");
    }
}
