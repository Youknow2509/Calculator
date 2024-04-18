package src.Tools;

import src.Config.Operator;

public class Change {

    // Đổi id thành giá trị của số
    public static String idToValue(String id) {
        switch (id) {
            case "commaSign":
                return ".";
            case "pane_Dot":
                return ".";

            case "number_1":
                return "1";
            case "pane_Number_1":
                return "1";

            case "number_2":
                return "2";
            case "pane_Number_2":
                return "2";

            case "number_3":
                return "3";
            case "pane_Number_3":
                return "3";

            case "number_4":
                return "4";
            case "pane_Number_4":
                return "4";

            case "number_5":
                return "5";
            case "pane_Number_5":
                return "5";

            case "number_6":
                return "6";
            case "pane_Number_6":
                return "6";

            case "number_7":
                return "7";
            case "pane_Number_7":
                return "7";

            case "number_8":
                return "8";
            case "pane_Number_8":
                return "8";

            case "number_9":
                return "9";
            case "pane_Number_9":
                return "9";

            case "number_0":
                return "0";
            case "pane_Number_0":
                return "0";

            default:
                return "";
        }

    }

    // Đổi operator thành string
    public static String operatorToString(String id) {
        switch (id) {
            case Operator.ADD:
                return "Add";
            case Operator.SUB:
                return "Sub";
            case Operator.MUL:
                return "Mul";
            case Operator.DIV:
                return "Div";
            case Operator.EQUAL:
                return "Equal";
            default:
                return "";
        }
    }

}
