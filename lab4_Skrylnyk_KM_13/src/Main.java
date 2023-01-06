public class Main {
    public static void main(String[] args) {
        Input inp = new Input();
        Integration integrate = new Integration(inp.a, inp.b, inp.n, inp.choice2);
        if (inp.choice1 == 1)
            System.out.print("Результат: ");
        else
            System.out.print("Result: ");
        System.out.print(integrate.result);
    }
}
