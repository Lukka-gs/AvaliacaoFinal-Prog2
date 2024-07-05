package ORM.UtilsDB;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GerarTabelaAluno {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("escola");
        factory.close();
    }
}