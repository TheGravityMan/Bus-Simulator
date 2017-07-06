/* The BusEvent class drives the action of a bus arriving at a stop, letting passengers off, letting passengers on, and
updating the data for itself, its passengers, and the stop Queues. In order to retrieve the correct information that is
specific to each bus, it holds information such as the busID associated with it, the current stop and direction, and the time
the event occurred. Also schedules a future event and updates the bus's information for the future event.
Patrick Shanks
shank219@umn.edu
5320894
 */

public class BusEvent implements Event{

    // Private Variables
    private int busID;
    private int stopNum;
    private int newDir;
    private int arriveTime;

    // Constructor
    public BusEvent(int id) {
        busID = id;
    }

    // Methods
    public void run() {

        // Initialize variables for .run()
        Bus bus = BusSim.busList[busID-1];
        newDir = bus.getCurrentDirection();
        stopNum = bus.getCurrentStop();
        arriveTime = (int) BusSim.agenda.getCurrentTime();

        // Changes direction if at the edges of bus line
        if (stopNum == 1)
            newDir = 0;
        if (stopNum == 10)
            newDir = 1;

        // Update bus stats to reflect new Queue length
        Stat.updateBusStats(bus.currentPass(),arriveTime,BusSim.busList[busID - 1].getLastBusUpdate(),busID);
        BusSim.busList[busID - 1].setLastBusUpdate(arriveTime);

        // Update Queue stats associated with the stop as the bus picks up Passengers
        if (newDir == 0) {
            Stat.updateQueueStats(BusSim.stopList[stopNum - 1].qArr[newDir].length() + 1, BusSim.stopList[stopNum - 1],
                    BusSim.stopList[stopNum - 1].getLastStopUpdateE(), arriveTime);
            BusSim.stopList[stopNum - 1].setLastStopUpdateE(arriveTime);
        } else {
            Stat.updateQueueStats(BusSim.stopList[stopNum - 1].qArr[newDir].length() + 1, BusSim.stopList[stopNum - 1],
                    BusSim.stopList[stopNum - 1].getLastStopUpdateW(), arriveTime);
            BusSim.stopList[stopNum - 1].setLastStopUpdateW(arriveTime);
        }

        // look through Bus List and determine if any passengers need to depart the bus. If so, record the Passenger
        // information including stop arrival time, time entering bus, and departure time
        int offCount = 0;
        for (int i = 0;i < bus.getOccupancy(); i++) {
            if (bus.passengers[i] != null && bus.passengers[i].getDestination() == stopNum) {
                Person n = bus.passengers[i];
                Stat.updatePersonStats(n.getArrivalTime(),n.getGetOnBus(),arriveTime,n.getNumStops());
                System.out.println("waited for: " + (bus.passengers[i].getGetOnBus() - bus.passengers[i].getArrivalTime()) + "rode for: " +
                        (arriveTime - bus.passengers[i].getGetOnBus()));
                bus.passengers[i] = null;
                offCount++;
            }
        }

        // Search through the correct queue at stop and let any Passengers in the Queue on the bus, as long as
        // the Bus has space. When the bus is full, it will stop letting Passengers on
        int onCount = 0;
        for (int i = 0;i < bus.getOccupancy(); i++) {
            if (bus.passengers[i] == null) {
                bus.passengers[i] = BusSim.stopList[stopNum - 1].qArr[newDir].remove();
                if (bus.passengers[i] != null) {
                    onCount++;
                    bus.passengers[i].setGetOnBus(arriveTime + (offCount * 2) + (onCount * 3));
                    System.out.println(bus.passengers[i].getGetOnBus() + " " + bus.passengers[i].getDestination());
                }
            }
        }

        // Calculate time spent exchanging passengers
        int exTime = (offCount * 2) + (onCount * 3);
        if (exTime <= 15)
            exTime = 0;
        else
            exTime = exTime - 15;

        // Set new direction for bus, update the bus's current stop to reflect the next stop
        bus.setDirection(newDir);
        if (newDir == 0)
            bus.setCurrentStop(stopNum + 1);
        else
            bus.setCurrentStop(stopNum - 1);

        // Save updated bus in busList, add new bus event for the future
        BusSim.busList[busID-1] = bus;
        BusSim.agenda.add(new BusEvent(busID), 315 + exTime);
    }


}
