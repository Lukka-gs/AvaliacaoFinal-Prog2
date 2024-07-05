package ORM.Actions;

import ORM.Model.alunos;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Calendar;
import java.util.Scanner;

public class AlterarAluno {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o ID do aluno a ser alterado: ");
        Long id = Long.parseLong(scanner.nextLine());

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("escola");
        EntityManager manager = factory.createEntityManager();

        alunos alunos = manager.find(ORM.Model.alunos.class, id);

        if (alunos != null) {
            System.out.println("Novo Nome: ");
            alunos.setNome(scanner.nextLine());

            System.out.println("Novo Email: ");
            alunos.setEmail(scanner.nextLine());

            System.out.println("Novo CPF: ");
            alunos.setCpf(scanner.nextLine());

            System.out.println("Nova Data de Nascimento (yyyy-MM-dd): ");
            String[] dataNascimento = scanner.nextLine().split("-");
            Calendar calendar = Calendar.getInstance();
            calendar.set(Integer.parseInt(dataNascimento[0]), Integer.parseInt(dataNascimento[1]) - 1, Integer.parseInt(dataNascimento[2]));
            alunos.setDataNascimento(calendar);

            System.out.println("Nova Naturalidade: ");
            alunos.setNaturalidade(scanner.nextLine());

            System.out.println("Novo Endereço: ");
            alunos.setEndereco(scanner.nextLine());

            manager.getTransaction().begin();
            manager.merge(alunos);
            manager.getTransaction().commit();

            System.out.println("ORM.Model.Aluno alterado com sucesso!");
        } else {
            System.out.println("ORM.Model.Aluno com ID " + id + " não encontrado.");
        }

        manager.close();
        factory.close();
        scanner.close();
    }
}
