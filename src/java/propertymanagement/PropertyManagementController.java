package propertymanagement;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@RequestScoped
public class PropertyManagementController {

    // ======================================
    // =             Attributes             =
    // ======================================
    @EJB
    private PropertyManagementEJB propertyManagementEJB;

    private SaleProperty saleProperty = new SaleProperty();
    private RentProperty Rentproperty = new RentProperty();
    private PropertyManagement propertymanagement = new PropertyManagement();
    private List<SaleProperty> salepropertyList = new ArrayList<SaleProperty>();
    private List<RentProperty> rentpropertyList = new ArrayList<RentProperty>();
    private List<SaleProperty> searchsalepropertyList = new ArrayList<SaleProperty>();
    private List<RentProperty> searchrentpropertyList = new ArrayList<RentProperty>();
    private Long sreferenceNumber;
     private Long ssreferenceNumber;

   
    private int totalSaleproperty;
    private int totalRentproperty;
    private int totalSearchrentproperty;
    private int totalSearchsaleproperty;

    // ======================================
    // =           Public Methods           =
    // ======================================
    public String doSaleproperty() {
        return "saleProperty.xhtml";
    }

    public String doRentproperty() {
        return "rentProperty.xhtml";
    }

    public String doCreateSaleproperty() {

        saleProperty = propertyManagementEJB.createSaleProperty(saleProperty);
        salepropertyList = propertyManagementEJB.findSaleProperty();

        return "listNewsaleProperty.xhtml";
    }

    public String doCreateRentproperty() {

        Rentproperty = propertyManagementEJB.createRentProperty(Rentproperty);
        rentpropertyList = propertyManagementEJB.findRentProperty();

        return "listrentProperty.xhtml";
    }

    public String doSearchSaleproperty() {

        searchsalepropertyList = propertyManagementEJB.searchSaleProperty(sreferenceNumber);
        totalSearchsaleproperty = searchsalepropertyList.size();

        return "listsearchNewsaleProperty.xhtml";
    }

    public String doSearchRentproperty() {

        searchrentpropertyList = propertyManagementEJB.searchRentProperty(ssreferenceNumber);
        totalSearchrentproperty = searchrentpropertyList.size();

        return "listsearchrentProperty.xhtml";
    }

    public String dosalepropertyDetailsByRefNo(String reference) {
        searchsalepropertyList = propertyManagementEJB.findSalePropertyByRefNo(reference);
        return "listSearchNewsaleProperty.xhtml";
    }

    public String dorentpropertyDetailsByRefNo(String refNo) {
        searchrentpropertyList = propertyManagementEJB.findRentPropertyByRefNo(refNo);
        return "newUsedCarDetails.xhtml";
    }
    
     public String doViewPropertyManagerDetails(SaleProperty saleproperty) {
        this.saleProperty = saleproperty;
        return "salepropertydetail.xhtml";
    }
     
      public String doViewrentPropertyManagerDetails(RentProperty car) {
        this.Rentproperty = car;
        return "rentpropertydetail.xhtml";
    }

    // ======================================
    // =          Getters & Setters         =
    // ======================================
    public PropertyManagementEJB getPropertyManagementEJB() {
        return propertyManagementEJB;
    }

    public void setPropertyManagementEJB(PropertyManagementEJB propertyManagementEJB) {
        this.propertyManagementEJB = propertyManagementEJB;
    }
   
     public Long getSreferenceNumber() {
        return sreferenceNumber;
    }

    public void setSreferenceNumber(Long sreferenceNumber) {
        this.sreferenceNumber = sreferenceNumber;
    }

    public Long getSsreferenceNumber() {
        return ssreferenceNumber;
    }

    public void setSsreferenceNumber(Long ssreferenceNumber) {
        this.ssreferenceNumber = ssreferenceNumber;
    }

    public SaleProperty getSaleProperty() {
        return saleProperty;
    }

    public void setSaleProperty(SaleProperty saleProperty) {
        this.saleProperty = saleProperty;
    }

    public RentProperty getRentproperty() {
        return Rentproperty;
    }

    public void setRentproperty(RentProperty Rentproperty) {
        this.Rentproperty = Rentproperty;
    }

    public PropertyManagement getPropertymanagement() {
        return propertymanagement;
    }

    public void setPropertymanagement(PropertyManagement propertymanagement) {
        this.propertymanagement = propertymanagement;
    }

    public List<SaleProperty> getSalepropertyList() {
        salepropertyList = propertyManagementEJB.findSaleProperty();
        return salepropertyList;
    }

    public void setSalepropertyList(List<SaleProperty> salepropertyList) {

        this.salepropertyList = salepropertyList;
    }

    public List<RentProperty> getRentpropertyList() {
        rentpropertyList = propertyManagementEJB.findRentProperty();
        return rentpropertyList;
    }

    public void setRentpropertyList(List<RentProperty> rentpropertyList) {
        this.rentpropertyList = rentpropertyList;
    }

    public List<SaleProperty> getSearchsalepropertyList() {
        return searchsalepropertyList;
    }

    public void setSearchsalepropertyList(List<SaleProperty> searchsalepropertyList) {
        this.searchsalepropertyList = searchsalepropertyList;
    }

    public List<RentProperty> getSearchrentpropertyList() {
       // searchrentpropertyList = propertyManagementEJB.searchRentProperty(sreferenceNumber);
        return searchrentpropertyList;
    }

    public void setSearchrentpropertyList(List<RentProperty> searchrentpropertyList) {
        this.searchrentpropertyList = searchrentpropertyList;
    }

    public int getTotalSaleproperty() {
        totalSaleproperty = salepropertyList.size();
        return totalSaleproperty;
    }

    public void setTotalSaleproperty(int totalSaleproperty) {
        this.totalSaleproperty = totalSaleproperty;
    }

    public int getTotalRentproperty() {
        totalRentproperty = rentpropertyList.size();
        return totalRentproperty;
    }

    public void setTotalRentproperty(int totalRentproperty) {
        this.totalRentproperty = totalRentproperty;
    }

    public int getTotalSearchrentproperty() {
        totalSearchsaleproperty = searchsalepropertyList.size();
        return totalSearchrentproperty;
    }

    public void setTotalSearchrentproperty(int totalSearchrentproperty) {
        this.totalSearchrentproperty = totalSearchrentproperty;
    }

    public int getTotalSearchsaleproperty() {
        totalSearchrentproperty = searchrentpropertyList.size();
        return totalSearchsaleproperty;
    }

    public void setTotalSearchsaleproperty(int totalSearchsaleproperty) {
        this.totalSearchsaleproperty = totalSearchsaleproperty;
    }

}
