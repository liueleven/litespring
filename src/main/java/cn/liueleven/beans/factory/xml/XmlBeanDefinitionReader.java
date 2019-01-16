package cn.liueleven.beans.factory.xml;

import cn.liueleven.beans.BeanDefinitionStoreException;
import cn.liueleven.beans.factory.BeanFactory;
import cn.liueleven.beans.factory.support.BeanDefinitionRegister;
import cn.liueleven.beans.factory.support.GenericBeanDefinition;
import cn.liueleven.core.io.Resource;
import cn.liueleven.util.ClassUtils;
import cn.liuleven.beans.BeanDefinition;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

/**
 * @description: 一定要写注释啊
 * @date: 2019-01-13 20:24
 * @author: 十一
 */
public class XmlBeanDefinitionReader implements BeanFactory {

    public static final String ID_ATTRIBUTE = "id";

    public static final String CLASS_ATTRIBUTE = "class";

    public static String SCOPE_ATTRIBUTE = "scope";

    private BeanDefinitionRegister register;

    public XmlBeanDefinitionReader(BeanDefinitionRegister register) {
        this.register = register;
    }

    public void loadBeanDefinitions(String configFile) {
        InputStream is = null;
        try {
            ClassLoader cl = ClassUtils.getDefaultClassLoader();
            is = cl.getResourceAsStream(configFile);
            SAXReader reader = new SAXReader();
            // 得到根<beans>标签
            Document doc = reader.read(is);
            Element root = doc.getRootElement();
            Iterator<Element> iter = root.elementIterator();
            while (iter.hasNext()) {
                Element ele = iter.next();
                String id = ele.attributeValue(ID_ATTRIBUTE);
                String beanClassName = ele.attributeValue(CLASS_ATTRIBUTE);
                BeanDefinition bd = new GenericBeanDefinition(id, beanClassName);
                this.register.registerBeanDefinition(id, bd);
            }
        } catch (DocumentException e) {
            throw new BeanDefinitionStoreException("IOException parse document for " + configFile);
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void loadBeanDefinitions(Resource r) {
        InputStream is = null;
        try {
            is = r.getInputStream();
            SAXReader reader = new SAXReader();
            // 得到根<beans>标签
            Document doc = reader.read(is);
            Element root = doc.getRootElement();
            Iterator<Element> iter = root.elementIterator();
            while (iter.hasNext()) {
                Element ele = iter.next();
                String id = ele.attributeValue(ID_ATTRIBUTE);
                String beanClassName = ele.attributeValue(CLASS_ATTRIBUTE);
                BeanDefinition bd = new GenericBeanDefinition(id, beanClassName);
                if(ele.attribute(SCOPE_ATTRIBUTE) != null) {
                    bd.setScope(ele.attributeValue(SCOPE_ATTRIBUTE));
                }

                this.register.registerBeanDefinition(id, bd);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch(DocumentException e) {
            throw new BeanDefinitionStoreException("IOException parse document for " + r.getDescription());
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public Object getBean(String beanId) {
        return this.register.getBeanDefinition(beanId);
    }
}