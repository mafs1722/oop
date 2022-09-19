public class Main {
    public static void main(String[] args) {
//        String numbers = ""; // 0
//        String numbers = "1,2,3"; // 6
//          String numbers = "1,2\n3"; // 6
//        String numbers = "\\;\n1;2;3"; // 6
//        String numbers = "\\;\n1;-2;3"; // помилка, бо має негативне значення
        String numbers = "\\[&][%]\n1&2%3"; // 6
        StringCalculator calculator = new StringCalculator();

        System.out.println("Result: " + calculator.add(numbers));

    }
}