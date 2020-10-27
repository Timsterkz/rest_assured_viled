package market.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Stock {
    private Boolean active;
    private Address address;
    private String buildingType;
    private CityDto cityDto;
    private Long merchantId;
    private String storeName;
    private String phone;
    private Boolean pickupAvailable;
    private List<Schedule> schedule;

    public Stock() {
    }


    public Stock(Boolean active, Address address, String buildingType, CityDto cityDto, Long merchantId, String storeName, String phone, Boolean pickupAvailable, List<Schedule> schedule) {
        this.active = active;
        this.address = address;
        this.buildingType = buildingType;
        this.cityDto = cityDto;
        this.merchantId = merchantId;
        this.storeName = storeName;
        this.phone = phone;
        this.pickupAvailable = pickupAvailable;
        this.schedule = schedule;
    }


    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getBuildingType() {
        return buildingType;
    }

    public void setBuildingType(String buildingType) {
        this.buildingType = buildingType;
    }

    public CityDto getCityDto() {
        return cityDto;
    }

    public void setCityDto(CityDto cityDto) {
        this.cityDto = cityDto;
    }

    public Long getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Boolean getPickupAvailable() {
        return pickupAvailable;
    }

    public void setPickupAvailable(Boolean pickupAvailable) {
        this.pickupAvailable = pickupAvailable;
    }

    public List<Schedule> getSchedule() {
        return schedule;
    }

    public void setSchedule(List<Schedule> schedule) {
        this.schedule = schedule;
    }

}
//{
//  "active": true,
//  "address": {
//    "city": "Almaty",
//    "cityId": 2,
//    "country": "Kazakhstan",
//    "flat": 110,
//    "house": 150,
//    "street": "Абая"
//  },
//  "buildingType": "string",
//  "cityDto": {
//    "code": "string",
//    "countryCode": "string",
//    "countryName": "string",
//    "id": 4,
//     "map": {
//    "latitude": 0,
//    "longitude": 0
//  }},
//  "merchantId": {{merchantId}},
//  "storeName": "{{storeName}}",
//  "phone": "77029203758",
//  "pickupAvailable": true,
//  "schedule": [
//    {
//      "day": "MONDAY",
//      "fromTime": "07:00",
//      "isAllDay": true,
//      "isDayOff": true,
//      "toTime": "21:00"
//    },
//        {
//      "day": "TUESDAY",
//      "fromTime": "07:00",
//      "isAllDay": true,
//      "isDayOff": true,
//      "toTime": "21:00"
//    },
//        {
//      "day": "WEDNESDAY",
//      "fromTime": "07:00",
//      "isAllDay": true,
//      "isDayOff": true,
//      "toTime": "21:00"
//    },
//        {
//      "day": "THURSDAY",
//      "fromTime": "07:00",
//      "isAllDay": true,
//      "isDayOff": true,
//      "toTime": "21:00"
//    },
//        {
//      "day": "FRIDAY",
//      "fromTime": "07:00",
//      "isAllDay": true,
//      "isDayOff": true,
//      "toTime": "21:00"
//    },
//        {
//      "day": "SATURDAY",
//      "fromTime": "07:00",
//      "isAllDay": true,
//      "isDayOff": true,
//      "toTime": "21:00"
//    },
//        {
//      "day": "SUNDAY",
//      "fromTime": "07:00",
//      "isAllDay": true,
//      "isDayOff": true,
//      "toTime": "21:00"
//    }
//  ]
//}