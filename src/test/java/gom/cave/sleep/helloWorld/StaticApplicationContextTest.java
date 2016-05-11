package gom.cave.sleep.helloWorld;

import gom.cave.sleep.helloWorld.hello.Hello;
import gom.cave.sleep.helloWorld.hello.HelloImpl;
import org.junit.Test;
import org.springframework.context.support.StaticApplicationContext;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by sleepbear on 2016. 5. 11..
 */
public class StaticApplicationContextTest {

    @Test
    public void testApplicationContext() throws Exception {
        final StaticApplicationContext applicationContext = new StaticApplicationContext();
        applicationContext.registerSingleton("hello", HelloImpl.class);
        final Hello hello = applicationContext.getBean("hello" , Hello.class);
        assertThat(hello.sayHello(), is("Hello!!!"));
    }
}
