package com.ApiUtils;

import com.ApiConstants.API_Constants;
import com.fileUtils.FileUtils;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.junit.Test;

import java.io.IOException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class
HTTPMethods extends FileUtils {
    Logger logger = Logger.getLogger(HTTPMethods.class.getName());
    public static String str = "NULL";

    public Response stimulaterequest(String httpMethodCall, Object... apiInput) {
        logger.log(Level.INFO, "Stimulating {0} Request", new Object[]{httpMethodCall});
        Response response = null;
        try {

            RestAssured.baseURI = API_Constants.BASE_URL.getValue();
            RequestSpecification requestSpecification = null;

            switch (httpMethodCall.toLowerCase()) {
                case "get":
                    response = get(apiInput);
                    break;
                case "post":
                    response = putorpost("post", apiInput);
                    break;
                case "put":
                    response = putorpost("put", apiInput);
                    break;
                case "postorder":
                    response = putorpost("postorder", apiInput);
                    break;
                case "patch":
                    response = patch(apiInput);
                    break;
                case "deleteuser":
                    response = Mydeleteuser(apiInput);
                    break;
                case "deleteorder":
                    response = Mydeleteorder(apiInput);
                    break;
            }
            return response;
        } catch (Exception e) {
            logger.log(Level.SEVERE, e.getMessage(), e);
            return null;

        }
    }

    private Response get(Object... apiInput) {
        RequestSpecification requestSpecification = null;
        Response response = null;
        Map<String, String> params = null;
        requestSpecification = RestAssured.given();
        String resources = null;
        if (apiInput.length > 1) {
            logger.log(Level.INFO, "Configuring parameters");
            params = (Map<String, String>) apiInput[0];
            for (Map.Entry<String, String> param : params.entrySet()) {
                requestSpecification.params(param.getKey(), param.getValue());
            }
            logger.log(Level.INFO, "Configuring Resources {0}", new Object[]{apiInput[1].toString()});
            resources = apiInput[1].toString();
        } else {
            logger.log(Level.INFO, "Configuring Resources {0}", new Object[]{apiInput[0].toString()});
            resources = apiInput[0].toString();
        }
        response = requestSpecification.when().get(API_Constants.valueOf(resources).getValue()).then().extract().response();
        logger.log(Level.INFO, "Get call completed with status code as{0} / Response: {1} ", new Object[]{response.getStatusCode(), response.asPrettyString()});
        return (response);
    }

    private Response patch(Object... apiInput) {
        RequestSpecification requestSpecification = null;
        Response response = null;
        String resources = null;
        String body = null;
        //gets BASE_URL
        requestSpecification = RestAssured.given();

        if (apiInput.length > 1) {
            logger.log(Level.INFO, "Configuring parameters");

            //Prepare body
            body = apiInput[0].toString();
            JSONObject payload = getpayload(body);
            // Prepare resource
            resources = apiInput[1].toString();

            logger.log(Level.INFO, "payload {0}", new Object[]{payload});

            //requestSpecification.contentType(apiInput[2].toString());
            requestSpecification.contentType("application/json\r\n").body(payload.toString());
        } else {
            logger.log(Level.INFO, "Configuring Resources {0}", new Object[]{apiInput[0].toString()});
            resources = apiInput[0].toString();
        }
        //Call patch functionaly and readback response
        response = requestSpecification.patch(API_Constants.valueOf(resources).getValue() + apiInput[2].toString()).then().extract().response();
        logger.log(Level.INFO, "Patch call completed with status code as{0} / Response: {1} ", new Object[]{response.getStatusCode(), response.asPrettyString()});
        return (response);
    }


    private Response putorpost(String callType, Object... apiInput) {
        RequestSpecification requestSpecification = null;
        Response response = null;
        requestSpecification = RestAssured.given();
        String resources = null;
        String body = null;
        if (apiInput.length > 1) {
            logger.log(Level.INFO, "Configuring parameters");
            body = apiInput[0].toString();
            resources = apiInput[1].toString();
            JSONObject payload = getpayload(body);
            logger.log(Level.INFO, "payload {0}", new Object[]{payload});
            requestSpecification.contentType("application/json\r\n").body(payload.toString());
        } else {
            resources = apiInput[0].toString();
        }
        if (callType.equals("post")) {
            response = requestSpecification.post(API_Constants.valueOf(resources).getValue()).then().extract().response();
            logger.log(Level.INFO, "Post call completed with status code as{0} / Response: {1} ", new Object[]{response.getStatusCode(), response.asPrettyString()});
        } else if (callType.equals("postorder")) {

            response = requestSpecification.post(API_Constants.valueOf(resources).getValue()).then().extract().response();
            System.out.println("postorders");
            logger.log(Level.INFO, "Post call completed with status code as{0} / Response: {1} ", new Object[]{response.getStatusCode(), response.asPrettyString()});
        } else {
            response = requestSpecification.put(API_Constants.valueOf(resources).getValue()).then().extract().response();
            logger.log(Level.INFO, "Put call completed with status code as{0} / Response: {1} ", new Object[]{response.getStatusCode(), response.asPrettyString()});
        }

        return response;
    }

    private Response Mydeleteuser(Object... apiInput) {
        RequestSpecification requestSpecification = null;
        Response response = null;
        String resources=null;
        requestSpecification=RestAssured.given();
        if(apiInput.length>1){
            resources = apiInput[0].toString();
            //requestSpecification.contentType(apiInput[1].toString());
        }else{
            logger.log(Level.INFO, "Configuring Resources {0}", new Object[]{apiInput[0].toString()});
            resources = apiInput[0].toString();
        }
        response = requestSpecification.delete(API_Constants.valueOf(resources).getValue() + apiInput[1].toString()).then().extract().response();
        logger.log(Level.INFO, "delete call completed with status code as{0} / Response: {1} ", new Object[]{response.getStatusCode(), response.asPrettyString()});
        return response;
    }
    private Response Mydeleteorder(Object... apiInput) {
        RequestSpecification requestSpecification = null;
        Response response = null;
        String resources=null;
        requestSpecification=RestAssured.given();
        resources = apiInput[0].toString();
        response = requestSpecification.delete(API_Constants.valueOf(resources).getValue() ).then().extract().response();
        logger.log(Level.INFO, "delete call completed with status code as{0} / Response: {1} ", new Object[]{response.getStatusCode(), response.asPrettyString()});
        return response;
    }
}

