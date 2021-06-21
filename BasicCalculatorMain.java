public class BasicCalculatorMain {
    public static void main(String args[])
    {
        BasicCalculator f = new BasicCalculator();
        System.out.println("Result: " + f.calculate("2*(1+(1+7-2))-6/3*2"));
    }
}
