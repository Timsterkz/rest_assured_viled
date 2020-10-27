package market.api.model;

public class MultipartItem {
    private String vendorCode;
    private Brand brand;
    private String barCode;
    private ValuesOnDiffLocale names;
    private Integer categoryId;
    private String attributeValues;
    private String dateCreated;
    private String dateUpdated;

}


//        {"vendorCode":"7891","brand":{"cn":"brand1","en":"brand1","kk":"brand1","ru":"brand1","zh":"brand1"},"barCode":"wtrixcode1","names":{"cn":"","en":"","kk":"","ru":"nameoftovar1","zh":""},"categoryId":30929,"attributeValues":[{"id":20044,"attributeNames":{"cn":"от","en":"от","kk":"от","ru":"jn","zh":"от"},"attributeValues":[]}],"dateCreated":"2020-10-27T01:59:51.702Z","dateUpdated":"2020-10-27T01:59:51.702Z"}
//
//                Content-Disposition: form-data; name="files"; filename="IMG_0049.PNG"
//                Content-Type: image/png


