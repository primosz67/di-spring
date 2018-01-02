package pl.tahona.di.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import pl.tahona.di.inject.InjectDefinition;
import pl.tahona.di.inject.SimpleInjectDefinition;
import pl.tahona.di.scanner.ScannerDefinition;
import pl.tahona.di.scanner.SimpleScannerDefinition;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class SpringConfiguration {

    private static final List<InjectDefinition> DEFINITIONS = Arrays.asList(
            new SimpleInjectDefinition<>(Autowired.class, a -> null)
    );

    private static final List<SimpleScannerDefinition> SCANNER_DEFINITIONS = Arrays.asList(
            new SimpleScannerDefinition<>(Component.class, Component::value),
            new SimpleScannerDefinition<>(Repository.class, Repository::value),
            new SimpleScannerDefinition<>(Service.class, Service::value)
    );

    private SpringConfiguration() {
    }

    public static Set<ScannerDefinition> scannerDefinitions() {
        return new HashSet<>(SCANNER_DEFINITIONS);
    }

    public static Set<InjectDefinition> injectDefinitions() {
        return new HashSet<>(DEFINITIONS);
    }
}
