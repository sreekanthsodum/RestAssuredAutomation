//import io.restassured.RestAssured;
//import io.restassured.response.Response;
//import org.testng.Assert;
//import org.testng.annotations.Test;
//import java.nio.file.Files;
//import java.nio.file.Paths;
//import java.io.IOException;
//
//public class APITests {
//
//    @Test
//    void test() throws IOException {
//        Response response = RestAssured.get("https://reqres.in/api/users?page=2");
//        String actualResponse = response.asString().trim();
//
//        compareWithStoredGetResponses(actualResponse);
//    }
//
//    private void compareWithStoredGetResponses(String actualResponse) throws IOException {
//        String filePath = "C:\\Users\\SWECHA\\IdeaProjects\\RestAssuredAuto\\TestData\\GET\\GetResponse.txt";
//        String fileContent = new String(Files.readAllBytes(Paths.get(filePath)));
//        String[] expectedResponses = fileContent.split(";");
//
//        boolean matchFound = false;
//        for (String expected : expectedResponses) {
//            int start = expected.indexOf("={");
//            int end = expected.lastIndexOf("};");
//            if (start != -1 && end != -1 && end > start) {
//                String json = expected.substring(start + 2, end + 1).trim(); // extract only {...}
//                if (actualResponse.equals(json)) {
//                    System.out.println("Comparison result: MATCH");
//                    matchFound = true;
//                    break;
//                }
//            }
//        }
//
//        if (!matchFound) {
//            System.out.println("Comparison result: DOES NOT MATCH");
//            System.out.println("Actual Response: " + actualResponse);
//            System.out.println("Expected Responses:");
//            for (String expected : expectedResponses) {
//                int start = expected.indexOf("={");
//                int end = expected.lastIndexOf("};");
//                if (start != -1 && end != -1 && end > start) {
//                    String json = expected.substring(start + 2, end + 1).trim();
//                    System.out.println(json);
//                } else {
//                    System.out.println("[Pattern not found] " + expected.trim());
//                }
//            }
//            Assert.fail("API response does not match any stored response.");
//        }
//    }
//}