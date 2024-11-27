package TPO;

public class Main {

  public static void main(String[] args) {
        BarcoPirata recurso=new BarcoPirata();
        Thread [] visitantes=new Thread [23];
        Thread maquinista;
        EncargadoBarco q1=new EncargadoBarco(recurso);
        maquinista=new Thread(q1);
        maquinista.start();

        for (int i = 0; i < visitantes.length; i++) {
            visitantes[i]=new Thread(new Visitante(recurso));
            visitantes[i].start();
        }
    }
}
