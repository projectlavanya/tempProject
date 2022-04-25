package com.ApiConstants;

public enum API_Constants {
    BASE_URL("https://api.predic8.de:443"),
    CATEGORIES("/shop/categories/"),
    CREAT_CUSTOMER("/shop/customers/"),
    CREAT_ORDERS("/shop/customers/368/orders/"),
    DELETE_ORDER("/shop/orders/7964");

    private String appconstant;
public String getValue(){
    return this.appconstant;
}
    API_Constants(String appconstant){
        this.appconstant=appconstant;
    }
}
