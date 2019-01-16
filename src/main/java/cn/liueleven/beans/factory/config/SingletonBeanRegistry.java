package cn.liueleven.beans.factory.config;

/**
 * @description: 一定要写注释啊
 * @date: 2019-01-16 00:32
 * @author: 十一
 */
public interface SingletonBeanRegistry {

    void registerSingleton(String beanName,Object singletonObject);

    Object getSingleton(String beanName);
}
