public class JumpList {


    private ARun[] lol;
    private int head;
    private int tail;

    public JumpList(int length) {

        lol = new ARun[length];

        System.out.println("\nNew JumpList Created");
        System.out.println("\nJumpList Length = " + lol.length);
        head = tail = 0;
    }

    public boolean isEmpty() {
        if (tail == head) {
        return true;
        }
        else {
            return false;
        }
    }

    public void enqueue(ARun run) {
        //Tail cannot go beyond the length of the array

        System.out.println("Enqueuing");

            lol[tail++] = run;


            System.out.println("Enqueued");

            if ((tail == (lol.length)) && (head != tail)) {
                tail = 0;
            }
        }




    public ARun dequeue() {
        // When dequeuing, if the heads hits the end of the array, it goes back
        if ((head == (lol.length)) && (head != tail)) {
            head = 0;
            return lol[head++];
        } else
            return lol[head++];
    }


    public int getLength() {
        return lol.length;
    }
}