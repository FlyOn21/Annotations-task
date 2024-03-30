package app;


import java.lang.annotation.*;

@Inherited
@Target({ ElementType.TYPE, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
public @interface Product {
    String name() default "unknown";
    int quota() default 0;
}
