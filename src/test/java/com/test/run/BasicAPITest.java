//package com.test.run;
//
//import org.testng.asserts.SoftAssert;
//
//import gherkin.deps.com.google.gson.JsonObject;
//import io.restassured.RestAssured;
//import io.restassured.path.json.JsonPath;
//import io.restassured.response.Response;
//import io.restassured.specification.RequestSpecification;
//
//public class BasicAPITest {
//	
//	public void getFunction() {
//		//request>> catch response
//		//int a=10;
//		Response resObj = RestAssured.get("https://httpbin.org/get");
//		//Testcases
//		resObj.statusCode();
//		resObj.time();
//		resObj.body();//not null , check test data
//		resObj.headers();//Json
//		
//		
//	}
//	public void deleteFunction() {
//		//request>> catch response
//		//int a=10;
//		Response resObj = RestAssured.delete("https://httpbin.org/delete");
//		//Testcases
//		resObj.statusCode();
//		resObj.time();
//		resObj.body();//not null , check test data
//		resObj.headers();//Json
//		
//		
//	}
//	public void postFunction() {
//		//request>> catch response
//		//add more code==> add new test data in JSON
////		{
////			"Name":"Sarower",
////			"Salary":5000,
////			}
//		
//		//add data in request= top in postman
//		RequestSpecification rqs = RestAssured.given();
//		//Test data in body
//		JsonObject jo = new JsonObject();
//		jo.addProperty("Name", "Sarower");
//		jo.addProperty("Salary", 5000);
//		
//		rqs.body(jo.toString());
//		rqs.header("Content-Type", "application/json");
//		
//		//response= below in postman
//		Response responseObj =rqs.post("https://httpbin.org/post");//send
//		responseObj.prettyPrint();
//		
//		//Write test cases with validation
//		SoftAssert sa = new SoftAssert();
//		sa.assertTrue(responseObj.statusCode()==200,"Test :1");
//		//System.out.println("Time : "+responseObj.time());
//		sa.assertTrue(responseObj.time()<2000 ,"Test :2");
//		sa.assertTrue(responseObj.header("Content-Type").contains("application/json"),"Test :3");
//		sa.assertTrue(!responseObj.body().toString().equals(null),"Test :4");
//		//key check
//		sa.assertTrue(responseObj.body().asString().contains("Name"),"Test :5");
//		sa.assertTrue(responseObj.body().asString().contains("Salary"),"Test :6");
//		//value = RestAssure can not check value directly
//		//>> need to break json with parser= JsonPath
//		JsonPath jp =responseObj.jsonPath() ;
//		sa.assertEquals(jp.get("json.Name"),"Sarower","Test :7");
//		jp.get("json.Salary");// 5000
//		sa.assertEquals(jp.get("json.Salary"),5000,"Test :8");
//		sa.assertAll();
//	}
//	
//	public static void main(String[] args) {
//		BasicAPITest obj = new BasicAPITest();
//		obj.postFunction();
//	}
//	
//	
//	
//	public void putFunction() {
//		//request>> catch response
//		//add more code==> add new test data in JSON
//		
//		Response resObj = RestAssured.put("https://httpbin.org/put");
//		//Testcases
//		resObj.statusCode();
//		resObj.time();
//		resObj.body();//not null , check test data
//		resObj.headers();//Json
//		
//		
//	}
//
//}
