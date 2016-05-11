package gom.cave.sleep.helloWorld;

import gom.cave.sleep.helloWorld.hello.Hello;
import gom.cave.sleep.helloWorld.hello.HelloImpl;
import gom.cave.sleep.helloWorld.hello.HelloPerson;
import gom.cave.sleep.helloWorld.hello.HelloPersonImpl;
import org.junit.Test;
import org.springframework.beans.factory.config.RuntimeBeanReference;
import org.springframework.beans.factory.support.RootBeanDefinition;
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

    @Test
    public void testApplicationContextUsingBeadDefinition() throws Exception {
        StaticApplicationContext applicationContext = new StaticApplicationContext();
        applicationContext.registerSingleton("hello", HelloImpl.class);
        RootBeanDefinition beanDefinition = new RootBeanDefinition(HelloPersonImpl.class);
        beanDefinition.getPropertyValues().addPropertyValue("name", "sleepbear");
        beanDefinition.getPropertyValues().addPropertyValue("hello", new RuntimeBeanReference("hello"));
        applicationContext.registerBeanDefinition("helloPerson", beanDefinition);
        HelloPerson helloPerson = applicationContext.getBean("helloPerson", HelloPerson.class);
        assertThat(helloPerson.sayHello(), is("Hello!!! sleepbear"));


    }
}
