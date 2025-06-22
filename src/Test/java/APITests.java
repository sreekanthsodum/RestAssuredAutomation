import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

public class APITests {

    @Test
    void test() throws IOException {
        Response response = RestAssured.get("https://reqres.in/api/users?page=2");
        String actualResponse = response.asString();

        compareWithStoredGetResponse(actualResponse);
    }

    private void compareWithStoredGetResponse(String actualResponse) throws IOException {
        String filePath = "C:\\Users\\SWECHA\\IdeaProjects\\RestAssuredAuto\\TestData\\GET\\GetResponse.txt";
        System.out.println("Comparing with stored response at: " + filePath);

        String expectedResponse = new String(Files.readAllBytes(Paths.get(filePath)));

        System.out.println("Expected Response:\n" + expectedResponse);
        System.out.println("Actual Response:\n" + actualResponse);

        if (!actualResponse.equals(expectedResponse)) {
            System.out.println("Comparison result: DOES NOT MATCH");
            System.out.println("Mismatch:");
            System.out.println("Expected: " + expectedResponse);
            System.out.println("Actual  : " + actualResponse);
            Assert.fail("API response does not match the stored response.");
        } else {
            System.out.println("Comparison result: MATCH");
        }
    }
}