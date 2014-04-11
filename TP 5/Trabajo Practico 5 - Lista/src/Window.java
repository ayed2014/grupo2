

import java.util.Random;

/**
 * Created by Francisco on 10/04/14.
 */
public class Window {
    private int averageWaitTime;
    private int idleTime;
    private double money;
    private QueueD customers;
    private PilaD waitTimes;
    private Customer currentCustomer;

    public Window() {
        money = 0;
        idleTime = 0;
        customers = new QueueD();
        waitTimes = new PilaD(0);
    }

    public void attend(int currentTime) {
        if (!isEmpty()) {
            Random r = new Random();
            int check = r.nextInt(100);
            if (currentCustomer == null) currentCustomer = (Customer) customers.deQueue();
            if (check < 30) {
                currentCustomer.depart(currentTime);
                waitTimes.apilar(currentCustomer.getWaitTime());
                currentCustomer = null;
                money = money + 0.7;
                if (!customers.isEmpty()) {
                    currentCustomer = (Customer) customers.deQueue();
                }
            } else {
                idleTime = idleTime + 10;
            }
        } else {
            idleTime = idleTime + 10;
        }
    }

    public void addCustomer(Customer c){
        customers.enQueue(c);
    }

    public boolean isEmpty() {
        return customers.isEmpty() && currentCustomer == null;
    }

    public int getAverageWaitTime(){
        int i = 0;
        while (!waitTimes.esVacia()){
            i++;
            averageWaitTime = averageWaitTime + ((Integer) waitTimes.verTope()).intValue();
            waitTimes.desapilar();
        }
        if (i != 0)return averageWaitTime / i;
        else return 0;
    }

    public double getMoney(){
        return money;
    }

    public int getIdleTime(){
        return idleTime;
    }
}
