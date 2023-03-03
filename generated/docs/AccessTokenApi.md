# AccessTokenApi

All URIs are relative to *https://www.glasp-api.eu*

Method | HTTP request | Description
------------- | ------------- | -------------
[**accessToken**](AccessTokenApi.md#accessToken) | **POST** /auth/token/access | Requesting the webservice access token with the user credentials.
[**revokeToken**](AccessTokenApi.md#revokeToken) | **GET** /auth/token/revoke | Requesting the revocation of the webservice access token.


<a name="accessToken"></a>
# **accessToken**
> TokenResponse accessToken(tokenRequest)

Requesting the webservice access token with the user credentials.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.AccessTokenApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://www.glasp-api.eu");

    AccessTokenApi apiInstance = new AccessTokenApi(defaultClient);
    TokenRequest tokenRequest = new TokenRequest(); // TokenRequest | 
    try {
      TokenResponse result = apiInstance.accessToken(tokenRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling AccessTokenApi#accessToken");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tokenRequest** | [**TokenRequest**](TokenRequest.md)|  |

### Return type

[**TokenResponse**](TokenResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | The token which shall be used for the searching requests. |  -  |
**500** | Internal Server Error |  -  |

<a name="revokeToken"></a>
# **revokeToken**
> MessageResponse revokeToken()

Requesting the revocation of the webservice access token.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.AccessTokenApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://www.glasp-api.eu");
    
    // Configure HTTP bearer authorization: bearerAuth
    HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
    bearerAuth.setBearerToken("BEARER TOKEN");

    AccessTokenApi apiInstance = new AccessTokenApi(defaultClient);
    try {
      MessageResponse result = apiInstance.revokeToken();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling AccessTokenApi#revokeToken");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**MessageResponse**](MessageResponse.md)

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | The confirmation that the token was revoked. |  -  |
**500** | Internal Server Error |  -  |

