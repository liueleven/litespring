package cn.liueleven.context;

import cn.liueleven.beans.factory.BeanFactory;
import cn.liueleven.beans.factory.config.ConfigurableBeanFactory;

/**
 * @description: 一定要写注释啊
 * @date: 2019-01-15 22:43
 * @author: 十一
 */
public interface ApplicationContext extends ConfigurableBeanFactory{

    @Override
    Object getBean(String beanId);
}
