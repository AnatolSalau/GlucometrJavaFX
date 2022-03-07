package com.work;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainApp extends Application {

    public static void main(String[] args) {
        if (!new File("C:\\Windows\\System32\\drivers\\CH341S64.SYS").exists()) {
            System.out.println("file not found");
            try (FileInputStream fin = new FileInputStream("driver/CH341SER/CH341S64.SYS");
                 FileOutputStream fos = new FileOutputStream("C:\\Windows\\System32\\drivers\\CH341S64.SYS")) {
                byte[] buffer = new byte[fin.available()];
                // считываем буфер
                fin.read(buffer, 0, buffer.length);
                // записываем из буфера в файл
                fos.write(buffer, 0, buffer.length);
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
                ex.printStackTrace();
            }
        } else {
            System.out.println("file found");
        }
        launch(args);
    }

    public void start(Stage stage) throws Exception {
        String fxmlFile = "/fxml/hello.fxml";
        String css = "/styles/delfidiaStyle.css";
        String icons = "/images/";

        FXMLLoader loader = new FXMLLoader();
        Parent root = (Parent) loader.load(getClass().getResourceAsStream(fxmlFile));
        Scene scene = new Scene(root);
        stage.setTitle("GLUCOREADER");
        scene.getStylesheets().add(css);
        stage.setScene(scene);
        stage.show();
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent t) {
                Platform.exit();
                System.exit(0);
            }
        });
    }

    @Override
    public void stop() throws Exception {
        System.exit(-1);
    }
}
