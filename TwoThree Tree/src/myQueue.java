/* A Queue data structure, list based, to easily manage data and render an implementation easier */

public class myQueue {
    //Stuffs related to a queue
    private static Datas head;
    private static Datas tail;
    private Datas data;

    //Constructor
    myQueue() {
        head = tail = data = null;
    }

    public void enqueue(int data) {
        //first setting the head
        if (head == null && tail == null) {
            this.data = new Datas(data);
            head = this.data;
            tail = this.data;
        }

        else {
            //Setting the other tail
            tail.setNext(new Datas(data));
            tail = tail.getNext();
        }
    }

    public int dequeue() {
        Datas temp;
        temp = head;
        head = head.getNext();
        return temp.getData();
    }

    //Checks if queue is empty
    public boolean isEmpty() {
        if (head != null) {
            return false;
        } else return true;
    }

    //Function which will empty the queue
    public void emptyQueue(){
        head = tail = null;
    }

}
