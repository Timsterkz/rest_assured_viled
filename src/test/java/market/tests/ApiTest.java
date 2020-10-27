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
            RestAssuredSteps.getMerchantId(token);
        }
    @Test
    @Order(2)
    @DisplayName("Создание склада")
    void CreationOfStock() throws JsonProcessingException {
        RestAssuredSteps.CreateStock(token);
    }

    @Test
    @Order(3)
    @DisplayName("список складов")
    void GetListOfStock() throws JsonProcessingException {
        RestAssuredSteps.GetListOfStock(token);
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
        RestAssuredSteps.treeOfcategory(token);
    }
    @Test
    @Order(5)
    @DisplayName("список атрибутов и их значении")
    void listOfAttrAndValues() {
        RestAssuredSteps.listOfAttrAndValues(token);
    }
    @Test
    @Order(6)
    @DisplayName("добавление атрибутов")
    void AddAttributes() throws JsonProcessingException {
        RestAssuredSteps.addAttributes(token);
    }

    @Test
    @Order(7)
    @DisplayName("добавление значение атрибутов")
    void AddAttributesValues() {
        RestAssuredSteps.addAttributesValues(token);
    }

    @Test
    @Order(8)
    @DisplayName("создание драфтового айтема")
    void createDraftItem() throws JsonProcessingException {
        RestAssuredSteps.createOrUpdateDraftItem(token);
    }

    @Test
    @Order(9)
    @DisplayName("отправка драфтового айтема на модерацию")
    void createItem() {
        RestAssuredSteps.draftToModeration(token);
    }
    @Test
    @Order(9)
    @DisplayName("удаление атрибутов")
    void deleteAttribute() {
        RestAssuredSteps.deleteAttributes(token);
    }
    @Test
    @Order(9)
    @DisplayName("удаление складов")
    void deleteStock() {
        RestAssuredSteps.deleteStock(token);
    }

//    @Test
//    @Order(10)
//    @DisplayName("подписка на айтем")
//    void itemSubscribe() {
//        RestAssuredSteps.itemSubscribe(token);
//    }




}

