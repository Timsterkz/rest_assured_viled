package market.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Merchant {
    public Merchant() {
    }

    public Merchant(Long id) {
        this.id = id;
    }

    private Long id;

    public Merchant(Long id, String companyName) {
        this.id = id;
        this.companyName = companyName;
    }

    private String companyName;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public Merchant(String companyName) {
        this.companyName = companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
