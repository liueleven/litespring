package cn.liueleven.util;

/**
 * @description: 一定要写注释啊
 * @date: 2019-01-15 23:08
 * @author: 十一
 */
public class Assert {

    public static void notNull(Object object,String message) {
        if(object == null) {
            throw new IllegalArgumentException(message);
        }
    }
}
