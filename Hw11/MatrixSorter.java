// Sunny Yu
// hw11 - Matrix Sorter
// 5 December 2014

// This program creates a ragged 3D array of random numbers.

// creates a class
public class MatrixSorter {
    // adds a main method
    public static void main(String arg[]) {
        // declares a 3D array
        int mat3d[][][];
        // calls the method buildMat3d to initialize the array
        mat3d=buildMat3d();
        // calls the method show to print out the array
        show(mat3d);
        // calls the method findMin to find the smallest value in the array
        System.out.println("The smallest entry in the 3D matrix is "+findMin(mat3d));
        System.out.println("After sorting the 3rd matrix we get");
        // calls the method sort to sort the array
        sort(mat3d[2]);
        // calls the method show to print out the array
        show(mat3d);
    }
    // creates the method buildMat3d to initialize the array
    public static int[][][] buildMat3d() {
        // declares a 3D array
        int[][][] array = new int[3][][];
        // runs through a loop of each slab
        for(int i=0; i<3; i++) {
            // initializes the number of rows per slab
            array[i] = new int[3+(2*i)][];
            // runs through a loop of each row
            for(int j=0; j<3+2*i; j++) {
                // initializes the number of columns per row
                array[i][j] = new int[i+j+1];
                // runs through a loop of each column
                for(int k=0; k<i+j+1; k++) {
                    // initializes a random value from 1-99 in each column
                    array[i][j][k] = (int)(Math.random()*99+1);
                }
           }
       }
       // returns the fully initialized array of random numbers
       return array;
    }
    // creates the method show that prints out the array
    public static void show(int[][][] array) {
        // declares and initializes an array of labels
        String[] label = {"---------------------------", "Slab 1", "Slab 2", "Slab 3"};
        // runs a loop through each slab
        for(int i=0; i<3; i++) {
            // prints out the label for each slab
            System.out.println(label[0]+label[i+1]);
            // runs a loop through each row
            for(int j=0; j<3+2*i; j++) {
                // runs a loop through each column
                for(int k=0; k<array[i][j].length; k++) {
                    // prints out the value of the column
                    System.out.print(array[i][j][k]+" ");
                }
                // prints out a new line
                System.out.println("");
            }
        }
        System.out.println(label[0]);
    }
    // creates the method findMin that returns the lowest value in the array
    public static int findMin(int[][][] array) {
        // sets the initial minimum value
        int min = 100;
        // runs a loop through each slab
        for(int i=0; i<3; i++) {
            // runs a loop through each row
            for(int j=0; j<3+2*i; j++) {
                // runs a loop through each column
                for(int k=0; k<i+j+1; k++) {
                    // checks if the value is less than the current minimum
                    if(array[i][j][k] < min) {
                        // sets a new minumum value
                        min = array[i][j][k];
                    }
                }
            }
        }
        // returns the lowest value of the entire array
        return min;
    }
    // creates the method sort that uses insertion sort
    public static void sort(int[][] array) {
        // calls the overloaded method sort to sort each row
        for(int k=0; k<array.length; k++) {
            sort(array[k]);
        }
        // runs a loop through each value in the array
        for(int i=1; i<array.length; i++) {
            // sets the initial value to the first value of the row
            int value = array[i][0];
            // saves the array at the starting point
            int[] temp = array[i];
            int j;
            // runs a loop through the previously sorted values
            for(j=i-1; j>=0 && value<array[j][0]; j--) {
                // only swaps the array at the index if the new value is lower
                array[j+1]=array[j];
            }
            // swaps the arrays
            array[j+1]=temp;
        }
    }
    // overloads the method sort
    // uses selection sort
    public static void sort(int[] array) {
        // runs a loop through every element of the array
        for(int j=0; j<array.length-1; j++) {
            // sets the new minimum value
            int min = array[j];
            // sets the index of the minimum
            int index = j;
            // runs a loop through the rest of the array
            for(int k=j+1; k<array.length; k++) {
                // checks if the element is less than the current minimum
                if(array[k] < min) {
                    // sets a new minimum value and its index
                    min = array[k];
                    index = k;
                }
            }
            // swaps the position of the current element with the minimum
            if(index != j) {
                array[index] = array[j];
                array[j] = min;
            }
        }
    }
}