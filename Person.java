/* The Person class is created for each person and saves all data needed for the Passenger's data collection such as
time of arrival to the Queue, time of entry to the bus, which stop it was originated from, the direction they
are travelling, and the destination. Person is manipulated by the Person event. All data is collected upon departure from
the bus.
Patrick Shanks
shank219@umn.edu
5320894
*/

public class Person {

    //private variables
    private int arrival;
    private int getOnBus;
    private int stopId;
    private int direction;
    private int destination;

    //constructor
    public Person(double arrive,int stop,int direct,int dest) {
        arrival = (int) arrive;
        stopId = stop;
        direction = direct;
        destination = dest;

        // Depending on the direction the Passenger is going, this puts the Passenger into the correct
        // Queue. The method then updates the data for the Queue.
        if (direction == 0) {
            BusSim.stopList[stop - 1].eastQ.add(this);
            Stat.updateQueueStats(BusSim.stopList[stop - 1].qArr[direction].length(), BusSim.stopList[stop - 1],
                    BusSim.stopList[stop - 1].getLastStopUpdateE(), arrival);
            BusSim.stopList[stop - 1].setLastStopUpdateE(arrival);
        } else {
            BusSim.stopList[stop - 1].westQ.add(this);
            Stat.updateQueueStats(BusSim.stopList[stop - 1].qArr[direction].length(), BusSim.stopList[stop - 1],
                    BusSim.stopList[stop - 1].getLastStopUpdateW(), arrival);
            BusSim.stopList[stop - 1].setLastStopUpdateW(arrival);
        }
    }

    // Methods

    public int getArrivalTime() {
        return arrival;
    }

    public int getDestination() {
        return destination;
    }

    public int getStopId() {
        return stopId;
    }

    public void setGetOnBus(int t) {
        getOnBus = t;
    }

    public int getGetOnBus() {
        return getOnBus;
    }

    // Retrieves number of stops the Passenger traveled through

    public int getNumStops() {
        if (direction == 0)
            return destination - stopId;
        else
            return stopId - destination;
    }
}
