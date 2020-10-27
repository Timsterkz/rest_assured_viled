package market.api.model;

public class AttributeValues {
    private Integer attributeId;
    private Integer attributeValueId;
    private Boolean isSelected;
    private Boolean isRequired;
    private Integer status;
    private ValuesOnDiffLocale value;
    private String value1;

    public AttributeValues(Integer attributeId, Integer attributeValueId, Boolean isRequired, String value1) {
        this.attributeId = attributeId;
        this.attributeValueId = attributeValueId;
        this.isRequired = isRequired;
        this.value1 = value1;
    }

    public AttributeValues() {
    }

    public AttributeValues(Integer attributeId, Boolean isSelected, Integer status, ValuesOnDiffLocale value) {
        this.attributeId = attributeId;
        this.isSelected = isSelected;
        this.status = status;
        this.value = value;
    }

    public Integer getAttributeId() {
        return attributeId;
    }

    public void setAttributeId(Integer attributeId) {
        this.attributeId = attributeId;
    }

    public Boolean getSelected() {
        return isSelected;
    }

    public void setSelected(Boolean selected) {
        isSelected = selected;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public ValuesOnDiffLocale getValue() {
        return value;
    }

    public void setValue(ValuesOnDiffLocale value) {
        this.value = value;
    }

    public Integer getAttributeValueId() {
        return attributeValueId;
    }

    public void setAttributeValueId(Integer attributeValueId) {
        this.attributeValueId = attributeValueId;
    }

    public Boolean getRequired() {
        return isRequired;
    }

    public void setRequired(Boolean required) {
        isRequired = required;
    }

    public String getValue1() {
        return value1;
    }

    public void setValue1(String value1) {
        this.value1 = value1;
    }
}
//{
//    "attributeId": {{attributeId}},
//    "id": 0,
//    "isSelected": true,
//    "status": 0,
//    "value": {
//        "ru": "jhb",
//        "en": "ft",
//        "kk": "fh",
//        "cn": "fhf"
//    }
//}