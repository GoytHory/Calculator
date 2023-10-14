package calculator3;

public class CalcException extends Exception {
    public CalcException() {
        System.out.println("throws Exception");
    }

    public CalcException(String message){
        this();
        System.out.println(message);
    }
}