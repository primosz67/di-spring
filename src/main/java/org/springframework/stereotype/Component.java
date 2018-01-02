package org.springframework.stereotype;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target(value = TYPE)
@Retention(value = RUNTIME)
@Documented
public @interface Component {
    String value() default "";
}
