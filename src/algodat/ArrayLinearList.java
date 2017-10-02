package algodat;

public class ArrayLinearList implements LinearList, Cloneable {
        
    
    protected Object[] element , element2 ;    
    protected int size; 
    
    //element.length ------ >>>>> UKURAN ARRAY 
    //size ---------------- >>>>> Jumlah Array yang terisi 
    
    public ArrayLinearList(int initialCapacity){
        
        if(initialCapacity < 1){
            throw new IllegalArgumentException("Initial Capacity harus >= 1");
        }
         element = new Object[initialCapacity];    // meinisialisasikan ukuran awal array 
    }
    
    public ArrayLinearList(){
        //pasang ukuran default menjadi 10 
        this(10);
    }
    
    @Override
    public boolean isEmpty() {
     return size == 0;
    }    
  
    
    @Override
    public int size() {
       return size;
    }

    void checkIndex(int index){
     //cek ukuran index 
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException ("index = " + index + " size = " + size);
        }
    }
    
    @Override
    public Object get(int index) {
        
        checkIndex(index);
        return element[index];
    }

    @Override
    public int indexOf(Object theElement) {
        for(int i = 0 ; i < size ; i++)
            if(element[i].equals(theElement))
                return i;       //kalo ketemu , bakalan balikin nilai index nya 
            return -1;          //kalo ga ada , bakalan balikin nilai 'false'
    }

    @Override
    public Object remove(int index) {
        
        checkIndex(index);
        
        Object removedElement = element[index];
        for(int i = index + 1 ; 1 < size ; i++)
            element[i-1] = element[i];
        
        element[--size] = null; //enable garbage collection 
        return removedElement;
    }
    
    

    @Override
    public void add(int index, Object theElement) {
     
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException ("Index = " + index + " size = " + size );
        }
        
        if(size == element.length){
            element = ChangeArrayLength.changeLength1D(element, 2 * size);
        }
   
        for(int i = size - 1 ; i >= index; i--){
            element[i + 1] = element[i]; 
        }
        
        element[index] = theElement;
        size++;
    }
   
    public void trimToSize(){
        element2 = new Object[size];
         if (size < element.length) {
           System.arraycopy(element, 0, element2, 0, size);
                 
           element = element2;
        }
    }
    
    
    public Object setSize(int newSize){
        
        
        if(size < newSize){
            element2 = new Object[newSize];
            System.arraycopy(element, 0, element2, 0, size);
            element = element2;
        }
        
        else if(size > newSize){
            int index = size - newSize;
            Object removedElement = element[index];
            
            for(int i=0; i<index;i++){
                for(int j = index + 1; j < size; j++)
                element[j-1] = element[j];

            element[--size] = null;
            }
            return removedElement;
        }
        return size;
    }
    
    public Object clear(){
        for(int i = 0; i<size; i++){
            element[i] = null;
        }
        return size;
    }
     
    public String toString(){
         StringBuffer s = new StringBuffer("[");
        
        // taruh element ke buffer
        for (int i = 0; i < size; i++)
            if (element[i] == null)
                s.append("null, ");
            else 
                s.append(element[i].toString() + ", ");
        if (size > 0)
            s.delete(s.length() - 2, s.length());
        s.append("]");
        
        // buat string yang setara/ equilvalent
        return new String(s);
                    
    } 
     
    public Object[] clone(){ 
      
        Object[] element2 = element; 
        
        for(int i = 0 ; i < element.length ; i++){
           System.out.print(element2[i] + " ");
        }  
        return element2;
    }   
    
    
    public void removeRange(int awalIndex, int akhirIndex){
        
        checkIndex(awalIndex);
        checkIndex(akhirIndex);
        
        for(int i = awalIndex ; i <= akhirIndex ; i++ ){
            element[i] = null;
        }
    }
     
     
     
    public static void main(String[] args) throws CloneNotSupportedException {
         ArrayLinearList a = new ArrayLinearList(5); // contructor dengan initial capacity 5
        //nambahin isi ke dalam masing2 index 
        a.add(0, 1);
        a.add(1, 2);
        a.add(2, 4);
        a.add(3, 8);
        a.add(4, 5);
        
        System.out.print("Isi Array : [ ");
        for(int i = 0 ; i < a.size ; i++){
            System.out.print(a.element[i]+" ");
        }
        
        System.out.print("]");
        System.out.println("");
        
        System.out.println("Remove element from index 1 - index 3 ");
        a.removeRange(1, 3);
        System.out.println("Isi array setelah d remove element ");
        
        System.out.print("Isi Array : [ ");
        for(int i = 0 ; i < a.size ; i++){
            System.out.print(a.element[i]+" ");
        }
        
        System.out.print("]");
        
        //clone
        System.out.println("");
        System.out.println(a.clone());
        
        System.out.println("Ukuran awal Array adalah : " +a.element.length);
        System.out.println("Array yang terisi : "+a.size());
        
        //nge set ukuran baru
        a.setSize(12);
        System.out.println("Ukuran setelah setSize Array adalah : " +a.element.length);
       
        
        //to String 
        System.out.println("Array dalam bentuk String : "+a.toString());
        
        
        //trimToSize
        System.out.println("sebelum dipotong "+a.element.length);
        a.trimToSize();
        System.out.println("setelah dipotong "+a.element2.length);
        
    }
}
    

    

    
  
