package application;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class CarQueue {

    private Queue<Integer> queue; // Queue to store directions
    private Random random = new Random(); // Random generator for directions

    /**
     * Constructor initializes the queue with 5-7 random directions (0-3).
     */
    public CarQueue() {
        queue = new LinkedList<>();
        for (int i = 0; i < 7; i++) {
            queue.add(random.nextInt(4));
        }
    }

    /**
     * Adds 0,1,2 or 3 to the queue in a separate thread.
     * 0 = up, 1 = down, 2 = right, 3 = left
     */
    public void addToQueue() {
        Runnable addTask = () -> {
            while (true) {
                queue.add(random.nextInt(4));
                try {
                    Thread.sleep(200); // Pause for 200ms before adding the next direction
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        new Thread(addTask).start();
    }

    /**
     * Removes and returns the first direction from the queue.
     * 
     * @return an integer representing a direction (0-3)
     */
    public int deleteQueue() {
        return queue.remove();
    }
}