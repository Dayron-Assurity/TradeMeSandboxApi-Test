package tests

import io.restassured.builder.RequestSpecBuilder
import io.restassured.builder.ResponseSpecBuilder
import io.restassured.response.Response
import io.restassured.specification.RequestSpecification
import io.restassured.specification.ResponseSpecification
import net.serenitybdd.rest.SerenityRest
import net.thucydides.core.annotations.Step
import org.hamcrest.Matcher

import static io.restassured.RestAssured.basePath
import static io.restassured.RestAssured.baseURI


class StepsApi {
    private Response apiResponse
    private RequestSpecification requestParameters
    private ResponseSpecification responseHttpCode

    static void setUpBaseApiUriAndPath(String baseApiUri, String baseApiUriPath){
        baseURI = baseApiUri
        basePath = baseApiUriPath
    }

    @Step
    void setRequestParameters(String Name, boolean parameterValue) {
        requestParameters = new RequestSpecBuilder().
                addParam(Name, parameterValue).
                build()
    }

    @Step
    void setHttpResponseCode(int expectedHttpStatus) {
        responseHttpCode = new ResponseSpecBuilder().
                expectStatusCode(expectedHttpStatus).
                build()
    }

     @Step
     void getApiResponseUsingParameters(String endpointPath) {
         apiResponse = SerenityRest.
                 given().
                 spec(requestParameters).
                 when().
                 get(endpointPath)
     }

     @Step
     void checkHttpCodeForSuccessfulResponse(){
         apiResponse.
                 then().
                 spec(responseHttpCode)
     }

    @Step
    void validateResponseCriteria(String path, Matcher<?> matcher) {
        apiResponse.
                then().
                body(path, matcher)
    }
}
