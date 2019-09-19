package travelexperts.main;

import com.jfoenix.controls.JFXSpinner;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import travelexperts.dbhandler.CustomerDBHandler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import travelexperts.models.Customer;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class CustomerController implements Initializable {

    @FXML
    private TextField txtSearch;

    @FXML
    private Button btnSearch;

    @FXML
    private JFXSpinner spinnerSearch;

    @FXML
    private TableView<Customer> tableCustomer;

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

    ObservableList<Customer> customerList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //link columns in table view to the properties of customer object
        col_id.setCellValueFactory(new PropertyValueFactory<>("customerID"));
        col_firstname.setCellValueFactory(new PropertyValueFactory<>("customerFirstName"));
        col_lastname.setCellValueFactory(new PropertyValueFactory<>("customerLastName"));
        col_homephone.setCellValueFactory(new PropertyValueFactory<>("customerHomePhone"));
        col_email.setCellValueFactory(new PropertyValueFactory<>("customerEmail"));

        //add a hint to the search box
        Tooltip searchHint = new Tooltip();
        searchHint.setText("Enter customer ID or first name and/or last name to retrieve customer record.");
        txtSearch.setTooltip(searchHint);

        TableView.TableViewSelectionModel<Customer> tableCustomerSelect = tableCustomer.getSelectionModel();
        tableCustomerSelect.selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                System.out.println(customerList.get((int)newValue).getCustomerID());
            }
        });
    }


    @FXML
    void onActionBtnSearch(ActionEvent event) throws InterruptedException {
        tableCustomer.getItems().clear();
        spinnerSearch.setOpacity(1);
        customerList = CustomerDBHandler.getCustomers(txtSearch.getText());
        //show an error message if no record was found
        if(customerList.size() == 0){
            new Alert(Alert.AlertType.ERROR, "No Record found!").showAndWait();
        }else { //else, display all of the customer records in the tableview
            tableCustomer.setItems(customerList);
        }
        spinnerSearch.setOpacity(0);
    }


    @FXML
    void handlemouseclick(MouseEvent event) {
        if(event.getClickCount()==2) {

            //TableCell cell = (TableCell) event.
            //int index = cell.getIndex();
            System.out.println(event.getSource());
            /*System.out.println("ID: " + customerList.get(index).getCustomerID());
            System.out.println("First Name: " + customerList.get(index).getCustomerFirstName());
            System.out.println("Last Name: " + customerList.get(index).getCustomerLastName());
            System.out.println("Address: " + customerList.get(index).getCustomerAddress());*/
        }
    }
}
