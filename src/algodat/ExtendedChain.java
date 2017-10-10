package algodat;

public class ExtendedChain extends Chain implements ExtendedLinearList {

    protected ChainNode lastNode;
    
    public void clear() {
        firstNode = lastNode = null;
        size = 0;
    }

    @Override
    public void append(Object theElement) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void add(Object theElement){
        ChainNode y = new ChainNode(theElement, null);
           
            if(firstNode == null)
                firstNode = lastNode = y;
        
            else{
                lastNode.next = y;
                lastNode = y; 
            }
            size++;
    }
    
    public Object remove(int index){
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
    
    public void add(int index, Object theElement){
        
        if(index < 0 || index > size)
            throw new IndexOutOfBoundsException("FULL ATAU KURANG");
        
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
        }
    }
}
