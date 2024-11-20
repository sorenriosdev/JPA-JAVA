package pe.edu.i202332181.persistencia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import pe.edu.i202332181.entity.Country;

public class JPARemove {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("world");
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            Country imaginaryCountry = em.find(Country.class, "JVW");

            if (imaginaryCountry != null) {
                em.remove(imaginaryCountry);
                System.out.println("Pais eliminado con sus ciudades y lenguajes.");
            } else {
                System.out.println("Pais eliminado o ya fue eliminado.");
            }

            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }
    }
}
