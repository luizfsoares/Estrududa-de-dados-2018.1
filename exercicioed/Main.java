package exercicioed;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.util.Scanner;
 
/**
 * IMPORTANT: 
 *      O nome da classe deve ser "Main" para que a sua solução execute
 *      Class name must be "Main" for your solution to execute
 *      El nombre de la clase debe ser "Main" para que su solución ejecutar
 */
public class Main {
    
    public static int MAX_SIZE = 5;
 
    public static void main(String[] args) throws IOException {
        
        int x;
        int nElemi = 1;
        int nElemp = 1;
        ListaSeq impar = new ListaSeq(MAX_SIZE);
        ListaSeq par = new ListaSeq(MAX_SIZE);
        Scanner scanner = new Scanner(System.in);
        
        for (int i = 0; i < 15; i++){
            x = scanner.nextInt();
            if(x % 2 != 0){ //checa se é impar e adiciona no vetor impar
                impar.inserePos(x, nElemi);
                nElemi++;
                    if(impar.listaCheia() == true){
                        for(int y = 1; y <= MAX_SIZE; y++){
                            System.out.println("impar[" + (y-1) + "] = " + impar.buscaElem(y)); 
                        }
                        impar = new ListaSeq(MAX_SIZE); // esvazia a lista
                        nElemi = 1;
                    }
            }
            else {
                par.inserePos(x, nElemp);
                nElemp++;
                    if (par.listaCheia() == true){
                        for (int y = 1; y <= MAX_SIZE; y++){
                            System.out.println("par[" + (y-1) + "] = " + par.buscaElem(y) );    
                        }
                        par = new ListaSeq(MAX_SIZE); //esvazia a lista
                        nElemp = 1;
                    }
            }
        }
        
        //Imprimir o resto que sobrou
        for (int z = 1; z < nElemi; z++){
            System.out.println("impar[" + (z-1) + "] = " + impar.buscaElem(z));
        }
        for (int z = 1; z < nElemp; z++){
            System.out.println("par[" + (z-1) + "] = " + par.buscaElem(z));
        } 
    }
}

//Classe de Definição para Lista Sequencial com todos os métodos
class ListaSeq {
    private int tamMax;
    private int[] dados;
    private int nElem;
    
    //Construtor 1
    public ListaSeq() {
        
        nElem = 0;
        tamMax = 100;
        dados = new int[tamMax];  
    }
    
    //Construtor 2
    public ListaSeq(int x) { // pode-se ter inumeros construtores desde que tenham parametris diferentes
    
        nElem = 0;
        tamMax = x;
        dados = new int[tamMax];
    }
    
    //Checa se a lista está Vazia
    public boolean listaVazia(){
        
        if (nElem == 0){
            return true;
        }
        else {
            return false;
        }
    }
    
    //Checa se a lista está Cheia
    public boolean listaCheia(){
        
        if(nElem == tamMax){
            return true;
        }
        else{
            return false;
        }
    }
    
    //Recebe uma posição e retorna o conteúdo desta
    public int buscaElem(int pos){
        
        if ((pos <= 0) || (pos > tamMax)){
            return -1;
        }
        
        else {
            return dados[pos-1];
        }
    }
    
    //Recebe um Conteúdo e se pertencer a lista, retorna a posição
    public int elemBusc (int elem){
        
        if (!listaVazia()){
            for (int i=0; i < tamMax; i++){
                if (dados[i] == elem){
                    return i+1;
                }
            }
        }
        return -1;        
    }
    
    //Insere um dado na posição desejada
    public boolean inserePos(int x, int pos){ // retorna true se der certo a inserção e false se não funfionar
    
        if(nElem == tamMax || pos <=0 || pos > nElem+1){  //Lista sequencial nao pode adicionar em qualquer canto, o maximo é no final
            return false;
        }
        
        else {
            for (int i = nElem; i >= pos; i--){
                dados[i] = dados[i-1];
            }
            dados[pos-1] = x;
            nElem++;
            return true;
        }
    }
    
    //Remove um dado da posição desejada
    public int removePos(int pos){ // checar se a posição fornecida é valida
        int x;
        if (pos <= 0 || pos >= nElem){
            return -1;
        }
        
        else{
            x = dados[pos-1]; // para salvar a informação que será retirada
            for (int i = pos-1 ; i < nElem - 1; i++){  // precisa começar no local da posição que quer retirar pois vai sobrescrever
                    dados[i] = dados[i+1];
                }   
            nElem--;
            } 
        return x;
        }
        
    }
    
    
    
    


