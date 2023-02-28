package eu.glasp;

import eu.glasp.api.SearchWrapper;
import eu.glasp.model.Address;
import eu.glasp.model.ApiException;

import java.io.IOException;
import java.util.List;

public class ValidationService {
    private final SearchWrapper searchWrapper;

    public ValidationService(String user, String password, Integer timeout) {
        this.searchWrapper = new SearchWrapper(user, password, timeout);
    }

    public List<Address> search(Address address) throws IOException, ApiException {
        return this.searchWrapper.search(address);
    }
}

