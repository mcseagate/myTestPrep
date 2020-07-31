import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import rootpage.TestBase;

public class LoginPage extends TestBase {

    JavascriptExecutor js = (JavascriptExecutor) driver;

    public LoginPage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(id="login-button")
    WebElement loginlink;

    @FindBy(id="login-email")
    WebElement emailfield;

    @FindBy(id="login-password")
    WebElement password;

    @FindBy(id="login-form")
    WebElement loginbtn;





    public void loginlink(){
        loginlink.click();
    }

    public void emailfield(){
        emailfield.sendKeys(prop.getProperty("username"));
    }

    public void password(){
        password.sendKeys(prop.getProperty("password"));
    }

    public void loginbtn(){
        loginbtn.click();
    }

    public void login(){
        loginlink();
        emailfield();
        password();
        loginbtn();
    }
}
