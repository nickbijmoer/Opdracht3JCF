/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opdracht3nickbart;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Bart
 */
public class TreeViewSample extends Application {
    
    Stage window;
    TreeView<String> tree;
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
        
        TreeItem<String> root,  Fontys, Avans;
        
        //Root
        root = new TreeItem<>();
        root.setExpanded(true);
        
        //Fontys branch
        Fontys = makeBranch("Fontys ICT", root);
        makeBranch("Students", Fontys);
        makeBranch("Teachers", Fontys);
        
        //Avans branch
        Avans = makeBranch("Avans ICT", root);
        makeBranch("Students", Avans);
        makeBranch("Teachers", Avans);
        
        //Create tree
        tree = new TreeView<>(root);
        tree.setShowRoot(false);
        
        //Layout
        StackPane layout = new StackPane();
        layout.getChildren().add(tree);
        Scene scene = new Scene(layout, 300, 250);
        window.setScene(scene);
        window.show();
    }

    //Create branches
    public TreeItem<String> makeBranch(String title, TreeItem<String> parent){
        TreeItem<String> item = new TreeItem<>(title);
        item.setExpanded(true);
        parent.getChildren().add(item);
        return item;
    }
    
}
