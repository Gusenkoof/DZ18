import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static com.codeborne.selenide.Selenide.open;

public class LoginPage extends LocatorsPage{
    void login() throws IOException{
        Properties properties = new Properties();
        properties.load(new FileInputStream("src/main/resources/user.properties"));
        userNameForm.sendKeys(properties.getProperty("user.username"));
        passwordForm.sendKeys(properties.getProperty("user.password"));
        loginButton.click();
    }

    public void openUrl() throws IOException{
        open("https://www.saucedemo.com/");
    }
}
