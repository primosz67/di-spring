package pl.tahona.di.spring;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import pl.tahona.di.BeanContainer;
import pl.tahona.di.Injector;
import pl.tahona.di.scanner.BeanScanner;
import pl.tahona.di.spring.testAnnotations.TestComponent;
import pl.tahona.di.spring.testAnnotations.TestRepositoryInterface;
import pl.tahona.di.spring.testAnnotations.TestService;

import static org.junit.Assert.assertNotNull;

@RunWith(value = JUnit4.class)
public class SpringBeanScannerTest {

    @Test
    public void shouldFindBeans() {
        //given
        final Injector injector = new Injector();
        injector.addDefinitions(SpringConfiguration.injectDefinitions());
        injector.addDefinitions(JavaStandardConfiguration.injectDefinitions());

        final BeanScanner scanner = new BeanScanner("pl.tahona.di.spring.testAnnotations");
        scanner.addDefinitions(SpringConfiguration.scannerDefinitions());
        injector.registerAll(scanner.scan());

        final BeanContainer beanContainer = new BeanContainer(injector);
        //when
        beanContainer.initialize();

        //then
        final TestService service = beanContainer.getBean(TestService.class);

        assertNotNull(beanContainer.getBean(TestComponent.class));
        assertNotNull(beanContainer.getBean("testComponentSuperName"));
        assertNotNull(beanContainer.getBean(TestRepositoryInterface.class));
        assertNotNull(service);
        assertNotNull(service.getTestComponent());
        assertNotNull(service.getTestRepository());
        assertNotNull(service.getTestRepositoryInterface());
    }
}