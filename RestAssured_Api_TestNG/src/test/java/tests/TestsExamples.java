package tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestsExamples {

    @Test
    public void test_1(){

        Response response = RestAssured.get("https://reqres.in/api/users?page=2");

        System.out.println(response.getStatusCode());
        System.out.println(response.getTime());
        System.out.println(response.getHeader("content-type"));
        System.out.println(response.getBody().asPrettyString());

        int statusCode = response.getStatusCode();

        Assert.assertEquals(statusCode,201);
    }

}
