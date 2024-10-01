package TP5.punto3;

public class GestorComedor implements Runnable{
    private Comedor comedor;
    public GestorComedor (Comedor unCom){
        this.comedor=unCom;
    }

    public void run() {
        while(true){
            try{
                comedor.controlarComedor();
            } catch (Exception e){
    
            }
        }
    }
}
