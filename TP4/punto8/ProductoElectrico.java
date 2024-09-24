package TP4.punto8;

public class ProductoElectrico implements Runnable{
    private Produccion recurso;

    public ProductoElectrico (Produccion rec){
        this.recurso=rec;
    }
    

    public void run (){
        try {
            recurso.llegaElectrico();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
