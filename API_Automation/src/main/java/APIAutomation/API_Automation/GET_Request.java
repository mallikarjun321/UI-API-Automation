package APIAutomation.API_Automation;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;

import static com.jayway.restassured.RestAssured.*;

public class GET_Request {

	@Test
	public void get(){
		
		Response re=given().param("q", "London").param("appid", "b6907d289e10d714a6e88b30761fae22").when().
				get("http://samples.openweathermap.org/data/2.5/weather");
		System.out.println(re.getStatusCode());
		System.out.println(re.asString());
		
	}
	//@Test
	public void get_Assert
	(){
		given().param("q", "London").param("appid", "b6907d289e10d714a6e88b30761fae22").
		when().get("http://samples.openweathermap.org/data/2.5/weather").
	    then().assertThat().statusCode(200);
		
		
	}

	//@Test
	public void validate_jsonpath(){
	String desc=	given().param("q", "London").param("appid", "b6907d289e10d714a6e88b30761fae22").
		when().get("http://samples.openweathermap.org/data/2.5/weather").
	    then().contentType(ContentType.JSON).extract()
	    .path("weather[0].description");
	System.out.println(desc);
	Assert.assertEquals(desc,"light intensity drizzle");
	
		
	}
}

