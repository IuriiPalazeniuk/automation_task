package Pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class MyAccountPage extends BasePage{

    @FindBy(xpath = "//*[@class='account']/span")
    private WebElement userName;

    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    public String getUserName(){
      return userName.getText();
    }
}
