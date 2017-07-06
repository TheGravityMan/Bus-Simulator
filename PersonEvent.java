/* PersonEvent class controls the processes of creating a Person object and placing it at a stop Queue. It is also necessary for
the data each Person object needs to keep track of it's statistics. Reschedules itself for a future time using randomArray from
BusSim.
Patrick Shanks
shank219@umn.edu
5320894
 */

public class PersonEvent implements Event {

    // Private Variables
    private int stopID;
    private int[] stoparr = {1,1,2,2,3,3,4,5,6,7,8,9,10};

    // Constructor
    public PersonEvent(int id) {
        stopID = id;
    }

    // Methods

    // Run()
    public void run() {

        // Depending on stop, schedules itself for a future time, choosing which array to get data from.
        // Downtown stops have more frequent Person events
        if (stopID == 1 || stopID == 2 || stopID == 3) {
            if (stopID == 1)
                BusSim.agenda.add(new PersonEvent(stopID), BusSim.randomArray1[getRandomNum(20)]);
            else
                BusSim.agenda.add(new PersonEvent(stopID), BusSim.randomArrayDT[getRandomNum(20)]);
        }
        else {
            BusSim.agenda.add(new PersonEvent(stopID), BusSim.randomArray[getRandomNum(20)]);
        }

        // Chooses which stop this person will have. Using the stop, saves direction data. Checks to make
        // sure the destination is not the current stop
        int dir;
        int dest = getRandomNum(13);
        System.out.println("this is the random number: "+dest);
        dest = stoparr[dest];
        while (dest == stopID) {
            dest = getRandomNum(13);
            dest = stoparr[dest];
        }
        if (dest < stopID)
            dir = 1;
        else
            dir = 0;

        // Creates new person at the current time
        Person person = new Person(BusSim.agenda.getCurrentTime(),stopID,dir,dest);
    }

    // Method used to generate random number
    private int getRandomNum(int upper) {
        return (int)(Math.random() * upper);
    }


}
