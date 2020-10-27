package market.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DraftItem {
    private Integer categoryId; //
    private Integer groupId; //
    private String name; //
    private String productCode; //
    private String vendorCode; //
    private String price; //
    private String brand; //
    private List<AttributeValues> attributes; //
    private List<Integer> stockIds; //

    public DraftItem(Integer categoryId, Integer groupId, String name, String productCode, String vendorCode, String price, String brand, List<AttributeValues> attributes, List<Integer> stockIds) {
        this.categoryId = categoryId;
        this.groupId = groupId;
        this.name = name;
        this.productCode = productCode;
        this.vendorCode = vendorCode;
        this.price = price;
        this.brand = brand;
        this.attributes = attributes;
        this.stockIds = stockIds;
    }

    public DraftItem() {
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getVendorCode() {
        return vendorCode;
    }

    public void setVendorCode(String vendorCode) {
        this.vendorCode = vendorCode;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public List<Integer> getStockIds() {
        return stockIds;
    }

    public void setStockIds(List<Integer> stockIds) {
        this.stockIds = stockIds;
    }

    public List<AttributeValues> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<AttributeValues> attributes) {
        this.attributes = attributes;
    }
}
//{
//  "categoryId": {{categoryId}},
//  "description": "Cola",
//  "groupId": 0,
//  "name": "CocaCola1",
//  "presentationUrl": "Cola",
//  "productCode": "Cola",
//  "vendorCode": "Cola12353",
//  "price": 789,
//  "brand": "brand",
//"attributes": [
//        {
//            "value": "1233",
//            "attributeId": 20004,
//            "isRequired": true,
//            "attributeValueId": null
//        },
//        {
//            "value": "435",
//            "attributeId": 20005,
//            "isRequired": true,
//            "attributeValueId": null
//        },
//        {
//            "value": "34535",
//            "attributeId": 20006,
//            "isRequired": true,
//            "attributeValueId": null
//        },
//        {
//            "value": "345345",
//            "attributeId": 20007,
//            "isRequired": true,
//            "attributeValueId": null
//        },
//        {
//            "value": "34534",
//            "attributeId": 20003,
//            "isRequired": true,
//            "attributeValueId": null
//        },
//        {
//            "value": "345345",
//            "attributeId": 20008,
//            "isRequired": true,
//            "attributeValueId": null
//        }
//    ],
//  "stockIds": [{{stockId}}]
//}