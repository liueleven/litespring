package cn.liueleven.beans.factory.config;

import cn.liueleven.beans.factory.BeanFactory;

/**
 * @description: 一定要写注释啊
 * @date: 2019-01-15 23:58
 * @author: 十一
 */
public interface ConfigurableBeanFactory extends BeanFactory {

    void setBeanClassLoder (ClassLoader beanClassLoader);

    ClassLoader getClassLoader();
}
