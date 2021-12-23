import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class example
{
    By usernameLocator = By.id("username");
    By passwordLocator = By.id("passwd");
    By loginButtonLocator = By.id("login");
    private final WebDriver driver;
    public example(WebDriver driver)
    {
        this.driver = driver;
        if (!"Login".equals(driver.getTitle()))
        {
            throw new IllegalStateException("This is not the login page");
        }
    }
    public example typeUsername(String username)
    {
        driver.findElement(usernameLocator).sendKeys(username);
        return this;
    }
    public example typePassword(String password)
    {
        driver.findElement(passwordLocator).sendKeys(password);
        return this;
    }
    public example submitLoginExpectingFailure()
    {
        driver.findElement(loginButtonLocator).submit();
        return new example(driver);
    }
}
