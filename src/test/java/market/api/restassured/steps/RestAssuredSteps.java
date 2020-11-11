package market.api.restassured.steps;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import market.api.model.*;
import market.api.restassured.spec.Utils;
import market.config.ConfigHelper;

import java.io.File;
import java.util.*;

import static io.restassured.RestAssured.given;
import static io.restassured.http.Method.*;
import static market.api.restassured.spec.CustomSpec.executeRequestWithSpec;
import static market.api.restassured.spec.CustomSpec.speci;

public class RestAssuredSteps {

    private static String token;
    private static Long merchantId;
    private static Integer stockId;
    private static Integer catId;
    private static Integer attributId;
    private static Integer draftItemId;
    private static Integer itemId;
    private static Integer attributeValueId;
    private static Integer itemPriceId;
    private static String path = "./src/test/java/market/api/restassured/steps/files/Н0000022828.jpeg";
    private static String path2 = "./src/test/java/market/api/restassured/steps/files/Н0000022828.jpeg";
    private static String path3 = "./src/test/java/market/api/restassured/steps/files/test.xlsx";



    public static String login(String email, String password) {
        SignInMerchantModerator moderator = new SignInMerchantModerator(email, password);
//        Token token1 = postReqWithoutAuthAndBody("/auth/merchant/login", moderator).as(Token.class);

        Token token1 = given()

                .contentType(ContentType.JSON)
                .body(moderator)
                .when()
                .post(ConfigHelper.getBaseURL()+"/auth/merchant/login")
                .then()
                .log().body()
                .statusCode(200)
                .extract()
                .response()
                .as(Token.class);
        return token = token1.getAccessToken();
    }

    public static void getMerchantId() {

        List<Merchant> merchants = Arrays.asList(
                executeRequestWithSpec(GET,"/user/v1/profiles/all", null, new HashMap<>())
                        .as(Merchant[].class));
        merchants.forEach(e -> {
            if (e.getCompanyName().equals("Vlife Moderator")) {
                merchantId = e.getId();
            }
        });
    }

    public static void CreateStock() {
        Coordinate maps = new Coordinate(0.0, 0.0);
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

        Response stockId2 = executeRequestWithSpec(POST,ConfigHelper.getBaseURL()+ ConfigHelper.getBasePath()+"/v1/stocks/create", stock1, null);

        stockId = stockId2.path("id");

    }

    public static void GetListOfStock() {

        Response stockId2 = executeRequestWithSpec(GET, ConfigHelper.getBaseURL() + ConfigHelper.getBasePath() + "/v1/stocks", null);
    }

