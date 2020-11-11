package market.api.model;

import java.util.List;

public class MultipartItem {
    private String vendorCode;
    private ValuesOnDiffLocale brand;
    private String barCode;
    private ValuesOnDiffLocale names;
    private Integer categoryId;
    private List<AttributeValues> attributeValues;

    public MultipartItem(String vendorCode, ValuesOnDiffLocale brand, String barCode, ValuesOnDiffLocale names, Integer categoryId, List<AttributeValues> attributeValues) {
        this.vendorCode = vendorCode;
        this.brand = brand;
        this.barCode = barCode;
        this.names = names;
        this.categoryId = categoryId;
        this.attributeValues = attributeValues;
    }

    public String getVendorCode() {
        return vendorCode;
    }

    public void setVendorCode(String vendorCode) {
        this.vendorCode = vendorCode;
    }

    public ValuesOnDiffLocale getBrand() {
        return brand;
    }

    public void setBrand(ValuesOnDiffLocale brand) {
        this.brand = brand;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public ValuesOnDiffLocale getNames() {
        return names;
    }

    public void setNames(ValuesOnDiffLocale names) {
        this.names = names;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public List<AttributeValues> getAttributeValues() {
        return attributeValues;
    }

    public void setAttributeValues(List<AttributeValues> attributeValues) {
        this.attributeValues = attributeValues;
    }
}


//        {"vendorCode":"7891","brand":{"cn":"brand1","en":"brand1","kk":"brand1","ru":"brand1","zh":"brand1"},"barCode":"wtrixcode1","names":{"cn":"","en":"","kk":"","ru":"nameoftovar1","zh":""},"categoryId":30929,"attributeValues":[{"id":20044,"attributeNames":{"cn":"от","en":"от","kk":"от","ru":"jn","zh":"от"},"attributeValues":[]}],"dateCreated":"2020-10-27T01:59:51.702Z","dateUpdated":"2020-10-27T01:59:51.702Z"}
//
//                Content-Disposition: form-data; name="files"; filename="IMG_0049.PNG"
//                Content-Type: image/png


