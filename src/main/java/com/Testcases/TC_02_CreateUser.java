package com.Testcases;

import com.ApiUtils.HTTPMethods;
import io.restassured.response.Response;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;


public class TC_02_CreateUser extends HTTPMethods{
    public static String CurrUserid="NULL";
    @Test(priority=1)
    public void validateCreateUser() throws ParseException {
        System.out.println("Create New User");
        Response response=stimulaterequest("post","createuser","CREAT_CUSTOMER");
        String UserID=getJsonValue(response.asString(),"customer_url" );
        CurrUserid = UserID.substring(UserID.lastIndexOf("/")+1).trim();
        System.out.println(UserID.substring(UserID.lastIndexOf("/")+1).trim());

    }

    @Test(priority=2)
    public void GetCreatedUserByID() throws ParseException {
        System.out.println("Created User");
        System.out.println(CurrUserid);
        Response response=stimulaterequest("post","createuser","CREAT_CUSTOMER",CurrUserid);

    }

    @Test(priority=3)
    public void validateUpdateUser() throws ParseException {
        System.out.println("Update existing User");
        System.out.println(CurrUserid);
        Response response = stimulaterequest("patch", "Updateuser", "CREAT_CUSTOMER",CurrUserid);

    }

    @Test(priority=4)
    public void validatedeleteUser() throws ParseException {
        Response response =stimulaterequest("deleteuser","CREAT_CUSTOMER",CurrUserid) ;

    }
    @Test(priority=2)
    public void validateCreateOrder() throws ParseException {
        stimulaterequest("postorder","CREAT_ORDERS");


    }

    @Test(priority=5)
    public void validatedeleteorder() throws ParseException {
        Response response =stimulaterequest("deleteorder","DELETE_ORDER") ;

    }
}
