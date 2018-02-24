import java.net.URL;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.xml.DOMConfigurator;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { 
		"/test_application-context-properties.xml",
		"/test_application-context-dao.xml",
		"/test_application-context-logic.xml"}, inheritLocations = false)
public abstract class AbstractTest {
	
	private static final String LOG_PROPERTIES_FILE = "test_app-log4j.xml";

	static {
		try {
			URL path2Conf = Thread.currentThread().getContextClassLoader()
					.getResource(LOG_PROPERTIES_FILE);
			DOMConfigurator.configure(path2Conf);
		} catch (Exception e) {
			throw new RuntimeException("Unable to load logging property "
					+ LOG_PROPERTIES_FILE);
		}
	}

	protected Log logger = (Log) LogFactory.getLog(getClass());


	

}
