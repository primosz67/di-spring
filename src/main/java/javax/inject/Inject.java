package javax.inject;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target(value = {TYPE, FIELD, METHOD})
@Retention(value = RUNTIME)
public @interface Inject {
}
