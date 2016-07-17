package ndvi.agro.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@Configuration
@Import(value = {
		WebConfig.class,
		PersistenceConfig.class,
		SecurityConfig.class,
		})
@ComponentScan(basePackages =  { 
		"ndvi.agro.config",
		"ndvi.agro.service" 
		})
public class AgroNdviConfig {
	

	@Bean
    PropertySourcesPlaceholderConfigurer propertyPlaceHolderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
