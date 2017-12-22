package APIAutomation.API_Automation;

import org.testng.annotations.Test;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import static org.hamcrest.Matchers.lessThan;

import API_Test_data.Info;
import API_Test_data.Test_data;


import static com.jayway.restassured.RestAssured.*;

public class POST_Request {

	//@Test
	public void post_test1() {
		Response res=given().body("{\"id\":\"2\",\"title\":\"shriyansh\",\"author\":\"advay\"}")
		.when().contentType(ContentType.JSON)
		.post("http://localhost:3000/posts");
		System.out.println(res.getStatusCode());
		}
	
	//@Test
	public void with_test_data() {
		Test_data data=new Test_data();
		data.setId("3");
		data.setTitle("MR");
		data.setAuthor("mallikarjun");
		Response res=given()
				.when().contentType(ContentType.JSON).body(data)
				.post("http://localhost:3000/posts");
				System.out.println(res.getStatusCode());
		
	}
	
	//PUT Request
	//@Test
	public void put_Test() {
		Test_data data=new Test_data();
		data.setId("3");
		data.setTitle("Chintha");
		data.setAuthor("mallikarjun");
		Response res=given()
				.when().contentType(ContentType.JSON).body(data)
				.put("http://localhost:3000/posts/3");
				System.out.println(res.getStatusCode());
		
		
	}
	
	//PATCH
	//@Test
	public void patch_Test() {
		Response res=given().body("{\"title\":\"MR\"}").when().contentType(ContentType.JSON)
		.patch("http://localhost:3000/posts/3");
		System.out.println(res.getStatusCode());
		
	}
	//DELETE
	//@Test
	public void delete_test() {
		Response resp=given().when().delete("http://localhost:3000/posts/2");
System.out.println(resp.getStatusCode());
	}
	
	//Complex post
	//@Test
	public void complex_post_test() {
		Info data1=new Info();
		data1.setEmail("mallik_321@gmail.com");
		data1.setAddress("mk");
		data1.setPhone("07787447482");
		Test_data data=new Test_data();
		data.setId("2");
		data.setTitle("shriyansh");
		data.setAuthor("advay");
		//data.setinfo(data1);
		Response res=given()
				.when().contentType(ContentType.JSON).body(data)
				.post("http://localhost:3000/posts");
				System.out.println(res.getStatusCode());
		
		
	}
	//Complex post with arrays
    // @Test
	public void complex_post_test2() {
		Info data1=new Info();
		data1.setEmail("mallik_321@gmail.com");
		data1.setAddress("mk");
		data1.setPhone("07787447482");
		Info data2=new Info();
		data2.setEmail("chintha@gmail.com");
		data2.setAddress("bristol");
		data2.setPhone("123456");
		Test_data data=new Test_data();
		data.setId("3");
		data.setTitle("shriyansh3");
		data.setAuthor("advay3");
		data.setinfo(new Info [] {data1,data2});
		Response res=given()                           
				.when().contentType(ContentType.JSON).body(data)
				.post("http://localhost:3000/posts");
				System.out.println(res.getStatusCode());
		
		
	}
	//time
	@Test
	public void time_test() {
		/*long time=given().when().get("http://localhost:3000/posts").then().extract().time();
		System.out.println(time);*/
		given().when().get("http://localhost:3000/posts").then().and().time(lessThan(60l));
	}
}
