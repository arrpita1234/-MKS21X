import java.util.*;
    
public class SuperArray implements Iterable<String>{
      private String[] data;
      private int size;

      //0
      //constructor make an empty superArray should make size 0, 
      //but the data capacity 10.
        
      public SuperArray(){
          data = new String[10];
          size = 0;
      }
    
      public SuperArray(int initialCapacity){
        if(initialCapacity < 0){
          throw new IllegalArgumentException("Construct: Please keep initialCapacity above or equal to 0"); 
      }
        else{
          data = new String[initialCapacity];
          size = 0;
        }
      }
        
      public Iterator<String> iterator(){
	  return new SuperArrayIterator(0, this);   
      }
    

          public  class SuperArrayIterator implements Iterator<String> {
            private int start;
            private SuperArray n;
    
            public SuperArrayIterator(int start, SuperArray n){
                this.start = start;
                this.n = n;
        
            }
    
            public boolean hasNext(){
                return start < n.size();
            }
    
            public String next(){
                if(hasNext()){
                    start ++;
                    return (n.get(start -1));
                }
	           else{
                    throw new NoSuchElementException("Reached end of SuperArray");
                    }
                }
    
          public void remove(){
              throw new UnsupportedOperationException();
            }
        }




     //returns the # of elements in array
      public int size(){
        return size;
      }

      public String get(int index){
          if(index < 0 || index >= size()){
          throw new IndexOutOfBoundsException("Get: Please keep index within 0 and size inclusive"); 
      }
          else{
          return data[index];
          }
      }

      //1
    /**add the value n to the next available slot in the superArray.
     *this will change the size. This function should always work
     *And will resize the SuperArray if needed.*/
      public boolean add(String n){
        if(size() < data.length){
            data[size()] = n;
            size += 1;
        }
        else{
            grow();
            data[size()] = n;
            size += 1;
        }
        return true;
      }

      //2
    /**Resize the data, by making a new array, then copying over elements, use this as your data.
    */

      private void grow(){
        String[] temp = new String[data.length * 2 + 1];
        for(int i = 0; i < data.length; i++){
            temp[i] = data[i];
        }
        data = temp;
      }

      //3
       /**format the super array like this :   [ 1, 3, 6, 8, 23, 99, -4, 5] 
        *commas between... square bracket start/end and no comma at end.*/
      public String toString(){
          String f = "[ ";
          for (int i = 0; i < size; i++){
              f += data[i];
              if(i < size - 1) {f += ", ";}
          }
          f += "]";
          return f;
      }

      //4
        /**format the super array like this :   [ 1, 8, 23, 99, -4, 5, _, _, _, _]   
        *(capacity is 10, but only 6 are used)
        *commas between... square bracket start/end and no comma at end.
        *unused slots should be printed as _ (underscores) */
      public String toStringDebug(){
          String f = "[ ";
          for (int i = 0; i < size(); i++){
              f += data[i];
              f += ", ";
          }
          for (int i = size; i < data.length; i++){f += "_, ";}
          f = f.substring(0, f.length() - 2);
          f += "]";
          return f;
     }
        
      /**Removes the index in parameter and returns removed element.
        */
      public String remove(int index){
          String returned = data[index];
          if (index < 0 || index >= size()){
              throw new IndexOutOfBoundsException("Remove: Please keep index within 0 inclusive and size exclusive");
          }
          else{
            String[] temp = new String[data.length];
            for(int i = 0; i < index; i++){
                  temp[i] = data[i];
              }
            for(int i = index; i + 1< data.length; i++){
                temp[i] = data[i + 1];
            }
            data = temp;
            size -= 1;
            return returned;
        }
      }

      public int getLength() {return data.length;}
    
      public void clear() { size = 0;}
    
      public boolean isEmpty() { return (size == 0); }
        
      public String set(int index, String element) {
          String returned = data[index];
          data[index] = element;
          return returned;
      }
      
        
    
      public void add(int index, String element){
          if (index < 0 || index > size()){
              throw new IndexOutOfBoundsException("Add: Please keep index within 0 and size inclusive");
          }
          else{
          if(size == data.length) {this.grow();}
          else{
            String[] temp = new String[data.length];
            for(int i = 0; i < index; i++){
                  temp[i] = data[i];
              }
            for(int i = index; i + 1< data.length; i++){
                temp[i + 1] = data[i];
            }
            temp[index] = element;
            data = temp;
            size += 1;
      }
    }
      }
      public String[] toArray(){
          String[] temp = new String[size()];
          for(int i = 0; i < size; i++){
              temp[i] = data[i];
          }
          return temp;
      }
      
      public int indexOf(String i){
        for(int x = 0; x < data.length; x++){
            if (data[x].equals(i)) 
            {
                return x;
            }
        }
        return -1;
      }
    
      public int lastIndexOf(String i){
        int last = -1;
        for(int x = 0; x < data.length; x++){
            if (data[x].equals(i)) {last = x;}
        }
        return last;
      }
          

    }