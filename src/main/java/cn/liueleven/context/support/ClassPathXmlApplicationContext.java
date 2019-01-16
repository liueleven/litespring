package cn.liueleven.context.support;

import cn.liueleven.core.io.ClassPathResource;
import cn.liueleven.core.io.Resource;

/**
 * @description: 一定要写注释啊
 * @date: 2019-01-15 22:45
 * @author: 十一
 */
public class ClassPathXmlApplicationContext extends AbstractApplicationContext {


    @Override
    public Object getBean(String beanId) {
        return super.factory.getBean(beanId);
    }

    public ClassPathXmlApplicationContext(String configFile) {
        super(configFile);
    }

    @Override
    protected Resource getResourceByPath(String path) {
        return new ClassPathResource(path,this.getClassLoader());
    }
}
