
/**
 * Created by Francisco on 10/04/14.
 */
public class Customer {
    private int arrivalTime;
    private int departureTime;

    public Customer(int arrivalTime){
        this.arrivalTime = arrivalTime;
    }

    public void depart(int departureTime){
        this.departureTime = departureTime;
    }

    public int getWaitTime(){
        return departureTime - arrivalTime;
    }

}
