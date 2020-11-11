package market.tests;

import com.fasterxml.jackson.core.JsonProcessingException;
import market.api.restassured.steps.RestAssuredSteps;
import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ApiTest extends TestBase{
        @Test
        @Order(1)
        @DisplayName("Проверка на существования мерчанта с нужными данными")
        void GetMerchant() {
            RestAssuredSteps.getMerchantId();
        }
    @Test
    @Order(2)
    @DisplayName("Создание склада")
    void CreationOfStock()  {
        RestAssuredSteps.CreateStock();
    }

    @Test
    @Order(3)
    @DisplayName("список складов")
    void GetListOfStock()  {
        RestAssuredSteps.GetListOfStock();
    }

//    @Test
//    @Order(4)
//    @DisplayName("обновление склада")
//    void UpdateOfStock() {
//        RestAssuredSteps.UpdateOfStock(token);
//    }
    @Test
    @Order(4)
    @DisplayName("дерево категории")
    void treeOfcategory() {
        RestAssuredSteps.treeOfcategory();
    }
    @Test
    @Order(5)
    @DisplayName("список атрибутов и их значении")
    void listOfAttrAndValues() {
        RestAssuredSteps.listOfAttrAndValues();
    }

   @Test
    @Order(6)
    @DisplayName("добавление атрибутов")
    void AddAttributes()  {
        RestAssuredSteps.addAttributes();
    }

    @Test
    @Order(7)
    @DisplayName("добавление значение атрибутов")
    void AddAttributesValues() {
        RestAssuredSteps.addAttributesValues();
    }

    @Test
    @Order(8)
    @DisplayName("создание драфтового айтема")
    void createDraftItem() throws JsonProcessingException {
        RestAssuredSteps.createOrUpdateDraftItem();
    }

    @Test
    @Order(9)
    @DisplayName("отправка драфтового айтема на модерацию")
    void createItem() {
        RestAssuredSteps.draftToModeration();
    }
    @Test
    @Order(10)
    @DisplayName("удаление атрибутов")
    void deleteAttribute() {
        RestAssuredSteps.deleteAttributes();
    }
    @Test
    @Order(11)
    @DisplayName("удаление складов")
    void deleteStock() {
        RestAssuredSteps.deleteStock();
    }

//    @Test
//    @Order(12)
//    @DisplayName("проверка на наличие атрибутов у категории ")
//    void checkTheExistenceOfAttrInCategory() {
//        RestAssuredSteps.AttrInCategory();
//    }
    /// нужно сделать проверку на наличие атрибутов у категории
    @Test
    @Order(13)
    @DisplayName("создание товара через модератора")
    void moderatorCreateItem() throws JsonProcessingException {
        RestAssuredSteps.CreateItemModerator();
    }

//    @Test
//    @Order(14)
//    @DisplayName("загрузка прайслиста с имеющиесями товарами с мастера товара")
//    void pricelistModerator() {
//        RestAssuredSteps.UploadPricelistModerator();
//    }
    @Test
    @Order(15)
    @DisplayName("загрузка прайслиста с подписанными товарами")
    void pricelistWithSubcribedItems() {
        RestAssuredSteps.UploadPricelistModerator();
    }
//    @Test
//    @Order(16)
//    @DisplayName("проверка на наличие товаров в неопубликованных/опубликованных с ценой и складами из прайслиста")
//    void checkPublishedUnpublishedWithPriceAndStocks() {
//        RestAssuredSteps.CheckPublishedUnpublished();
//    }
//    @Test
//    @Order(17)
//    @DisplayName("активировать товар с неопубликованных")
//    void ActivationItemsFromUnpublished() {
//        RestAssuredSteps.ItemActivation();
//    }
//    @Test
//    @Order(18)
//    @DisplayName("проверка наличия опубликованных товаров в приложении")
//    void CheckingCatalogOfPublishedItems() {
//        RestAssuredSteps.CheckExistenceOfItemsInMobile();
//    }
//
//    @Test
//    @Order(19)
//    @DisplayName("вывод списка мерчанта")
//    void GetlistOfMerchants() {
//        RestAssuredSteps.ListOfMerchants();
//    }
//
//
//    @Test
//    @Order(20)
//    @DisplayName("создание заказа")
//    void creationOrder() {
//        RestAssuredSteps.CreateOrder();
//    }
//    @Test
//    @Order(21)
//    @DisplayName("поменять на статус оплачен")
//    void changeStatusPayed() {
//        RestAssuredSteps.ChangeStatus();
//    }
//    @Test
//    @Order(22)
//    @DisplayName("поменять на статус потвержден")
//    void changeStatusConfirmed() {
//        RestAssuredSteps.ChangeStatus();
//    }
//    @Test
//    @Order(23)
//    @DisplayName("поменять на статус доставлен/забран")
//    void changeStatusDelivered() {
//        RestAssuredSteps.ChangeStatus();
//    }



//    @Test
//    @Order(10)
//    @DisplayName("подписка на айтем")
//    void itemSubscribe() {
//        RestAssuredSteps.itemSubscribe(token);
//    }




}

