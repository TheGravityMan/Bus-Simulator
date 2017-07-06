
// In order to maintain neatness, I created a new class which simply does all the calculations necessary to create
// an array that will be used in randomly choosing times Passengers will enter a stop. The array is a length of 20,
// and each entry represents a 5% probability of being chosen, thus corresponding with the required random guidelines.
// Patrick Shanks
// shank219@umn.edu
// 5320894



public class ArrivalArray {
    public static int[] newArray(int avg) {
        int[] newArray = {(int) (avg * .75) + avg, (int) (avg * .75) + avg, (int) (avg * .5) + avg, (int) (avg * .5) + avg,
                (int) (avg * .5) + avg, (int) (avg * .2) + avg, (int) (avg * .2) + avg, (int) (avg * .2) + avg, (int) (avg * .2) + avg,
                avg, avg, (int) (avg - (avg * .2)), (int) (avg - (avg * .2)), (int) (avg - (avg * .2)), (int) (avg - (avg * .2)),
                (int) (avg - (avg * .5)), (int) (avg - (avg * .5)), (int) (avg - (avg * .5)), (int) (avg - (avg * .75)),
                (int) (avg - (avg * .75))};
        return newArray;
    }
}

