package com.jsonreader.wellymalquitar.jsonreader;

/**
 * Created by wellymalquitar on 07/09/2017.
 */

public class LocationDetails {

    private String street_number;
    private String route;
    private String neighborhood;
    private String locality;
    private String country;
    private String postal_code;

    public LocationDetails() {
        setStreet_number("");
        setRoute("");
        setNeighborhood("");
        setLocality("");
        setCountry("");
        setPostal_code("");
    }

    public String getStreet_number() {
        return street_number;
    }

    public void setStreet_number(String street_number) {
        this.street_number = street_number;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostal_code() {
        return postal_code;
    }

    public void setPostal_code(String postal_code) {
        this.postal_code = postal_code;
    }
}
