package com.frugalbasketer.constants;

public class ApiConstants {

    //WEB APIS
    public static final String WEB_REGISTER_USER = StringConstants.WEB + "register/user";
    public static final String WEB_REGISTER_OPERATOR = "register/operator";



    //DASHBOARD APIS

    /*USERS TAB*/

    public static final String DASH_UPDATE_USER = StringConstants.DASHBOARD + "update/user";
    public static final String DASH_DELETE_USER = StringConstants.DASHBOARD + "delete/user";
    public static final String DASH_FETCH_ALL_USER = StringConstants.DASHBOARD + "get/all/users";
    public static final String DASH_FETCH_USER_DETAILS = StringConstants.DASHBOARD + "get/user/details/{userid}";
    public static final String GET_USER_LOGS = StringConstants.DASHBOARD + "get/user/activity/logs/{userid}";
    public static final String FETCH_USER_FOR_TERM = StringConstants.DASHBOARD + "get/searched/user";
    public static final String EXPORT_USER_DATA = StringConstants.DASHBOARD + "get/export/users/data";

    /*OPERATOR TABS*/
    public static final String DASH_FETCH_ALL_OPERATORS = StringConstants.DASHBOARD + "get/all/operators";
    public static final String DASH_FETCH_OPERATORS_DETAILS = StringConstants.DASHBOARD + "get/operator/details/{operatorId}";
    public static final String DASH_DELETE_OPERATOR = StringConstants.DASHBOARD + "delete/operator";
    public static final String GET_OPERATOR_ACTIVITY_LOGS = StringConstants.DASHBOARD + "get/operator/activity/logs/{operatorId}";

    /*ADMINS TAB*/

    public static final String DASH_REGISTER_ADMIN = StringConstants.DASHBOARD + "register/admin";
    public static final String DASH_UPDATE_ADMIN = StringConstants.DASHBOARD + "update/admin";
    public static final String DASH_DELETE_ADMIN = StringConstants.DASHBOARD + "delete/admin";
    public static final String DASH_FETCH_ALL_ADMIN = StringConstants.DASHBOARD + "get/all/admins";
    public static final String DASH_FETCH_ADMIN_DETAILS = StringConstants.DASHBOARD + "get/admin/details/{adminId}";
    public static final String GET_ADMIN_ACTIVITY_LOGS = StringConstants.DASHBOARD + "get/admin/activity/logs/{adminId}";
    public static final String FETCH_ADMIN_FOR_TERM = StringConstants.DASHBOARD + "get/searched/admin";
    public static final String EXPORT_ADMIN_DATA = StringConstants.DASHBOARD + "get/export/admins/data";


}
