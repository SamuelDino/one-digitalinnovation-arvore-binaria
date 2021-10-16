package one.digitalinovation;

import java.util.*;

public class Arvore<T extends Comparable<T>>{

    private No<T> raiz;

    public Arvore() {
        this.raiz = null;
    }

    public Arvore(T valor) {
        this.raiz = new No(valor);
    }

    public boolean isNull(){
        return (raiz==null ? true : false);
    }

    public void removeNo(T valor){ // remove o nó e todos seus filhos...

        HashMap<String, No<T>> nosPaieFilho = new HashMap<String, No<T>>();

        nosPaieFilho.put("pai",null);
        nosPaieFilho.put("filho",null);

        nosPaieFilho=localizaNo(raiz, valor, nosPaieFilho);
        if (nosPaieFilho.get("pai").getDir().getValor()==valor){
            nosPaieFilho.get("pai").setDir(null);
        }
        else{
            nosPaieFilho.get("pai").setEsq(null);
        }

    }

    private HashMap<String, No<T>> localizaNo(No<T> noAtual,T valor,HashMap<String, No<T>> nosPaieFilho){

        nosPaieFilho.put("pai",noAtual);

        if (noAtual.getValor().compareTo(valor) > 0) {
            if (noAtual.getEsq()!=null){
                nosPaieFilho.put("filho",noAtual.getEsq());
                if (noAtual.getEsq().getValor().compareTo(valor) != 0){
                    localizaNo(noAtual.getEsq(), valor, nosPaieFilho);
                }
            }
        }
        else{
            if (noAtual.getValor().compareTo(valor) < 0) {
                if (noAtual.getDir() != null) {
                    nosPaieFilho.put("filho",noAtual.getDir());
                    if (noAtual.getDir().getValor().compareTo(valor) != 0){
                        localizaNo(noAtual.getDir(), valor, nosPaieFilho);
                    }
                }
            }
        }
        return nosPaieFilho;
    }

    public void addNo(T valor){
        No<T> novoNo = new No<>(valor);
        if (this.isNull()){
            this.raiz = novoNo;
        }
        else{
            addNovoNo(raiz, novoNo);
        }
    }

    private void addNovoNo(No<T> noAtual, No<T> novoNo){

        if (novoNo.getValor().compareTo(noAtual.getValor()) > 0) {
            if (noAtual.getDir()!=null){
                addNovoNo(noAtual.getDir(), novoNo);
            }
            else{
                noAtual.setDir(novoNo);
            }
        }
        else{
            if (novoNo.getValor().compareTo(noAtual.getValor()) < 0) {
                if (noAtual.getEsq() != null) {
                    addNovoNo(noAtual.getEsq(), novoNo);
                }
                else {
                    noAtual.setEsq(novoNo);
                }
            }
            else{
               // throw new RuntimeException("Já existe nó com esse valor...");
            }
        }


    }

    private String noToString(No<T> noAtual){
        String noToString = " ==>> { No--> [" + noAtual.getValor() + "] "+"--> dir--> "+noAtual.getDir()+"--> esq--> "+noAtual.getEsq()+" }";
        if (noAtual.getDir()!=null){
            noToString += noToString(noAtual.getDir());
        }
        if (noAtual.getEsq()!=null){
            noToString += noToString(noAtual.getEsq());
        }
        return noToString;
    }

    private String arvoreToString(){
        String arvore = "Raiz--->"+noToString(raiz);

        return arvore;
    }

    @Override
    public String toString() {
        return "Arvore-->>" +arvoreToString();
    }

}
