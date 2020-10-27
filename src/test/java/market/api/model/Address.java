package market.api.model;

public class Address {
    private String city;
    private Integer cityId;
    private String country;
    private Integer flat;
    private Integer house;
    private String street;

    public Address() {
    }

    public Address(String city, int cityId, String country, Integer flat, Integer house, String street) {
        this.city = city;
        this.cityId = cityId;
        this.country = country;
        this.flat = flat;
        this.house = house;
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getFlat() {
        return flat;
    }

    public void setFlat(Integer flat) {
        this.flat = flat;
    }

    public Integer getHouse() {
        return house;
    }

    public void setHouse(Integer house) {
        this.house = house;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
}
//  "address": {
//    "city": "Almaty",
//    "cityId": 2,
//    "country": "Kazakhstan",
//    "flat": 110,
//    "house": 150,
//    "street": "Абая"
//  },