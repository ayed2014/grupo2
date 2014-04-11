package tp4;

import tad.queue.QueueE;

import java.util.Random;

/**
 * Created by Francisco on 10/04/14.
 */
public class Bank2 {
    int secondsOpen = 18000;
    Window window1;
    Window window2;
    Window window3;
    QueueE customers;

    public Bank2() {
        window1 = new Window(30, 90);
        window2 = new Window(30, 120);
        window3 = new Window(30, 150);
        customers = new QueueE();
        for (int i = 0; i < 15; i++) {
            Customer c = new Customer();
            customers.enQueue(c);
        }
    }

    public void organizeCustomer() {
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
                    w1.addToQueue((Customer) customers.deQueue());
                    break;
                case 2:
                    windowSelection.deQueue();
                    Window w2 = (Window) windowSelection.deQueue();
                    w2.addToQueue((Customer) customers.deQueue());
                    break;
                case 3:
                    windowSelection.deQueue();
                    windowSelection.deQueue();
                    Window w3 = (Window) windowSelection.deQueue();
                    w3.addToQueue((Customer) customers.deQueue());
                    break;
            }
        }
    }

    public void simulate() {
        int passedTime = 0;
        int newCustomerCounter = 0;
        while (passedTime < secondsOpen) {
            if (newCustomerCounter == 3) {
                newCustomerCounter = 0;
                customers.enQueue(new Customer());
            }
            while (window1.isEmpty() || window2.isEmpty() || window3.isEmpty()) organizeCustomer();
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
