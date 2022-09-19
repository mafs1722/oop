
import java.util.Objects;

public class StringCalculator {
    public int add(String numbers) {
        // перевіряє чи рядок порожній
        if (numbers.equals(""))
            return 0;

        // перевіряє чи рядок має ",\n"
        if(numbers.contains(",\n")) {
            System.out.println("\u001B[31mERROR: SOMETHING WRONG WITH DELIMITER\u001B[0m"); // виводить помилку
            return 0;
        }

        // створюємо розділювач
        String delimiter = createDelimiter(numbers);

        // видаляємо розділювач з рядка
        numbers = numbers.substring(numbers.indexOf("\n") + 1);

        // створюємо масив значень
        int[] values = convertStringArrayToIntArray(numbers.split(delimiter));

        // перевіряє чи є від'ємні числа в масиві
        if (isNegativeValueInArray(values)) {
            // виводить всі негативні елементи
            printNegativeValues(values);
            return 0;
        }

        // повертає суму всіх елементів
        return getSumOfArrayValues(values);
    }

    // функція, яка створю розділювач
    private String createDelimiter(String numbers) {
        // перевіряє чи є в рядку \\[delimiter]\n
        if (numbers.contains("\\") && numbers.contains("\n"))
            // первіряє чи є в рядку [ та ]
            if (numbers.contains("[") && numbers.contains("]"))
                return createDelimiterFromMultipleScopes(numbers);
            else
                return getDelimiter(numbers);

        return ",|\\n";
    }

    // створює делімітер якщо в рядку існує \\[][][]\n
    private String createDelimiterFromMultipleScopes(String numbers) {
        String[] delimiters = getDelimiter(numbers).split("\\[");
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < delimiters.length; i++) {
            if (!Objects.equals(delimiters[i], ""))
                if (i != delimiters.length - 1)
                    result.append(delimiters[i].replace("]", "")).append("|");
                else result.append(delimiters[i].replace("]", ""));
        }

        return result.toString();
    }

    // повертає розділювач з рядка
    private String getDelimiter(String numbers) {
        return numbers.substring(numbers.indexOf("\\") + 1, numbers.indexOf("\n"));
    }

    // Перетворю строковий масив в масив з числами
    private int[] convertStringArrayToIntArray(String[] values) {
        int[] result = new int[values.length];

        for (int i = 0; i < values.length; i++) {
            result[i] = Integer.parseInt(values[i]);
        }

        return result;
    }

    // Перевіряє чи є в масиві негативні числа
    private boolean isNegativeValueInArray(int[] values) {
        for (int value: values) {
            if (value < 0)
                return true;
        }

        return false;
    }

    // виводить тільки негативні значення в масиві
    private void printNegativeValues(int[] values) {
        System.out.println("\u001B[31mERROR: NEGATIVE VALUES\u001B[0m");
        for (int value: values) {
            if (value < 0)
                System.out.println("\u001B[31m" + value + "\u001B[0m");
        }
    }

    // повертає суму всіх значень масиву
    private int getSumOfArrayValues(int[] values) {
        int sum = 0;

        for (int value: values) {
            // перевіряє чи значення менше ніж 1000
            if (value <= 1000)
                sum += value;
            else
                System.out.println("\u001B[33mWARNING: " + value + " is > 1000 and will not include in sum \u001B[0m"); // виводить попередження що значення не буде використовуватись для суми
        }

        return sum;
    }
}
