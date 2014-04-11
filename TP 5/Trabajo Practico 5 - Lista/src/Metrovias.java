
import java.util.Random;

/**
 * Created by Francisco on 10/04/14.
 */
public class Metrovias {
    private ListE windows;
    private double money;
    private int averageWaitTime;
    private int currentTime;
    private int totalOpenTime;

    public Metrovias(int windows) {
        money = 0;
        currentTime = 0;
        totalOpenTime = 57570;
        this.windows = new ListE();
        for (int i = 0; i < windows; i++) {
            this.windows.addAfter(new Window());
        }
    }

    public void simulate() {
        while (currentTime < totalOpenTime) {
            newCustomers();
            attend();
            currentTime = currentTime + 10;
        }
        close();
    }

    public void newCustomers() {
        for (int i = 0; i < 5; i++) {
            Customer c = new Customer(currentTime);
            Random r = new Random();
            Queue windowOptions = new QueueD();
            if (thereIsEmptyWindow()) {
                for (int j = 0; j < windows.size(); j++) {
                    windows.goTo(j);
                    Window w = (Window) windows.seeCurrent();
                    if (w.isEmpty()) {
                        windowOptions.enQueue(w);
                    }
                }
                int windowChoice = r.nextInt(windowOptions.length()) + 1;
                for (int j = 1; j < windowChoice; j++) {
                    windowOptions.deQueue();
                }
                Window w = (Window) windowOptions.deQueue();
                w.addCustomer(c);
            } else {
                for (int j = 0; j < windows.size(); j++) {
                    windows.goTo(j);
                    Window w = (Window) windows.seeCurrent();
                    windowOptions.enQueue(w);
                }
                int windowChoice = r.nextInt(windowOptions.length()) + 1;
                for (int k = 1; k < windowChoice; k++) {
                    windowOptions.deQueue();
                }
                Window w = (Window) windowOptions.deQueue();
                w.addCustomer(c);

            }
        }
    }

    private boolean thereIsEmptyWindow() {
        windows.goTo(0);
        for (int i = 0; i < windows.size(); i++) {
            Window w = (Window) windows.seeCurrent();
            if (w.isEmpty()) return true;
            else windows.next();
        }
        return false;
    }

    private void attend() {
        windows.goTo(0);
        for (int i = 0; i < windows.size(); i++) {
            Window w = (Window) windows.seeCurrent();
            w.attend(currentTime);
            windows.next();
        }
    }

    private void close() {
        while (thereIsEmptyWindow()) {
            attend();
        }
        System.out.println("Average wait time for each customer was: " + getAverageWaitTime() + " seconds.");
        getIdleTime();
        System.out.println("Total money obtained is: " + getTotalMoney());
    }

    private int getAverageWaitTime() {
        windows.goTo(0);
        for (int i = 0; i < windows.size(); i++) {
            Window w = (Window) windows.seeCurrent();
            averageWaitTime = averageWaitTime + w.getAverageWaitTime();
            windows.next();
        }
        return averageWaitTime / windows.size();
    }

    private double getTotalMoney() {
        windows.goTo(0);
        for (int i = 0; i < windows.size(); i++) {
            Window w = (Window) windows.seeCurrent();
            money = money + w.getMoney();
            windows.next();
        }
        return money;
    }

    private void getIdleTime() {
        windows.goTo(0);
        for (int i = 0; i < windows.size(); i++) {
            Window w = (Window) windows.seeCurrent();
            System.out.println("Idle time for Window #" + (i + 1) + " is " + w.getIdleTime() + " seconds");
            windows.next();
        }
    }
}
