package calculator3;

import java.util.Arrays;
import java.util.List;



public class Calculation {

    private int var1, var2;

    private String operand;



    private int Calculation(int n1,String oper,int n2){
        int res = 0;
        switch (oper){
            case "+":
                res = n1+n2;
                break;
            case "-":
                res = n1-n2;
                break;
            case "*":
                res = n1*n2;
                break;
            case "/":
                res = n1/n2;
                break;
            default:
                System.out.println("throws Exception");

        }
        return res;
        }




    public String res(String exp) throws CalcException {
            boolean isRomanExp;
            calculator3.Parse parse = new calculator3.Parse();

            List<String> expItems = Arrays.asList(exp.split(" "));

            if (expItems.size()!=3){
                throw new CalcException("Invalid expression.Must be: \"Num1 OPERAND Num2\", separated by space");
            }

            if (parse.checkOperator(expItems.get(1))){
                operand = expItems.get(1);
            } else {
                throw new CalcException("Invalid operand '" + expItems.get(1) + "'. Use this: + - * / ");
            }

            if (parse.isNumeric(expItems.get(0)) && parse.isNumeric(expItems.get(2))){
                var1 = Integer.parseInt(expItems.get(0));
                var2 = Integer.parseInt(expItems.get(2));
                isRomanExp = false;
            } else if (parse.isRoman(expItems.get(0)) && parse.isRoman(expItems.get(2))){
                var1 = parse.romeToArabConvert(expItems.get(0));
                var2 = parse.romeToArabConvert(expItems.get(2));
                isRomanExp = true;
            } else {
                throw new CalcException("Invalid number. Numbers must be only arabic, or only roman");
            }

            if (!(var1>=1 && var1<=10)){
                throw new CalcException("Invalid number. Num1 must be from 1 to 10 or I to X");
            }

            if (!(var2>=1 && var2<=10)){
                throw new CalcException("Invalid number. Num2 must be from 1 to 10 or I to X");
            }

            int res = Calculation(var1, operand, var2);

            if (isRomanExp){
                String sign = res < 0 ? "-" : "";
                return sign + parse.arabToRomeConvert(Math.abs(res));
            }

            return String.valueOf(res);
        }
    }

