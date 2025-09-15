package co.com.bancolombia.logconstants.logconstants;

public interface LogConstants {
    //PROCESS
    String START_JJWT_PROCESS = "Starting JJWT  process";

    //HANDLER
    String GET_REPORT_HANDLER_SUCCESS = "Report retrieved successfully";
    String ERROR_GET_REPORT_HANDLER_SUCCESS = "Error retrieving report";

    //ERROR MESSAGES
    String ERROR_INTERN = "Internal error retrieving report";

    //DYNAMO
    String SEARCH_DYNAMO_ID = "[DynamoDB] Searching report with id={}";
    String REPORT_FOUND = "[DynamoDB] Report found: {}";
    String REPORT_NOT_FOUND = "[DynamoDB] Report not found: {}";
    String ERROR_SEARCHING_REPORT = "[DynamoDB] Error retrieving report with id={}";






}