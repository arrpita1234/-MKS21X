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
                 data[n + 1] = data[n];            }
            data[n + 1] = x;
        }
    }

    public static void main(String[] args){
    int[] data = {64, 25, 12, 22, 11};
    
    String blah = "{";
    for(int i = 0; i < data.length; i++){
        blah += data[i] + " ";
    }
    System.out.println(blah + "}");
   
    //selectionSort(data);
      insertionSort(data);
     String bleh = "{";
    for(int i = 0; i < data.length; i++){
        bleh += data[i] + " ";
    }
    System.out.println(bleh + "}");
}
}



