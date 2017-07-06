// N.java
// A *simplified* node class for use with the Stack1 class 
// and other uses as desired
// Posted previously, but used for simulation
//
// Credit: Professor Chris Dovolis
// Patrick Shanks
// shank219@umn.edu
// 5320894
public class N {
  
    // constructors
    
    public N() {}

    public N(Object o, N link) {
        data = o;
        next = link;
    }

    // selectors

    public Object getData() {
        return data;
    }

    public void setData(Object o) {
        data = o;
    }

    public N getNext() {
        return next;
    }

    public void setNext(N link) {
        next = link;
    }

    // instance variables

    private Object data;
    private N next;

}  // N class
