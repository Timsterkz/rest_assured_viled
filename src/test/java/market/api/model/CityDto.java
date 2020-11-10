package market.api.model;

public class CityDto {
    private String code;
    private String countryCode;
    private String countryName;
    private Integer id;

    public CityDto() {
    }

    public CityDto(String code, String countryCode, String countryName, Integer id, Coordinate coordinate) {
        this.code = code;
        this.countryCode = countryCode;
        this.countryName = countryName;
        this.id = id;
        this.coordinate = coordinate;
    }

    private Coordinate coordinate;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }
}
//  "cityDto": {
//    "code": "string",
//    "countryCode": "string",
//    "countryName": "string",
//    "id": 4,
//     "map": {
//    "latitude": 0,
//    "longitude": 0
//  }}