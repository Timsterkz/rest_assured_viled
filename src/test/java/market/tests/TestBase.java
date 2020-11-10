package market.tests;


import io.restassured.RestAssured;
import market.api.restassured.steps.RestAssuredSteps;
import market.config.ConfigHelper;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {

    protected static String token;
    protected static String email = ConfigHelper.getEmail();
    protected static String password = ConfigHelper.getPassword();


    @BeforeAll
    public static void loginMerchant(){
        token = RestAssuredSteps.login(email, password);
    }
}
