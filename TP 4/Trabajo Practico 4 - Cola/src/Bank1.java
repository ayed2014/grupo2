package tp4;

import tad.queue.QueueE;

import java.util.Random;

/**
 * Created by Francisco on 10/04/14.
 */
public class Bank1 {

    int secondsOpen = 18000;
    Window window1;
    Window window2;
    Window window3;
    QueueE queue;

    public Bank1() {
        window1 = new Window(30, 90);
        window2 = new Window(30, 120);
        window3 = new Window(30, 150);
        queue = new QueueE();
        for (int i = 0; i < 15; i++) {
            Customer c = new Customer();
            queue.enQueue(c);
        }
        organizeCustomer();
    }

    public void organizeCustomer() {
        while (!queue.isEmpty()) {
            if (window1.isEmpty() || window2.isEmpty() || window3.isEmpty()) {
                QueueE windowSelection = new QueueE();
                if (window1.isEmpty()) windowSelection.enQueue(window1);
                if (window2.isEmpty()) windowSelection.enQueue(window2);
                if (window3.isEmpty()) windowSelection.enQueue(window3);
                Random r = new Random();
                int chosenWindow = r.nextInt(windowSelection.length()) + 1;
                switch (chosenWindow) {
                    case 1:
                        Window w1 = (Window) windowSelection.deQueue();
                        w1.addToQueue((Customer) queue.deQueue());
                        break;
                    case 2:
                        windowSelection.deQueue();
                        Window w2 = (Window) windowSelection.deQueue();
                        w2.addToQueue((Customer) queue.deQueue());
                        break;
                    case 3:
                        windowSelection.deQueue();
                        windowSelection.deQueue();
                        Window w3 = (Window) windowSelection.deQueue();
                        w3.addToQueue((Customer) queue.deQueue());
                        break;
                }
            } else {

                Random r = new Random();
                int window = r.nextInt(4 - 1) + 1;
                switch (window) {
                    case 1:
                        window1.addToQueue((Customer) queue.deQueue());
                        break;
                    case 2:
                        window2.addToQueue((Customer) queue.deQueue());
                        break;
                    case 3:
                        window3.addToQueue((Customer) queue.deQueue());
                        break;
                }
            }
        }
    }

    public void simulate() {
        int passedTime = 0;
        int newCustomerCounter = 0;
        while (passedTime < secondsOpen) {
            if (newCustomerCounter == 3) {
                newCustomerCounter = 0;
                queue.enQueue(new Customer());
                organizeCustomer();
            }
            window1.attend();
            window2.attend();
            window3.attend();
            passedTime = passedTime + 30;
            newCustomerCounter++;
        }
        int overTime = 0;
        while (!window1.isEmpty() || !window2.isEmpty() || !window3.isEmpty()) {
            if (!window1.isEmpty()) window1.attend();
            if (!window2.isEmpty()) window2.attend();
            if (!window3.isEmpty()) window3.attend();
            overTime = overTime + 30;
        }
        System.out.println("Overtime was: " + overTime + " seconds.");
    }
}
