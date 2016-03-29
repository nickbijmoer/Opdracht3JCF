package opdracht3nickbart;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Bart
 */
public class Main extends Application {

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
        
        TreeItem<String> root, Scholen,  Fontys, Avans;
        
        //Root
        root = new TreeItem<>();
        root.setExpanded(true);
        
        //Scholen branch
        Scholen = makeBranch("scholen", root);
        
        //Fontys branch
        Fontys = makeBranch("Fontys", Scholen);
        makeBranch("Students", Fontys);
        makeBranch("Teachers", Fontys);
        
        //Avans branch
        Avans = makeBranch("Avans", Scholen);
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
