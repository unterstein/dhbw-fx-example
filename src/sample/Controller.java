package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Controller implements Initializable {

  @FXML
  private Button button;

  @FXML
  private ListView<String> listView;

  private ObservableList<String> listData = FXCollections.observableArrayList();

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    button.setOnAction(event -> {
      Main.switchScene("second.fxml");
    });
    listView.setItems(listData);
  }
}
