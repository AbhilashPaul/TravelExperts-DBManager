package exercise6.models;

public class Customer {

    private int customerID;
    private String customerFirstName;
    private String customerLastName;
    private String customerAddress;
    private String customerCity;
    private String customerProvince;
    private String customerPostalCode;
    private String customerCountry;
    private String customerHomePhone;
    private String customerBusPhone;
    private String customerEmail;
    private int assignedAgentID;

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getCustomerFirstName() {
        return customerFirstName;
    }

    public void setCustomerFirstName(String customerFirstName) {
        this.customerFirstName = customerFirstName;
    }

    public String getCustomerLastName() {
        return customerLastName;
    }

    public void setCustomerLastName(String customerLastName) {
        this.customerLastName = customerLastName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getCustomerCity() {
        return customerCity;
    }

    public void setCustomerCity(String customerCity) {
        this.customerCity = customerCity;
    }

    public String getCustomerProvince() {
        return customerProvince;
    }

    public void setCustomerProvince(String customerProvince) {
        this.customerProvince = customerProvince;
    }

    public String getCustomerPostalCode() {
        return customerPostalCode;
    }

    public void setCustomerPostalCode(String customerPostalCode) {
        this.customerPostalCode = customerPostalCode;
    }

    public String getCustomerCountry() {
        return customerCountry;
    }

    public void setCustomerCountry(String customerCountry) {
        this.customerCountry = customerCountry;
    }

    public String getCustomerHomePhone() {
        return customerHomePhone;
    }

    public void setCustomerHomePhone(String customerHomePhone) {
        this.customerHomePhone = customerHomePhone;
    }

    public String getCustomerBusPhone() {
        return customerBusPhone;
    }

    public void setCustomerBusPhone(String customerBusPhone) {
        this.customerBusPhone = customerBusPhone;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public int getAssignedAgentID() {
        return assignedAgentID;
    }

    public void setAssignedAgentID(int assignedAgentID) {
        this.assignedAgentID = assignedAgentID;
    }

    public Customer(int customerID, String customerFirstName, String customerLastName,
                    String customerAddress, String customerCity, String customerProvince,
                    String customerPostalCode, String customerCountry, String customerHomePhone,
                    String customerBusPhone, String customerEmail, int assignedAgentID) {
        this.customerID = customerID;
        this.customerFirstName = customerFirstName;
        this.customerLastName = customerLastName;
        this.customerAddress = customerAddress;
        this.customerCity = customerCity;
        this.customerProvince = customerProvince;
        this.customerPostalCode = customerPostalCode;
        this.customerCountry = customerCountry;
        this.customerHomePhone = customerHomePhone;
        this.customerBusPhone = customerBusPhone;
        this.customerEmail = customerEmail;
        this.assignedAgentID = assignedAgentID;
    }

    public Customer() {
    }
}
