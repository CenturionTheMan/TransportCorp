package com.tasnporstcorp.app.database;

public interface Filter {

    // warunki filtrowania
    final static String LESS = "<";
    final static String GREATER = ">";
    final static String EQUAL = "=";
    final static String GREATER_EQUAL = ">=";
    final static String LESS_EQUAL = "<=";

    // atrybuty filtrowania
    final static String ORDER_NAME = "name";
    final static String ORDER_DELIVERY_DATE = "delivery date";
    final static String ORDER_PRICE = "price";
    final static String COMMODITY_VOLUME = "volume";

} 