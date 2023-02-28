package eu.glasp.model;

import java.util.Objects;

public class Address {
    private String street;
    private String zip;
    private String city;
    private String country;

    public Address(){}

    public Address(String street, String zip, String country) {
        this.street = street;
        this.zip = zip;
        this.country = country;
    }

    public Address(String street, String zip, String city, String country) {
        this.street = street;
        this.zip = zip;
        this.city = city;
        this.country = country;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Address address = (Address) o;
        return Objects.equals(this.zip, address.zip) &&
                Objects.equals(this.street, address.street) &&
                Objects.equals(this.city, address.city) &&
                Objects.equals(this.country, address.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(zip, street, city, country);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Address {\n");
        sb.append("    zip: ").append(toIndentedString(zip)).append("\n");
        sb.append("    street: ").append(toIndentedString(street)).append("\n");
        sb.append("    city: ").append(toIndentedString(city)).append("\n");
        sb.append("    country: ").append(toIndentedString(country)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}
