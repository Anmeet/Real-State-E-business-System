package allocation;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import javax.persistence.TypedQuery;

@Stateless
public class AllocationEJB {

    // ======================================
    // =             Attributes             =
    // ======================================

    @PersistenceContext(unitName = "Assignment2FinalPU")
    private EntityManager em;

    // ======================================
    // =           Public Methods           =
    // ======================================

    public List<PropertyManagerAllocation> findNewAllocation() {
        Query query = em.createNamedQuery("findOrder");
        return query.getResultList();
    }
    
    
    
    public List <PropertyManagerAllocation> searchNewAllocation(Long rn){
        Query query =em.createNamedQuery("searchNewOrder");
        query.setParameter(1,rn);
        return query.getResultList();
    }
    
     

    public PropertyManagerAllocation createNewAllocation(PropertyManagerAllocation a) {
        em.persist(a);
        return a;
    }
        public List<Object[]> getAllocationDetails() {
       String sql = "SELECT co.id , cust.id, cust.firstName,cust.lastName, c.streetNumber,c.streetName, "
            + "c.city ,co.date_created FROM PropertyManagerAllocation co "
            + "INNER JOIN PropertyManagement c ON co.propertymanagementId =c.id "
            + "INNER JOIN PropertyManager cust ON co.propertymanagerId =cust.id";
        List<Object[]> results = em.createNativeQuery(sql).getResultList();
        return results;
    }
    
    public List<Object[]> getAllocationForSpecificPropertyManager(Long id) {
        String sql = "SELECT co.id ,cust.firstName ,co.date_created, "
            + "c.price FROM PropertyManagerAllocation co "
            + "INNER JOIN PropertyManagement c ON co.propertymanagementrId =c.id "
            + "INNER JOIN PropertyManager cust ON co.propertymanagerId =cust.id WHERE co.propertymanagerId = ?1";
        List<Object[]> results = em.createNativeQuery(sql).setParameter(1, id).getResultList();
        return results;
    }
    
     public PropertyManagerAllocation getAllocationById(long id) {
        TypedQuery<PropertyManagerAllocation> query = em.createNamedQuery("findOrderById", PropertyManagerAllocation.class);
        query.setParameter(1, id);
        return query.getSingleResult();
    }
     
     public void deleteAllocation(PropertyManagerAllocation allocation) {
        em.remove(em.merge(allocation));
    }
     
     public PropertyManagerAllocation createAllocation(PropertyManagerAllocation Allocation) {
        em.persist(Allocation);
        return Allocation;
    }

    
}