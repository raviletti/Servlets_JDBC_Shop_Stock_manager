package model;

public class Calculator {
    public String calculating(String one, String two, String operation) {
        String output = one + " " + operation + " " + two + " = " ;

        try {
            double numberOne = Double.parseDouble(one);
            double numberTwo = Double.parseDouble(two);
            switch (operation) {
                case "+":
                    output += numberOne + numberTwo;
                    break;
                case "-":
                    output += numberOne - numberTwo;
                    break;
                case "/":
                    output += numberOne / numberTwo;
                    break;
                case "*":
                    output += numberOne * numberTwo;
                    break;
            }
        }
        catch (NumberFormatException e){
            output = "IncorrectInput";
        }
        return output;

    }
}
