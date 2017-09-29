package algodat;

import java.lang.reflect.Array;

public class ChangeLength2D {
    
    public static Object [][] changeLength2D(Object[][] matriks , int baris, int kolom, int newBaris, int newKolom){
        
        if(baris > newBaris || kolom > newKolom){
            throw new IllegalArgumentException("Baris atau Kolom lebih kecil dari ukuran sebelumnya");
        }
        
        Object[][] newMatriks = (Object [][]) Array.newInstance(matriks.getClass().getComponentType(), 2);
        
        //copyarray
        System.arraycopy(matriks, kolom, newMatriks, newKolom, kolom);
        System.arraycopy(matriks, baris, newMatriks, newBaris, baris);
       
        return newMatriks;
    }
    
     public static Object[][] changeLength2D(Object[][] matriks , int newBaris, int newKolom){
        return changeLength2D(matriks, matriks.length, matriks[0].length, newBaris, newKolom);
    }


    public static void main(String[] args) {
        
        Object[][] matriks2D = new Object[2][2];
        matriks2D[0][0] = 1;
        matriks2D[0][1] = 5;
        matriks2D[1][0] = 7;
        matriks2D[1][1] = 8;
        
        
        ChangeLength2D c = new ChangeLength2D();
        c.changeLength2D(matriks2D, 5, 5);
        
        
       // ChangeLength2D a = new ChangeLength2D(changeLength2D(changeLength2D(matriks2D, 0, 0, 0, 0)));
        
    }
    
}



