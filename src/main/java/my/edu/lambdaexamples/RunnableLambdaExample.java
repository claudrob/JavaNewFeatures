package my.edu.lambdaexamples;

public class RunnableLambdaExample {

    public static void main(String[] args) {

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello!");
            }
        };
        new Thread(runnable).start();

        Runnable runnable1 = () -> {
            System.out.println("Hello Lambda!");
        };
        new Thread(runnable1).start();

        new Thread(() ->System.out.println("Runnable4")).start();

    }
}
