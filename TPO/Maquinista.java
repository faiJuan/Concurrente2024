package TPO;

public class Maquinista implements Runnable{
    private TrenTuristico tren;
    public Maquinista(TrenTuristico unTren) {
        this.tren=unTren;
    }

    public void run(){
        try {
            while (true) {
                tren.empezarViaje();
            }
            
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
