package com.frugalbasketer.constants;

public class ApiConstants {

    //WEB APIS
    public static final String WEB_REGISTER_USER = StringConstants.WEB + "register/user";
    public static final String WEB_REGISTER_SELLER = "register/seller";



    //DASHBOARD APIS

    /*USERS TAB*/

    public static final String DASH_DELETE_USER = StringConstants.DASHBOARD + "delete/user";
    public static final String DASH_FETCH_ALL_USER = StringConstants.DASHBOARD + "get/all/users";
    public static final String DASH_FETCH_USER_DETAILS = StringConstants.DASHBOARD + "get/user/details/{userid}";
    public static final String GET_USER_LOGS = StringConstants.DASHBOARD + "get/user/activity/logs/{userid}";

    /*SELLER TABS*/
    public static final String DASH_FETCH_ALL_SELLERS = StringConstants.DASHBOARD + "get/all/sellers";
    public static final String DASH_FETCH_SELLERS_DETAILS = StringConstants.DASHBOARD + "get/seller/details/{sellerId}";
    public static final String DASH_DELETE_SELLER = StringConstants.DASHBOARD + "delete/seller";
    public static final String GET_SELLER_ACTIVITY_LOGS = StringConstants.DASHBOARD + "get/seller/activity/logs/{sellerId}";

    /*ADMINS TAB*/

    public static final String DASH_REGISTER_ADMIN = StringConstants.DASHBOARD + "register/admin";
    public static final String DASH_DELETE_ADMIN = StringConstants.DASHBOARD + "delete/admin";
    public static final String DASH_FETCH_ALL_ADMIN = StringConstants.DASHBOARD + "get/all/admins";
    public static final String DASH_FETCH_ADMIN_DETAILS = StringConstants.DASHBOARD + "get/admin/details/{adminId}";
    public static final String GET_ADMIN_ACTIVITY_LOGS = StringConstants.DASHBOARD + "get/admin/activity/logs/{adminId}";










}
