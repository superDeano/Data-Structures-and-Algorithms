/*Tree structures, abstract so every other tree can inherit from it*/

public abstract class Tree {

    //The first node in a tree -- all trees will have a root node
    protected Nodes Root = null;
    //Queue Data Structure
    protected myQueue queue = new myQueue();
    //Stats
    protected static int numComparisons = 0;
    protected static int numTreeNode = 0;

    //function which will add a new node to a tree
    public abstract void addNode(int n);

    //Function which will look for a value in a tree
    public abstract boolean lookFor(Nodes aNode, int something);

    //Function which will be traversing nodes
    public abstract void nodeTraversal(Nodes current);

    //Function which returns the root of a tree
    public Nodes getRoot() {
        return Root;
    }

}
