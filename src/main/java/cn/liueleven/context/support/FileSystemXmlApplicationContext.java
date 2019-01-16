package cn.liueleven.context.support;

import cn.liueleven.beans.factory.support.DefaultBeanFactory;
import cn.liueleven.beans.factory.xml.XmlBeanDefinitionReader;
import cn.liueleven.context.ApplicationContext;
import cn.liueleven.core.io.FileSystemResource;
import cn.liueleven.core.io.Resource;

/**
 * @description: 一定要写注释啊
 * @date: 2019-01-15 22:45
 * @author: 十一
 */
public class FileSystemXmlApplicationContext extends AbstractApplicationContext {


    @Override
    public Object getBean(String beanId) {
        return super.factory.getBean(beanId);
    }

    public FileSystemXmlApplicationContext(String configFile) {
        super(configFile);
    }

    @Override
    protected Resource getResourceByPath(String path) {
        return new FileSystemResource(path);
    }
}
