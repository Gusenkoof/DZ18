import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FillingFormPage extends LocatorsPage{
    void fillingForm() throws IOException{
        Properties properties = new Properties();
        properties.load(new FileInputStream("src/main/resources/user.properties"));
        firstNameForm.sendKeys(properties.getProperty("user.firstname"));
        lastNameForm.sendKeys(properties.getProperty("user.lastname"));
        postalCodeForm.sendKeys(properties.getProperty("user.postalcode"));
        continueButton.click();
    }
}
