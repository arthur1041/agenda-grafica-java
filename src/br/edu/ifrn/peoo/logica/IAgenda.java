/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrn.peoo.logica;

import br.edu.ifrn.peoo.excecoes.ContatoJaCadastradoException;
import br.edu.ifrn.peoo.excecoes.ContatoNaoEncontradoException;
import br.edu.ifrn.peoo.excecoes.ParametroVazioException;
import br.edu.ifrn.peoo.modelo.Pessoa;
import java.util.List;

/**
 *
 * @author Arthur Cruz
 */
public interface IAgenda {
    public void adicionar(Pessoa pessoa) throws ContatoJaCadastradoException, ParametroVazioException;
    public Pessoa buscar(String nome) throws ContatoNaoEncontradoException, ParametroVazioException;
    public void remover(String nome) throws ContatoNaoEncontradoException, ParametroVazioException;
    public int quantidade();
    public String quantidadePessoas();
    public List<Pessoa> listarContatos();
}
