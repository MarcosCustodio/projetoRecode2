package com.spacetur.aplicacao;

import java.time.LocalDate;
import java.util.Scanner;
import com.spacetur.dao.UsuarioDAO;
import com.spacetur.dao.DestinoDAO;
import com.spacetur.model.Usuario;
import com.spacetur.model.Destino;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Menu Principal:");
            System.out.println("1 - Gerenciar Usuários");
            System.out.println("2 - Gerenciar Destinos");
            System.out.println("3 - Sair");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    gerenciarUsuarios();
                    break;

                case 2:
                    gerenciarDestinos();
                    break;

                case 3:
                    System.out.println("Saindo do programa.");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
                    break;
            }
        }
    }

    public static void gerenciarUsuarios() {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Menu de Usuários:");
            System.out.println("1 - Cadastrar usuário");
            System.out.println("2 - Atualizar usuário");
            System.out.println("3 - Excluir usuário");
            System.out.println("4 - Listar usuários");
            System.out.println("5 - Voltar ao menu principal");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    Usuario usuario = new Usuario();
                    System.out.print("Nome: ");
                    usuario.setNome_usuario(scanner.next());
                    System.out.print("CPF: ");
                    usuario.setCpf_usuario(scanner.nextInt());
                    System.out.print("Email: ");
                    usuario.setEmail_usuario(scanner.next());
                    System.out.print("Senha: ");
                    usuario.setSenha_usuario(scanner.nextInt());
                    System.out.print("Telefone: ");
                    usuario.setTelefone_usuario(scanner.nextInt());
                    usuarioDAO.save(usuario);
                    break;

                case 2:
                    Usuario c1 = new Usuario();
                    System.out.print("Digite o ID do usuário a ser atualizado: ");
                    int userIdToUpdate = scanner.nextInt();
                    c1.setId(userIdToUpdate);
                    System.out.print("Novo nome: ");
                    c1.setNome_usuario(scanner.next());
                    scanner.nextLine();
                    System.out.print("Novo CPF: ");
                    c1.setCpf_usuario(scanner.nextInt());
                    System.out.print("Novo email: ");
                    c1.setEmail_usuario(scanner.next());
                    System.out.print("Nova senha: ");
                    c1.setSenha_usuario(scanner.nextInt());
                    System.out.print("Novo telefone: ");
                    c1.setTelefone_usuario(scanner.nextInt());
                    usuarioDAO.update(c1);
                    break;

                case 3:
                    System.out.print("Digite o ID do usuário a ser excluído: ");
                    int userIdToDelete = scanner.nextInt();
                    usuarioDAO.deletebyID(userIdToDelete);
                    System.out.println ("Usuário excluído com sucesso!");
                    break;

                case 4:
                    for (Usuario c : usuarioDAO.getUsuarios()) {
                        System.out.println("Usuário: " + c.getNome_usuario());
                    }
                    break;

                case 5:
                    return;

                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
                    break;
            }
        }
    }

    public static void gerenciarDestinos() {
        DestinoDAO destinoDAO = new DestinoDAO();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Menu de Destinos:");
            System.out.println("1 - Cadastrar destino");
            System.out.println("2 - Atualizar destino");
            System.out.println("3 - Excluir valor dos destinos");
            System.out.println("4 - Listar valor dos destinos");
            System.out.println("5 - Voltar ao menu principal");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    Destino destino = new Destino();
                    System.out.print("Valor: ");
                    destino.setValor(scanner.nextDouble());
                    LocalDate dateIda = LocalDate.of(2023, 11, 10);
                    destino.setData_ida(dateIda);
                    LocalDate dateVolta = LocalDate.of(2023, 11, 20);
                    destino.setData_volta(dateVolta);
                    // Preencha as outras informações do destino
                    destinoDAO.save(destino);
                    break;

                case 2:
                	Destino destinoUpdate = new Destino();
                    System.out.print("Digite o ID do destino a ser atualizado: ");
                    int destinoIdToUpdate = scanner.nextInt();
                    destinoUpdate.setId(destinoIdToUpdate);
                    System.out.print("Novo valor: ");
                    destinoUpdate.setValor(scanner.nextDouble());
                    
                    // Preencha as outras informações do destino
                    destinoDAO.update(destinoUpdate);
                    System.out.println ("Valor atualizado com sucesso!");
                    break;

                case 3:
                    System.out.print("Digite o ID do destino a ser excluído: ");
                    int destinoIdToDelete = scanner.nextInt();
                    destinoDAO.deletebyID(destinoIdToDelete);
                    System.out.print ("Destino excluído com sucesso!");
                    break;

                case 4:
                    for (Destino c : destinoDAO.getDestinos()) {
                        System.out.println("Destino: " + c.getValor());
                    }
                    break;

                case 5:
                    return;

                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
                    break;
            }
        }
    }
}
