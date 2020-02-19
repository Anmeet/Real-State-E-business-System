package propertymanager;

import allocation.PropertyManagerAllocation;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class PropertyManagerEJB {

    // ======================================
    // =             Attributes             =
    // ======================================

    @PersistenceContext(unitName = "Assignment2FinalPU")
    private EntityManager em;

    // ======================================
    // =           Public Methods           =
    // ======================================

    public List<PropertyManager> findPropertyManager() {
        Query query = em.createNamedQuery("findPropertymanager");
        return query.getResultList();
    }
    public List<PropertyManagerAllocation> getOrdersPerPropertyManager(long propertymanagerId) {
        Query query = em.createNamedQuery("findAllocationByPropertyManagerId");
        query.setParameter(1, propertymanagerId);
        return query.getResultList();
    }
    
    
    
    public List <PropertyManager> searchPropertyManager(String rn,String ro){
        Query query =em.createNamedQuery("searchPropertymanager");
        query.setParameter(1,rn);
        query.setParameter(2,ro);
        return query.getResultList();
    }
    
    public List<PropertyManager> doListName(){
        Query query =em.createNamedQuery("listname");
        return query.getResultList();
        
    }
    
    public PropertyManager createSaleProperty(PropertyManager a) {
        em.persist(a);
        return a;
    }
    
    public List<PropertyManager> searchPropertyManagerDetails(Long id) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Query query =em.createNamedQuery("searchPropertymanagerID");
        query.setParameter(1,id);
        return query.getResultList();
    }

    
}