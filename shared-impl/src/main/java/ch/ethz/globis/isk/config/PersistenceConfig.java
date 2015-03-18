package ch.ethz.globis.isk.config;

import ch.ethz.globis.isk.domain.*;
import com.mongodb.MongoClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.core.MongoTemplate;


/**
 * The main configuration class for Spring.
 *
 * The @Configuration annotation marks it as a configuration class.
 * The @ComponentScan annotation marks the packages that will be scanned by Spring. Any Java classes
 * in these files that are annotated by @Component, @Service or @Repository will be instantiated automatically
 * by Spring. Moreover, any member attributes of objects corresponding to Spring managed classes and which are annotated
 * by @Autowired are automatically populated through dependency injection.
 * The @PropertySource annotation specifies a list of property files that Spring will scan for any properties.
 *
 */
@Configuration
@ComponentScan(basePackages = { "ch.ethz.globis.isk.persistence",
                                "ch.ethz.globis.isk.domain",
                                "ch.ethz.globis.isk.transaction",
                                "ch.ethz.globis.isk.service"})
public class PersistenceConfig {

    /**
     * A reference to the Spring Environment. The Environment contains all the properties
     * in the property files listed as arguments to the @PropertySource annotation.
     *
     * Spring scans these files automatically once the annotation @PropertySource is set on a
     * class also marked with the @Configuration annotation.
     */
    @Autowired
    Environment environment;

    /**
     * A Boolean bean whose value determines if the database needs to be cleared on
     * startup.
     *
     * This is true in case of the profiles 'import' and 'test'.
     * @return                              True for the profiles 'import' and 'test'.
     */
    @Bean(name = "dropDatabase")
    @Profile({"import", "test"})
    Boolean dropDatabase() {
        return true;
    }

    /**
     * A Boolean bean whose value determines if the database needs to be cleared on
     * startup.
     *
     * This is false in case of the profile 'production'
     * @return                              False for the profiles ''production'.
     */
    @Bean(name = "dropDatabase")
    @Profile({"production"})
    Boolean productionDropDatabase() {
        return false;
    }

    /**
     * A String bean representing the name of the database to be used.
     *
     * The name is only used if the profile 'test' is active.
     * @return                              The name of the database.
     */
    @Bean(name = "databaseName")
    @Profile("test")
    String testDatabaseName() {
        return "dblp-test";
    }

    /**
     * A String bean representing the name of the database to be used.
     *
     * The name is only used if one of the profiles 'production' or 'import' is active.
     * @return                              The name of the database.
     */
    @Bean(name = "databaseName")
    @Profile({"production", "import"})
    String productionDatabaseName() {
        return "dblp";
    }
}