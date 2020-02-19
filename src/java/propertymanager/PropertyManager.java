/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package propertymanager;

import allocation.PropertyManagerAllocation;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author amit
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "findPropertymanager", query = "SELECT i FROM PropertyManager i")
    ,
@NamedQuery(name = "searchPropertymanager", query = "SELECT i FROM PropertyManager i where i.firstName=?1 and i.lastName=?2")
    ,
@NamedQuery(name = "searchPropertymanagerID", query = "SELECT i From PropertyManager i where i.id=?1")
})

public class PropertyManager implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;

    private String firstName;
    private String lastName;
    private Long phoneNumber;
    private String email;
    private Long mobile;

      // ======================================
    // =             Getter and Setter      =
    // ======================================
    
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
/*
    public List<PropertyManagerAllocation> getOrders() {
        return orders;
    }

    public void setOrders(List<PropertyManagerAllocation> orders) {
        this.orders = orders;
    }
    */


  

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JoinColumn(name = "propertymanagerId")
    private List<PropertyManagerAllocation> orders;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getMobile() {
        return mobile;
    }

    public void setMobile(Long mobile) {
        this.mobile = mobile;
    }

  

    @Override
    public String toString() {
        return "PropertyManager{" + "id=" + id + ",  first name=" + firstName + ", last name=" + lastName + ", phoneNumber=" + phoneNumber + ", email=" + email + ",mobile="+mobile +'}';
    }



}