/*
    @Test
    public void test() throws ParseException, IOException {
        stimulaterequest("get", "CATEGORIES");
    }

    @Test
    public void getCatogeries() throws ParseException {
        RestAssured.baseURI = API_Constants.BASE_URL.getValue();
        Response response = RestAssured.given()
                .when()
                .get(API_Constants.CATEGORIES.getValue())
                .then()
                .extract()
                .response();
        System.out.println(response.getStatusCode());
        //System.out.println(response.asPrettyString());
        // (Above System.out...prints as Json object)
        // JsonPath Jsonpath=new JsonPath(response.asString());
        //for(Object category:Jsonpath.getList("categories"))
        //{
        //  System.out.println(category);
        //}
        //System.out.println(Jsonpath.getList("categories"));
        //(above prints Json string in a single line)

        JSONArray array = getJsonArray(response.asString(), "categories");
        for (Object object : array) {
            JSONObject jsonobject = getJsonObject(object.toString());
            System.out.println(jsonobject.get("name"));
        }


    }



    @Test
    public void CreateCustomer() throws IOException, ParseException {
        RestAssured.baseURI = API_Constants.BASE_URL.getValue();
        JSONObject payloads = getpayload("createuser");

        Response response = RestAssured.given()
                .contentType("application/json\r\n")
                .body(payloads.toString())
                .when()
                .post(API_Constants.CREAT_CUSTOMER.getValue())
                .then()
                .extract()
                .response();

        System.out.println(response.getStatusCode());

        System.out.println(response.getHeader("location"));
        str = response.getHeader("location");
        System.out.println(str);
    }

    @Test
    public void getCustomers(){
        RestAssured.baseURI = API_Constants.BASE_URL.getValue();

        Response response = RestAssured.given()
                .when()
                .get("https://api.predic8.de:443/shop/customers/343")
                .then()
                .extract()
                .response();
        System.out.println(response.asPrettyString());
        System.out.println(response.getStatusCode());
    }

    @Test
    public void UpdateCustomers() throws IOException, ParseException {
        RestAssured.baseURI = API_Constants.BASE_URL.getValue();
        JSONObject updatebody = getUpdateuserdata("Updateuser");
               Response response = RestAssured.given()
                       .contentType("application/json\r\n")
                       .body(updatebody.toString())
                       .when()
                       .patch("https://api.predic8.de:443/shop/customers/343")
                       .then()
                      .extract()
                       .response();
        System.out.println(response.asPrettyString());
        System.out.println(response.getStatusCode());
    }
    @Test
    public void createOrder(){
        RestAssured.baseURI = API_Constants.BASE_URL.getValue();

        Response response = RestAssured.given()
                .when()
                .post("https://api.predic8.de:443/shop/customers/366/orders/")
                .then()
                .extract()
                .response();
        System.out.println(response.asPrettyString());
        System.out.println(response.getStatusCode());
    }
    @Test
    public void DeleteOrder(){
        RestAssured.baseURI = API_Constants.BASE_URL.getValue();

        Response response = RestAssured.given()
                .when()
                .delete("https://api.predic8.de:443/shop/orders/7961")
                .then()
                .extract()
                .response();
        System.out.println(response.asPrettyString());
        System.out.println(response.getStatusCode());
    }
    @Test
    public void DeleteCreatedCustomer(){
        RestAssured.baseURI = API_Constants.BASE_URL.getValue();

        Response response = RestAssured.given()
                .when()

                .delete("https://api.predic8.de:443/shop/customers/366")
                .then()
                .extract()
                .response();
        System.out.println(response.getStatusCode());
    }


}*/