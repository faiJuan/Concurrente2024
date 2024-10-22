package lectoresEscritores;

public class Main {

    public static void main(String[] args) {
        int le = 10;
        int es = 5;
        int max = 3;
        Thread [] lectores = new Thread[le];
        Thread [] escritores = new Thread[es];
        Libro nuevoLibro = new Libro(max, 100);
 
        for (int i = 0; i < escritores.length; i++) {
            escritores[i] = new Thread(new Escritor(nuevoLibro, "Escritor_"+i));
            escritores[i].start();
        }
 
 
        for (int i = 0; i < lectores.length; i++) {
           lectores[i]= new Thread(new Lector(nuevoLibro, "Lector_"+i));
           lectores[i].start();
        }
 
 
        
     }  
 
     }


