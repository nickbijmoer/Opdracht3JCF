package opdracht3nickbart;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeCell;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Callback;
 
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.VBox;
 
public class TreeViewSample {
 
    private final Image depIcon = 
        new Image(getClass().getResourceAsStream("departments.png"));
   
    List<Employee> ICTpeople = Arrays.<Employee>asList(
            new Employee("Ethan", "Williams", "William@hotmail.com"),
            new Employee("Emma", "Jones", "Jones@hotmail.com"),
            new Employee("Michael", "Brown", "Brown@hotmail.com"),
            new Employee("Anna", "Black", "Black@hotmail.com"));
            
    List<Employee> SalesPeople = Arrays.<Employee>asList(
            new Employee("Rodger", "York", "York@hotmail.com"),
            new Employee("Susan", "Collins", "Collins@hotmail.com"),
            new Employee("Mike", "Graham", "Graham@hotmail.com"),
            new Employee("Judy", "Mayer", "Mayer@hotmail.com"));
    
    List<Employee> BusinessPeople = Arrays.<Employee>asList(
            new Employee("Gregory", "Smith", "Smith@hotmail.com"),
            new Employee("Jacob", "Smith", "j.smith@hotmail.com"),
            new Employee("Isabella", "Johnson", "johnson@hotmail.com"));
    
     private final ObservableList<Department> data
            = FXCollections.observableArrayList(
            new Department("ICT", "Eindhoven", ICTpeople),
            new Department("Sales", "Tilburg", SalesPeople),
            new Department("Business", "Breda", BusinessPeople));
    
    TreeItem<Object> rootNode = 
        new TreeItem<Object>(new Department());
 
    public TreeViewSample() {
        Stage stage = new Stage();
        rootNode.setExpanded(true);
        for (Department department : data) {
            TreeItem<Object> depNode = new TreeItem<>(department);
            for(Employee employee : department.getEmployees())
            {
                TreeItem<Object> empLeaf = new TreeItem<>(employee);
                depNode.getChildren().add(empLeaf);
            }
            rootNode.getChildren().add(depNode);
        }
 
        stage.setTitle("Tree View");
        VBox box = new VBox();
        final Scene scene = new Scene(box, 400, 300);
        scene.setFill(Color.LIGHTGRAY);
        
        TreeView<Object> treeView = new TreeView<Object>(rootNode);
        treeView.setShowRoot(false);
        treeView.setEditable(true);
//        treeView.setCellFactory(new Callback<TreeView<Department>,TreeCell<Department>>(){
//            @Override
//            public TreeCell<Department> call(TreeView<Department> p) {
//                return new TextFieldTreeCellImpl();
//            }
//        });
 
        box.getChildren().add(treeView);
        stage.setScene(scene);
        stage.show();
    }
 
    private final class TextFieldTreeCellImpl extends TreeCell<String> {
 
        private TextField textField;
        private ContextMenu addMenu = new ContextMenu();
 
        public TextFieldTreeCellImpl() {
            MenuItem addMenuItem = new MenuItem("Add Employee");
            addMenu.getItems().add(addMenuItem);
            addMenuItem.setOnAction(new EventHandler() {
                public void handle(Event t) {
                    TreeItem newEmployee = 
                        new TreeItem<String>("New Employee");
                            getTreeItem().getChildren().add(newEmployee);
                }
            });
        }
 
        @Override
        public void startEdit() {
            super.startEdit();
 
            if (textField == null) {
                createTextField();
            }
            setText(null);
            setGraphic(textField);
            textField.selectAll();
        }
 
        @Override
        public void cancelEdit() {
            super.cancelEdit();
 
            setText((String) getItem());
            setGraphic(getTreeItem().getGraphic());
        }
 
        @Override
        public void updateItem(String item, boolean empty) {
            super.updateItem(item, empty);
 
            if (empty) {
                setText(null);
                setGraphic(null);
            } else {
                if (isEditing()) {
                    if (textField != null) {
                        textField.setText(getString());
                    }
                    setText(null);
                    setGraphic(textField);
                } else {
                    setText(getString());
                    setGraphic(getTreeItem().getGraphic());
                    if (
                        !getTreeItem().isLeaf()&&getTreeItem().getParent()!= null
                    ){
                        setContextMenu(addMenu);
                    }
                }
            }
        }
        
        private void createTextField() {
            textField = new TextField(getString());
            textField.setOnKeyReleased(new EventHandler<KeyEvent>() {
 
                @Override
                public void handle(KeyEvent t) {
                    if (t.getCode() == KeyCode.ENTER) {
                        commitEdit(textField.getText());
                    } else if (t.getCode() == KeyCode.ESCAPE) {
                        cancelEdit();
                    }
                }
            });  
            
        }
 
        private String getString() {
            return getItem() == null ? "" : getItem().toString();
        }
    }
}