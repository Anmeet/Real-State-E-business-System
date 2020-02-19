package propertymanagement;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

/**
 *
 * @author amit
 */
@Entity
@NamedQuery(name = "findRentProperty", query = "SELECT i FROM RentProperty i")
public class RentProperty extends PropertyManagement implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String referenceNumber;
    private int weeklyRent;
    private boolean furnished;
    
  // ======================================
    // =             Getter and Setter      =
    // ======================================
    
    public boolean isFurnished() {
        return furnished;
    }

    public void setFurnished(boolean furnished) {
        this.furnished = furnished;
    }

    
    
    public int getWeeklyRent() {
        return weeklyRent;
    }

    public void setWeeklyRent(int weeklyRent) {
        this.weeklyRent = weeklyRent;
    }

    public String getReferenceNumber() {
        return referenceNumber;
    }

    public void setReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
    }


   

    @Override
    public String toString() {
        return "RentProperty{" + "id=" + id + ", referenceNumber=" + referenceNumber + ", weeklyRent=" + weeklyRent + ", furnished=" + furnished + '}';
    }

   

}
