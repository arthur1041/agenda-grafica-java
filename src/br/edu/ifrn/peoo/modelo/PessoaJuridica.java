package br.edu.ifrn.peoo.modelo;

public class PessoaJuridica extends Pessoa {

    private String cnpj;
    private String razaoSocial;
    private String nomeFantasia;

    public PessoaJuridica() {
    }

    public PessoaJuridica(String nome, String telefone, String endereco, String cidade, String estado, String cnpj, String razaoSocial, String nomeFantasia) {
        super(nome, telefone, endereco, cidade, estado);

        this.cnpj = cnpj;
        this.razaoSocial = razaoSocial;
        this.nomeFantasia = nomeFantasia;
    }

    @Override
    public String toString() {
        return super.toString() + ", cnp: " + cnpj + ", razaoSocial: " + razaoSocial + ", nomeFantasia: " + nomeFantasia;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

}
