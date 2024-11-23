package org.example;

public class ListasEncadeada<T> {

    private No<T> inicio;
    private No<T> ultimo;
    private int tamanho = 0;
    private final int NAO_ENCONTRADO = -1;
    private final String NAO_EXISTE = "Posicao nao existe!";
    public void adiciona (T elemento) {
        //CRIANDO CELULA DE MEMORIA
        No<T> celula  = new No<>(elemento);

        //VERIFICANDO SE A LISTA ESTAR VAZIA
        if (this.tamanho == 0) {
            this.inicio = celula;
        } else {
            //SETAMOS O ULTIMO PARA O PROXIMO ELEMENTO
            this.ultimo.setProximo(celula);
        }
        this.ultimo = celula;
        this.tamanho++;

    }

    private void adicionaInicio (T elemento) {

        if (this.tamanho == 0) {
            No<T> celula = new No<>(elemento);
            this.inicio = celula;
            this.ultimo = celula;
        } else {
            No<T> celula = new No<T>(elemento, this.inicio);
            this.inicio = celula;
        }
      this.tamanho++;
    }

    public void adiciona (int pos, T elemento) {

        if(pos < 0 || pos > this.tamanho) {
            throw new IllegalArgumentException(NAO_EXISTE);
        }

        if (pos == 0) {
            adicionaInicio(elemento);
        } else if (pos == this.tamanho) {
            this.adiciona(elemento);
        } else {//meio
           No<T> noAnterior = this.buscaPosicao(pos);
           No<T> proximoNo = noAnterior.getProximo();
           No<T> novoNo = new No<>(elemento, proximoNo);
           noAnterior.setProximo(novoNo);
           this.tamanho++;
        }

    }

    private boolean posicaoExiste (int posicao) {
        return !(posicao >= 0 && posicao <= this.tamanho);
    }

    public T removerInicio () {

        if (this.tamanho == 0) {
            throw new RuntimeException("A lista estar vazia");
        }
        T removido = this.inicio.getElemento();
        this.inicio = this.inicio.getProximo();
        this.tamanho--;

        if (this.tamanho == 0) {
            this.ultimo = null;
        }

        return removido;
    }

    public T removeFinal () {
        if (this.tamanho == 0) {
            throw  new RuntimeException("Lista esta vaiza");
        }

        if (this.tamanho == 1) {
            return this.removerInicio();
        }

        No<T> penultimoNo =  this.buscaPosicao(this.tamanho - 2);
        T removido = penultimoNo.getProximo().getElemento();
        penultimoNo.setProximo(null);
        this.ultimo = penultimoNo;
        this.tamanho--;

        return removido;
    }

    public void remove (int pos) {

        if (this.posicaoExiste(pos)) {
            throw new IllegalArgumentException(NAO_EXISTE);
        }


        if (pos == 0) {
            removerInicio();
        }
        if (pos == this.tamanho -1) {
            removeFinal();
        }
        No<T> noAnterior = this.buscaPosicao(pos -1);
        No<T> aux = noAnterior.getProximo();
        No<T> proximo = aux.getProximo();
        noAnterior.setProximo(proximo);
        aux.setProximo(null);
        this.tamanho--;
    }

    public void MostrarLista () {

        No<T> aux = this.inicio;

        while (aux != null) {
            System.out.println(aux.getElemento());
            aux = aux.getProximo();
        }
    }

    public void limpar () {
        // laço para percorrer toda a lista, enquanto atual(var auxiliar) nao for nula(contem celulas).
        No<T> atual = this.inicio;
        while (atual != null) {
            No<T> proximo  = atual.getProximo();

            atual.setElemento(null);
            atual.setProximo(null);
            atual = proximo;
        }
        this.inicio = null;
        this.ultimo =  null;
        this.tamanho = 0;
    }
    public int getTamanho (){
        return this.tamanho;
    }

    private No<T> buscaPosicao (int pos) {
        if (!(pos >= 0 && pos <= this.tamanho)) {
            throw new IllegalArgumentException(NAO_EXISTE);
        }

        No<T> atual = this.inicio;
        int posicao = 0;
        while (posicao < pos -1) {
            atual = atual.getProximo();
            posicao++;
        }

        return atual;
    }

    public T busca (int pos) {
        return buscaPosicao(pos).getElemento();
    }

    public T buscaIndice(int index) {
        No<T> atual = this.inicio;
        int contador = 0;

        while (atual != null) {
            if (contador == index) {
                return atual.getElemento();
            }
            atual = atual.getProximo();
            contador++;
        }
        return null;
    }

    public int busca (T elemento) {
        No<T> atual = this.inicio;
        int pos = 0;

        while (atual != null) {

            if (atual.getElemento().equals(elemento)) {
                return pos;
            }
            pos++;
            atual = atual.getProximo();
        }

        return NAO_ENCONTRADO;
    }

    @Override
    public String toString() {
        if (this.tamanho == 0) {
            return "[]";
        }

        StringBuilder builder = new StringBuilder();
        No<T> atual = this.inicio;
        builder.append("[");
        for (int i = 0; i < this.tamanho - 1; i++) {
           builder.append(atual.getElemento()).append(",");
            atual = atual.getProximo();
        }
        builder.append(atual.getElemento()).append("]");
        return builder.toString();
    }
}
