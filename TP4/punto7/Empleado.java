package TP4.punto7;

public class Empleado implements Runnable{
    private Silla recurso;
    public Empleado (Silla rec){
        this.recurso=rec;
    }

    public void run (){
        try {
            recurso.sentarseComer();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
