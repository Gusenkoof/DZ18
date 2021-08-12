import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;

import java.io.IOException;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SaucedemoTest {

    @BeforeEach
    public void setUp(){
        Configuration.startMaximized = true;
    }

    @AfterEach
    public void tearDown(){
        closeWebDriver();
    }

    @Test
    @Order(1)
    public void loginTest() throws IOException {
        LoginPage loginPage = new LoginPage();
        loginPage.openUrl();
        loginPage.login();
        loginPage.startMessage.shouldBe(visible);
        //проверка
        Assertions.assertEquals("PRODUCTS", loginPage.startMessage.getText(), "Вы зашли не на ту страницу");
    }

    @Test
    @Order(2)
    public void purchaseTest() throws IOException{
        LoginPage loginPage = new LoginPage();
        AddProductPage addPro = new AddProductPage();
        FillingFormPage fillingFormPage = new FillingFormPage();
        loginPage.openUrl();
        loginPage.login();
        addPro.addProduct();
        addPro.checkoutButton.click();
        fillingFormPage.fillingForm();
        fillingFormPage.finishButton.click();
        fillingFormPage.finishMessage.shouldBe(visible);
        // проверка
        Assertions.assertEquals("CHECKOUT: COMPLETE!", fillingFormPage.finishMessage.getText(), "Чтото пошло не так!");

    }

    @Test
    @Order(3)
    public void cancelingPurchaseTest() throws  IOException{
        LoginPage loginPage = new LoginPage();
        AddProductPage addPro = new AddProductPage();
        FillingFormPage fillingFormPage = new FillingFormPage();
        loginPage.openUrl();
        loginPage.login();
        addPro.addProduct();
        addPro.checkoutButton.click();
        fillingFormPage.fillingForm();
        fillingFormPage.cancelButton.click();
        fillingFormPage.startMessage.shouldBe(visible);
        // Проверка
        Assertions.assertEquals("PRODUCTS", fillingFormPage.startMessage.getText(), "Чтото пошло не так!");

    }

    @Test
    @Order(4)
    public void deletingProductsTest() throws IOException{
        LoginPage loginPage = new LoginPage();
        AddProductPage addPro = new AddProductPage();
        loginPage.openUrl();
        loginPage.login();
        addPro.addProduct();
        ElementsCollection removeButtonBefore = $$(By.xpath("//button[text()='Remove']"));
        int remBttSizeBefore = removeButtonBefore.size();
        for (int i = 0; i < remBttSizeBefore; i++){
            removeButtonBefore.first().click();
        }
        // проверка того что все товары удалены из карзины
        ElementsCollection removeButtonAfter = $$(By.xpath("//button[text()='Remove']"));
        int remBttSizeAfter = removeButtonAfter.size();
        Assertions.assertEquals(0, remBttSizeAfter, "Не все товары удалились из корзины");
        //или так(еще проще)
        $$(By.xpath("//button[text()='Remove']")).shouldHave(size(0));

    }

    @Test
    @Order(5)
    public void calculatingAmountTest() throws IOException{
        LoginPage loginPage = new LoginPage();
        AddProductPage addPro = new AddProductPage();
        FillingFormPage fillingFormPage = new FillingFormPage();
        loginPage.openUrl();
        loginPage.login();
        addPro.addProduct();
        addPro.checkoutButton.click();
        fillingFormPage.fillingForm();

        // Создаем коллекцию
        ElementsCollection collectionPrices = $$(By.className("inventory_item_price"));
        int collectionPricesSize = collectionPrices.size();

        // Считаем сумму товаров
        Double sum = 0.00;
        for (int i = 0; i < collectionPricesSize; i++){
            String stringCollection = $$(By.className("inventory_item_price")).get(i).getText().replace("$", "");
            Double doubleCollection = Double.parseDouble(stringCollection);
            sum = sum + doubleCollection;
        }
        // Находим значение общей суммы посчитанной на странице
        String stringPrice = $(By.className("summary_subtotal_label")).getText().replace("Item total: $", "");
        Double doublePrice = Double.parseDouble(stringPrice);

        // Проверяем правильно ли подсчитана сумма
        Assertions.assertEquals(doublePrice, sum, "Не верно посчитана сумма");

    }

}
