package org.springframework.beans.factory.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target(value = {CONSTRUCTOR, METHOD, PARAMETER, FIELD, ANNOTATION_TYPE})
@Retention(value = RUNTIME)
@Documented
public @interface Autowired {

}