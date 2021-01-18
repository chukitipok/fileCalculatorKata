package fileCalculatorKata;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("Expecting 2 arguments.");
        }

        if (args[1].length() != 1 || (!args[1].equals("+") && !args[1].equals("*"))) {
            System.err.println("Expecting '+' or '*' as second argument.");
        }

        try {
            String filename = args[0];
            String operator = args[1];
            Scanner scanner = new Scanner(new File(filename));
            scanner.useDelimiter("\n");
            int sum = Integer.parseInt(scanner.next());
            while(scanner.hasNext()) {
                if (operator.equals("+")) {
                    sum += Integer.parseInt(scanner.next());
                } else if(operator.equals("*")) {
                    sum *= Integer.parseInt(scanner.next());
                }
            }

            if (operator.equals("+")) {
                System.out.println("total = " + sum + "(addition)");
            } else if(operator.equals("*")) {
                System.out.println("total = " + sum + "(multiplication)");
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }
}
