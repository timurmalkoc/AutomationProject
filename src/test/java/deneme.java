import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import reportConfig.Log;
import utils.TestBase;

public class deneme extends TestBase {
    @Test
    public void test() throws InterruptedException {

        Log.info("hi");
    }
}
