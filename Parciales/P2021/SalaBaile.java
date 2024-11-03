package Parciales.P2021;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SalaBaile {
    private int F1listo,F2listo;
    private Lock lock ;
    private Condition F1,F2,listoParaBailar;

    public SalaBaile(){
        this.F1listo=0;
        this.F2listo=0;
        this.lock=new ReentrantLock();
        F1=lock.newCondition();
        F2=lock.newCondition();
        listoParaBailar=lock.newCondition();
    }


    public void entrarf1() {
        lock.lock();
        try {
            while(F1listo>=1){
                F1.await();
            }
            F1listo++;
            if(F2listo==1){
                listoParaBailar.signal();
            }else{
                listoParaBailar.await();
                F1listo=0;
                F2listo=0;
            }
        } catch (Exception e) {
            // TODO: handle exception
        }finally{
            lock.unlock();
        }
    }

    public void entrarf2() {
        lock.lock();
        try {
            while(F2listo>=1){
                F2.await();
            }
            F2listo++;
            if(F1listo==1){
                listoParaBailar.signal();
            }else{
                listoParaBailar.await();
                F1listo=0;
                F2listo=0;
            }
        } catch (Exception e) {
            // TODO: handle exception
        }finally{
            lock.unlock();
        }
    }
}
