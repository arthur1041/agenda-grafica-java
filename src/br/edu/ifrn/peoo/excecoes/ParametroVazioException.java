package br.edu.ifrn.peoo.excecoes;

public class ParametroVazioException extends Exception{

    public ParametroVazioException() {
        super("Parametro vazio! Preencha todos os campos para poder cadastrar uma pessoa.");
    }
    
}
