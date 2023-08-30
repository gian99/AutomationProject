package tests;

import config.Properties;
import io.qameta.allure.*;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;

@Epic("Allure Report for API call")
public class HttpRequest {


    private static final Logger logger = LogManager.getLogger(HttpRequest.class);

    //https://reqres.in/api/users?page=2&id=5
    @Severity(SeverityLevel.MINOR)
    @Owner("GiancarloAguado")
    @Description("This is test for http request using restAssured")
    @Test(groups = {"globant"})
    void TestPathQueryParam(){
        logger.info("Inicializando el metodo TestPathQueryParam para validar un request usando queryParams");
        given()
                .pathParam("mypath","users")
                .queryParam("page",2)
                .queryParam("id",5)
                .when()
                .get(Properties.getConfig().APIURL())
                .then()
                .statusCode(200)
                .log().all();
    }

    @Severity(SeverityLevel.MINOR)
    @Owner("GiancarloAguado")
    @Description("This is test to get the Channel program Members related to a org62AccountId")
    @Test(groups = {"globant"})
    void TestExistCPM()  {
        logger.info("Validando el endpoint de partner-data-service para obtener la informacion del CPM usando el org62AccountId como parametro");
        Map<String,String> defaultHeader= new HashMap<String,String>();
        defaultHeader.put("Content-Type","application/json");
        defaultHeader.put("client_id",Properties.getConfig().client_id());
        defaultHeader.put("client_secret",Properties.getConfig().client_secret());
        Response res=given()
                .queryParam("org62AccountId",Properties.getConfig().org62AccountId())
                .headers(defaultHeader)
                .when()
                .get(Properties.getConfig().CPMURL());
        Assert.assertEquals(res.getStatusCode(),200);
        logger.info("Response del endpoint: "+res.getBody().asString());
    }
}
