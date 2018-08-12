public class Nodes {

    protected Nodes parent;
    protected Nodes[] children = null;
    protected Datas[] data = null;
    protected int numData = 0;
    protected int numChildren = 0;

    //The constructors for nodes
    Nodes() {
    }

    Nodes (int MaxNumData, int MaxNumChildren, int value){

        children = new Nodes[MaxNumChildren];
        data = new Datas[MaxNumData];

        //first setting all the data to null
        for (int n = 0; n < data.length; n++) {
            data[n] = null;
        }

        //First setting all the children to null
        for (int i = 0; i < children.length; i++) {
            children[i] = null;
        }

        //Sets the first data
        data[TwoThree.firstData] = new Datas(value);
    }

    Nodes(int MaxNumData, int MaxNumChildren, int value, Nodes parent) {
        children = new Nodes[MaxNumChildren];
        data = new Datas[MaxNumData];


        //first setting all the data to null
        for (int n = 0; n < data.length; n++) {
            data[n] = null;
        }


        //First setting all the children to null
        for (int i = 0; i < children.length; i++) {
            children[i] = null;
        }

        data[TwoThree.leftChild] = new Datas(value);
        this.parent = parent;
    }

    //Constructor
    Nodes(int MaxNumData, int MaxNumChildren) {

        this.numData = MaxNumData;
        this.numChildren = MaxNumChildren;


        children = new Nodes[numChildren];
        data = new Datas[numData];


        //first setting all the data to null
        for (int n = 0; n < data.length; n++) {
            data[n] = null;
        }


        //First setting all the children to null
        for (int i = 0; i < children.length; i++) {
            children[i] = null;
        }
    }


    //Getting and setting Child Nodes
    public Nodes getChild(int index) {
        return children[index];
    }


    //Checks whether a node has a child
    public boolean check4Child(int index) {
        if (children[index] == null) {
            return false;
        } else return true;
    }


    //Checks if a node has no children
    public boolean check4Children() {

        //Goes throughout the whole array
        for (int i = 0; i < children.length; i++) {
            //Finds a child, returns true
            if (children[i] != null) {
                return true;
            }
        }
        return false;
    }

    //Checks if a node has all data -- returns true is all data is true
    public boolean check4AllData() {
        for (int i = 0; i < data.length; i++) {
            if (data[i] != null)
                return true;
        }
        return false;
    }

    //checks whether a node has data
    public boolean check4Data(int index) {
        if (data[index] == null) {
            return false;
        } else return true;
    }

    //Sets a child
    public void setChild(int index, Nodes child) {
        this.children[index] = child;
    }


    //Getter for parent
    public Nodes getParent() {
        return parent;
    }

    //Setter for parent
    public void setParent(Nodes parent) {
        this.parent = parent;
    }


    //Getter for Datas
    public int getData(int index) {
        if (data[index] != null) {
            return data[index].getData();
        } else return -1;
    }

    //Setter for Datas
    public void setData1(int index, int data1) {

        if (data[index] == null) {
            data[index] = new Datas(data1);
        } else
            this.data[index].setData(data1);
    }

    //Deletes Data
    public void deleteData(int index){
    if (data[index] != null){
        data[index] = null;
    }
    }

    public void deleteChild(int index){
        if (children[index] != null){
            children[index] = null;
        }
    }

    public int getLengthDataArray() {
        return data.length;
    }

    public int getLengthChildrenArray() {
        return children.length;
    }

}