package market.api.restassured.steps;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import market.api.model.*;
import market.api.restassured.spec.Utils;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

public class RestAssuredSteps {
    protected static String token;
    protected static Long merchantId;
    protected static Integer stockId;
    protected static Integer catId;
    protected static Integer attributId;
    protected static Integer draftItemId;
    protected static Integer itemId;
    protected static Integer attributeValueId;


    public static String login(String email, String password) {
        SignInMerchantModerator moderator = new SignInMerchantModerator(email, password);

        Token token1 = given()
                .contentType(ContentType.JSON)
                .body(moderator)
                .when()
                .post("/auth/merchant/login")
                .then()
                .log().body()
                .statusCode(200)
                .body("accessToken", is(notNullValue()))
                .extract()
                .response()
                .as(Token.class);

        return token = token1.getAccessToken();
    }

    public static Long getMerchantId(String token) {

        List<Merchant> merchants = Arrays.asList(
                given()
                        .auth().oauth2(token)
                        .when()
                        .get("/user/v1/profiles/all")
                        .then()
                        .statusCode(200)
                        .extract()
                        .body()
                        .as(Merchant[].class));


        merchants.forEach(e -> {
            if (e.getCompanyName().equals("Vlife Moderator")) {
                merchantId = e.getId();

            }
        });
        return merchantId;
    }

    public static Integer CreateStock(String token) throws JsonProcessingException {
        Map maps = new Map(0.0, 0.0);
        Address address = new Address("Almaty", 2, "Kazakhstan", 110, 150, "Абая");
        CityDto cityDto = new CityDto("code", "countryCode", "countryName", 4, maps);
        Schedule monday = new Schedule("MONDAY", "07:00", true, true, "21:00");
        Schedule tuesday = new Schedule("TUESDAY", "07:00", true, true, "21:00");
        Schedule wednesday = new Schedule("WEDNESDAY", "07:00", true, true, "21:00");
        Schedule thursday = new Schedule("THURSDAY", "07:00", true, true, "21:00");
        Schedule friday = new Schedule("FRIDAY", "07:00", true, true, "21:00");
        Schedule saturday = new Schedule("SATURDAY", "07:00", true, true, "21:00");
        Schedule sunday = new Schedule("SUNDAY", "07:00", true, true, "21:00");
        List<Schedule> schedule = Arrays.asList(monday, tuesday, wednesday, thursday, friday, saturday, sunday);

        Stock stock1 = new Stock(Boolean.TRUE, address, "buildingType", cityDto, merchantId, "StoreName213", "77029203758", Boolean.TRUE, schedule);
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = ow.writeValueAsString(stock1);
        System.out.println(json);
        Response stockId2 = given()
                .auth().oauth2(token)
                .contentType(ContentType.JSON)
                .body(stock1)
                .when()
                .post("/market/core/v1/stocks/create")
                .then()
                .statusCode(200)
                .log().body()
                .extract()
                .response();

        stockId = stockId2.path("id");

        return stockId;
    }

    public static void GetListOfStock(String token) {

        given()
                .auth().oauth2(token)
                .when()
                .get("/market/core/v1/stocks")
                .then()
                .statusCode(200)
                .log().body()
                .extract()
                .response();
    }

    public static void UpdateOfStock(String token) {
        Map maps = new Map(0.0, 0.0);
        Address address = new Address("Almaty", 2, "Kazakhstan", 110, 150, "Абая");
        CityDto cityDto = new CityDto("code", "countryCode", "countryName", 4, maps);
        Schedule monday = new Schedule("MONDAY", "07:00", true, true, "21:00");
        Schedule tuesday = new Schedule("TUESDAY", "07:00", true, true, "21:00");
        Schedule wednesday = new Schedule("WEDNESDAY", "07:00", true, true, "21:00");
        Schedule thursday = new Schedule("THURSDAY", "07:00", true, true, "21:00");
        Schedule friday = new Schedule("FRIDAY", "07:00", true, true, "21:00");
        Schedule saturday = new Schedule("SATURDAY", "07:00", true, true, "21:00");
        Schedule sunday = new Schedule("SUNDAY", "07:00", true, true, "21:00");
        List<Schedule> schedule = Arrays.asList(monday, tuesday, wednesday, thursday, friday, saturday, sunday);

        Stock stock1 = new Stock(Boolean.TRUE, address, "buildingType", cityDto, merchantId, "StoreName213", "77029203758", Boolean.TRUE, schedule);

        given()
                .auth().oauth2(token)
                .contentType("application/json-patch+json")
                .body(stock1)
                .when()
                .patch("/market/core/v1/stocks/{stockId}", stockId)
                .then()
                .log().body()
                .statusCode(200)
                .log().body()
                .extract()
                .response();
    }

    public static void deleteStock(String token) {
        given()
                .auth().oauth2(token)
                .when()
                .delete("/market/core/v1/stocks/{stockId}", stockId)
                .then()
                .statusCode(200)
                .log().body()
                .extract()
                .response();
    }


    public static void treeOfcategory(String token) {

        Response categoryId = given()
                .auth().oauth2(token)
                .when()
                .get("/market/catalog/v2/categories")
                .then()
                .statusCode(200)
                .log().body()
                .extract()
                .response();
        catId = categoryId.path("list[0].children[1].children[1].id");
        System.out.println(catId);
    }

