import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import rootpage.TestBase;

public class LoginTest extends TestBase {

    LoginPage lp;

    public LoginTest(){
        super();
    }

    @BeforeMethod

    public void setUp(){
        initialization();
    }

    @Test
    public void userlogintest(){
        lp = new LoginPage();
        lp.login();

    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }


}
