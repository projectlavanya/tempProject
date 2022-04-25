package com.Testcases;

import com.ApiUtils.HTTPMethods;
import org.junit.Test;

public class TC_01_GetCategories extends HTTPMethods {

    @Test
    public void validateGetCategories(){
               stimulaterequest("get","CATEGORIES");

    }

}
