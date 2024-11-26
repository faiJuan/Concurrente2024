package TPO;

public class Main {

  public static void main(String[] args) {
        TrenTuristico recurso=new TrenTuristico();
        Thread [] visitantes=new Thread [17];
        Thread maquinista;
        Maquinista q1=new Maquinista(recurso);
        maquinista=new Thread(q1);
        maquinista.start();

        for (int i = 0; i < visitantes.length; i++) {
            visitantes[i]=new Thread(new Visitante(recurso));
            visitantes[i].start();
        }
    }
}
