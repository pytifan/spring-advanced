import beans.ServiceConfig;
import beans.configuration.AppConfiguration;
import beans.configuration.AuditoriumConfiguration;
import beans.configuration.StrategiesConfiguration;
import beans.configuration.db.DataSourceConfiguration;
import beans.configuration.db.DbSessionFactory;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Created by oleksiiprokopenko on 06/11/2017.
 */
public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{ServiceConfig.class, AppConfiguration.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
