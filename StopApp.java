// Patrick Shanks
// shank219@umn.edu
// 5320894
// This is a static class that is used before the simulation to create the random arrays.

public class StopApp {

    //list to help attach name with Stop. Stops are held in a Stop[] in BusSim
    static String[] nameList = {"Union Depot","Minnesota Street and 4th Street","Cedar Street and 5th Street",
            "University Ave and Marion Street","University Ave and Dale Street","University Ave and Lexington Parkway",
            "University Ave and Snelling Ave","University Ave and Fairview Ave","Raymond Ave Station",
            "University Ave and 27th Street SE"};


    //Builds the 10 Stop objects
    public static void begin() {
        for (int i = 1;i != 11;i++) {
            Stop newStop = new Stop(nameList[i - 1],i);
            BusSim.stopList[i - 1] = newStop;
        }
    }

}
