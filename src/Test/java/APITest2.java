import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;


public class APITest2 {

    @Test
    void test(){
        Response response = RestAssured.get("https://reqres.in/api/users?page=2");
        System.out.println("Response : "+response.asString());
        System.out.println("Status Code : "+response.getStatusCode());
        System.out.println("Body : "+response.getBody().asString());
        System.out.println("Time taken : "+response.getTime());
        System.out.println("Header : "+response.getHeader("content-type"));
    }

}
