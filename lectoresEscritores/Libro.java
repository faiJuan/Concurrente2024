package lectoresEscritores;

import java.util.concurrent.Semaphore;

public class Libro {
    private int nLectores,nEscritores, cantPagEscritas,totalPag;
    private Semaphore mutex1,/*mutex2,*/lectores,escritores;
 
 
    public Libro (int maxL, int totalPaginas){
        mutex1 = new Semaphore(1);
        //mutex2 = new Semaphore(1);
        lectores = new Semaphore(maxL);
        escritores = new Semaphore(1);
        this.nLectores = 0;
        this.nEscritores = 0;
        this.totalPag = totalPaginas;
    }
 
 
    public void empezarLeer(String nn) throws InterruptedException{
        lectores.acquire();
        mutex1.acquire();
        nLectores++;
        if (nLectores==1){
            escritores.acquire();
        }
        System.out.println("Empieza a Leer "+ nn);
        mutex1.release();
        
    }
 
 
    public void terminarLeer(String nn) throws InterruptedException{
        mutex1.acquire();
        nLectores--;
        System.out.println("Termina de Leer " + nn);
        if (nLectores==0){
            
            escritores.release();
        }
        lectores.release();
        mutex1.release();
    }
 
 
    public void empezarEscribir(String nn) throws InterruptedException{
        mutex1.acquire();
        escritores.acquire();//mutex2.acquire();
        System.out.println("Empieza a Escribir " + nn);
        nEscritores++;
        //if (nEscritores==1){
            
            //lectores.acquire();
        //}
        //mutex2.release();
        //escritores.release();
        //mutex1.release();
    }
 
 
    public void terminarEscribir(int nuevasPag, String nn) throws InterruptedException{
        
        //mutex2.acquire();
        nEscritores--;
        cantPagEscritas += nuevasPag;
        System.out.println("Termina de Escribir " + nn + ". Escribio " + nuevasPag + " paginas.");
        //if (nEscritores==0){
            
            //lectores.release();
       // }
        escritores.release();
        //mutex2.release();
        mutex1.release();
    }}
 