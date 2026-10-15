public class Main {
    private static final String DIGITS = "9876543210";
    private static final long TARGET = 200;

    public static void main(String[] args) {
        search(1, "9", 0, 9, 1);
    }

    private static void search(int index, String expression,
                               long sum, long number, int sign) {
        if (index == DIGITS.length()) {
            if (sum + sign * number == TARGET) {
                System.out.println(expression + "=" + TARGET);
            }
            return;
        }

        int digit = DIGITS.charAt(index) - '0';

        // Ничего: присоединяем цифру к текущему числу.
        search(index + 1, expression + digit,
               sum, number * 10 + digit, sign);

        // Плюс: завершаем текущее число и начинаем следующее.
        search(index + 1, expression + "+" + digit,
               sum + sign * number, digit, 1);

        // Минус: следующее число будет отрицательным.
        search(index + 1, expression + "-" + digit,
               sum + sign * number, digit, -1);
    }
}
