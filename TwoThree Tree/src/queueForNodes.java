public class queueForNodes {
    //Stuffs related to a queue
    private static Nodes head;
    private static Nodes tail;

    //Constructor
    queueForNodes() {
        head = tail = null;
    }

    public void enqueue(Nodes data) {
        //very first time setting the head and tail
        if (head == null && tail == null) {
            head = data;
            tail = head;
        } else {
            //Setting the other tail
            tail.setNextNode(data);
            tail = tail.getNextNode();
        }
    }


    public static Nodes dequeue() {
        Nodes temp;
        temp = head;
        head = head.getNextNode();
        return temp;
    }

    //Checks if queue is empty
    public boolean isEmpty() {

        if (head != null) {
            return false;
        } else return true;

    }

    //Function which will empty the queue
    public void emptyQueue() {
        head = tail = null;
    }

}

