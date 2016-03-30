/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opdracht3nickbart;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeCell;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author Bart
 */
public class TreeViewSample extends Application {

    Stage window;
    TreeView<Department> tree;

    private ObservableList<Department> data;
    
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;
        window.setTitle("JavaFX - TreeView");

        ArrayList<Department> temp = new ArrayList<Department>();
        temp.add(new Department("ICT", "Eindhoven"));
        temp.add(new Department("Design", "Tilburg"));
        temp.add(new Department("Teachers", "Eindhoven"));
        temp.add(new Department("Cleaning", "Eindhoven"));
        temp.add(new Department("Kitchen", "Tilburg"));

        data = FXCollections.observableArrayList(temp);
        TreeItem<Department> Fontys;

        //Fontys branch
        Fontys = new TreeItem<Department>();
        Fontys.setExpanded(true);

        for (Department item : data) {
            TreeItem<Department> newItem = new TreeItem<>(item);
            Fontys.getChildren().add(newItem);
        }
        

        //Create tree
        tree = new TreeView<>(Fontys);
        tree.setShowRoot(true);

        //Layout
        StackPane layout = new StackPane();
        layout.getChildren().add(tree);
        VBox box = new VBox();

        TreeView<Department> treeView = new TreeView<Department>(Fontys);

        box.getChildren().add(treeView);
        Scene scene = new Scene(layout, 300, 250);

        scene.setFill(Color.LIGHTGRAY);
        window.setScene(scene);
        window.show();

    }
    
    private final class TextFieldTreeCellImpl extends TreeCell<String> {
 
        private TextField textField;
        
         public TextFieldTreeCellImpl() {
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
 
   

    //Create branches
    public TreeItem<Department> makeBranch(Department title, TreeItem<Department> parent) {
        TreeItem<Department> item = new TreeItem<>(title);
        parent.getChildren().add(item);
        return item;
    }

}
