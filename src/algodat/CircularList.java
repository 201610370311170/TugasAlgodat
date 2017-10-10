package algodat;

import java.time.temporal.TemporalAdjusters;

public class CircularList extends Chain implements ExtendedLinearList{

   protected ChainNode lastNode;
   protected ChainNode currentNode;
    
    @Override
    public void clear() {
        firstNode = lastNode = null;
        size = 0;
    }

    @Override
    public void append(Object theElement) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    public boolean isEmpty(){
        return size == 0 ; 
    }
    
    public int size(){
        return size;
    }

    void checkIndex(int index){
        if(index < 0 || index >= size )
            throw new IndexOutOfBoundsException("FULL atau KURANG");
    }
    
    @Override
    public Object get(int index) {
        checkIndex(index);
        
        ChainNode currentNode = firstNode;
        for(int i = 0 ; i < index ; i++){
            currentNode = currentNode.next;
        }
        
        return currentNode.element;
    }

    @Override
    public int indexOf(Object theElement) {
        
         ChainNode currentNode = firstNode;
         int index = 0 ;
         while(currentNode != null && !currentNode.element.equals(theElement)){
             currentNode = currentNode.next;
             index++;
         }
         if(currentNode == null){
             return -1;
         }else{
             return index;
         }
        
    }

    @Override
    public Object remove(int index) {
        
        checkIndex(index);
        Object removeElement;
        
        if(index == 0){
            removeElement = firstNode.element;
            firstNode = firstNode.next;
        }
        else{
            ChainNode q = firstNode;
            for(int i=0 ; i<index-1; i++){
                q = q.next;
            }
            removeElement = q.next.element;
            q.next = q.next.next;
        }
        size--;
        return removeElement;
    }

    @Override
    public void add(int index, Object theElement) {
        
        //if(index < 0 || index > size)
        //    throw new IndexOutOfBoundsException("FULL ATAU KURANG");
        
        if(index == 0){
            firstNode = new ChainNode(theElement, firstNode);
            
        }
        else{
            ChainNode p = firstNode;
            for(int i = 0 ; i<index-1; i++){
                p = p.next;
            }
            p.next = new ChainNode(theElement, p.next);
            size++;
            
            for(int i = index+1 ; i<=size; i++){
               p = p.next;
               if(p.next == null){
                   p.next = firstNode;
               }
            }
        
        }
        
        
    
    }
    
    public String toString(){
        StringBuffer s = new StringBuffer("[");
        
        ChainNode currentNode = firstNode;
        while(currentNode != null){
            if(currentNode.element == null){
                s.append("null, ");
            }
            else{
                s.append(currentNode.element.toString()+ ", ");
            }
            currentNode = currentNode.next;
        }
        
        if(size > 0)
            s.delete(s.length() - 2, s.length());
        s.append("]");
        
        return new String(s);
    }
    
    
    public static void main(String[] args) {
        
        
        CircularList cl = new CircularList();
        cl.clear();
        cl.add(0, 32);
        cl.add(1, 321);
        
        cl.add(2, 3121);
        cl.add(3, 21);
        cl.add(4, 211);
        cl.add(2, 122);
        System.out.println(cl.size);
        
        System.out.print(cl.firstNode.element+ " ---> " );
        cl.currentNode = cl.firstNode.next;
        for(int i=0; i<cl.size; i++){
            System.out.print(cl.currentNode.next.element+" ---> ");
            cl.currentNode = cl.currentNode.next;
            
            if(cl.currentNode.next == null){
                cl.currentNode.next = cl.firstNode;
            }
        }
        System.out.println("");
        
        
    }
}
