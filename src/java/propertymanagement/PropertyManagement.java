package propertymanagement;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author amit
 * 
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@NamedQueries({
    @NamedQuery(name = "findAllPropertyManagement", query = "select c from PropertyManagement c"),
@NamedQuery(name = "findNewPropertyManagement", query = "SELECT i FROM SaleProperty i"),
@NamedQuery(name = "findRentProperty", query = "SELECT i FROM RentProperty i"),
@NamedQuery(name = "searchSaleProperty", query = "SELECT i from PropertyManagement i where i.id=?1"),
@NamedQuery(name = "searchRentProperty", query = "SELECT i from PropertyManagement i where i.id=?1"),
@NamedQuery(name = "findSalePropertyByRefNo", query = "SELECT c From SaleProperty c WHERE c.referenceNumber = ?1"),
@NamedQuery(name = "findRentPropertyByRefNo", query = "SELECT c FROM RentProperty c WHERE c.referenceNumber = ?1")
})
public class PropertyManagement implements Serializable {
    
    // ======================================
    // =             Attributes             =
    // ======================================

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String propertyType;
    private String numberofBedroom;
    private String numberofBathroom;
    private String propertyDescription;
    private String streetNumber;
    private String streetName;
    private String city;
    private String postCode;
    private String country;
    private float price;
    
    // ======================================
    // =             Getter and Setter      =
    // ======================================

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType;
    }

    public String getNumberofBedroom() {
        return numberofBedroom;
    }

    public void setNumberofBedroom(String numberofBedroom) {
        this.numberofBedroom = numberofBedroom;
    }

    public String getNumberofBathroom() {
        return numberofBathroom;
    }

    public void setNumberofBathroom(String numberofBathroom) {
        this.numberofBathroom = numberofBathroom;
    }

    public String getPropertyDescription() {
        return propertyDescription;
    }

    public void setPropertyDescription(String propertyDescription) {
        this.propertyDescription = propertyDescription;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "PropertyManagement{" + "id=" + id + ", propertyType=" + propertyType + ", numberofBedroom=" + numberofBedroom + ", numberofBathroom=" + numberofBathroom + ", propertyDescription=" + propertyDescription + ", streetNumber=" + streetNumber + ", streetName=" + streetName + ", city=" + city + ", postCode=" + postCode + ", country=" + country + ", price=" + price + '}';
    } 

}
