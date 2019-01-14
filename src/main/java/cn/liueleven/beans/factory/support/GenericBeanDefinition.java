package cn.liueleven.beans.factory.support;

import cn.liuleven.beans.BeanDefinition;

/**
 * @description: 一定要写注释啊
 * @date: 2019-01-13 17:20
 * @author: 十一
 */
public class GenericBeanDefinition implements BeanDefinition {

    private String id;

    private String beanClassName;

    public GenericBeanDefinition(String id, String beanClassName) {
        this.id = id;
        this.beanClassName = beanClassName;
    }

    @Override
    public String getBeanClassName() {
        return this.beanClassName;
    }
}
