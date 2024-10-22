package lectoresEscritores;

public class Escritor implements Runnable {


    private final Libro libro;
    private String nombre;
 
    public Escritor(Libro unL, String n) {
        libro = unL;
        nombre=n;
    }
 
 
    @Override
    public void run() {
        try {
            int cantPag = 0;
            int aux = 0;
            //empezar a escribir
            libro.empezarEscribir(nombre);
            //escribe
            aux =  (int) (Math.random() * 500 + 500);
            Thread.sleep(1000);   //tiempo escribiendo entre 500 y 1000
            //terminar de escribir
            cantPag = aux / 500;   // si aux<1000, escribe 1 pag, sino escribe 2.
            libro.terminarEscribir(cantPag,nombre);
        } catch (InterruptedException e) {
 
 
        }
    }
 }
 