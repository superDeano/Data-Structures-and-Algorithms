/*This is a class which stores data, enables one to set INT to null*/

public class Datas
{

    private int data;
    //Used for queue
    public Datas next = null;

    //constructors
    Datas (int data){
        this.data = data;
    }

    Datas(){}


    //Getters and Setters
    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Datas getNext() {
        return next;
    }

    public void setNext(Datas next) {
        this.next = next;
    }
}
