/* Stop class is used to represent each stop and is instantiated just once at the beginning of the simulation.
Each stop holds 2 queues, one for each direction, a stop ID, and the time for each queue's last update time.
Also holds information about the stop name
Patrick Shanks
shank219@umn.edu
5320894
 */

public class Stop {

    // Public Variables
    // Queue's for both Westbound and EastBound Passengers
    public Q3 eastQ = new Q3();
    public Q3 westQ = new Q3();
    public Q3[] qArr = {eastQ,westQ};
    int stopID;
    private int lastStopUpdateE;
    private int lastStopUpdateW;

    //Private Variables
    private String stopName;

    //Constructor
    public Stop(String name,int ID) {
        stopID = ID;
        stopName = name;
    }

    //Methods
    public String toString() {
        return stopName;
    }

    public int getLastStopUpdateE() {
        return lastStopUpdateE;
    }

    public void setLastStopUpdateE(int t) {
        lastStopUpdateE = t;
    }

    public int getLastStopUpdateW() {
        return lastStopUpdateW;
    }

    public void setLastStopUpdateW(int t) {
        lastStopUpdateW = t;
    }






}
