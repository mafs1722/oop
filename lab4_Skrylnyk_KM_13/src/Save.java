import java.io.FileWriter;
import java.io.IOException;

public class Save {
    public Save(double a, double b, int n, double result) {
        try {
            FileWriter data = new FileWriter("data.json");
            data.write("{");
            data.write("\"a\": " + a + ", ");
            data.write("\"b\": " + b + ", ");
            data.write("\"n\": " + n + ", ");
            data.write("\"result\": " + result);
            data.write("}");
            data.close();
        } catch (IOException e) {
            System.out.println("Exception: " + e);
        }
    }
}