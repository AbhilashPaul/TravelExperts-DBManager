package exercise6.dbhandler;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import exercise6.models.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerDBHandler {

    public static ObservableList<Customer> getCustomers(String searchString){
        ObservableList<Customer> customerList = FXCollections.observableArrayList();
        String query="";
        String fnameSearch="";
        String lnameSearch="";
        if (searchString == " "){
            query = "SELECT * FROM customers ORDER BY CustFirstName";
        }else{
            String[] search =searchString.split(" ");
            if (search.length == 1){
                fnameSearch= "%"+search[0]+"%";
                lnameSearch= "%"+search[0]+"%";
                System.out.println(fnameSearch);
                System.out.println(lnameSearch);
                query = "SELECT * FROM customers WHERE CustFirstName LIKE ? OR CustLastName LIKE ? ORDER BY CustFirstName;";
            }else {
                fnameSearch= "%"+search[0]+"%";
                lnameSearch= "%"+search[1]+"%";
                System.out.println(fnameSearch);
                System.out.println(lnameSearch);
                query = "SELECT * FROM customers WHERE CustFirstName LIKE ? AND CustLastName LIKE ? ORDER BY CustFirstName;";
            }
        }


        try (Connection connection = DBConnectionManager.getDBConnection();
             PreparedStatement statement = connection.prepareStatement(query,
                     ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);) {
            if (searchString != " ") {
                statement.setString(1, fnameSearch);
                statement.setString(2, lnameSearch);
            }
            try (ResultSet resultSet = statement.executeQuery()) {
                //gather agent details and store them in an agent object
                while(resultSet.next()){
                    Customer cust = new Customer(resultSet.getInt("CustomerId"),
                            resultSet.getString("CustFirstName"),
                            resultSet.getString("CustLastName"),
                            resultSet.getString("CustAddress"),
                            resultSet.getString("CustCity"),
                            resultSet.getString("CustProv"),
                            resultSet.getString("CustPostal"),
                            resultSet.getString("CustCountry"),
                            resultSet.getString("CustHomePhone"),
                            resultSet.getString("CustBusPhone"),
                            resultSet.getString("CustEmail"),
                            resultSet.getInt("AgentId"));
                    customerList.add(cust);
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getStackTrace());
            return null;
        }
        return customerList;
    }
}
