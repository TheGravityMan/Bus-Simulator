/* Drives the Simulation and allows programmer to change certain variables such as bus size, bus number, and passenger
frequency. Contains arrays for objects such as the Buses, Stops, and int arrays which hold time frequency used by the PassengerEvent
class. Also holds the agenda which drives all time events in the program
Patrick Shanks
shank219@umn.edu
5320894
*/

public class BusSim {

    // Public Variables
    static PQ agenda = new PQ();
    static Stop[] stopList = new Stop[10];
    static Bus[] busList;
    static int[] randomArray;
    static int[] randomArrayDT;
    static int[] randomArray1;

    static int avg = 150;


    public static void main(String args[]) {

        // set up array for PersonEvent. Implemented here so the calculations
        // are not necessary each and every time a new PassengerEvent is scheduled.
        // Also makes it simple to adjust Average arrival time.
        randomArray = ArrivalArray.newArray(avg);
        randomArrayDT = ArrivalArray.newArray(avg - 30);
        randomArray1 = ArrivalArray.newArray(avg - 10);

        // Begins the simulation by creating all the stops, adding them to the stopList
        StopApp.begin();

        // Creates all busses.
        // Adjust first parameter to adjust size of bus.
        // Adjust second parameter to adjust number of busses (1-18)
        busList = BusMaker.busStart(40,18);

        //Schedule a person event for each of the stops that will occur at
        //Time == 10.

        for (int i = 0;i < 10;i++) {
            agenda.add(new PersonEvent(i+1), 10);
        }

        //Schedule a Bus event for each bus that will take place at time = 15.
        for (int i = 0;i < busList.length;i++) {
            agenda.add(new BusEvent(i + 1), 15);
        }

        //Run simulation. Adjust time to change length of simulation
        while (agenda.getCurrentTime() <= 10000)
            agenda.remove().run();

        Stat.display();
    }




}
