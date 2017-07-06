// QQ mirrors Q and is specific for Person Objects
//
// Credit: Chris Dovolis
// Patrick Shanks
// shank219@umn.edu
// 5320894


public interface QQ {

// Interface for a Queue

    void add(Person o);

    /* adds an object o to a queue placing it in the order of arrival
       relative to other items added to the queue--first in, first out
       (FIFO) */

    Person remove();

    /* removes and returns the object placed in a queue prior
       to any other items presently in the queue */

    int length();

    /* returns the integer quantity of items currently present in the
       queue */

}  // QQ Interface

