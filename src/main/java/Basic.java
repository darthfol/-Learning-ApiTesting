import files.Payload;
import io.restassured.RestAssured;
import io.restassured.internal.ResponseSpecificationImpl;
import io.restassured.path.json.JsonPath;

import static org.hamcrest.Matcher.*;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class Basic {
    public static void main(String[] args){
        RestAssured.baseURI = "https://rahulshettyacademy.com";
        Payload payload = new Payload();

        // Add place
        String response = RestAssured
                .given()
                    .queryParam("key","qaclick123")
                    .header("Content-type","application/JSON")
                    .body(payload.getPlace())
                .when()
                    .post("maps/api/place/add/json")
                .then()
                .assertThat().statusCode(200)
                .body("scope", equalTo("APP"))
                .header("server", "Apache/2.4.18 (Ubuntu)")
                .extract().response().asString();

        JsonPath js = new JsonPath(response);
        payload.setPlaceId(js.getString("place_id"));
        //Update place with New Adress
        RestAssured
                .given()
                    .queryParam("key","qaclick123")
                    .header("Content-type","application/JSON")
                    .body(payload.updatePlace("Karczokowska 34 m2"))
                .when()
                    .put("/maps/api/place/update/json")
                .then()
                .assertThat().statusCode(200);

    //      -> Get place and validate is present in respons
    }
}
