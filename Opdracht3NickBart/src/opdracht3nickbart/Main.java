package opdracht3nickbart;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {



    @Override
    public void start(Stage primaryStage) throws Exception{
        TableViewSample c = new TableViewSample();
        TreeViewSample tree = new TreeViewSample();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
