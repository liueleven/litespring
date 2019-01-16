package cn.liueleven.test.v1;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * @description: 一定要写注释啊
 * @date: 2019-01-15 22:51
 * @author: 十一
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
        ApplicationContextTest.class,
        BeanFactoryTest.class,
        ResourceTest.class
})
public class V1AllTests {
}
