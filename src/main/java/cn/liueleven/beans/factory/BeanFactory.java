package cn.liueleven.beans.factory;

import cn.liuleven.beans.BeanDefinition;

/**
 * @description: 一定要写注释啊
 * @date: 2019-01-13 16:57
 * @author: 十一
 */
public interface BeanFactory{



    Object getBean(String beanId);
}
