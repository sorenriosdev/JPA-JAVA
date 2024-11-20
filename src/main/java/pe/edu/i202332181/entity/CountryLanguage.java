package pe.edu.i202332181.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "countrylanguage")
public class CountryLanguage {

    @Id
    @Column(name = "language")
    private String language;

    @Id
    @Column(name = "countryCode")
    private String countryCode;

    @Column(name = "isOfficial")
    private String isOfficial;

    @Column(name = "percentage")
    private float percentage;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "countryCode", referencedColumnName = "code", insertable = false, updatable = false)
    private Country country;

    public CountryLanguage(String language, String countryCode, String isOfficial, float percentage, Country country) {
        this.language = language;
        this.countryCode = countryCode;
        this.isOfficial = isOfficial;
        this.percentage = percentage;
        this.country = country;
    }

    public CountryLanguage() {}

    @Override
    public String toString() {
        return "CountryLanguage{" +
                "language='" + language + '\'' +
                ", countryCode='" + countryCode + '\'' +
                ", isOfficial='" + isOfficial + '\'' +
                ", percentage=" + percentage +
                ", country=" + country +
                '}';
    }

    public String getIsOfficial() {
        return isOfficial;
    }

    public void setIsOfficial(String isOfficial) {
        this.isOfficial = isOfficial;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public float getPercentage() {
        return percentage;
    }

    public void setPercentage(float percentage) {
        this.percentage = percentage;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
