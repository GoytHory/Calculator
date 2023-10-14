package calculator3;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



public class Calculator3 {

    public static void main(String[] args) throws IOException {
        try{
        System.out.println("Input two number for calculation like this: \"Num1 OPERAND Num2\" separated by space. Use arabic number 1-10, or roman number I-X");
        BufferedReader buffReader = new BufferedReader(new InputStreamReader(System.in));
        String calcString = buffReader.readLine();




            Calculation calc = new Calculation();
            String res = calc.res(calcString);
            System.out.println("Output: " + res);


           }
        catch(CalcException | IOException e){


    }

    }

}









