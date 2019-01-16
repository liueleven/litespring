package cn.liueleven.beans.factory.support;

import cn.liueleven.beans.factory.config.SingletonBeanRegistry;
import cn.liueleven.util.Assert;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @description: 一定要写注释啊
 * @date: 2019-01-16 00:33
 * @author: 十一
 */
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {

    private final Map<String,Object> singletonObjects = new ConcurrentHashMap<String, Object>(64);


    @Override
    public void registerSingleton(String beanName, Object singletonObject) {
        Assert.notNull(beanName,"'beanName' must not be null");
        Object oldObject = this.singletonObjects.get(beanName);
        if(oldObject != null) {
            throw new IllegalStateException("Could not register object [" + singletonObject + "] under bean name '"
            + beanName + "': there is already object [" + oldObject + "" );
        }
        this.singletonObjects.put(beanName,singletonObject);
    }

    @Override
    public Object getSingleton(String beanName) {
        return this.singletonObjects.get(beanName);
    }
}
