package tests

import net.serenitybdd.junit.runners.SerenityRunner
import net.thucydides.core.annotations.Steps
import org.junit.Test
import org.junit.runner.RunWith

import static org.hamcrest.CoreMatchers.is
import static org.hamcrest.Matchers.contains

@RunWith(SerenityRunner.class)
class TradeMeApiTest {
    private final String BASE_URI = "https://api.tmsandbox.co.nz"
    private final String CATEGORY_BASE_PATH = "v1/Categories"
    private final String CATEGORY_ID_PATH = "/6327"
    private final String JSON_ENDPOINT = "/Details.json"

    @Steps
    StepsApi StepsApi

    void setAndRequestApiResponse() {
        StepsApi.setUpBaseApiUriAndPath(BASE_URI, CATEGORY_BASE_PATH + CATEGORY_ID_PATH)
        StepsApi.setRequestParameters("catalogue", false)
        StepsApi.setHttpResponseCode(200)
        StepsApi.getApiResponseUsingParameters(JSON_ENDPOINT)
        StepsApi.checkHttpCodeForSuccessfulResponse()
    }

    @Test
    void validateCategoryDescription() {
        setAndRequestApiResponse()
        StepsApi.validateResponseCriteria("Name", is("Carbon credits"))
    }

    @Test
    void validateCanRelist() {
        setAndRequestApiResponse()
        StepsApi.validateResponseCriteria("CanRelist", is(true))
    }

    @Test
    void validatePromotionsDescription() {
        setAndRequestApiResponse()
        StepsApi.validateResponseCriteria("Promotions.findAll {it.Name.equals('Gallery')}" +
                                          ".Description.findAll()",
                                      contains("Good position in category"))
    }

}

