package cn.liueleven.beans;

/**
 * @description: 一定要写注释啊
 * @date: 2019-01-13 17:39
 * @author: 十一
 */
public class BeansException extends RuntimeException{

    public BeansException(String msg) {
        super(msg);
    }
    public BeansException(String msg,Throwable e) {
        super(msg,e);
    }
}
