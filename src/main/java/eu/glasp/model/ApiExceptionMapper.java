package eu.glasp.model;

public class ApiExceptionMapper {
    public ApiException map(org.openapitools.client.ApiException exception){
        return new ApiException(exception.getCode(), exception.getResponseHeaders(), exception.getResponseBody());
    }
}
