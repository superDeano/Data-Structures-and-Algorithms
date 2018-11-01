import java.io.*;

public class TwoThree extends Tree {

    public static int leftChild = 0;
    public static int middleChild = 1;
    public static int rightChild = 2;
    public static int firstData = 0;
    public static int secondData = 1;


    //Constructor
    TwoThree() {
        try {
            //For standard Two Three tree
            Root = new Nodes(2, 3);
            //New node created
            numTreeNode++;
        }

        //There is ever an error
        catch (Exception z) {
            System.out.println(z);
        }
    }


    @Override
    public void addNode(int valueToBeAdded) {

        //Checks the node where the data is supposed to go and holds onto it
        Nodes holder = findNode(Root, valueToBeAdded);

        //The first node has no data at first and no children
        if (holder.check4Data(firstData) == false && (!holder.check4Children())) {

            holder.setData1(firstData, valueToBeAdded);

        }

        //if the node has only one data and no children
        else if (holder.check4Data(firstData) && !holder.check4Children()) {

            //if the value to be added is greater than the one already there
            if (valueToBeAdded > holder.getData(firstData)) {
                numComparisons++;
                holder.setData1(secondData, valueToBeAdded);
            }

            //if the value being added is smaller than the one there
            else {
                //switches data
                holder.setData1(secondData, holder.getData(firstData));

                holder.setData1(firstData, valueToBeAdded);
            }
        }

        //If the node has all data taken and no children
        else if (!holder.check4AllData() && !holder.check4Children()) {
            //calls funtion which will be promoting the nodes
            promoteNode(holder, valueToBeAdded);
        }

        //The node is a child node, has no children and all its data are full
        else if (!holder.check4Children() && holder.check4AllData() && holder.getParent() != null) {

            //Checking if the value to be entered
            if (holder.getData(leftChild) > valueToBeAdded && !holder.getParent().check4AllData()) {

                numComparisons++;
                holder.getParent().setData1(secondData, holder.getData(firstData));

                holder.getParent().setChild(middleChild, new Nodes(2, 3, valueToBeAdded, holder.getParent()));
                numTreeNode++;
            }
        }

        //The node has full data and full children
        else if (holder.check4AllData() && holder.check4Children()) {

            //if a parent has all children and all data
            if (holder.getParent().check4Children() && holder.getParent().check4AllData()) {
                splitAndPromoteNodes(holder, valueToBeAdded);
            }


        }

    }


    //Function which will go find a node where a value goes
    private static Nodes findNode(Nodes current, int value) {

        //Node with no data and no children
        //Also known as first case
        if (!current.check4AllData() == !current.check4Children()) {
            return current;
        }

        //One node with one data only and no children
        else if (!current.check4Data(secondData) && !current.check4Children()) {
            return current;
        }

        //A node with only one data
        else if (value <= current.getData(firstData) && !current.check4Data(secondData)) {
            numComparisons++;
            //The node is a leaf node
            if (!current.check4Children()) {
                //Can be added for second data
                return current;
            }

            //The node has children, goes onto check on the children
            else findNode(current.getChild(leftChild), value);
        }

        //The value is greater than the only value
        else if (value >= current.getData(firstData) && !current.check4Data(secondData) && current.check4Child(rightChild)) {
            numComparisons++;
            findNode(current.getChild(rightChild), value);
        }

        //Middle value
        else if (value < current.getData(secondData) && value > current.getData(firstData) && current.check4Child(middleChild)) {
            numComparisons++;
            //walks onto middle child
            findNode(current.getChild(middleChild), value);
        }

        //Value is bigger than the two data from the node, walks to the right child
        else if (value >= current.getData(secondData) && current.check4Child(rightChild)) {
            numComparisons++;
            findNode(current.getChild(rightChild), value);
        }

        return current;
    }

    @Override
    public boolean lookFor(Nodes Root, int something) {


        //less than the first value in the node
        if (something < Root.getData(firstData)) {
            numComparisons++;
            lookFor(Root.getChild(leftChild), something);
        }


        //Greater than the only value in the node
        if (something > Root.getData(firstData) && !Root.check4Data(secondData)) {
            numComparisons++;
            lookFor(Root.getChild(rightChild), something);
        }

        //If the value is in first one from the node
        if (something == Root.getData(firstData)) {
            numComparisons++;
            return true;
        }

        //The value is between the two data from the node
        if (something > Root.getData(firstData) && something < Root.getData(secondData)) {
            numComparisons++;
            lookFor(Root.getChild(middleChild), something);
        }

        //The value is greater than the second data from the node
        else if (something > Root.getData(secondData)) {
            numComparisons++;
            lookFor(Root.getChild(rightChild), something);
        }

        //is the same as the second data from the node
        else if (something == Root.getData(secondData)) {
            numComparisons++;
            return true;
        }

        //If the value was not found, return false
        return false;

    }

