import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

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
    public void stampaNumPari(){
        try{
            semaforoPari.acquire(); //viene diminuito il numero di permessi di semaforoPari
            System.out.println(nome+": "+conta); //stampa del numero, ovvero la variabile conta
            conta=conta+2; //viene aggiornata la variabile conta, in questo caso viene sommato 2 dato che siamo nella stampa relativa ai numeri pari
            semaforoDispari.release(); //viene aumentato il numero dei permessi di semaforoDispari dato che è terminata la stampa del numero pari
            TimeUnit.SECONDS.sleep(1); //attesa di un secondo per rendere l'output più leggibile
        }catch (Exception e){
            System.out.println(e);
        }
    }
}