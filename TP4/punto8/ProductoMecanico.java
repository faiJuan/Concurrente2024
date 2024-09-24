package TP4.punto8;

public class ProductoMecanico implements Runnable{
private Produccion recurso;
public ProductoMecanico (Produccion rec){
    this.recurso=rec;
}

public void run (){
   
        try {
            recurso.llegaMecanico();
        } catch (Exception e) {
            // TODO: handle exception
        }
    
}

}
