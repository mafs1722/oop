import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

        // перевіряє чи є у рядку //...\n...
        Matcher matcher = Pattern.compile("//(.*)\\\\n(.*)").matcher(numbers);
        String delimiter;

        // перевіряє чи є у рядку //...\n...
        if (matcher.matches()) {
            delimiter = createDelimiter(matcher.group(1));
            numbers = matcher.group(2);
        } else {
            delimiter = ",|\\\\n";
        }

        // перетворює масив рядків у масив чисел
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

    private String createDelimiter(String delimiter) {
        StringBuilder result = new StringBuilder();

        // перевіряє чи є у рядку [ та ]
        if (delimiter.contains("[") && delimiter.contains("]")) {
            Pattern p = Pattern.compile("\\[(.*?)\\]");
            Matcher m = p.matcher(delimiter);

            while(m.find()) {
                StringBuilder str = new StringBuilder();

                for (int i = 0; i < m.group(1).length(); i++) {
                    str.append("\\").append(m.group(1).charAt(i));
                }

                str.append("|");

                result.append(str);
            }

            result.deleteCharAt(result.length() - 1);
        } else {
            for (int i = 0; i < delimiter.length(); i++) {
                result.append("\\").append(delimiter.charAt(i));
            }
        }

        return result.toString();
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
            if (value < 0) return true;
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