    public static void listOfAttrAndValues(String token) {

        Response attrId = given()
                .queryParams("page", 0, "pageSize", 25)
                .auth().oauth2(token)
                .when()
                .get("/market/core/v1/category/{catId}/all", catId)
                .then()
                .log().body()
                .statusCode(200)
                .extract()
                .response();
        attributId = attrId.path("id");
    }

    public static void addAttributes(String token) throws JsonProcessingException {

        String generatedString = Utils.getRandomString(10);

        ValuesOnDiffLocale names = new ValuesOnDiffLocale(generatedString, generatedString, generatedString, generatedString, generatedString);


        Attribute attributes = new Attribute(catId, true, true, false, 0, names);
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = ow.writeValueAsString(attributes);
        System.out.println(json);
        System.out.println(attributes);
        Response attributesId = given()
                .auth().oauth2(token)
                .header("Accept-Language", "ru")
                .contentType(ContentType.JSON)
                .body(attributes)
                .when()
                .post("/market/core/v1/attribute/add")
                .then()
                .log().body()
                .statusCode(200)
                .log().body()
                .extract()
                .response();
        attributId = attributesId.path("id");
    }

    public static void addAttributesValues(String token) {
        String generatedString = Utils.getRandomString(10);

        ValuesOnDiffLocale names = new ValuesOnDiffLocale(generatedString, generatedString,generatedString,generatedString,generatedString);

        AttributeValues attributeValues = new AttributeValues(attributId, true, 0, names);
        Response attrValId = given()
                .auth().oauth2(token)
                .contentType(ContentType.JSON)
                .body(attributeValues)
                .when()
                .post("/market/core/v1/attribute-value/add")
                .then()
                .statusCode(200)
                .log().body()
                .extract()
                .response();
        attributeValueId = attrValId.path("id");
    }

    public static void deleteAttributes(String token) {

        given()
                .auth().oauth2(token)
                .when()
                .delete("/market/core/v1/attribute/{id}",attributId)
                .then()
                .statusCode(200)
                .log().body()
                .extract()
                .response();
    }
    ///v1/attribute/{id}

    public static void itemMultipart(String token) {
        MultipartItem multi = new MultipartItem();
        Response categoryId = given()
                .auth().oauth2(token)
                .contentType(ContentType.JSON)
                .body(multi)
                .when()
                .post("/market/core/v1/items/multipart")
                .then()
                .statusCode(200)
                .log().body()
                .extract()
                .response();
        //        Content-Disposition: form-data; name="request"; filename="blob"
        //        Content-Type: application/json
    }

    public static void createOrUpdateDraftItem(String token) throws JsonProcessingException {
        AttributeValues attributes1 =  new AttributeValues( attributId, attributeValueId,  true, "value");
        AttributeValues attributes2 =  new AttributeValues( attributId, attributeValueId,  true, "value1");
        String generatedString = Utils.getRandomString(10);
        List<AttributeValues> attributes = Arrays.asList(attributes1,attributes2);
        List<Integer> stockIds = Collections.singletonList(stockId);

        DraftItem draftItem = new DraftItem(catId, 0, generatedString,  generatedString,  generatedString,  "4444",  generatedString,  attributes, stockIds);
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = ow.writeValueAsString(draftItem);
        System.out.println(json);
        Response draftId = given()
                .auth().oauth2(token)
                .header("Accept-Language", "ru")
                .contentType(ContentType.JSON)
                .body(draftItem)
                .when()
                .post("/market/core/v1/drafts/items")
                .then()
                .log().body()
                .statusCode(200)
                .log().body()
                .extract()
                .response();
        draftItemId = draftId.path("id");
    }

//    ///v1/drafts/items/{draftId}/moderate
public static void draftToModeration(String token) {

    given()
            .auth().oauth2(token)
            .when()
            .put("/market/core/v1/drafts/items/{draftId}/moderate", draftItemId )
            .then()
            .log().body()
            .statusCode(200)
            .log().body()
            .extract()
            .response();

}

    public static void createItemFromDraft(String token) {

        Response item =  given()
                .auth().oauth2(token)
                .when()
                .post("/market/core/v1/drafts/items/{draftItemId}/create", draftItemId )
                .then()
                .log().body()
                .statusCode(200)
                .log().body()
                .extract()
                .response();
        itemId = item.path("id");
    }

    public static void itemSubscribe(String token) {
        ItemSubscription itemSubscription = new ItemSubscription();
        given()
                .auth().oauth2(token)
                .contentType(ContentType.JSON)
                .body(itemSubscription)
                .when()
                .post("market/core/v1/items/{itemId}/subscribe", itemId )
                .then()
                .log().body()
                .statusCode(200)
                .log().body()
                .extract()
                .response();
    }

//    {
//    "merchantVendorCode": "dsfs34fwe",
//    "price": "12243",
//    "productCode": "asfdsfwq",
//    "quantity": 1,
//    "stockIdList": [398]
//}
//https://api.dev.vlife.kz/market/core/v1/items/{{item}}/subscribe
//    https://api.dev.vlife.kz/market/core/v1/drafts/items/{{draftItemId}}/create
}