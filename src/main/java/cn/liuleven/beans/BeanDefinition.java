package cn.liuleven.beans;

/**
 * @description: 一定要写注释啊
 * @date: 2019-01-13 17:03
 * @author: 十一
 */
public interface BeanDefinition {


    public static final String SCOPE_DEFAULT = "";
    public static final String SCOPE_SINGLETON = "singleton";
    public static final String SCOPE_PROTOTYPE = "prototype";

    String getBeanClassName();

    boolean isSingleton();

    boolean isPrototype();

    public void setScope(String scope);

    public String getScope();
}
