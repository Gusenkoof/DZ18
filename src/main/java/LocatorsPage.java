import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LocatorsPage {
    SelenideElement userNameForm = $(By.id("user-name"));
    SelenideElement passwordForm = $(By.id("password"));
    SelenideElement loginButton = $(By.id("login-button"));
    SelenideElement startMessage = $(By.className("title"));
    SelenideElement backpackAdd = $(By.id("add-to-cart-sauce-labs-backpack"));
    SelenideElement jacketAdd = $(By.id("add-to-cart-sauce-labs-fleece-jacket"));
    SelenideElement onesieAdd = $(By.id("add-to-cart-sauce-labs-onesie"));
    SelenideElement basketButton = $(By.className("shopping_cart_link"));
    SelenideElement checkoutButton = $(By.id("checkout"));
    SelenideElement firstNameForm = $(By.id("first-name"));
    SelenideElement lastNameForm = $(By.id("last-name"));
    SelenideElement postalCodeForm = $(By.id("postal-code"));
    SelenideElement continueButton = $(By.id("continue"));
    SelenideElement finishButton = $(By.id("finish"));
    SelenideElement finishMessage = $(By.className("title"));
    SelenideElement cancelButton = $(By.id("cancel"));










}
