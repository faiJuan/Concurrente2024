package lectoresEscritores;

public class Lector implements Runnable{


    private Libro libro;
    private String nombre;
    public Lector (Libro unL, String n){
        libro=unL;
        nombre=n;

    }
 
 
    @Override
    public void run() {
        try{
            libro.empezarLeer(nombre);
            Thread.sleep(1000);//simula que lee
            libro.terminarLeer(nombre);
        } catch(InterruptedException e){
            System.out.println("Fallo");
        }
    }
 }
 