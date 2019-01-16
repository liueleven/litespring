package cn.liueleven.context.support;

import cn.liueleven.beans.factory.support.DefaultBeanFactory;
import cn.liueleven.beans.factory.xml.XmlBeanDefinitionReader;
import cn.liueleven.context.ApplicationContext;
import cn.liueleven.core.io.Resource;
import cn.liueleven.util.ClassUtils;

/**
 * @description: 一定要写注释啊
 * @date: 2019-01-15 23:46
 * @author: 十一
 */
public abstract class AbstractApplicationContext implements ApplicationContext{


    public DefaultBeanFactory factory = null;
    private ClassLoader classLoader;

    @Override
    public Object getBean(String beanId) {
        return factory.getBean(beanId);
    }

    public AbstractApplicationContext(String configFile) {
        factory = new DefaultBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
        // 这里的精髓在于用接口来接收和传值，高度抽象，灵活，兼容
        Resource resource = getResourceByPath(configFile);
        // 去解析xml文件
        reader.loadBeanDefinitions(resource);
        factory.setBeanClassLoder(this.getClassLoader());
    }

    protected abstract Resource getResourceByPath(String path);

    @Override
    public void setBeanClassLoder(ClassLoader beanClassLoader) {
        this.classLoader = beanClassLoader;
    }

    @Override
    public ClassLoader getClassLoader() {
        return (this.classLoader != null ? this.classLoader : ClassUtils.getDefaultClassLoader());
    }
}
