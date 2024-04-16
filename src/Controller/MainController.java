package src.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.List;

public class MainController {
    // Var FXML
    @FXML
    private TextField textField;
    @FXML
    private BorderPane borderPane;
    @FXML
    private Pane Number_1;
    @FXML
    private Pane test;

    // Var
    private List<Text> listTextNumber;

    @FXML
    public void initialize() {

        listTextNumber = new ArrayList<Text>();

        addEventToNumber();

        System.out.println("Inited!");
    }

    // Gắn sự kiện vào tất cả các số
    private void addEventToNumber() {
        for (int i = 0; i <= 9; i++) {
            String idNumber = "#number_" + String.valueOf(i);
            Text text = (Text) borderPane.lookup(idNumber);
            listTextNumber.add(text);
            text.setOnMouseClicked(e -> {
                handleNumber(e);
            });
        }
    }

    // Thêm sự kiến khi bấm vào số
    public void handleNumber(MouseEvent e) {
        Text text = (Text) e.getSource();
        String number = text.getId().split("_")[1];
        textField.setText(textField.getText() + number);
    }

    public void close(ActionEvent e) {
        System.exit(0);
    }
}
