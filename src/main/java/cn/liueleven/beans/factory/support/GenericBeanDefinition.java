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

    private String scope = SCOPE_DEFAULT;

    private boolean singleton = true;

    private boolean prototype = false;

    public GenericBeanDefinition(String id, String beanClassName) {
        this.id = id;
        this.beanClassName = beanClassName;
    }

    @Override
    public String getBeanClassName() {
        return this.beanClassName;
    }

    @Override
    public boolean isSingleton() {
        return this.singleton;
    }

    @Override
    public boolean isPrototype() {
        return this.prototype;
    }

    @Override
    public void setScope(String scope) {
        this.scope = scope;
        this.singleton = SCOPE_SINGLETON.equals(scope) || SCOPE_DEFAULT.equals(scope);
        this.prototype = SCOPE_PROTOTYPE.equals(scope);
    }

    @Override
    public String getScope() {
        return this.scope;
    }

}
