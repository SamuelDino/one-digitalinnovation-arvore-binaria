package one.digitalinovation;

import java.util.Objects;

public class No<T extends Comparable<T>>{
    private T valor;
    private No dir;
    private No esq;

    public No() {
        this.dir = null;
        this.esq = null;
    }
    public No(T valor) {
        this.valor = valor;
        this.dir = null;
        this.esq = null;
    }


    public T getValor() {
        return this.valor;
    }

    public void setValor(T valor) {
        this.valor = valor;
    }

    public No getDir() {
        return dir;
    }

    public void setDir(No dir) {
        this.dir = dir;
    }

    public No getEsq() {
        return esq;
    }

    public void setEsq(No esq) {
        this.esq = esq;
    }

    @Override
    public String toString() {
        return "No{" +
                "valor=" + valor +
                '}';
    }
}
