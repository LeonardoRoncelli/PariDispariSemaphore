import java.util.concurrent.Semaphore;
public class PariDispariSemaphore {
    //dichiarazione degli attributi della classe
    int conta;
    String nome;
    //creazione dei semafori
    static Semaphore semaforoPari=new Semaphore(1);
    static Semaphore semaforoDispari=new Semaphore(0);
    public PariDispariSemaphore(String nome){ //costruttore della classe
        this.nome=nome;
        if(nome.equalsIgnoreCase("dispari")){ //in questo if viene assegnato il primo valore alla variabile conta, tutto in base al contenuto della variabile nome
            conta=1;
        }else{
            conta=0;
        }
    }
}