package TP6.punto2;

public class Estudiante implements Runnable{
    private SalaEstudio sala;
    private int turno;

    public Estudiante (SalaEstudio unaSala){
        this.sala=unaSala;
    }

    public void run (){
        try {
            sala.usarMesa();
            Thread.sleep(2000);
            sala.dejarMesa();
            
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

}
