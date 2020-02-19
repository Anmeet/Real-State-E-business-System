package propertymanagement;

import propertymanager.PropertyManager;
import allocation.PropertyManagerAllocation;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import javax.inject.Named;
import javax.persistence.TypedQuery;

@Named
@Stateless
public class PropertyManagementEJB {

    // ======================================
    // =             Attributes             =
    // ======================================
    @PersistenceContext(unitName = "Assignment2FinalPU")
    private EntityManager em;

    // ======================================
    // =           Public Methods           =
    // ======================================
    public List<SaleProperty> findSaleProperty() {
        Query query = em.createNamedQuery("findNewPropertyManagement");
        return query.getResultList();
    }

    public List<RentProperty> findRentProperty() {
        Query query = em.createNamedQuery("findRentProperty");
        return query.getResultList();
    }

    public List<SaleProperty> searchSaleProperty(Long rn) {
        Query query = em.createNamedQuery("searchSaleProperty");
        query.setParameter(1, rn);
        return query.getResultList();
    }

    public List<RentProperty> searchRentProperty(Long rn) {
        Query query = em.createNamedQuery("searchRentProperty");
        query.setParameter(1, rn);
        return query.getResultList();
    }

    public List<SaleProperty> findSalePropertyByRefNo(String refNo) {
        Query query = em.createNamedQuery("findSalePropertyByRefNo");
        query.setParameter(1, refNo);
        return query.getResultList();
    }

    public List<RentProperty> findRentPropertyByRefNo(String refNo) {
        Query query = em.createNamedQuery("findRentPropertyByRefNo");
        query.setParameter(1, refNo);
        return query.getResultList();
    }

    public SaleProperty createSaleProperty(SaleProperty a) {
        em.persist(a);
        return a;
    }

    public RentProperty createRentProperty(RentProperty b) {
        em.persist(b);
        return b;
    }

    public List<PropertyManagerAllocation> getAllocationPerPropertyManager(long customerId) {
        Query query = em.createNamedQuery("findAllocationByPropertyManagerId");
        query.setParameter(1, customerId);
        return query.getResultList();
    }

    public List<PropertyManager> findPropertyManagerByName(String name) {
        Query query = em.createNamedQuery("findCustomerByName");
        query.setParameter(1, name);
        return query.getResultList();
    }

    public PropertyManager findPropertyManagerById(long id) {
        Query query = em.createNamedQuery("findCustomerById");
        query.setParameter(1, id);
        return (PropertyManager) query.getSingleResult();
    }

    public PropertyManagerAllocation createAllocation(PropertyManagerAllocation allocation) {
        em.persist(allocation);
        return allocation;
    }
    
    public PropertyManagerAllocation createsalePropertyAllocation(PropertyManagerAllocation allocation) {
        em.persist(allocation);
        return allocation;
    }

    public void deleteAllocation(PropertyManagerAllocation allocation) {
        em.remove(em.merge(allocation));
    }

    public List<PropertyManager> findPropertyManager() {
        Query query = em.createNamedQuery("findPropertymanager");
        return query.getResultList();
    }

    public List<PropertyManagement> findAllProperty() {
        Query query = em.createNamedQuery("findAllPropertyManagement", PropertyManagement.class);
        return query.getResultList();
    }

    public List<RentProperty> findAllRentProperty() {
        Query query = em.createNamedQuery("findRentProperty", RentProperty.class);
        List<RentProperty> rentPropertyList = query.getResultList();
        rentPropertyList.forEach((rentProperty) -> {
            System.out.println("rent Property id: " + rentProperty.getCity());
        });
        return rentPropertyList;
    }
    
    public List<SaleProperty> findAllSaleProperty() {
        Query query = em.createNamedQuery("findSaleProperty", SaleProperty.class);
        List<SaleProperty> salePropertyList = query.getResultList();
        salePropertyList.forEach((saleProperty) -> {
            System.out.println("sale Property id: " + saleProperty.getCity());
        });
        return salePropertyList;
    } 
    
    
    public List<Object[]> getAllocationDetails() {
        String sql = "SELECT co.id , cust.id, cust.firstName,cust.lastName,c.streetNumber,c.streetName,c.city, "
                + "co.date_created FROM PropertyManagerAllocation co "
                + "INNER JOIN PropertyManagement c ON co.propertymanagementId =c.id "
                + "INNER JOIN PropertyManager cust ON co.propertymanagerId =cust.id";
        List<Object[]> results = em.createNativeQuery(sql).getResultList();
        return results;
    }

    public List<Object[]> getAllocationsForSpecificPropertyManager(Long id) {
        String sql = "SELECT co.id ,cust.firstName,cust.lastName,c.streetNumber,c.streetName,c.city, "
                + "co.date_created FROM PropertyManagerAllocation co "
                + "INNER JOIN PropertyManagement c ON co.propertymanagementId =c.id "
                + "INNER JOIN PropertyManager cust ON co.propertymanagerId =cust.id WHERE co.propertymanagerId = ?1";
        List<Object[]> results = em.createNativeQuery(sql).setParameter(1, id).getResultList();
        return results;
    }

    public PropertyManagerAllocation getAllocationById(long id) {
        TypedQuery<PropertyManagerAllocation> query = em.createNamedQuery("findOrderById", PropertyManagerAllocation.class);
        query.setParameter(1, id);
        return query.getSingleResult();
    }
}
