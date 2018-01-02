package pl.tahona.di.spring.testAnnotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class TestService {

    @Autowired
    private TestComponent testComponent;

    @Inject
    private  TestRepository testRepository;

    @Inject
    private  TestRepositoryInterface testRepositoryInterface;


    public TestComponent getTestComponent() {
        return testComponent;
    }

    public TestRepository getTestRepository() {
        return testRepository;
    }

    public TestRepositoryInterface getTestRepositoryInterface() {
        return testRepositoryInterface;
    }
}
