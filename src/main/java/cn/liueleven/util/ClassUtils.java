package cn.liueleven.util;

/**
 * @description: 一定要写注释啊
 * @date: 2019-01-13 17:23
 * @author: 十一
 */
public class ClassUtils {

    public static ClassLoader getDefaultClassLoader() {

        ClassLoader cl = null;
        try {
            cl = Thread.currentThread().getContextClassLoader();
        }catch (Throwable ex) {
            ex.printStackTrace();
        }
        if(cl == null) {
            cl = ClassUtils.class.getClassLoader();
            if(cl == null) {
                try {
                    cl = ClassLoader.getSystemClassLoader();
                }catch (Throwable ex) {
                    ex.printStackTrace();
                }
            }
        }
        return cl;
    }
}
