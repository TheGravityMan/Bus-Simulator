/* Stat class collects all stats and displays them when the method is called
Patrick Shanks
shank219@umn.edu
5320894
*/
public class Stat {

    // Private Variables
    public static int avgBusPassenger;
    public static int totalBusTime = 1;
    public static int maxCapacity;
    public static int maxCapAtStop;
    private static int avgCapacityAtStop;
    public static Stop busiestStop;
    private static int totalWaitTime;
    private static int totalPassengers;
    private static int totalRideTime;
    private static int totalQueueTime = 1;
    private static int totalNumStops;

    public static void updateQueueStats(int num,Stop busy,int last,int arrive) {
        if (num > maxCapAtStop) {
            busiestStop = busy;
            maxCapAtStop = num;
        }
        avgCapacityAtStop += (num - 1) * (arrive - last);
        totalQueueTime += (arrive - last);
        System.out.println(avgCapacityAtStop + " " + num + " " + last + " " + arrive + " " + totalQueueTime + " " + busy.stopID);
        System.out.println(totalQueueTime + " " + avgCapacityAtStop/totalQueueTime);
    }

    public static void updatePersonStats(int arrive,int onBus,int offBus,int numst) {
        System.out.println(arrive +" "+onBus+" "+offBus+" "+numst);
        totalWaitTime += onBus - arrive;
        totalRideTime += offBus - onBus;
        totalNumStops += numst;
        totalPassengers++;
    }

    public static void updateBusStats(int num,int time,int lastBusUpdate,int ID) {
        if (num > maxCapacity)
            maxCapacity = num;
        avgBusPassenger += num * (time - lastBusUpdate);
        totalBusTime += time - lastBusUpdate;
    }

    public static void display() {
        System.out.println("--Results Of The Bus Simulation--");
        System.out.println("Maximum Occupancy Reached On Busses: " + maxCapacity);
        System.out.println("Average Occupancy Of All Running Busses: " + avgBusPassenger/totalBusTime);
        System.out.println("Average Passenger Miles Per Gallon: " + (4 * (avgBusPassenger/totalBusTime)));
        System.out.println("Total Time Of All Busses: " + totalBusTime);
        System.out.println("Total Number Of Passengers: " + totalPassengers);
        System.out.println("Average Wait Time Per Passenger: " + totalWaitTime/totalPassengers);
        System.out.println("Average Ride Time Per Passenger: " + totalRideTime/totalPassengers);
        System.out.println("Average Ride Time Per Stop: " + (totalRideTime/totalPassengers) / (totalNumStops/totalPassengers));
        System.out.println("Average Occupancy Of All Stops: " + avgCapacityAtStop / totalQueueTime);
        System.out.println("Busiest Stop Was " + busiestStop.toString() + " With A Queue Length Of: " + maxCapAtStop);
    }
}
