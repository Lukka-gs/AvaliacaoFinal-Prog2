
// Desconsiderar

//package ORM.View;
//
//import ORM.Actions.*;
//
//import java.util.Scanner;
//
//public class Main {
//
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int opcao = 0;
//
//        do {
//            System.out.println("### Menu ###");
//            System.out.println("1 - Listar alunos");
//            System.out.println("2 - Inserir aluno");
//            System.out.println("3 - Alterar aluno");
//            System.out.println("4 - Remover aluno");
//            System.out.println("5 - Filtrar alunos por nome");
//            System.out.println("0 - Sair");
//            System.out.println("Digite a opção desejada:");
//
//            opcao = Integer.parseInt(scanner.nextLine());
//
//            switch (opcao) {
//                case 1:
//                    ListarAlunos.main(args);
//                    break;
//                case 2:
//                    InserirAluno.main(args);
//                    break;
//                case 3:
//                    AlterarAluno.main(args);
//                    break;
//                case 4:
//                    RemoverAluno.main(args);
//                    break;
//                case 5:
//                    FiltrarAlunosPorNome.main(args);
//                    break;
//                case 0:
//                    System.out.println("Saindo...");
//                    break;
//                default:
//                    System.out.println("Opção inválida. Tente novamente.");
//                    break;
//            }
//
//        } while (opcao != 0);
//
//        scanner.close();
//    }
//}