    public static void UpdateOfStock() {
        Coordinate maps = new Coordinate(0.0, 0.0);
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
//        Response stockId2 = executeRequestWithSpec(POST,ConfigHelper.getBaseURL()+ ConfigHelper.getBasePath()+"/v1/stocks/create", stock1);

        given()
                .spec(speci().requestWithAuth())
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

    public static void deleteStock() {
        executeRequestWithSpec(DELETE, ConfigHelper.getBaseURL() + ConfigHelper.getBasePath() + "/v1/stocks/" + stockId, null);
    }

    public static void treeOfcategory() {
        Response categoryId = executeRequestWithSpec(GET,ConfigHelper.getBaseURL()+ "/market/catalog/v2/categories", null);
        catId = categoryId.path("list[0].children[1].children[1].id");
    }

    public static void listOfAttrAndValues() {
        Map<String, Object> params = new HashMap<>();
        params.put("page", 0);
        params.put("pageSize", 20);

        Response attrId = executeRequestWithSpec(GET,ConfigHelper.getBaseURL()+ ConfigHelper.getBasePath()+"/v1/category/"+catId+"/all", null, params);
        attributId = attrId.path("id");
    }

    public static void addAttributes(){

        String generatedString = Utils.getRandomString(10);

        ValuesOnDiffLocale names = new ValuesOnDiffLocale(generatedString, generatedString, generatedString, generatedString, generatedString);

        Attribute attributes = new Attribute(catId, true, true, false, 0, names);
        Response attributesId = executeRequestWithSpec(POST,ConfigHelper.getBaseURL()+ ConfigHelper.getBasePath()+"/v1/attribute/add", attributes);

        attributId = attributesId.path("id");
    }

    public static void addAttributesValues() {
        String generatedString = Utils.getRandomString(10);

        ValuesOnDiffLocale names = new ValuesOnDiffLocale(generatedString, generatedString,generatedString,generatedString,generatedString);

        AttributeValues attributeValues = new AttributeValues(attributId, true, 0, names);
        Response attrValId = executeRequestWithSpec(POST,ConfigHelper.getBaseURL()+ ConfigHelper.getBasePath()+"/v1/attribute-value/add", attributeValues);
        attributeValueId = attrValId.path("id");
    }

    // изменить ручку на https://api.dev.vlife.kz/market/core/v1/category/unsubscribe/attribute/9418?categoryIds=32358
    public static void deleteAttributes() {
        executeRequestWithSpec(DELETE,ConfigHelper.getBaseURL()+ ConfigHelper.getBasePath()+"/v1/attribute/"+attributId, null);

    }



    public static void createOrUpdateDraftItem() throws JsonProcessingException {
        AttributeValues attributes1 =  new AttributeValues( attributId, attributeValueId,  true, "value");
        AttributeValues attributes2 =  new AttributeValues( attributId, attributeValueId,  true, "value1");
        String generatedString = Utils.getRandomString(20);
        List<AttributeValues> attributes = Arrays.asList(attributes1,attributes2);
        List<Integer> stockIds = Collections.singletonList(stockId);

        DraftItem draftItem = new DraftItem(catId, 0, generatedString,  generatedString,  generatedString,  "4444",  generatedString,  attributes, stockIds);
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = ow.writeValueAsString(draftItem);
        System.out.println(json);
        Response draftId = executeRequestWithSpec(POST, ConfigHelper.getBasePath()+"/v1/drafts/items", draftItem);

        draftItemId = draftId.path("id");
    }

public static void draftToModeration() {
        executeRequestWithSpec(PUT, ConfigHelper.getBasePath()+"/v1/drafts/items"+ draftItemId+"/moderate", null);
}

    public static void createItemFromDraft() {

        Response item =  given()
                .spec(speci().requestWithAuth())
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

    public static void itemSubscribe() {
        ItemSubscription itemSubscription = new ItemSubscription();
        given()
//                .spec(speci().BodyOfRequest(itemSubscription))
                .when()
                .post("/v1/items/{itemId}/subscribe", itemId )
                .then()
                .log().body()
                .statusCode(200)
                .log().body()
                .extract()
                .response();
    }

    public static void item() {
        ItemSubscription itemSubscription = new ItemSubscription();
        given()
//                .spec(speci().BodyOfRequest(itemSubscription))
                .when()
                .post("/v1/items/{itemId}/subscribe", itemId )
                .then()
                .log().body()
                .statusCode(200)
                .log().body()
                .extract()
                .response();
    }
///// not changed the method
    public static void AttrInCategory() {
        ItemSubscription itemSubscription = new ItemSubscription();
        given()
//                .spec(speci().BodyOfRequest(itemSubscription))
                .when()
                .post("/v1/items/{itemId}/subscribe", itemId )
                .then()
                .log().body()
                .statusCode(200)
                .log().body()
                .extract()
                .response();
    }
/// нужно сделать проверку на наличие атрибутов у категории
    //не сохраняются картинки
public static void CreateItemModerator() throws JsonProcessingException {
//    Brand brand = new Brand();names instead of brand
    String generatedString = Utils.getRandomString(20);

    ValuesOnDiffLocale names = new ValuesOnDiffLocale(generatedString,generatedString,generatedString,generatedString,generatedString);
    AttributeValues attributes1 =  new AttributeValues( attributId, attributeValueId,  true, "value1");
    AttributeValues attributes2 =  new AttributeValues( attributId, attributeValueId,  true, "value1");
    List<AttributeValues> attrValues = Arrays.asList();

    MultipartItem multi = new MultipartItem("bananretVendorCode", names, "bananretBarcode", names, catId, attrValues);

    ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
    String json = ow.writeValueAsString(multi);
    System.out.println(json);

    Response item = given()
            .log().body()

            .auth().oauth2(token)
////            .multiPart(new MultiPartSpecBuilder(path).fileName("/Снимок экрана 2020-10-22 в 18.36.38.png")
////                    .controlName("files")
////                    .mimeType("image/png")
////                    .build())
            .multiPart("files", new File(path), "image/jpeg")
            .multiPart("files", new File(path2), "image/png")
            .multiPart("request", multi, "application/json")
//            .multiPart("files", path )
            .log().everything()
            .when()
            .post(ConfigHelper.getBaseURL()+ ConfigHelper.getBasePath()+"/v1/items/multipart")
            .then()
            .log().body()
            .statusCode(200)
            .log().body()
            .extract()
            .response();
    itemId = item.path("id");


}



    ///not ready
    public static void CreateOrder() {
        Address address = new Address("Almaty", 2, "Kazakhstan", 21,2, "Kazybek Bi");
        Gift gift = new Gift("Daniyar","77029203758","Mukhtarkhanov");
        Price price = new Price("kzt", 123);
        Delivery delivery = new Delivery( address, "Express", "today",  gift,  price);
        OrderInputDto order = new OrderInputDto(delivery, itemPriceId, 1 );

        given()
                .when()
                .body(order)
                .post("/v1/orders" )
                .then()
                .log().body()
                .statusCode(200)
                .log().body()
                .extract()
                .response();
    }

    ///not ready
    public static void ChangeStatus() {
        ItemSubscription itemSubscription = new ItemSubscription();
        given()
                .when()
                .post("/v1/items/{itemId}/subscribe", itemId )
                .then()
                .log().body()
                .statusCode(200)
                .log().body()
                .extract()
                .response();
    }
/////////////////////////////// not changed the methods
    public static void UploadPricelistModerator() {

        Response item = given()
                .log().body()
                .header("Accept-language", "ru")

                .auth().oauth2(token)
                .multiPart("file", new File(path3), "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")
                .log().everything()
                .when()
                .post(ConfigHelper.getBaseURL()+ ConfigHelper.getBasePath()+"/v1/imports/pricelist")
                .then()
                .log().body()
                .statusCode(200)
                .log().body()
                .extract()
                .response();
        Integer quantityOfUnreconzed = item.path("unrecognized");
    }

    public static void CheckPublishedUnpublished() {
        ItemSubscription itemSubscription = new ItemSubscription();
        given()
                .when()
                .post("/v1/items/{itemId}/subscribe", itemId )
                .then()
                .log().body()
                .statusCode(200)
                .log().body()
                .extract()
                .response();
    }
    public static void ItemActivation() {
        ItemSubscription itemSubscription = new ItemSubscription();
        given()
//                .spec(speci().BodyOfRequest(itemSubscription))
                .when()
                .post("/v1/items/{itemId}/subscribe", itemId )
                .then()
                .log().body()
                .statusCode(200)
                .log().body()
                .extract()
                .response();
    }    public static void CheckExistenceOfItemsInMobile() {
        ItemSubscription itemSubscription = new ItemSubscription();
        given()
//                .spec(speci().BodyOfRequest(itemSubscription))
                .when()
                .post("/v1/items/{itemId}/subscribe", itemId )
                .then()
                .log().body()
                .statusCode(200)
                .log().body()
                .extract()
                .response();
    }    public static void ListOfMerchants() {
        ItemSubscription itemSubscription = new ItemSubscription();
        given()
//                .spec(speci().BodyOfRequest(itemSubscription))
                .when()
                .post("/v1/items/{itemId}/subscribe", itemId )
                .then()
                .log().body()
                .statusCode(200)
                .log().body()
                .extract()
                .response();
    }





}