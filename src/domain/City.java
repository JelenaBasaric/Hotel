package domain;

import java.util.Objects;

/**
 *
 * @author Jelena Basaric
 */
public class City {
    private String cityName;
    private Long zipCode;
    private Country country;

    public City(Long zipCode,String cityName, Country country) {
        this.cityName = cityName;
        this.zipCode = zipCode;
        this.country = country;
    }

    public City() {
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Long getZipCode() {
        return zipCode;
    }
    

    public void setZipCode(Long zipCode) {
        this.zipCode = zipCode;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return ""+cityName + "," + zipCode;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final City other = (City) obj;
        if (!Objects.equals(this.cityName, other.cityName)) {
            return false;
        }
        return Objects.equals(this.zipCode, other.zipCode);
    }
    
}
