package cn.liueleven.beans.factory.support;

import cn.liueleven.beans.BeanCreateException;
import cn.liueleven.beans.BeanDefinitionStoreException;
import cn.liueleven.beans.factory.BeanFactory;
import cn.liueleven.util.ClassUtils;
import cn.liuleven.beans.BeanDefinition;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @description: 一定要写注释啊
 * @date: 2019-01-13 16:59
 * @author: 十一
 */
public class DefaultBeanFactory implements BeanFactory,BeanDefinitionRegister{

    public static final String ID_ATTRIBUTE = "id";

    public static final String CLASS_ATTRIBUTE = "class";

    private final Map<String,BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<String,BeanDefinition>();


    public DefaultBeanFactory() {
    }

    public void loadBeanDefinition(String configFile) {
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
                BeanDefinition bd = new GenericBeanDefinition(id,beanClassName);
                this.beanDefinitionMap.put(id,bd);
            }
        }catch (DocumentException e) {
            throw new BeanDefinitionStoreException("IOException parse document for " + configFile);
        }finally {
            if(is != null) {
                try {
                    is.close();
                }catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public BeanDefinition getBeanDefinition(String beanId) {
        return this.beanDefinitionMap.get(beanId);
    }

    @Override
    public void RegisterBeanDefinition(String beanId, BeanDefinition bd) {
        this.beanDefinitionMap.put(beanId,bd);
    }

    @Override
    public Object getBean(String beanId) {
        BeanDefinition bd = this.getBeanDefinition(beanId);
        if(bd == null) {
            throw new BeanCreateException("Bean Definition dose not exist");
        }
        ClassLoader cl = ClassUtils.getDefaultClassLoader();
        String beanClassName = bd.getBeanClassName();
        try {
            Class<?> clz = cl.loadClass(beanClassName);
            return clz.newInstance();
        } catch (Exception e) {
            throw new BeanCreateException("create bean for " + beanClassName +" exception");
        }
    }


}
