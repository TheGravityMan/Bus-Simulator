/* Bus maker is run at the beginning of the simulation and creates all the bus objects, sets their initialization
data, and places the bus at a stop.
Patrick Shanks
shank219@umn.edu
5320894
*/

public class BusMaker {

    //private variables
    private static Bus[] busList;
    private static int[] priorityList = {10, 5, 14, 17, 8, 12, 3, 18, 9, 2, 11, 16, 7, 4, 13, 6, 15};

    //Methods

    // Creates bus and returns a list of all buses
    // First Bus is always the same. Uses priority
    // list to place buses when more than 9

    public static Bus[] busStart(int size, int num) {
        busList = new Bus[num];
        int busInt = 1;
        int id;
        int direct;

        //Create first bus which is always the same
        Bus newBus = new Bus(size, 1, 0,1);
        busList[0] = newBus;

        // Uses switch to place buses depending on number
        if (num < 7 || num == 9) {
            switch (num) {
                case 1:
                    busInt = 0;
                    break;
                case 2:
                    busInt = 9;
                    break;
                case 3:
                    busInt = 6;
                    break;
                case 4:
                    busInt = 5;
                    break;
                case 5:
                    busInt = 4;
                    break;
                case 6:
                    busInt = 3;
                    break;
                case 9:
                    busInt = 2;
                    break;
                default:
                    break;
            }
            for (int i = 1; i < num; i++) {
                id = 1 + (i * busInt);
                if (id < 10)
                    direct = 0;
                else
                    direct = 1;
                Bus bus = new Bus(size, id, direct,i+1);
                busList[i] = bus;

            }
        }
        if (num == 7) {
            id = 3;
            for (int i = 1; i < 7; i = i + 2) {
                if (i < 4)
                    direct = 0;
                else
                    direct = 1;
                Bus bus = new Bus(size, id, direct,i+1);
                busList[i] = bus;
                if (i == 3)
                    direct = 1;
                id = id + 3;
                Bus bus2 = new Bus(size, id, direct,i+2);
                busList[i + 1] = bus2;
                id = id + 2;
            }
        }
        if (num == 8) {
            id = 3;
            for (int i = 1; i < 8; i++, id = id + 2) {
                if (i < 4)
                    direct = 0;
                else
                    direct = 1;
                Bus bus = new Bus(size, id, direct,i + 1);
                busList[i] = bus;
                if (i == 3) {
                    id = 10;
                    Bus bus2 = new Bus(size, id, 1,4);
                    busList[i + 1] = bus2;
                    i++;
                    }
                }
        }
        if (num > 9) {
            for (int i = 1;i<num;i++) {
                id = priorityList[i - 1];
                if (id < 10)
                    direct = 0;
                else
                    direct = 1;
                Bus bus = new Bus(size,id,direct,i+1);
                busList[i] = bus;
            }
        }
        return busList;
    }
}

