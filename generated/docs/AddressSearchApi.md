# AddressSearchApi

All URIs are relative to *https://www.glasp-api.eu*

Method | HTTP request | Description
------------- | ------------- | -------------
[**searchZipStreet**](AddressSearchApi.md#searchZipStreet) | **POST** /app/search/zipstreet | Search request when the zip code and the street are known.
[**searchZipStreetCity**](AddressSearchApi.md#searchZipStreetCity) | **POST** /app/search/zipstreetcity | Search request when the zip code, the street and the city are known.


<a name="searchZipStreet"></a>
# **searchZipStreet**
> SearchResult searchZipStreet(zipStreetRequest)

Search request when the zip code and the street are known.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.AddressSearchApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://www.glasp-api.eu");
    
    // Configure HTTP bearer authorization: bearerAuth
    HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
    bearerAuth.setBearerToken("BEARER TOKEN");

    AddressSearchApi apiInstance = new AddressSearchApi(defaultClient);
    ZipStreetRequest zipStreetRequest = new ZipStreetRequest(); // ZipStreetRequest | 
    try {
      SearchResult result = apiInstance.searchZipStreet(zipStreetRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling AddressSearchApi#searchZipStreet");
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
 **zipStreetRequest** | [**ZipStreetRequest**](ZipStreetRequest.md)|  |

### Return type

[**SearchResult**](SearchResult.md)

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json, */*

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | The search results. |  -  |
**400** | Error in the provided data, please check the response message for details. |  -  |
**404** | There is no address matching the ZipStreet. |  -  |
**429** | Too many requests per minute. |  -  |
**500** | Internal Server Error. |  -  |

<a name="searchZipStreetCity"></a>
# **searchZipStreetCity**
> SearchResult searchZipStreetCity(zipStreetCityRequest)

Search request when the zip code, the street and the city are known.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.AddressSearchApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://www.glasp-api.eu");
    
    // Configure HTTP bearer authorization: bearerAuth
    HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
    bearerAuth.setBearerToken("BEARER TOKEN");

    AddressSearchApi apiInstance = new AddressSearchApi(defaultClient);
    ZipStreetCityRequest zipStreetCityRequest = new ZipStreetCityRequest(); // ZipStreetCityRequest | 
    try {
      SearchResult result = apiInstance.searchZipStreetCity(zipStreetCityRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling AddressSearchApi#searchZipStreetCity");
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
 **zipStreetCityRequest** | [**ZipStreetCityRequest**](ZipStreetCityRequest.md)|  |

### Return type

[**SearchResult**](SearchResult.md)

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json, */*

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | The search results. |  -  |
**400** | Error in the provided data, please check the response message for details. |  -  |
**404** | There is no address matching the ZipStreet. |  -  |
**429** | Too many requests per minute. |  -  |
**500** | Internal Server Error. |  -  |

