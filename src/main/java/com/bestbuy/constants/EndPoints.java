package com.bestbuy.constants;

public class EndPoints {
    /**
     * *This is Endpoints of products
     */
     // http://localhost:3030/products



    public static final String GET_ALL_PRODUCTS = "/products";
    public static final String GET_SINGLE_PRODUCTS_BY_ID = "/{productID}";
    public static final String UPDATE_PRODUCT_BY_ID = "/{productID}";
    public static final String DELETE_PRODUCT_BY_ID = "/{productID}";

    /**
     * This is Endpoints of stores
     */
    public static final String GET_SINGLE_STORE_BY_ID = "/stores/{storeID}";
    public static final String UPDATE_STORE_BY_ID = "/stores/{storeID}";
    public static final String DELETE_STORE_BY_ID = "/stores/{storeID}";




}
