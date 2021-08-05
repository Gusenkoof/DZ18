import java.io.IOException;

public class AddProductPage extends LocatorsPage{
// в этом классе описываем добовление товаров в корзину и переход в саму карзину
    void addProduct() throws IOException{
        backpackAdd.click();
        jacketAdd.click();
        onesieAdd.click();
        basketButton.click();
    }
}
