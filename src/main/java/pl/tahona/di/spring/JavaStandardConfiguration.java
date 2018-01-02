package pl.tahona.di.spring;

import pl.tahona.di.inject.InjectDefinition;
import pl.tahona.di.inject.SimpleInjectDefinition;
import pl.tahona.di.scanner.ScannerDefinition;
import pl.tahona.di.scanner.SimpleScannerDefinition;

import javax.annotation.Resource;
import javax.inject.Inject;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class JavaStandardConfiguration {

    private static final List<InjectDefinition> DEFINITIONS = Arrays.asList(
            new SimpleInjectDefinition<>(Resource.class, Resource::name),
            new SimpleInjectDefinition<>(Inject.class, x -> null)
    );

    private JavaStandardConfiguration() {

    }

    public static Set<InjectDefinition> injectDefinitions() {
        return new HashSet<>(DEFINITIONS);
    }
}



