package Pages;

import lombok.Getter;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


@Slf4j
@Getter
public class SingInPage extends BasePage {

    @FindBy(id = "email")
    private WebElement mailField;

    @FindBy(id = "passwd")
    private WebElement passwordField;

    @FindBy(id = "SubmitLogin")
    private WebElement signInButton;


    public SingInPage(WebDriver driver) {
        super(driver);
    }

    @SneakyThrows
    public void fillInputFieldByName(String mail, String password) {
        mailField.sendKeys(mail);
        passwordField.sendKeys(password);
        signInButton.click();
    }


}
