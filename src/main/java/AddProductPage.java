import io.qameta.allure.Step;

import java.io.IOException;

public class AddProductPage extends LocatorsPage{
// в этом классе описываем добовление товаров в корзину и переход в саму карзину
    @Step("Добавление продуктов в карзину")
    void addProduct() throws IOException{
        backpackAdd.click();
        jacketAdd.click();
        onesieAdd.click();
        basketButton.click();
    }
}
