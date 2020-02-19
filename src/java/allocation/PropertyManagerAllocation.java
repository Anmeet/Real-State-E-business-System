package allocation;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
    @NamedQuery(name = "findAllocationByPropertyManagerId", query = "SELECT o FROM PropertyManagerAllocation o WHERE o.propertymanagerId = ?1")
    ,
   @NamedQuery(name = "findOrderById", query = "SELECT o FROM PropertyManagerAllocation o WHERE o.id = ?1")
})
public class PropertyManagerAllocation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private long propertymanagementId;
    private long propertymanagerId;
    private String date_created;

    // ======================================
    // =             Getter and Setter      =
    // ======================================
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getPropertymanagementId() {
        return propertymanagementId;
    }

    public void setPropertymanagementId(long propertymanagementId) {
        this.propertymanagementId = propertymanagementId;
    }

  

    public long getPropertymanagerId() {
        return propertymanagerId;
    }

    public void setPropertymanagerId(long propertymanagerId) {
        this.propertymanagerId = propertymanagerId;
    }

    public String getDate_created() {
        return date_created;
    }

    public void setDate_created(String date_created) {
        this.date_created = date_created;
    }

    @Override
    public String toString() {
        return "PropertyManagerAllocation{" + "id=" + id + ", carId=" + propertymanagementId + ", customerId=" + propertymanagerId + ", date_created=" + date_created + '}';
    }
    

}
