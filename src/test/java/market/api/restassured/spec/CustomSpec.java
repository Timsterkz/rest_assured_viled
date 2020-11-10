package market.api.restassured.spec;

import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import market.config.ConfigHelper;
import market.tests.TestBase;
import org.apache.http.HttpStatus;

import java.util.Map;

import static io.restassured.RestAssured.expect;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.is;


public class CustomSpec extends TestBase {

    static Object object;

    /**
     * Формирует для всех запросов базовые параметры URL, path, header и фильтры отчета.
     */
    private static final RequestSpecification BodyOfRequestWithoutAuth = given()
            .baseUri(ConfigHelper.getBaseURL())
            .contentType(ContentType.JSON)
            ;
    private static final RequestSpecification BodyOfRequestWithAuth = given()
            .baseUri(ConfigHelper.getBaseURL())
            .auth().oauth2(token)
            .contentType(ContentType.JSON)
            ;
    private static final RequestSpecification PatchRequestWithAuth = given()
            .baseUri(ConfigHelper.getBaseURL())
            .auth().oauth2(token)
            .contentType("application/json-patch+json")
            ;

    private final RequestSpecification GetMarketRequest = given()
            .baseUri(ConfigHelper.getBaseURL())
            .basePath(ConfigHelper.getBasePath())
            .auth().oauth2(token);

    private static final RequestSpecification requestWithAuth = given()
            .baseUri(ConfigHelper.getBaseURL())
            .auth().oauth2(token);




    public static CustomSpec speci() {
        return new CustomSpec();
    }
    public RequestSpecification GetMarketRequest() {
        return GetMarketRequest;
    }
    public RequestSpecification requestWithAuth() {
        return requestWithAuth;
    }
    public static RequestSpecification BodyOfRequestWithoutAuth() { return BodyOfRequestWithoutAuth;}


    private static final ResponseSpecification responseStatus =
            expect()
            .statusCode(anyOf(is(HttpStatus.SC_OK),is(HttpStatus.SC_CREATED)))
            .log().body();

    public static Response postReqWithoutAuthAndBody(String url, Object object)
    {

        Response response = BodyOfRequestWithoutAuth
                .body(object)
                .post(url)
                .then().spec(responseStatus())
                .log().body()
                .extract().response();
        return response ;
    }

    private static Response postReqWithAuthAndBody(String url, Object object)
    {

        Response response = BodyOfRequestWithAuth
                .body(object)
                .post(url)
                .then().spec(responseStatus())
                        .log().body()
                .extract().response();
        return response ;
    }

    private static Response DeleteRequest(String url) {
        Response response = requestWithAuth.delete(url).then().spec(responseStatus())
                .extract().response();
        return response ;
    }



    private static Response getReqWithAuth(String url, Map<String, Object> queryParam)
    {
//        ResponseSpecification responseSpec = builder.build();
        Response response = requestWithAuth.queryParams(queryParam).get(url).then().spec(responseStatus())
                .extract().response();
        return response ;
    }

    private static Response getReqWithAuth(String url)
    {
//        ResponseSpecification responseSpec = builder.build();
        Response response = requestWithAuth.get(url).then().spec(responseStatus())
                .extract().response();
        return response ;
    }

    public static ResponseSpecification responseStatus() {
        return responseStatus;
    }

    public static Response executeRequestWithSpec(Method type, String url, Object obj, Map<String, Object> queryParam)
    {
        Response response = null;

            switch (type) {
                case GET:
                    response = getReqWithAuth(url, queryParam);
                    break;
                case POST:
                    response = postReqWithAuthAndBody(url, obj);
                    break;
                case PUT:
                    response = putReqWithAuthAndBody(url, obj);
                    break;
                case DELETE:
                    response = DeleteRequest(url);
                    break;
                case PATCH:
                    response = patchReqWithAuthAndBody( url, obj);
                    break;
            }

        return response;
    }



    private static Response patchReqWithAuthAndBody(String url, Object object) {
        Response response = PatchRequestWithAuth
                .body(object)
                .patch(url)
                .then().spec(responseStatus())
                .log().body()
                .extract().response();
        return response ;

    }

    private static Response putReqWithAuthAndBody(String url, Object object) {
        Response response = BodyOfRequestWithAuth
                .body(object)
                .put(url)
                .then().spec(responseStatus())
                .log().body()
                .extract().response();
        return response ;
    }

    public static Response executeRequestWithSpec(Method type, String url, Object obj)
    {
        Response response = null;

        switch (type) {
            case GET:
                response = getReqWithAuth(url);
                break;
            case POST:
                response = postReqWithAuthAndBody(url, obj);
                break;
//                case PUT:
//                    response = executePutRequestWithSpec( url, builder);
//                    break;
            case DELETE:
                response = DeleteRequest(url);
                break;
        }

        return response;
    }




}