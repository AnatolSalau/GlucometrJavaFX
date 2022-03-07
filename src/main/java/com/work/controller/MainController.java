package com.work.controller;

import com.work.comPort.ComPortConnectivity;
import com.work.control.Control;
import com.work.exception.ComPortException;
import com.work.file.Read;
import com.work.file.Write;
import com.work.model.Data;
import javafx.application.Platform;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    private Data data;
    private ComPortConnectivity connectivity;
    private ObservableList<Data> dataObservableList = FXCollections.observableArrayList();

    @FXML
    private Button showSavedData;

    @FXML
    private Button closeButton;

    @FXML
    private Button button;

    @FXML
    private TextArea textArea;

    @FXML
    private TableView<Data> dataTable;

    @FXML
    private TableColumn<Data, LocalDate> dateColumn;

    @FXML
    private TableColumn<Data, LocalTime> timeColumn;

    @FXML
    private TableColumn<Data, Integer> glucoseColumn;

    @FXML
    private TableColumn<Data, Integer> eatColumn;

    @FXML
    private TableColumn<Data, Integer> hctColumn;

    public void initialize(URL location, ResourceBundle resources) {
        dateColumn.setCellValueFactory(new PropertyValueFactory<Data, LocalDate>("date"));
        timeColumn.setCellValueFactory(new PropertyValueFactory<Data, LocalTime>("time"));
        glucoseColumn.setCellValueFactory(new PropertyValueFactory<Data, Integer>("glucose"));
        eatColumn.setCellValueFactory(new PropertyValueFactory<Data, Integer>("eat"));
        hctColumn.setCellValueFactory(new PropertyValueFactory<Data, Integer>("hct"));

        //dataTable.setItems(dataObservableList);

    }

    public void getData(ActionEvent actionEvent) {
        Control control = new Control(textArea);
        try {
            byte[] bytes = {92};
            connectivity = ComPortConnectivity.getInstance(ComPortConnectivity.getPortName());
            connectivity.setControl(control);
            if (!connectivity.isBusy()) {
                connectivity.openPort();
                textArea.appendText("port opened\n");
                connectivity.sendBytes(bytes);
                control.setConnectivity(connectivity);
            } else {
                textArea.appendText("port is already open\n");
            }

        } catch (ComPortException e) {
            System.out.println(e.getMessage());
            textArea.appendText("port is busy or device not connected\n");
        }
    }

    public void close(ActionEvent actionEvent) {
        if (connectivity != null) {
            connectivity.closePort();
            textArea.appendText("\nport closed\n");
        }
    }

    public void showSavedData(ActionEvent actionEvent) {
       /* Data data = new Data(1,1,LocalDate.now(),LocalTime.now(),1,1,1,1);
        Data data1 = new Data(1,1,LocalDate.now(),LocalTime.now(),1,0,1,0);
        List<Data> records = new ArrayList<>();
        records.add(data);
        records.add(data1);
        Write.writing(data);*/
        dataTable.getItems().clear();
        List<Data> records = Read.reading();
        dataObservableList.addAll(records);

        dataTable.setItems(dataObservableList);
    }
}
