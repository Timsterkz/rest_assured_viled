package market.api.model;

public class Attribute {
    private Integer categoryId;
    private Boolean isEditable;
    private Boolean isRequired;

    private Boolean isDefault;
    private Integer status;
    private ValuesOnDiffLocale names;

    public Attribute() {
    }

    public Attribute(Integer categoryId, Boolean isEditable, Boolean isRequired, Boolean isDefault, Integer status, ValuesOnDiffLocale names) {
        this.categoryId = categoryId;
        this.isEditable = isEditable;
        this.isRequired = isRequired;
        this.isDefault = isDefault;
        this.status = status;
        this.names = names;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Boolean getIsEditable() {
        return isEditable;
    }

    public void setIsEditable(Boolean isEditable) {
        this.isEditable = isEditable;
    }

    public Boolean getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Boolean isDefault) {
        this.isDefault = isDefault;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public ValuesOnDiffLocale getNames() {
        return names;
    }

    public void setNames(ValuesOnDiffLocale names) {
        this.names = names;
    }

    public Boolean getIsRequired() {
        return isRequired;
    }

    public void setIsRequired(Boolean isRequired) {
        this.isRequired = isRequired;
    }
}

