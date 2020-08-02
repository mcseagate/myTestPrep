import org.testng.Assert;
import org.testng.annotations.*;
import rootpage.TestBase;

public class LoginTest extends TestBase {

    LoginPage lp;

    public LoginTest() {

        super();
    }

    @BeforeTest

    public void setUp(){

        initialization();
    }

    @Test
    public void userlogintest(){
        lp = new LoginPage();
        lp.login();
    }

    @Test
    public void verifyTitle(){
        String title = driver.getTitle();
        if(title != null){
            System.out.println(title);
        }
        else{
            System.out.println("Page has no title");
        }
    }

    @AfterTest
    public void tearDown(){

        if(driver != null){
            driver.quit();
            driver = null;
        }

    }


}
