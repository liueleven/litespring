package cn.liueleven.beans.factory.support;

import cn.liuleven.beans.BeanDefinition;

/**
 * @description: 一定要写注释啊
 * @date: 2019-01-13 20:28
 * @author: 十一
 */
public interface BeanDefinitionRegister {
    BeanDefinition getBeanDefinition(String beanId);

    void RegisterBeanDefinition(String beanId,BeanDefinition bd);
}
