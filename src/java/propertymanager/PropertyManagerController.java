package propertymanager;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@RequestScoped
public class PropertyManagerController {

    // ======================================
    // =             Attributes             =
    // ======================================

    @EJB
    private PropertyManagerEJB PropertyManagerEJB;
    

    private PropertyManager propertyManager = new PropertyManager();
    
    private List<PropertyManager> propertyManagerlist = new ArrayList<PropertyManager>();
    private List<PropertyManager> searchPropertymanagerList = new ArrayList<PropertyManager>();
    private List<PropertyManager> searchPropertyManagerName = new ArrayList<PropertyManager>();
    
    private int totalPropertyManager;
    private int totalSearchpropertymanager;
    private Long id;
     private String searchPropertymanager1;
     private String searchPropertymanager;

    

   

    // ======================================
    // =           Public Methods           =
    // ======================================

    public String doNewPropertyManager() {
        return "newPropertymanager.xhtml";
    }

    public String doCreateNewPropertyManager() {

        propertyManager=PropertyManagerEJB.createSaleProperty(propertyManager);
        propertyManagerlist=PropertyManagerEJB.findPropertyManager();
        return "listPropertymanager.xhtml";
    }
    
    public String doSearchPropertyManager() {
          
        searchPropertymanagerList=PropertyManagerEJB.searchPropertyManager(searchPropertymanager,searchPropertymanager1);
        totalSearchpropertymanager=searchPropertymanagerList.size();
               
        return "listSearchPropertymanager.xhtml";
    }
    
    public String doDetails(Long id){
    searchPropertymanagerList=PropertyManagerEJB.searchPropertyManagerDetails(id);
    return "detailsCustomer.xhtml";
    }
    
  
    

    // ======================================
    // =          Getters & Setters         =
    // ======================================
    
    public String doViewPropertyManagerDetails(PropertyManager propertymanager) {
        this.propertyManager = propertymanager;
        return "PropertymanagerDetails.xhtml";
    }

    public PropertyManagerEJB getPropertyManagerEJB() {
        return PropertyManagerEJB;
    }

    public void setPropertyManagerEJB(PropertyManagerEJB propertyManagerEJB) {
        this.PropertyManagerEJB = propertyManagerEJB;
    }

    public PropertyManager getPropertyManager() {
        return propertyManager;
    }

    public void setPropertyManager(PropertyManager propertymanager) {
        this.propertyManager = propertymanager;
    }
 
 
    public long doOrdersCount(long propertymanagerID) {
        return PropertyManagerEJB.getOrdersPerPropertyManager(propertymanagerID).size();
    }

    public List<PropertyManager> getPropertyManagerList() {
        propertyManagerlist = PropertyManagerEJB.findPropertyManager();
        return propertyManagerlist;
    }

    public void setPropertyManagerList(List<PropertyManager> propertymanagerList) {
        this.propertyManagerlist = propertymanagerList;
    }
    
     public String getSearchPropertymanager() {
        return searchPropertymanager;
    }

    public void setSearchPropertymanager(String searchPropertymanager) {
        this.searchPropertymanager = searchPropertymanager;
    }

    public List<PropertyManager> getPropertyManagerlist() {
        return propertyManagerlist;
    }

    public void setPropertyManagerlist(List<PropertyManager> propertyManagerlist) {
        this.propertyManagerlist = propertyManagerlist;
    }

    public int getTotalSearchpropertymanager() {
        return totalSearchpropertymanager;
    }

    public void setTotalSearchpropertymanager(int totalSearchpropertymanager) {
        this.totalSearchpropertymanager = totalSearchpropertymanager;
    }
  
    public String getSearchPropertymanager1() {
        return searchPropertymanager1;
    }

    public void setSearchPropertymanager1(String searchPropertymanager1) {
        this.searchPropertymanager1 = searchPropertymanager1;
    }
    
    
    public List<PropertyManager> getSearchPropertymanagerList() {
        return searchPropertymanagerList;
    }

    public void setSearchPropertymanagerList(List<PropertyManager> searchPropertymanagerList) {
        this.searchPropertymanagerList = searchPropertymanagerList;
    }
    
    public int getTotalPropertyManager() {
        totalPropertyManager = propertyManagerlist.size();
        return totalPropertyManager;
    }

    public void setTotalPropertyManager(int totalPropertymanager) {
        this.totalPropertyManager = totalPropertymanager;
    }

    public int getTotalSearchPropertyManager() {
        return totalSearchpropertymanager;
    }

    public void setTotalSearchPropertyManager(int totalSearchPropertymanager) {
        this.totalSearchpropertymanager = totalSearchPropertymanager;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSearchPropertyManagerName() {
        searchPropertyManagerName=PropertyManagerEJB.doListName();
        return searchPropertyManagerName.toString();
        
    }

    public void setSearchPropertyManagerName(List<PropertyManager> searchPropertymanagerName) {
        this.searchPropertyManagerName = searchPropertymanagerName;
    }   

    @Override
    public String toString() {
        return "propertyManagerController{" + "PropertyManagerEJB=" + PropertyManagerEJB + ", PropertyManager=" + propertyManager + ", PropertyManagerList=" + propertyManagerlist + ", searchPropertyManagerList=" + searchPropertymanagerList + ", searchPropertyManagerName=" + searchPropertyManagerName + ", totalPropertyManager=" + totalPropertyManager + ", totalSearchPropertyManager=" + totalSearchpropertymanager + ", id=" + id + ", searchPropertyManager=" + searchPropertymanager + '}';
    }

  
}