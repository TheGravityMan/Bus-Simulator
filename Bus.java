/* The Bus class  creates Bus objects which store the buses Queue of Passengers, as well as relevant information such as
bus Id number, its current stop and direction, max size, and when it was last updated. Works closely with the BusEvent class
to retrieve information specific to each bus when performing its .run() method
Patrick Shanks
shank219@umn.edu
5320894
*/

public class Bus {

    // Public Variables
    public Person[] passengers;

    // Private Variables
    private int busID;
    private int currentStop;
    private int currentDir;
    private int occupancy;
    private int lastBusUpdate;

    // Constructor
    public Bus(int size,int stop,int dir,int bid) {
        occupancy = size;
        passengers = new Person[size];
        if (stop > 10){
            stop = 20 - stop;
        }
        currentStop = stop;
        currentDir = dir;
        busID = bid;
    }

    // Methods

    public int getBusID() {
        return busID;
    }

    public int getCurrentStop() {
        return currentStop;
    }

    public int getCurrentDirection() {
        return currentDir;
    }

    public int getOccupancy() {
        return occupancy;
    }

    public void setDirection(int dir) {
        currentDir = dir;
    }

    public void setCurrentStop(int cstop) {
        currentStop = cstop;
    }

    public int getLastBusUpdate() {
        return lastBusUpdate;
    }

    public void setLastBusUpdate(int t) {
        lastBusUpdate = t;
    }

    // Retrieve the current number of passengers

    public int currentPass() {
        int count = 0;
        for (int i = 0;i < passengers.length;i++) {
            if (passengers[i] != null)
                count++;
        }
        return count;
    }
}
