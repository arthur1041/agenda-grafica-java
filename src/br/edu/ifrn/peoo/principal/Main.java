package br.edu.ifrn.peoo.principal;

import br.edu.ifrn.peoo.excecoes.ContatoJaCadastradoException;
import br.edu.ifrn.peoo.excecoes.ContatoNaoEncontradoException;
import br.edu.ifrn.peoo.excecoes.ParametroVazioException;
import br.edu.ifrn.peoo.logica.Agenda;
import br.edu.ifrn.peoo.logica.IAgenda;
import br.edu.ifrn.peoo.modelo.Pessoa;
import br.edu.ifrn.peoo.modelo.PessoaFisica;
import br.edu.ifrn.peoo.modelo.PessoaJuridica;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        IAgenda agenda = new Agenda();

        while (true) {
            System.out.println("1 - Inserir Contato");
            System.out.println("2 - Remover Contato");
            System.out.println("3 - Buscar Contato");
            System.out.println("4 - Listar Contatos");
            System.out.println("5 - Listar Quantidade de Pessoas Físicas e Pessoas Jurídicas");
            System.out.println("6 - Quantidade de Contatos Cadastrados");
            System.out.println("7 - Sair");
            //System.out.println("1 - Inserir Contato");

            int n = scanner.nextInt();

            if (n == 1) {
                System.out.println("1 - Pessoa Física");
                System.out.println("2 - Pessoa Jurídica");
                int nn = scanner.nextInt();
                if (nn == 1) {
                    System.out.println("Informe os seguintes dados:");
                    System.out.print("Nome: ");
                    String nome = scanner.next();
                    System.out.print("Telefone: ");
                    String telefone = scanner.next();
                    System.out.print("Endereço: ");
                    String endereco = scanner.next();
                    System.out.print("Cidade: ");
                    String cidade = scanner.next();
                    System.out.print("Estado: ");
                    scanner.nextLine();
                    String estado = scanner.nextLine();
                    System.out.print("CPF: ");
                    String cpf = scanner.next();

                    Pessoa pF = new PessoaFisica(nome, telefone, endereco, cidade, estado, cpf);
                    try {
                        agenda.adicionar(pF);
                    } catch (ContatoJaCadastradoException e) {
                        System.out.println(e.getMessage());
                    } catch (ParametroVazioException e) {
                        System.out.println(e.getMessage());
                    }
                }

                if (nn == 2) {
                    System.out.println("Informe os seguintes dados:");
                    System.out.print("Nome: ");
                    String nome = scanner.next();
                    System.out.print("Telefone: ");
                    String telefone = scanner.next();
                    System.out.print("Endereço: ");
                    String endereco = scanner.next();
                    System.out.print("Cidade: ");
                    String cidade = scanner.next();
                    System.out.print("Estado: ");
                    scanner.nextLine();
                    String estado = scanner.nextLine();
                    System.out.print("CNPJ: ");
                    String cnpj = scanner.next();
                    System.out.print("Razao Social: ");
                    String razaoSocial = scanner.next();
                    System.out.print("Nome Fantasia: ");
                    String nomeFantasia = scanner.next();

                    Pessoa pJ = new PessoaJuridica(nome, telefone, endereco, cidade, estado, cnpj, razaoSocial, nomeFantasia);
                    try {
                        agenda.adicionar(pJ);
                    } catch (ContatoJaCadastradoException e) {
                        System.out.println(e.getMessage());
                    } catch (ParametroVazioException e) {
                        System.out.println(e.getMessage());
                    }
                }

            }

            if (n == 2) {
                System.out.println("Digite o nome do contato para remover:");
                try {
                    agenda.remover(scanner.next());
                } catch (ContatoNaoEncontradoException e) {
                    System.out.println(e.getMessage());
                } catch (ParametroVazioException e) {
                    System.out.println(e.getMessage());
                }
            }

            if (n == 3) {
                System.out.println("Digite o nome do contato para buscar:");
                try {
                    agenda.buscar(scanner.next());
                } catch (ContatoNaoEncontradoException e) {
                    System.out.println(e.getMessage());
                } catch (ParametroVazioException e) {
                    System.out.println(e.getMessage());
                }

            }

            if (n == 4) {
                for (Pessoa p : agenda.listarContatos()) {
                    System.out.println(p);
                }
            }

            if (n == 5) {
                System.out.println(agenda.quantidadePessoas());
            }

            if (n == 6) {
                System.out.println("A lista contém " + agenda.quantidade() + " contatos cadastrados.");
            }

            if (n == 7) {
                break;
            }

        }
        scanner.close();
    }
}
