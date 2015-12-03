//Team Praise be Arrays -- Jennifer Yu, Jackson Deysine
//APCS1 pd9
//HW40 -- Array of Grade 316
//2015-12-02

/*****************************
 * SKELETON for
 * class SuperArray --  A wrapper class for an array. 
 * Maintains functionality:
 *  access value at index
 *  overwrite value at index
 * Adds functionality to std Java array:
 *  resizability
 *  ability to print meaningfully
 *****************************/

public class SuperArray {

		//~~~~~INSTANCE VARS~~~~~
		//underlying container, or "core" of this data structure:
    private int[] _data;

		//position of last meaningful value
    private int _lastPos;

		//size of this instance of SuperArray
	private int _size;

		
		//~~~~~METHODS~~~~~
    //default constructor – initializes 10-item array
    public SuperArray() {
        //_data = new int[10]; //all zeros
        _data = new int[] {1,0,2,0,4,0,6,0,8,0}; //easy test case
        _lastPos = -1;
        _size = 0;
    }

    //output array in [a,b,c] format, eg
    // {1,2,3}.toString() -> "[1,2,3]"
    public String toString() {
        
        String retStr = "["; //beginning of string
        
        for (int x = 0; x < _data.length; x++) {
            retStr += _data[x]; //adds each element to string
            if (x != _data.length - 1) {
                retStr += ","; //stops the last comma
            }
        }
        
        retStr += "]"; //end of string
        
        return retStr; //return string
    }

	
    //double capacity of this SuperArray
    private void expand() {
        int[] newData = new int[_data.length * 2]; //initializes a new array with double capacity
        
        for (int x = 0; x < _data.length; x++) {
            newData[x] = _data[x]; //inserts everything into the new array
        }            

        _data = newData; //replaces the original array with the new array
    }

		
    //accessor -- return value at specified index
    public int get( int index ) {
        return _data[index]; //returns value at specifed index
    }

		
    //mutator -- set value at index to newVal, 
    //           return old value at index
    public int set( int index, int newVal ) {

        int oldVal = _data[index]; //stores the old value to be returned
        
        _data[index] = newVal; //puts new value into the index of the new array
        
        return oldVal; //returns old value
    }
    
    public int remove( int index ) {
        int[] newData = new int[_data.length-1]; //initializes a new array
        
        int oldVal = _data[index]; //stores the old value to be returned
        
        for (int x = 0; x < index; x++) {
            newData[x] = _data[x]; //inserts everything up to the index into the new array
        }
        
        for (int x = index + 1; x < _data.length; x++) {
            newData[x-1] = _data[x]; //finishes filling in
        }
        
        _data = newData; //replaces the original array with the new array
        
        return oldVal; //returns what you removed
    }    
    
    public void add(int value) { //adds value at the end
        int[] newData = new int[_data.length+1]; //initializes a new larger array
        
        for (int x = 0; x < _data.length-1; x++) {
            newData[x] = _data[x]; //inserts everything in the new array
        }    
        
        newData[_data.length] = value; //adds the value

        _data = newData; //replaces the original array with the new array
    }

    public void add(int index, int value) { //adds value at an index
        int[] newData = new int[_data.length+1]; //initializes a new larger array
        
        for (int x = 0; x < index; x++) {
            newData[x] = _data[x]; //inserts everything up to the index into the new array
        }
        
        newData[index] = value; //adds the value at specified index
        
        for (int x = index; x < _data.length; x++) {
            newData[x+1] = _data[x]; //finishes filling in
        }
        
        _data = newData; //replaces the original array with the new array
    }//end add(third one)

    public int leftJustify() {

        int[] newData = new int[_data.length]; //initializes a new array
    
        int y = 0; //to skip 0s by setting a separate counter for the new array
        
        for (int x = 0; x < _data.length; x++) {
            if (_data[x] != 0) { //if its not zero, significant
                newData[y] = _data[x];
                y += 1;
            }
        }
        
        _data = newData; //replaces the original array with the new array
        
        return y; //how many spaces
    }

		//main method for testing
	public static void main( String[] args ) {
		//*****INSERT ADEQUATE TEST CALLS HERE*****
	    SuperArray myArray = new SuperArray();
	    myArray.set(6,333);
	    myArray.add(100);
	    myArray.add(2,10000);
	    //myArray.expand();
	    //System.out.println(myArray.get(6));
	    //myArray.remove(6);
	    //myArray.leftJustify();
	    System.out.println(myArray);
	}//end main
		
}//end class
