package br.edu.ifrn.peoo.modelo;

public class PessoaFisica extends Pessoa {

    private String cpf;

    public PessoaFisica(){
        
    }

    public PessoaFisica(String nome, String telefone, String endereco, String cidade, String estado, String cpf) {
        super(nome, telefone, endereco, cidade, estado);

        this.cpf = cpf;
    }
    
    @Override
    public String toString() {
        return super.toString() + ", Cpf: " + cpf;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

}
