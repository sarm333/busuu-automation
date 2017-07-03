package busuu;

import org.apache.log4j.Logger;
import org.testng.annotations.*;

import java.lang.reflect.Method;

public class AbstractTestCase {

    protected final Logger logger = Logger.getLogger(getClass());

    @BeforeMethod
    public void beforeMethod(Method method) {
        logger.info("Executing Test Case: [" + method.getName() + "]");

    }

    @AfterMethod
    public void afterMethod(Method method) {
        logger.info("Ending Test Case: [" + method.getName() + "]");
    }
}
