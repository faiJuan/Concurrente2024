package TP6.punto2;

public class Estudiante implements Runnable{
    private SalaEstudio sala;

    public Estudiante (SalaEstudio unaSala){
        this.sala=unaSala;
    }

    public void run (){
        try {
            sala.usarMesa();
            
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

}
