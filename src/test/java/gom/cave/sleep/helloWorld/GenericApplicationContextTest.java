package gom.cave.sleep.helloWorld;

import gom.cave.sleep.helloWorld.hello.HelloPerson;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.Test;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.support.GenericApplicationContext;

/**
 * Created by sleepbear on 2016. 5. 11..
 */
public class GenericApplicationContextTest {
    @Test
    public void testApplicationContext() throws Exception {
        GenericApplicationContext applicationContext = new GenericApplicationContext();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(applicationContext);
        reader.loadBeanDefinitions("applicationContext.xml");
        applicationContext.refresh();
        HelloPerson helloPerson = applicationContext.getBean("helloPerson", HelloPerson.class);
        MatcherAssert.assertThat(helloPerson.sayHello(), CoreMatchers.is("Hello!!! sleepbear"));
    }
}
