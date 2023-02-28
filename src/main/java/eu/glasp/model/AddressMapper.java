package eu.glasp.model;

public class AddressMapper {
    public Address map(org.openapitools.client.model.Address address){
        Address tmpAddress = new Address();
        tmpAddress.setStreet(address.getStreet());
        tmpAddress.setZip(address.getZip());
        tmpAddress.setCity(address.getCity());
        tmpAddress.setCountry(address.getCountry());
        return tmpAddress;
    }
}
