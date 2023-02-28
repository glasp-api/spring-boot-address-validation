package eu.glasp.api;

import eu.glasp.model.Address;
import eu.glasp.model.AddressMapper;
import eu.glasp.model.ApiException;
import eu.glasp.model.ApiExceptionMapper;
import org.openapitools.client.api.AddressSearchApi;
import org.openapitools.client.model.SearchResult;
import org.openapitools.client.model.ZipStreetCityRequest;
import org.openapitools.client.model.ZipStreetRequest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SearchWrapper {
    private final TokenManager tokenManager;
    private final AddressSearchApi addressSearchApi;
    private final AddressMapper addressMapper;
    private final ApiExceptionMapper apiExceptionMapper;

    public SearchWrapper(String user, String password, Integer timeout){
        this.tokenManager = new TokenManager(user, password, timeout);
        this.addressSearchApi = new AddressSearchApi();
        this.addressMapper = new AddressMapper();
        this.apiExceptionMapper = new ApiExceptionMapper();

        this.addressSearchApi.getApiClient().setReadTimeout(timeout);
        this.addressSearchApi.getApiClient().setWriteTimeout(timeout);
        this.addressSearchApi.getApiClient().setConnectTimeout(timeout);
    }

    public List<Address> search(Address address) throws ApiException, IOException {
        try {
            this.addressSearchApi.getApiClient().setBearerToken(this.tokenManager.getToken());

            if (address.getCity() == null || address.getCity().length() <= 1){
                return this.searchZipStreet(address);
            } else {
                return this.searchZipStreetCity(address);
            }
        } catch (org.openapitools.client.ApiException e){
            if (e.getCause() != null){
                if (e.getCause() instanceof IOException) {
                    throw (IOException) e.getCause();
                }
            } else {
                throw this.apiExceptionMapper.map(e);
            }
        }
        return new ArrayList<>();
    }

    private List<Address> searchZipStreet(Address address) throws org.openapitools.client.ApiException {
        SearchResult searchResult = new SearchResult();
        ZipStreetRequest zipStreetRequest = new ZipStreetRequest();
        zipStreetRequest.setStreet(address.getStreet());
        zipStreetRequest.setZip(address.getZip());
        zipStreetRequest.setCountry(address.getCountry());
        if (address.getStreet() != null && address.getStreet().length() <= 18){
            zipStreetRequest.setMaxErrors(5);
            zipStreetRequest.setNoOfResults(2);
            searchResult = this.addressSearchApi.searchZipStreet(zipStreetRequest);
        } else if (address.getStreet() != null && address.getStreet().length() > 18) {
            zipStreetRequest.setMaxErrors(6);
            zipStreetRequest.setNoOfResults(1);
            searchResult = this.addressSearchApi.searchZipStreet(zipStreetRequest);
        }
        if (searchResult.getAddresses() == null) return new ArrayList<>();
        return searchResult.getAddresses().stream().map(this.addressMapper::map)
                .collect(Collectors.toList());
    }

    private List<Address> searchZipStreetCity(Address address) throws org.openapitools.client.ApiException {
        SearchResult searchResult = new SearchResult();
        ZipStreetCityRequest zipStreetCityRequest = new ZipStreetCityRequest();
        zipStreetCityRequest.setStreet(address.getStreet());
        zipStreetCityRequest.setZip(address.getZip());
        zipStreetCityRequest.setCity(address.getCity());
        zipStreetCityRequest.setCountry(address.getCountry());
        if (address.getStreet() != null && address.getStreet().length() <= 18){
            zipStreetCityRequest.setMaxErrors(5);
            zipStreetCityRequest.setNoOfResults(2);
            searchResult = this.addressSearchApi.searchZipStreetCity(zipStreetCityRequest);
        } else if (address.getStreet() != null && address.getStreet().length() > 18) {
            zipStreetCityRequest.setMaxErrors(6);
            zipStreetCityRequest.setNoOfResults(1);
            searchResult = this.addressSearchApi.searchZipStreetCity(zipStreetCityRequest);
        }
        if (searchResult.getAddresses() == null) return new ArrayList<>();
        return searchResult.getAddresses().stream().map(this.addressMapper::map)
                .collect(Collectors.toList());
    }
}
