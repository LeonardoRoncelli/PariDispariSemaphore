import java.util.concurrent.Semaphore;

public class PariDispariSemaphore {
    int conta;
    static Semaphore semaforoPari=new Semaphore(1);
    static Semaphore semaforoDispari=new Semaphore(0);
    String nome;
    public PariDispariSemaphore(String nome){
        this.nome=nome;
        if(nome.equalsIgnoreCase("dispari")){
            conta=1;
        }else{
            conta=0;
        }
    }
}