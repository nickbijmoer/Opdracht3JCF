package opdracht3nickbart;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import jdk.nashorn.internal.objects.NativeArray;

public class TableViewSample {

    private TableView<Employee> table = new TableView<Employee>();
    private final ObservableList<Employee> data
            = FXCollections.observableArrayList(
                    new Employee("Jacob", "Smith", "jacob.smith@example.com"),
                    new Employee("Isabella", "Johnson", "isabella.johnson@example.com"),
                    new Employee("Ethan", "Williams", "ethan.williams@example.com"),
                    new Employee("Emma", "Jones", "emma.jones@example.com"),
                    new Employee("Michael", "Brown", "michael.brown@example.com"));
    final HBox hb = new HBox();

    public TableViewSample() {
        Stage stage = new Stage();
        Scene scene = new Scene(new Group());
        stage.setTitle("Table View Sample");
        stage.setWidth(450);
        stage.setHeight(550);

        final Label label = new Label("Employees");
        label.setFont(new Font("Arial", 20));

        table.setEditable(true);

        TableColumn firstNameCol = new TableColumn("First Name");
        firstNameCol.setMinWidth(100);
        firstNameCol.setCellValueFactory(
                new PropertyValueFactory<Employee, String>("firstName"));
        firstNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
        firstNameCol.setOnEditCommit(
                new EventHandler<CellEditEvent<Employee, String>>() {
                    @Override
                    public void handle(CellEditEvent<Employee, String> t) {
                        ((Employee) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())).setFirstName(t.getNewValue());

                        showCurrentData();

                    }
                }
        );

        TableColumn lastNameCol = new TableColumn("Last Name");
        lastNameCol.setMinWidth(100);
        lastNameCol.setCellValueFactory(
                new PropertyValueFactory<Employee, String>("lastName"));
        lastNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
        lastNameCol.setOnEditCommit(
                new EventHandler<CellEditEvent<Employee, String>>() {
                    @Override
                    public void handle(CellEditEvent<Employee, String> t) {
                        ((Employee) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())).setLastName(t.getNewValue());

                        showCurrentData();
                    }
                }
        );

        TableColumn emailCol = new TableColumn("Email");
        emailCol.setMinWidth(200);
        emailCol.setCellValueFactory(
                new PropertyValueFactory<Employee, String>("email"));
        emailCol.setCellFactory(TextFieldTableCell.forTableColumn());
        emailCol.setOnEditCommit(
                new EventHandler<CellEditEvent<Employee, String>>() {
                    @Override
                    public void handle(CellEditEvent<Employee, String> t) {
                        ((Employee) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())).setEmail(t.getNewValue());

                        showCurrentData();
                    }
                }
        );

        table.setItems(data);
        table.getColumns().addAll(firstNameCol, lastNameCol, emailCol);

        final TextField addFirstName = new TextField();
        addFirstName.setPromptText("First Name");
        addFirstName.setMaxWidth(firstNameCol.getPrefWidth());
        final TextField addLastName = new TextField();
        addLastName.setMaxWidth(lastNameCol.getPrefWidth());
        addLastName.setPromptText("Last Name");
        final TextField addEmail = new TextField();
        addEmail.setMaxWidth(emailCol.getPrefWidth());
        addEmail.setPromptText("Email");

        final Button addButton = new Button("Add");
        addButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                data.add(new Employee(
                        addFirstName.getText(),
                        addLastName.getText(),
                        addEmail.getText()));
                addFirstName.clear();
                addLastName.clear();
                addEmail.clear();

                showCurrentData();
            }
        });

        final Button deleteButton = new Button("Delete");
        deleteButton.setOnAction(e -> deleteButtonClicked());

        hb.getChildren().addAll(addFirstName, addLastName, addEmail, addButton);
        hb.getChildren().add(deleteButton);

        hb.setSpacing(3);

        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label, table, hb);

        ((Group) scene.getRoot()).getChildren().addAll(vbox);

        stage.setScene(scene);
        stage.show();
    }

    private void deleteButtonClicked() {
        Employee selectedPerson = table.getSelectionModel().getSelectedItem();
        data.remove(selectedPerson);

        showCurrentData();

    }

    private void showCurrentData() 
    {

        for (Employee employee : data) {

            System.out.println("First name : " + employee.getFirstName() + " Last Name: " + employee.getLastName() + " E-mail " + employee.getEmail());

        }
        System.out.println("" + '\n' + '\n');
    }

}
