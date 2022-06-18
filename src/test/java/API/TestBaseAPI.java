package API;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

import static utils.ConfigsReader.*;

public class TestBaseAPI {
    private static final String API_FILE_DIRECTORY = "resources/API.properties";
    private static RequestSpecification reqSpec;

    public RequestSpecification setUp() throws FileNotFoundException {

        readProperties(API_FILE_DIRECTORY);

        PrintStream apiLog = new PrintStream(new FileOutputStream("logs/API-Log.log"));
            reqSpec = new RequestSpecBuilder().setBaseUri(getProperty("uri")).
                    addFilter(RequestLoggingFilter.logRequestTo(apiLog)).
                    addFilter(ResponseLoggingFilter.logResponseTo(apiLog)).
                    setContentType(ContentType.JSON).build();

        return reqSpec;
    }

    public String getKeyValue(Response response,String key){
        String res = response.asString();
        JsonPath js = new JsonPath(res);
        return js.getString(key);
    }

}
