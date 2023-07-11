package domain;

import java.util.Objects;

/**
 *
 * @author Jelena Basaric
 */
public class Country {
    private int id;
    private String name;
    private String shortName;

    public Country(int countryId, String countryName, String shortName) {
        this.id = countryId;
        this.name = countryName;
        this.shortName = shortName;
    }

    public Country() {
    }

    public int getCountryId() {
        return id;
    }

    public void setCountryId(int countryId) {
        this.id = countryId;
    }

    public String getCountryName() {
        return name;
    }

    public void setCountryName(String countryName) {
        this.name = countryName;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final Country other = (Country) obj;
        return Objects.equals(this.name, other.name);
    }

    @Override
    public String toString() {
        return " "+ name+", "+ shortName;
    }
    
    
}
