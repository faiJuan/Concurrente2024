package TPO;

public class Main {

  public static void main(String[] args) {
        ControlParque control=new ControlParque();
        Parque parque=new Parque();
        Thread [] visitantes=new Thread [30];
        Thread admin,encargadoBarco,maquinista;
        admin=new Thread(new AdministradorParque(control));
        //encargadoBarco=new Thread (new EncargadoBarco(parque, control));
        maquinista=new Thread (new Maquinista(parque, control));


        admin.start();
        maquinista.start();
        //encargadoBarco.start();
        for (int i = 0; i < visitantes.length; i++) {
            visitantes[i]=new Thread(new Visitante(control,parque));
            visitantes[i].start();
        }
    }
}




