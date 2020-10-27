package market.tests;


import io.restassured.RestAssured;
import market.api.restassured.steps.RestAssuredSteps;
import market.config.ConfigHelper;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {

    protected static String token;
    protected static String email = ConfigHelper.getEmail();
    protected static String password = ConfigHelper.getPassword();
    protected static String BaseURL = ConfigHelper.getBaseURL();
    protected static String BasePath = ConfigHelper.getBasePath();


    @BeforeAll
    public static void loginMerchant(){
        RestAssured.baseURI = BaseURL;
        token = RestAssuredSteps.login(email, password);
    }
}
