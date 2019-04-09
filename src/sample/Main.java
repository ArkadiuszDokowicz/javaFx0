package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        Button button = new Button();
        button.setText("Click me");
        StackPane layout = new StackPane();
        layout.getChildren().add(button);
        Scene scene=new Scene(layout,300,250);
        primaryStage.setScene(scene);

        primaryStage.show();

    }


    public static void main(String[] args) throws InterruptedException {


        ExecutorService exectuor = Executors.newFixedThreadPool(3);
        exectuor.submit(new Runnable() {
            @Override
            public void run() {

            }
        });
        exectuor.submit(new Runnable() {
            @Override
            public void run() {
               
                Date date = new Date();


            while(true){
                // display time and date using toString()
                System.out.println(date.toString());
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            }
        });
        launch(args);
        exectuor.shutdown();
        exectuor.awaitTermination(1, TimeUnit.DAYS);


    }
}
