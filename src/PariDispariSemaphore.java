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
            conta=conta+2; //viene aggiornata la variabile conta, viene sommato 2 dato che siamo nella stampa relativa ai numeri pari e la variabile conta per i numeri pari è inizializzata a 0, grazie all'if nel costruttore
            semaforoDispari.release(); //viene aumentato il numero dei permessi di semaforoDispari dato che è terminata la stampa del numero pari
            TimeUnit.SECONDS.sleep(1); //attesa di un secondo per rendere l'output più leggibile
        }catch (Exception e){
            System.out.println(e);
        }
    }
    public void stampaNumDispari(){
        try{
            semaforoDispari.acquire(); //viene diminuito il numero di permessi di semaforoDispari
            System.out.println(nome+": "+conta); //stampa del numero, ovvero la variabile conta
            conta=conta+2; //viene aggiornata la variabile conta, viene sommato 2 dato che siamo nella stampa relativa ai numeri pari e la variabile conta per i numeri pari è inizializzata a 0, grazie all'if nel costruttore
            semaforoPari.release(); //viene aumentato il numero dei permessi di semaforoPari dato che è terminata la stampa del numero dispari
            TimeUnit.SECONDS.sleep(1); //attesa di un secondo per rendere l'output più leggibile
        }catch (Exception e){
            System.out.println(e);
        }
    }
}