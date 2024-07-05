package ORM.Actions;

import ORM.Model.alunos;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Calendar;
import java.util.Scanner;

public class InserirAluno {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        alunos alunos = new alunos();
        System.out.println("Nome: ");
        alunos.setNome(scanner.nextLine());

        System.out.println("Email: ");
        alunos.setEmail(scanner.nextLine());

        System.out.println("CPF: ");
        alunos.setCpf(scanner.nextLine());

        System.out.println("Data de Nascimento (yyyy-MM-dd): ");
        String[] dataNascimento = scanner.nextLine().split("-");
        Calendar calendar = Calendar.getInstance();
        calendar.set(Integer.parseInt(dataNascimento[0]), Integer.parseInt(dataNascimento[1]) - 1, Integer.parseInt(dataNascimento[2]));
        alunos.setDataNascimento(calendar);

        System.out.println("Naturalidade: ");
        alunos.setNaturalidade(scanner.nextLine());

        System.out.println("Endereço: ");
        alunos.setEndereco(scanner.nextLine());

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("escola");
        EntityManager manager = factory.createEntityManager();

        manager.getTransaction().begin();
        manager.persist(alunos);
        manager.getTransaction().commit();

        System.out.println("ORM.Model.Aluno inserido com sucesso, ID: " + alunos.getId());

        manager.close();
        factory.close();
        scanner.close();
    }
}
