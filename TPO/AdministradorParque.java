package TPO;

public class AdministradorParque implements Runnable{
    private ControlParque parque;
    public AdministradorParque (ControlParque unp){
        this.parque=unp;
    }
    public void run(){
        try {
            parque.abrirParque();
            parque.cerrarParque();
            parque.cierreAtracciones(); 
        } catch (Exception e) {
            // TODO: handle exception
        }
        
    }
}
