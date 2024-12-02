package TPO;

public class Parque {
    BarcoPirata barco;
    MontañaRusa montania;
    AutoChocador autosChocadores;
    TrenTuristico tren;

    public Parque (){
        this.barco=new BarcoPirata();
        this.montania=new MontañaRusa();
        this.autosChocadores=new AutoChocador();
        this.tren=new TrenTuristico();
    }

}
