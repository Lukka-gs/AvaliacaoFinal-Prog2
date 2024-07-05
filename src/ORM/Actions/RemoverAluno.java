package ORM.Actions;

import ORM.Model.alunos;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Scanner;

public class RemoverAluno {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o ID do aluno a ser removido: ");
        Long id = Long.parseLong(scanner.nextLine());

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("escola");
        EntityManager manager = factory.createEntityManager();

        alunos alunos = manager.find(ORM.Model.alunos.class, id);

        if (alunos != null) {
            manager.getTransaction().begin();
            manager.remove(alunos);
            manager.getTransaction().commit();

            System.out.println("ORM.Model.Aluno removido com sucesso!");
        } else {
            System.out.println("ORM.Model.Aluno com ID " + id + " não encontrado.");
        }

        manager.close();
        factory.close();
        scanner.close();
    }
}
