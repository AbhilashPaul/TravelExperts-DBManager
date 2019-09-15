package exercise6.main;

import exercise6.dbhandler.CustomerDBHandler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import exercise6.models.Customer;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class CustomerController implements Initializable {

    @FXML
    private TextField txtSearch;

    @FXML
    private Button btnSearch;

    @FXML
    private TableView<Customer> tableCustomer;

    public TableView<Customer> getTableCustomer() {
        return tableCustomer;
    }

    @FXML
    private TableColumn<Customer, Integer> col_id;

    @FXML
    private TableColumn<Customer, String> col_firstname;

    @FXML
    private TableColumn<Customer, String> col_lastname;

    @FXML
    private TableColumn<Customer, String> col_homephone;

    @FXML
    private TableColumn<Customer, String> col_email;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        col_id.setCellValueFactory(new PropertyValueFactory<>("customerID"));
        col_firstname.setCellValueFactory(new PropertyValueFactory<>("customerFirstName"));
        col_lastname.setCellValueFactory(new PropertyValueFactory<>("customerLastName"));
        col_homephone.setCellValueFactory(new PropertyValueFactory<>("customerHomePhone"));
        col_email.setCellValueFactory(new PropertyValueFactory<>("customerEmail"));
    }

    ObservableList<Customer> customerList = FXCollections.observableArrayList();
    @FXML
    void onActionBtnSearch(ActionEvent event) {
        customerList = CustomerDBHandler.getCustomers(txtSearch.getText());
        tableCustomer.setItems(customerList);
    }

    @FXML
    void handlemouseclick(MouseEvent event) {
        //if(event.getClickCount()==2) {
            TableCell cell = (TableCell) event.getSource();
            System.out.println(cell);
            /*System.out.println("ID: " + customerList.get(index).getCustomerID());
            System.out.println("First Name: " + customerList.get(index).getCustomerFirstName());
            System.out.println("Last Name: " + customerList.get(index).getCustomerLastName());
            System.out.println("Address: " + customerList.get(index).getCustomerAddress());
        //}*/
    }
}
