/* Q3 exacly mirros Q2. The only difference is that it is made specifically to implement QQ,
because for some reason I was unable to get the Person Q to work using the Q2. However it works
with Q3, so I went with it

Still, Credit: Chris Dovolis
Patrick Shanks
shank219@umn.edu
5320894
 */
public class Q3 implements QQ {

    // constructors

    public Q3() {
        q = new Person[0];
    }

    public Q3(int initLength) {

        if (initLength < 0)
            throw new IllegalArgumentException("capacity requested is negative");
        q = new Person[initLength];
    }

    // selectors

    public void add(Person o) {

        if (q.length == 0) {  // array non-existant, create it and insert first object
            q = new Person[1];
            size = 1;
            q[0] = o;
        }
        else if (size == 0)  { // adding to empty queue
            rear = 0;
            front = 0;
            size = 1;
            q[0] = o;
        }
        else  {  // general case: array exists and non-empty
            if (size == q.length) {  // allocate bigger array if needed
                Person[] newq = new Person[2 * q.length + 1];
                if (front <= rear)  // queue has not wrapped,
                    // so make simple copy to new space
                    System.arraycopy(q, front, newq, 0, size);
                else if (front > rear) {  // queue has wrapped,
                    // so copy in two chunks
                    System.arraycopy(q, front, newq, 0, q.length - front);
                    System.arraycopy(q, 0, newq, q.length - front, rear + 1);
                    front = 0;
                    rear = size - 1;
                }
                q = newq;
            }  // allocate bigger array if needed

            rear = (rear + 1) % q.length;
            q[rear] = o;
            size++;

        }  // general case: array exists and non-empty
    }  // add

    public Person remove() {

        if (size == 0)
            return null;

        Person answer = q[front];
        front = (front + 1) % q.length;
        size--;
        return answer;
    }

    public int length() {
        return size;
    }

    private Person[] q;
    private int size;  // number of items in the array
    private int front;  // first element
    private int rear;  // last element

}  // Q3 class


