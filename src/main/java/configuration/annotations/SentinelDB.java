package configuration.annotations;

import org.springframework.beans.factory.annotation.Qualifier;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author Alina_Tamkevich
 */
@Retention(RetentionPolicy.RUNTIME)
@Qualifier
public @interface SentinelDB {
}
