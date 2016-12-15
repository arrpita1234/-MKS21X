public class Sorts{
  /**EDIT THIS METHOD TO MATCH YOUR NAME 
  */
  public static String name(){
    return "09.Nag.Arpita"; 
  }

  /**Selection sort of an int array. 
  *Upon completion, the elements of the array will be in increasing order.
  *@param data  the elements to be sorted.
  */
  public static void selectionSort(int[] data){
        int x = 0;
        for(int n = 0; n < data.length; n++){
            int min = data[n];
            for (int i = n; i < data.length; i++) {
                if (data[i] <= min){
                    min = data[i];
                    x = i;
                    }
                }
                
            data[x] = data[n];
            data[n] = min;
        }
   }

    
    public static void insertionSort(int[] data){
                    int n;
        for (int i = 1; i < data.length; i++){
            int x = data[i];
            for (n = i - 1; n >= 0 && x < data[n]; n--){
                 data[n + 1] = data[n];            
                 }
            data[n + 1] = x;
        }
    }
    
    
    public static void bubbleSort(int[] data){
    
        for (int i = 0; i + 1 < data.length; i++){
            for (int n = 0; n + 1 < data.length; n++){
                if(data[n] > data[n + 1]){
                    int foo = data[n];
                    data[n] = data[n+1];
                    data[n+1] = foo;
                }
            }
        }
    
    }
    
    private static String toString(int[] data){
        String blah = "{";
     for(int i = 0; i < data.length; i++){
        blah += data[i] + " ";
        }
            return (blah + "}");
    
    
    }

    public static void main(String[] args){
    int[] data = {64, 25, 12, 22, 11};
    
    System.out.println(toString(data));
   
    bubbleSort(data);
    
    System.out.println(toString(data));
    
    int[] solutionArray = {1, 2, 3, 4, 5, 6, 6, 5, 4, 3, 2, 1};
    
    System.out.println(toString(solutionArray));
    
    bubbleSort(solutionArray);
    
    System.out.println(toString(solutionArray));
    //selectionSort(data);
      //insertionSort(data);
      
    int[] moreData = {28,	81,	44,	81,	53,10,	82,	83,	41,	43, 93,	36,	31,	75,	80,43,	81,	84};
    
     System.out.println(toString(moreData));
   
    bubbleSort(moreData);
    
    System.out.println(toString(moreData));
    
}
}



