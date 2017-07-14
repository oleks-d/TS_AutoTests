package annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by odiachuk on 14.07.17.
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface TestName {
    String name() default "";
}
