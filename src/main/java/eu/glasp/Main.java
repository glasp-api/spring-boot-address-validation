package eu.glasp;

import eu.glasp.model.Address;
import eu.glasp.model.ApiException;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws IOException, ApiException {
        ValidationService validationService = new ValidationServiceBuilder()
                .configureUser("eef49c16-b708-455e-86d1-6cadf3b0b9a2")
                .configurePassword("}RgJl?NmxIOyTGbRS}07")
                .configureTimeout(1500, TimeUnit.MILLISECONDS)
                .build();
        Address address = new Address("Strada Cascina","43032", "Buseto", "IT");

        long startTime = System.currentTimeMillis();
        System.out.println("Start time: " + startTime);

        List<Address> addresses = validationService.search(address);

        System.out.println(addresses.toString());
        System.out.println("End time: " + (System.currentTimeMillis() - startTime));
    }
}
