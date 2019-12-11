interface Executable {
    int execute(int x);
}

class Runner {
    public void run (Executable e) {
        int a = e.execute(3);
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
        // 1 способ
        //runner.run(new ExecutableImplementation());

        // 2 способ
        runner.run(new Executable() {
            @Override
            public int execute(int x) {
                System.out.println("Второй способ");

                return x + 1;
            }
        });

        // 3 способ
        runner.run((int x) -> {
            System.out.println("Третий способ - лямбда выражение");

            return x + 5;
        });
        // тоже самое что и код выше. слово return опускается
        runner.run((x) -> x + 5);

    }
}
