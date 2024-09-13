package com.hexagonal.microservice_transaction.constants;

public class ValidationConstants {

    public static final int SEVEN = 7;
    public static final int NAME_LENGTH = 50;
    public static final int STATUS_LENGTH = 60;

    public static final String SPRING = "spring";

    public static final String ID = "id";
    public static final String NAME = "name";
    public static final String QUANTITY = "quantity";
    public static final String SUPPLY_DATE = "supplyDate";
    public static final String LAST_UPDATED = "lastUpdated";
    public static final String STATUS = "status";

    public static final String SUPPLY = "supply";
    public static final String SUPPLY_ID = "supplyId";
    public static final String SUPPLY_NAME = "supplyName";
    public static final String SUPPLY_QUANTITY = "supplyQuantity";
    public static final String TARGET_SUPPLY_DATE = "supplyDate";
    public static final String SUPPLY_LAST_UPDATED = "supplyLastUpdated";
    public static final String SUPPLY_STATUS = "supplyStatus";

    public static final String TITLE = "Hexagonal Monolithic API";
    public static final String TERMS_OF_SERVICE_URL = "http://swagger.io/terms/";
    public static final String LICENSE_NAME = "Apache 2.0";
    public static final String LICENSE_URL = "http://springdoc.org";
    public static final String APP_DESCRIPTION = "${app.description}";
    public static final String APP_VERSION = "${app.version}";

    public static final String BASE_URL = "/";
    public static final String SUPPLIES_URL = "/supplies";
    public static final String CREATE_SUPPLY_DESCRIPTION = "Create a new supply";
    public static final String CREATE_SUPPLY_ACTION = "Add a new supply to the system";

    public static final String ROL = "rol";
    public static final String PRIVATE = "294A404E635266556A586E327235753878214125442A472D4B6150645367566B";
    public static final String SWAGGER_UI = "/swagger-ui.html";
    public static final String SWAGGER_UI_RESOURCES = "/swagger-ui/**";
    public static final String AUTHORIZATION = "Authorization";
    public static final String BEARER = "Bearer ";
    public static final String ROLE =  "ROLE_";

    public static final String V3_API = "/v3/api-docs/**";
    public static final String AUTH = "/auth/**";
    public static final String ALL_API = "/api/**";

    public static final String JSON = "application/json";
    public static final String ERROR_JWT = "{ \"error\": \"Access denied: Invalid or malformed JWT token\" }";

    private ValidationConstants() {
        throw new IllegalStateException("Utility class");
    }
}