    //Function which traverses a tree and outputs the value
    @Override
    public void nodeTraversal(Nodes current) {
        //Calls the function which adds nodes to the Queue
        addToQueue(current);
        //which then displays the values
        show();

    }


    //Function which promotes a node
    private void promoteNode(Nodes current, int value) {

        Nodes nodeHolder;

        //That means that the node is the root
        if (current.getParent() == null) {
            if (value > current.getData(firstData) && value < current.getData(secondData)) {
                numComparisons++;
                nodeHolder = current;
                Root = new Nodes();
                numTreeNode++;
                Root.setData1(firstData, value);
                Root.setChild(leftChild, new Nodes(firstData, nodeHolder.getData(firstData)));
                numTreeNode++;
                Root.setChild(rightChild, new Nodes(secondData, nodeHolder.getData(secondData)));
                numTreeNode++;
            }

        }


    }

    //Assume that the node N will have two data
    private void splitAndPromoteNodes(Nodes current, int value) {

        Nodes tempHolder;
        //we have the root
        if (current.getParent().getParent() == null) {
            //holding to the root
            tempHolder = current.getParent().getParent();

            Root = new Nodes(2, 3, tempHolder.getData(secondData));
            numTreeNode++;
            //Sets the roots left child
            Root.setChild(leftChild, tempHolder);
            //deletes the previous data which became the root
            tempHolder.deleteData(secondData);
            //the previous root switches middle child with right child
            tempHolder.setChild(rightChild, tempHolder.getChild(middleChild));
            //new right child from the root
            Root.setChild(rightChild, new Nodes(2, 3, value));
            numTreeNode++;
            //Sets the new left leaf node
            Root.getChild(rightChild).setChild(leftChild, new Nodes(2, 3, current.getData(firstData)));
            numTreeNode++;
            //Sets the new right leaf node
            Root.getChild(rightChild).setChild(rightChild, new Nodes(2, 3, current.getData(secondData)));
            numTreeNode++;
            //finally deletes the middle child from the previous node
            tempHolder.deleteChild(middleChild);
        } else {
            //Keeps on going until finds the root
            splitAndPromoteNodes(current.getParent(), value);
        }


    }

    //Function which will display the values the tree
    private void show() {

//        while (!queue.isEmpty()) {
//            System.out.print(queue.dequeue() + " ");
//        }

    }

    //Function which will addToQueue through the nodes with a preorder traversal and store the values in a queue structure
    private void addToQueue(Nodes current) {

        theQueue.enqueue(current);

        //Checks if the current nodes has a left child, if so then adds the child to theQueue
        if (current.check4Child(leftChild)){
            theQueue.enqueue(current.getChild(leftChild));

            //Checks if there is a middle child
            if (current.check4Child(middleChild)) {
                theQueue.enqueue(current.getChild(middleChild));
            }

            //If there is a leftChild, there is a right child because of the 2-3 tree properties, so adds it to theQueue
            theQueue.enqueue(current.getChild(rightChild));
        }


    }

    public static void main(String[] args) {

        try {

            //Getting the file location
            File theTextFile = new File(args[0]);

            //getting the amount of steps
            int Steps = Integer.parseInt(args[1]);

            //To create a link to read the file
            BufferedReader reader = new BufferedReader(new FileReader(theTextFile));

            //Temporary Strings
            String tempHolder, checker;

            int i = 0;
            int value = 0;
            int numAddOp = 0;
            int numFindOp = 0;

            //Settting up new tree
            TwoThree rock = new TwoThree();

            while ((tempHolder = reader.readLine()) != null && i < Steps) {

                //getting first character of the line
                checker = Character.toString(tempHolder.charAt(0));

                //Getting the numbers into int from the string
                value = Integer.parseInt(tempHolder.substring(1, 3));

                switch (checker) {
                    //Adding a new value
                    case "a":
                        rock.addNode(value);
                        numAddOp++;
                        break;
                    //Finding a value
                    case "f":
                        rock.lookFor(rock.getRoot(), value);
                        numFindOp++;
                        break;
                }
                //Incrementing for the while loop
                i++;
            }

            //Then finally traversing the tree
            rock.nodeTraversal(rock.getRoot());
            System.out.println(numTreeNode + " number of nodes created");
            System.out.println(numComparisons + " number of comparisons done");
            System.out.println(numAddOp + " of add operations done");
            System.out.println(numFindOp + " of find operations done");

        } catch (Exception E) {
            System.out.println(E);
        }
    }

}
