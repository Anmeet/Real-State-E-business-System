package allocation;

import propertymanagement.PropertyManagement;

import propertymanagement.PropertyManagementEJB;
import propertymanager.PropertyManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import propertymanagement.RentProperty;
import propertymanagement.SaleProperty;

@ManagedBean
@RequestScoped
public class AllocationController {
//all variables declared
    @EJB
    private PropertyManagementEJB propertyEJB;

    private PropertyManagerAllocation allocation = new PropertyManagerAllocation();
    private List<PropertyManagerAllocation> propertyAllocationList = new ArrayList<>();
    private List<PropertyManager> propertyManagerList = new ArrayList<>();
    private List<PropertyManagement> propertyList = new ArrayList<>();
    private List<SaleProperty> saleProperty = new ArrayList<>();
    List<Object[]> allocationDetailsList = new ArrayList<>();
    List<Object[]> searchDetailedAllocationsList = new ArrayList<>();
    private Long id;
    private int totalAllocation;
    List<RentProperty> rentPropertyList;
    List<SaleProperty> salePropertyList;
    private PropertyManager propertManager = new PropertyManager();

    public PropertyManager getPropertManager() {
        return propertManager;
    }

    public void setPropertManager(PropertyManager propertManager) {
        this.propertManager = propertManager;
    }
     
    public void setRentPropertyList(List<RentProperty> rentPropertyList) {
        this.rentPropertyList = rentPropertyList;
    }

    public List<SaleProperty> getSalePropertyList() {
        salePropertyList=propertyEJB.findAllSaleProperty();
        return salePropertyList;
    }
    
     public List<RentProperty> getRentPropertyList() {
        rentPropertyList= propertyEJB.findAllRentProperty();
        return rentPropertyList;
    }

    public void setSalePropertyList(List<SaleProperty> salePropertyList) {
        this.salePropertyList = salePropertyList;
    }

    public AllocationController() {
        
    }
    public List<SaleProperty> getSaleProperty() {
        return saleProperty;
    }

    public void setSaleProperty(List<SaleProperty> saleProperty) {
        this.saleProperty = saleProperty;
    }

    public String doCreateAllocation() {
        String currentDateTime = java.util.Calendar.getInstance().getTime().toString();
        allocation.setDate_created(currentDateTime);
        allocation = propertyEJB.createAllocation(allocation);
        return "listAllocation.xhtml";
    }
    
    public String doCreatesaleAllocation() {
        String currentDateTime = java.util.Calendar.getInstance().getTime().toString();
        allocation.setDate_created(currentDateTime);
        allocation = propertyEJB.createsalePropertyAllocation(allocation);
        return "listAllocation.xhtml";
    }

    public List<Object[]> getPropertyManagerAllocationsFromId(long id) {
        return propertyEJB.getAllocationsForSpecificPropertyManager(id);
    }

    public PropertyManagementEJB getPropertyEJB() {
        return propertyEJB;
    }

    public void setPropertyEJB(PropertyManagementEJB propertyEJB) {
        this.propertyEJB = propertyEJB;
    }

    public PropertyManagerAllocation getAllocation() {
        return allocation;
    }

    public void setAllocation(PropertyManagerAllocation allocation) {
        this.allocation = allocation;
    }

    public List<PropertyManagerAllocation> getPropertyAllocationList() {
        allocationDetailsList = propertyEJB.getAllocationDetails();
        return propertyAllocationList;
    }

    public void setPropertyAllocationList(List<PropertyManagerAllocation> propertyAllocationList) {
        this.propertyAllocationList = propertyAllocationList;
    }

    public List<PropertyManager> getPropertyManagerList() {
        propertyManagerList = propertyEJB.findPropertyManager();
        return propertyManagerList;
    }

    public void setPropertyManagerList(List<PropertyManager> propertyManagerList) {
        this.propertyManagerList = propertyManagerList;
    }

    public List<PropertyManagement> getPropertyList() {
        propertyList = propertyEJB.findAllProperty();
        return propertyList;
    }
    
    public void setPropertyList(List<PropertyManagement> propertyList) {
        this.propertyList = propertyList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Object[]> getAllocationDetailsList() {
        allocationDetailsList = propertyEJB.getAllocationDetails();
        return allocationDetailsList;
    }

    public void setAllocationDetailsList(List<Object[]> allocationDetailsList) {
        this.allocationDetailsList = allocationDetailsList;
    }

    public List<Object[]> getSearchDetailedAllocationsList() {
        return searchDetailedAllocationsList;
    }

    public void setSearchDetailedAllocationsList(List<Object[]> searchDetailedAllocationsList) {
        this.searchDetailedAllocationsList = searchDetailedAllocationsList;
    }

    public String doDeleteAllocation(long id) {
        PropertyManagerAllocation tmp = propertyEJB.getAllocationById(id);
        propertyEJB.deleteAllocation(tmp);

        return "listAllocation.xhtml";
    }

    public String doSearchPropertyAllocation() {
        allocationDetailsList.clear();
        propertyEJB.getAllocationDetails().stream().filter((ord) -> ((int) ord[0] == allocation.getId())).forEachOrdered((ord) -> {
            searchDetailedAllocationsList.add(ord);
        });
        return "listSearchAllocation.xhtml";
    }

    public int getTotalAllocation() {
        totalAllocation = propertyAllocationList.size();
        return totalAllocation;
    }

    public void setTotalAllocation(int totalAllocation) {
        this.totalAllocation = totalAllocation;
    }

}
