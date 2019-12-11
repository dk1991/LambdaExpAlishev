interface Executable {
    int execute(int x, int y);
}

class Runner {
    public void run (Executable e) {
        int a = e.execute(3, 10);
        System.out.println(a);
    }
}

/*class ExecutableImplementation implements Executable {
    @Override
    public int execute() {
        System.out.println("Первый способ");
        return 3;
    }
}*/

public class FirstLesson {
    public static void main(String[] args) {
        // лямбда выражение заменяет анонимный класс с одним методом
        /*Thread thread = new Thread(() -> {
            System.out.println("Lambda");
        });*/

        Runner runner = new Runner();
        int a = 4;
        // 1 способ
        //runner.run(new ExecutableImplementation());

        // 2 способ
        runner.run(new Executable() {
            @Override
            public int execute(int x, int y) {
                System.out.println("Второй способ");

                return x + y;
            }
        });

        // 3 способ
        runner.run((int x, int y) -> {
            System.out.println("Третий способ - лямбда выражение");
            // У лямбда выражения нет своей облости видимости! Если переменная а уже есть, ее нельзя создать
            //int a = 3;
            return x + y;
        });

        // тоже самое что и код выше. слово return опускается
        final int b = 1; // ДОЛЖНА БЫТЬ final, или значение НЕ должно изменяться до использования лямбда выражения!!!
        runner.run((x, y) -> x + y + b);

    }
}
