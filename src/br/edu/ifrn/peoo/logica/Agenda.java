package br.edu.ifrn.peoo.logica;

import br.edu.ifrn.peoo.excecoes.ContatoJaCadastradoException;
import br.edu.ifrn.peoo.excecoes.ContatoNaoEncontradoException;
import br.edu.ifrn.peoo.excecoes.ParametroVazioException;
import br.edu.ifrn.peoo.modelo.Pessoa;
import br.edu.ifrn.peoo.modelo.PessoaFisica;
import br.edu.ifrn.peoo.modelo.PessoaJuridica;
import br.edu.ifrn.peoo.persistencia.Persistencia;
import java.util.ArrayList;
import java.util.List;

public class Agenda implements IAgenda {

    private List<Pessoa> listaContatos;

    public Agenda() {
        listaContatos = Persistencia.getListFromXML();
    }

    @Override
    public void adicionar(Pessoa pessoa) throws ContatoJaCadastradoException, ParametroVazioException {
        if (pessoa == null) {
            throw new ParametroVazioException();
        }
        for (Pessoa p : listaContatos) {
            if (p instanceof PessoaFisica && pessoa instanceof PessoaFisica) {
                PessoaFisica pF = (PessoaFisica) p;
                PessoaFisica pessoaFisica = (PessoaFisica) pessoa;
                if (pF.getCpf().equals(pessoaFisica.getCpf())) {
                    throw new ContatoJaCadastradoException("Usuário com CPF " + pF.getCpf() + " já existente");
                }
            }
            if (p instanceof PessoaJuridica && pessoa instanceof PessoaJuridica) {
                PessoaJuridica pJ = (PessoaJuridica) p;
                PessoaJuridica pessoaJuridica = (PessoaJuridica) pessoa;
                if (pJ.getCnpj().equals(pessoaJuridica.getCnpj())) {
                    throw new ContatoJaCadastradoException("Usuário com CNPJ " + pJ.getCnpj() + " já existente");
                }
            }
        }
        listaContatos.add(pessoa);
        Persistencia.convertListToXML(listarContatos());
    }

    @Override
    public Pessoa buscar(String nome) throws ContatoNaoEncontradoException, ParametroVazioException {
        if (nome == null) {
            throw new ParametroVazioException();
        }
        for (Pessoa p : listaContatos) {
            if (p.getNome().equals(nome)) {
                return p;
            }
        }
        throw new ContatoNaoEncontradoException();
    }

    @Override
    public void remover(String nome) throws ContatoNaoEncontradoException, ParametroVazioException {
        listaContatos.remove(buscar(nome));
        Persistencia.convertListToXML(listarContatos());
    }

    @Override
    public int quantidade() {
        return listaContatos.size();
    }

    @Override
    public String quantidadePessoas() {
        int qPF = 0;
        int qPJ = 0;
        for (Pessoa p : listaContatos) {
            if (p instanceof PessoaFisica) {
                qPF++;
            }
            if (p instanceof PessoaJuridica) {
                qPJ++;
            }
        }
        return "Existem " + qPF + " Pessoas Físicas e "+qPJ+" Pessoas Jurídicas";
    }

    @Override
    public List<Pessoa> listarContatos() {
        return listaContatos;
    }

//    public void setListaContatos(List<Pessoa> listaContatos){
//        this.listaContatos = listaContatos;
//    }
}
