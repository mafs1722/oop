import java.util.Scanner;

public class Input {
    Scanner s = new Scanner(System.in);
    public int n, choice1, choice2;
    public double a, b;
    public Input() {
        System.out.println("Оберіть якою мовою ви хочете отримати результат:");
        System.out.println("(Select the language in which you want to receive the result:)");
        System.out.println("1 - Українська (1 - Ukrainian)\n2 - Англійська (2 - English)");
        System.out.print("Ваш вибір (Your choice): ");
        this.choice1 = s.nextInt();
        if (this.choice1 == 1)
            InputUK();
        else
            InputEN();
    }

    public void InputUK() {
        System.out.println("\nОберіть алгоритм інтегрування: ");
        System.out.println("1 - Лівих прямокутників\n2 - Правих прямокутників");
        System.out.print("Ваш вибір: ");
        this.choice2 = s.nextInt();
        System.out.println();
        System.out.print("Введіть нижню границю функції: ");
        this.a = s.nextDouble();
        System.out.print("Введіть верхню границю функції: ");
        this.b = s.nextDouble();
        System.out.print("Введіть інтервал інтегрування: ");
        this.n = s.nextInt();
    }

    public void InputEN() {
        System.out.println("\nSelect the integration algorithm: ");
        System.out.println("1 - Left rectangles\n2 - Right rectangles");
        System.out.print("Your choice: ");
        this.choice2 = s.nextInt();
        System.out.println();
        System.out.print("Enter the lower limit of the function: ");
        this.a = s.nextDouble();
        System.out.print("Enter the upper limit of the function: ");
        this.b = s.nextDouble();
        System.out.print("Enter the integration interval: ");
        this.n = s.nextInt();
    }
}
