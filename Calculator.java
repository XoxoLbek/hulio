interface Operation {
    double calculate(double x, double y);
}

class Addition implements Operation {
    @Override
    public double calculate(double x, double y) {
        return x + y;
    }
}

class Subtraction implements Operation {
    @Override
    public double calculate(double x, double y) {
        return x - y;
    }
}

class Multiplication implements Operation {
    @Override
    public double calculate(double x, double y) {
        return x * y;
    }
}

class Division implements Operation {
    @Override
    public double calculate(double x, double y) {
        if (y == 0) {
            throw new ArithmeticException("Деление на ноль невозможно");
        }
        return x / y;
    }
}

class OperationFactory {
    public static Operation getOperation(char operator) {
        switch (operator) {
            case '+':
                return new Addition();
            case '-':
                return new Subtraction();
            case '*':
                return new Multiplication();
            case '/':
                return new Division();
            default:
                throw new IllegalArgumentException("Неподдерживаемая операция: " + operator);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        System.out.print("Введите первое число: ");
        double x = scanner.nextDouble();

        System.out.print("Введите оператор (+, -, *, /): ");
        char operator = scanner.next().charAt(0);

        System.out.print("Введите второе число: ");
        double y = scanner.nextDouble();

        try {
            Operation operation = OperationFactory.getOperation(operator);
            double result = operation.calculate(x, y);
            System.out.println("Результат: " + result);
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        scanner.close();
    }
}
