public class CounterApp {

    public static void main(String[] args) {
        // Thread that counts up to 20
        Thread countUp = new Thread(new CountUp());
        // Thread that counts down to 0
        Thread countDown = new Thread(new CountDown());

        // Start the countUp thread
        countUp.start();

        try {
            // Wait for the countUp thread to finish
            countUp.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Start the countDown thread once countUp is finished
        countDown.start();
    }

}

// Class to count up to 20
class CountUp implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i <= 20; i++) {
            System.out.println("Count Up: " + i);
            try {
                Thread.sleep(500);  // Pause for 500ms to simulate processing time
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

// Class to count down to 0
class CountDown implements Runnable {
    @Override
    public void run() {
        for (int i = 20; i >= 0; i--) {
            System.out.println("Count Down: " + i);
            try {
                Thread.sleep(500);  // Pause for 500ms to simulate processing time
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}