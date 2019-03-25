package TestApp;

import TestApp.Data.TestAppData;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("mainwindow.fxml"));
        primaryStage.setTitle("TestApp");
        primaryStage.setScene(new Scene(root, 700, 500));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void stop() {
        try{
            TestAppData.getInstance().storeUsers();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }

        try{
            TestAppData.getInstance().storeTests();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void init() {
        try{
            TestAppData.getInstance().loadUsers();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
        try{
            TestAppData.getInstance().loadTests();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
