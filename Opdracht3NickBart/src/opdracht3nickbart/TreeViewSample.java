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
    TreeView<String> tree;

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
        TreeItem<String> Fontys, root;

        root = new TreeItem<>();
        root.setExpanded(true);

        //Fontys branch
        Fontys = new TreeItem<String>("Fontys");
        Fontys.setExpanded(true);

        for (Department item : data) {
            TreeItem<String> empLeaf = new TreeItem<>(item.getDepartmentName());
            boolean found = false;
            if (Fontys.getChildren().size() > 0) {
                for (TreeItem<String> depNode : Fontys.getChildren()) {
                    if (depNode.getValue().contentEquals(item.getCity())) {
                        depNode.getChildren().add(empLeaf);
                        found = true;
                        break;
                    }
                    if (!found) {
                        TreeItem<String> depNodes = new TreeItem<String>(item.getCity());
                        Fontys.getChildren().add(depNodes);
                        depNodes.getChildren().add(empLeaf);
                    }
                }
            } else {
                TreeItem<String> depNodes = new TreeItem<String>(item.getCity());
                Fontys.getChildren().add(depNodes);
                depNodes.getChildren().add(empLeaf);
            }
        }

        //Create tree
        tree = new TreeView<>(root);
        tree.setShowRoot(false);

        //Layout
        StackPane layout = new StackPane();
        layout.getChildren().add(tree);
        VBox box = new VBox();

        TreeView<String> treeView = new TreeView<String>(root);

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
            } else if (isEditing()) {
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
