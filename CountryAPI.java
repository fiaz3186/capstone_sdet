package api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import utils.ExcelReader;

import java.util.List;

import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class CountryAPI {
	@Test
    public void countryApiTest() {

        String excelPath = "testdata/countries.xlsx";
        List<String> translations = ExcelReader.readTranslations(excelPath, "Sheet1");
        System.out.println(translations);
        for (String translation : translations) {
            System.out.println("Testing translation: " + translation);
            String url = "https://restcountries.com/v3.1/translation/" + translation;

            Response response = RestAssured.get(url);
            // response.prettyPrint();

            // Assertions
            System.out.println(url);
            System.out.println(response.statusCode());
            //System.out.println(response.jsonPath().getString("[0].translations"));
            assertThat(response.statusCode(), is(200));
            //assertThat(response.jsonPath().getString("[0].translations"), notNullValue());
        }
    }
}