package src.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class MainController {
    // Var FXML
    @FXML
    TextField textField;

    @FXML
    public void initialize() {
        System.out.println("Init");
    }

    public void add(MouseEvent e) {
        System.out.println("Add");
    }
    public void sub(MouseEvent e) {
        System.out.println("Sub");
    }
    public void mul(MouseEvent e) {
        System.out.println("Mul");
    }
    public void div(MouseEvent e) {
        System.out.println("Div");
    }

    public void close(ActionEvent e) {
        System.exit(0);
    }
}
