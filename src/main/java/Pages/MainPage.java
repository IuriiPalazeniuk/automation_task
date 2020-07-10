package Pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


@Getter
public class MainPage extends BasePage {

    @FindBy(xpath = "//*[@class='login']")
    private WebElement logIn;

    @FindBy(xpath = "//*[@class='logout']")
    private WebElement logOut;

    public MainPage(WebDriver driver) {
        super(driver);
    }

}
