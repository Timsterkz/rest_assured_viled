package market.api.model;

public class ValuesOnDiffLocale {
    private String en;
    private String ru;
    private String kk;
    private String zh;
    private String cn;

    public ValuesOnDiffLocale(String en, String ru, String kk, String zh, String cn) {
        this.en = en;
        this.ru = ru;
        this.kk = kk;
        this.zh = zh;
        this.cn = cn;
    }

    public String getEn() {
        return en;
    }

    public void setEn(String en) {
        this.en = en;
    }

    public String getRu() {
        return ru;
    }

    public void setRu(String ru) {
        this.ru = ru;
    }

    public String getKk() {
        return kk;
    }

    public void setKk(String kk) {
        this.kk = kk;
    }

    public String getZh() {
        return zh;
    }

    public void setZh(String zh) {
        this.zh = zh;
    }

    public String getCn() {
        return cn;
    }

    public void setCn(String cn) {
        this.cn = cn;
    }
}
