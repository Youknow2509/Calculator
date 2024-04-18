package src.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import src.Config.Operator;
import src.Model.Calculator;
import src.Tools.Change;

import java.util.ArrayList;
import java.util.List;

public class MainController {
    // Var FXML
    @FXML
    private TextField tFRes;
    @FXML
    private TextField tFResAfter;
    @FXML
    private BorderPane borderPane;
    @FXML
    private ImageView clear;

    // Var
    private String number = "";
    private double firstNumber = 0;
    private double secondNumber = 0;
    private String operator = "";

    @FXML
    public void initialize() {

        addEventToNumber();
        addEventToOperator();

        System.out.println("Inited!");
    }

    // Gắn sự kiện vào tất cả các số
    private void addEventToNumber() {
        for (int i = 0; i <= 9; i++) {
            String idNumber = "#number_" + i;
            String idPaneNumber = "#pane_Number_" + i;
            Text text = (Text) borderPane.lookup(idNumber);
            Pane pane = (Pane) borderPane.lookup(idPaneNumber);
            text.setOnMouseClicked(e -> {
                handleNumber(e);
            });
            pane.setOnMouseClicked(e -> {
                handleNumber(e);
            });
        }
    }

    // Gắn sự kiện vào các operator
    private void addEventToOperator() {
        List<String> operators = new ArrayList<>();

        operators.add(Operator.ADD);
        operators.add(Operator.SUB);
        operators.add(Operator.MUL);
        operators.add(Operator.DIV);
        operators.add(Operator.EQUAL);

        for (int i = 0; i < operators.size(); i++) {
            String idOperator = "#pane_Operator_" + Change.operatorToString(operators.get(i));
            Pane pane = (Pane) borderPane.lookup(idOperator);
            choosesHandleOperator(pane, operators.get(i));
        }

    }

    // Thêm sự kiến khi bấm vào số
    public void handleNumber(MouseEvent e) {
        Object obj = e.getSource();
        String n = "";
        if (obj instanceof Text) {
            n = Change.idToValue(((Text) obj).getId());
        } else if (obj instanceof Pane) {
            n = Change.idToValue(((Pane) obj).getId());
        }

        if (tFRes.getText().contains(".") && n.equals(".")) {
            // ignore add .
        } else if (tFRes.getText().equals("0") && !n.equals(".")) {
            number = n;
        } else {
            number = tFRes.getText() + n;
        }
        tFRes.setText(number);
        System.out.println("Clicked: " + n);
    }

    // Handle operator
    public void handleOperatorDiv(MouseEvent e) {
        System.out.println("Clicked operator div");
        operator = Operator.DIV;
        firstNumber = Double.parseDouble(tFRes.getText());
        tFResAfter.setText(tFRes.getText());
        tFRes.setText("0");
    }

    public void handleOperatorMul(MouseEvent e) {
        System.out.println("Clicked operator mul");
        operator = Operator.MUL;
        firstNumber = Double.parseDouble(tFRes.getText());
        tFResAfter.setText(tFRes.getText());
        tFRes.setText("0");
    }

    public void handleOperatorAdd(MouseEvent e) {
        System.out.println("Clicked operator add");
        operator = Operator.ADD;
        firstNumber = Double.parseDouble(tFRes.getText());
        tFResAfter.setText(tFRes.getText());
        tFRes.setText("0");
    }

    public void handleOperatorSub(MouseEvent e) {
        System.out.println("Clicked operator sub");
        operator = Operator.SUB;
        firstNumber = Double.parseDouble(tFRes.getText());
        tFResAfter.setText(tFRes.getText());
        tFRes.setText("0");
    }

    public void handleOperatorEqual(MouseEvent e) {
        System.out.println("Clicked operator equal");
        calculate();
    }

    // Handle clear
    public void handleClear(MouseEvent e) {
        firstNumber = 0;
        secondNumber = 0;
        number = "";
        operator = "";
        tFRes.setText("0");
        tFResAfter.setText("0");
    }

    // Close app
    public void close(ActionEvent e) {
        System.exit(0);
    }

    // Help funtions

    // Handle after calculate
    private void calculate() {
        secondNumber = Double.parseDouble(tFRes.getText());
        switch (operator) {
            case Operator.DIV:
                tFRes.setText(String.valueOf(Calculator.div(firstNumber, secondNumber)));
                firstNumber = Double.parseDouble(tFRes.getText());
                break;
            case Operator.MUL:
                tFRes.setText(String.valueOf(Calculator.mul(firstNumber, secondNumber)));
                firstNumber = Double.parseDouble(tFRes.getText());
                break;
            case Operator.ADD:
                tFRes.setText(String.valueOf(Calculator.add(firstNumber, secondNumber)));
                firstNumber = Double.parseDouble(tFRes.getText());
                break;
            case Operator.SUB:
                tFRes.setText(String.valueOf(Calculator.sub(firstNumber, secondNumber)));
                firstNumber = Double.parseDouble(tFRes.getText());
                break;
            default:
                break;
            // todo check
        }
        tFResAfter.setText(String.valueOf(firstNumber));
    }

    // Chooses handle operator
    private void choosesHandleOperator(Pane pane, String idOperator) {
        pane.setOnMouseClicked(e -> {
            switch (idOperator) {
                case Operator.ADD:
                    handleOperatorAdd(e);
                    break;
                case Operator.SUB:
                    handleOperatorSub(e);
                    break;
                case Operator.MUL:
                    handleOperatorMul(e);
                    break;
                case Operator.DIV:
                    handleOperatorDiv(e);
                    break;
                case Operator.EQUAL:
                    handleOperatorEqual(e);
                    break;
                default:
                    break;
            }
        });
    }
}
