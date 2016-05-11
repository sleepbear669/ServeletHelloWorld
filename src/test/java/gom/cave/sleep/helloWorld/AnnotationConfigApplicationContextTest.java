package gom.cave.sleep.helloWorld;

import gom.cave.sleep.helloWorld.hello.Hello;
import gom.cave.sleep.helloWorld.hello.HelloPerson;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by sleepbear on 2016. 5. 11..
 */
public class AnnotationConfigApplicationContextTest {

    @Test
    public void testApplicationContext() throws Exception {
        final AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext("gom.cave.sleep.helloWorld");
        Hello hello = applicationContext.getBean("hello", Hello.class);
        assertThat(hello.sayHello(), is("Hello!!!"));
    }

    @Test
    public void testApplicationContextUsingClass() throws Exception {
        final AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext("gom.cave.sleep.helloWorld");
        Hello hello = applicationContext.getBean(Hello.class);
        assertThat(hello.sayHello(), is("Hello!!!"));
    }

    @Test
    public void testApplicationContextUsingDi() throws Exception {
        final AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext("gom.cave.sleep.helloWorld");
        final HelloPerson helloPerson = applicationContext.getBean(HelloPerson.class);
        assertThat(helloPerson.sayHello(), is("Hello!!! sleepbear"));

    }
}
