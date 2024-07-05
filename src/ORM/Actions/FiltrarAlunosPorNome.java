package ORM.Actions;

import ORM.Model.alunos;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;
import java.util.Scanner;

public class FiltrarAlunosPorNome {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite a letra inicial do nome: ");
        String letraInicial = scanner.nextLine() + "%";

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("escola");
        EntityManager manager = factory.createEntityManager();

        Query query = manager.createQuery("SELECT a FROM ORM.Model.Aluno a WHERE a.nome LIKE :letraInicial");
        query.setParameter("letraInicial", letraInicial);
        List<alunos> alunos = query.getResultList();

        for (ORM.Model.alunos aluno : alunos) {
            System.out.println("ID: " + aluno.getId());
            System.out.println("Nome: " + aluno.getNome());
            System.out.println("Email: " + aluno.getEmail());
            System.out.println("CPF: " + aluno.getCpf());
            System.out.println("Data de Nascimento: " + aluno.getDataNascimento().getTime());
            System.out.println("Naturalidade: " + aluno.getNaturalidade());
            System.out.println("Endereço: " + aluno.getEndereco());
            System.out.println("====================================");
        }

        manager.close();
        factory.close();
        scanner.close();
    }
}
