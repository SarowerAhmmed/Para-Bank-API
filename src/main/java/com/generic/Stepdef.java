package com.generic;




import org.testng.asserts.SoftAssert;

import gherkin.deps.com.google.gson.JsonObject;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;



public class Stepdef {
	RequestSpecification rqs;
	Response responseObj;
	SoftAssert sa;
	JsonPath jp;
	
	@Given("Create request and add test data in json")
	public void create_request_and_add_test_data_in_json() {
		 rqs = RestAssured.given();
	     
	}

	@When("send data with post method with post URL and get response")
	public void send_data_with_post_method_with_post_URL_and_get_response() {
	   
		JsonObject jo = new JsonObject();
		jo.addProperty("Name", "Sarower");
		jo.addProperty("Salary", 5000);
		
		rqs.body(jo.toString());
		rqs.header("Content-Type", "application/json");
		//response= below in postman
		responseObj =rqs.post("https://httpbin.org/post");//send
		responseObj.prettyPrint();
	}

	@Then("check status two hundred")
	public void check_status_two_hundred() {
		sa = new SoftAssert();
		sa.assertTrue(responseObj.statusCode()==200);
	     
	}

	@Then("check response time below two thousand")
	public void check_response_time_below_two_thousand() {
		sa.assertTrue(responseObj.time()<2000 );
	     
	}

	@Then("check response header contain-type is application json")
	public void check_response_header_contain_type_is_application_json() {
		sa.assertTrue(responseObj.header("Content-Type").contains("application/json"));
	     
	}

	@Then("response body should not null")
	public void response_body_should_not_null() {
		sa.assertTrue(!responseObj.body().toString().equals(null));
	     
	}

	@Then("check response body contain key Name")
	public void check_response_body_contain_key_Name() {
		sa.assertTrue(responseObj.body().asString().contains("Name"));
	     
	}

	@Then("check response body contain key Salary")
	public void check_response_body_contain_key_Salary() {
		sa.assertTrue(responseObj.body().asString().contains("Salary"));
	     
	}

	@Then("check response body contain value Sarower")
	public void check_response_body_contain_value_Sarower() {
		 jp =responseObj.jsonPath() ;
		 sa.assertTrue(jp.get("json.Name").toString().contains("Sarower"));
	
	     
	}

	@Then("check response body contain value five thousand")
	public void check_response_body_contain_value_five_thousand() {
		sa.assertTrue(jp.get("json.Salary").toString().contains("5000"));
		
		
		
	}

	@When("send data with put method with put URL and get response")
	public void send_data_with_put_method_with_put_URL_and_get_response() {
		JsonObject jo = new JsonObject();
		jo.addProperty("Name", "Adam");
		jo.addProperty("Salary", 10000);
		
		rqs.body(jo.toString());
		rqs.header("Content-Type", "application/json");
		//response= below in postman
		responseObj =rqs.put("https://httpbin.org/put");//send
		responseObj.prettyPrint();
	}

	@Then("check response body contain value Adam")
	public void check_response_body_contain_value_Adam() {
		 jp =responseObj.jsonPath() ;
		 sa.assertTrue(jp.get("json.Name").toString().contains("Adam"));
	}

	@Then("check response body contain value ten thousand")
	public void check_response_body_contain_value_ten_thousand() {
	   
		sa.assertTrue(jp.get("json.Salary").toString().contains("10000"));
		
	}
	@When("send data with get method with get URL and get response")
	public void send_data_with_get_method_with_get_URL_and_get_response() {
		
		 responseObj = RestAssured.get("https://httpbin.org/get");
		
		responseObj.prettyPrint();
	}

	@Then("check response body contain key url")
	public void check_response_body_contain_key_url() {
		sa.assertTrue(responseObj.body().asString().contains("url"));
	}

	@Then("check response body contain key origin")
	public void check_response_body_contain_key_origin() {
	  
		sa.assertTrue(responseObj.body().asString().contains("origin"));
		
		
	}
	@When("send data with get method with delete URL and delete response")
	public void send_data_with_get_method_with_delete_URL_and_delete_response() {
		 responseObj = RestAssured.delete("https://httpbin.org/delete");
			
			responseObj.prettyPrint();
		
		sa.assertAll();
	}

}
