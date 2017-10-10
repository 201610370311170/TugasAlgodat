package algodat;

public class DoublyLinkedList extends ExtendedChain {
    
    protected ChainNode previousNode;
    protected ChainNode currentNode;
    
    
    public void clear(){
        firstNode = lastNode = null;
        size = 0;
    }
    
    void checkIndex(int index){
        if(index < 0 || index >= size )
            throw new IndexOutOfBoundsException("FULL");
    }    
    
    public Object get(int index) {
        checkIndex(index);
        
        ChainNode currentNode = firstNode;
        for(int i = 0 ; i < index ; i++){
            currentNode = currentNode.next;
        }
        
        return currentNode.element;
    }

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

    
    public void add(int index , Object theElement){
        
        if(index == 0){
        
            ChainNode newLink = new ChainNode(theElement);
            newLink.next = firstNode;
            
            if(firstNode != null){
                firstNode.prev = newLink;
            }
            else{
                lastNode = newLink;
            }
                firstNode = newLink;
            }
        
        else{
            ChainNode currentNode = firstNode;
            ChainNode newLink = new ChainNode(theElement);
            for(int i = 0 ; i<index-1; i++){
                    currentNode = currentNode.next;
                }
                
                ChainNode temp = currentNode.next;
                
                if(temp != null){
                
                
                newLink.next = temp;
                temp.prev = newLink;
                
                currentNode.next = newLink; 
                newLink.prev = currentNode;
                }
                
                else{
                    
                    lastNode.next = newLink;
                    newLink.prev = lastNode;
                    lastNode = newLink;
                }
                
            }   
        }
    
   public Object remove(int index){
         
       checkIndex(index);
       Object removeElement;
        
        if(index == 0){     //hapus di awal
            removeElement = firstNode.element;
            firstNode = firstNode.next;
            if(firstNode != null){
                firstNode.prev = null;
            }
        
        }
        else{
            
            ChainNode q = firstNode;
            for(int i=0 ; i<index-1; i++){
                q = q.next;
            }
            
            
            if(q.next != null){
                removeElement = q.next.element;
                q.next = q.next.next;
                q.next.next.prev = q;
            }
            
            else{
                removeElement = lastNode;
                lastNode = lastNode.prev;
                lastNode.next = null;
            }
        
        }
        
        size--;
        return removeElement;
    }
        
   
    public static void main(String[] args) {
        
        DoublyLinkedList dl = new DoublyLinkedList();
        dl.add(0, "LASKAR PELANGI");
        dl.add(1, "HARRY POTTER");
        dl.add(2, "OBJEK");
        
        
        dl.currentNode = dl.firstNode;
        for(int i = 0 ; i <=2 ; i++){
            System.out.println("BUKU   : "+dl.currentNode.element);
            dl.currentNode = dl.currentNode.next;
        }
        System.out.println("Buku sebelum OBJEK : "+dl.lastNode.prev.element);
        System.out.println("Buku sebelum HARRY POTTER : "+dl.lastNode.prev.prev.element);
        
        
        
    }
   
   
   
   
}




