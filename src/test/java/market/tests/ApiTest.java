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
    void CreationOfStock() throws JsonProcessingException {
        RestAssuredSteps.CreateStock();
    }

    @Test
    @Order(3)
    @DisplayName("список складов")
    void GetListOfStock() throws JsonProcessingException {
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
    void AddAttributes() throws JsonProcessingException {
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
    @Test
    @Order(12)
    @DisplayName("создание товара через модератора")
    void moderatorCreateItem() {
        RestAssuredSteps.CreateItemModerator();
    }
//    @Test
//    @Order(13)
//    @DisplayName("создание заказа")
//    void creationOrder() {
//        RestAssuredSteps.CreateOrder();
//    }
//    @Test
//    @Order(14)
//    @DisplayName("поменять на статус оплачен")
//    void changeStatusPayed() {
//        RestAssuredSteps.ChangeStatus();
//    }
//    @Test
//    @Order(15)
//    @DisplayName("поменять на статус потвержден")
//    void changeStatusConfirmed() {
//        RestAssuredSteps.ChangeStatus();
//    }
//    @Test
//    @Order(16)
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

