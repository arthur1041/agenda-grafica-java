package br.edu.ifrn.peoo.excecoes;

public class ContatoNaoEncontradoException extends Exception {

    public ContatoNaoEncontradoException() {
        super("Contato não encontrado.");
    }

}
