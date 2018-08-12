import java.util.*;

public class Main {


    public static void main(String[] args) {
        int a;
        Scanner S = new Scanner(System.in);

        System.out.println("\nEnter the length of the array");

        a = S.nextInt();

        JumpList tesT = new JumpList(a);


        System.out.println("\nEnter numbers to go into the circular array");
        System.out.println("\nEnter 96 to Finish entering the numbers into the array");

        int counter = 0;
        do {
            a = S.nextInt();
//          tesT.enqueue(a);
          counter++;
        } while (counter < (tesT.getLength()));

        System.out.println("\nQueue full at this point");

        System.out.println("\nNow dequeuing two elements");

        for (int i = 0; i < 2;i++){
            System.out.print(tesT.dequeue() + " ");
        }

        System.out.println("\nNow Add two elements again");

        for (int i = 0; i < 2;i++){
            a = S.nextInt();
//            tesT.enqueue(a);
        }


        System.out.println("\nNow displaying the queue");

        for (int i = 0; i < tesT.getLength();i++){
            System.out.print(tesT.dequeue() + " ");
        }

    }
}
