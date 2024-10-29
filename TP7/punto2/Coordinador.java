package TP7.punto2;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class Coordinador {
    private Lock lock;
    private int cantL,cantPC,librosEnUso,pcEnUso;
    Condition libros,computadoras;

    public Coordinador(int unL, int pcs){
        lock= new ReentrantLock(true);
        computadoras=lock.newCondition();
        libros=lock.newCondition();
        cantL=unL;
        cantPC=pcs;
        librosEnUso=0;
        pcEnUso=0;
        
    }

    public void usarLibro(){
        lock.lock();
        try {
            while(librosEnUso>=cantL){
                libros.await();
            }
            librosEnUso++;
            System.out.println(Thread.currentThread().getName()+"tiene un libro");

        } catch (Exception e) {
        
        }finally{
            lock.unlock();
        }
    }

    public void usarPC(){
        lock.lock();
        try {
            while(pcEnUso>=cantPC){
                computadoras.await();
            }
            pcEnUso++;
            System.out.println(Thread.currentThread().getName()+"tiene una pc");
            
        } catch (Exception e) {
        
        }finally{
            lock.unlock();
        }
    }

    public void dejarLibro (){
        lock.lock();
        System.out.println(Thread.currentThread().getName()+"dejo un libro");
        librosEnUso--;
        libros.signal();
        lock.unlock();
    }

    public void dejarPC(){
        lock.lock();
        System.out.println(Thread.currentThread().getName()+"dejo una pc");
        pcEnUso--;
        computadoras.signal();
        lock.unlock();
    }

}
