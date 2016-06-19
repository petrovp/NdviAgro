package ndvi.agro.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class NdviAgroInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[]{AgroNdviConfig.class/*, SecurityConfig.class */};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[] {WebConfig.class  };
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

}
