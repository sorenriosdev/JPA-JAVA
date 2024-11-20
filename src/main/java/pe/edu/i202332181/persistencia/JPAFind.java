package pe.edu.i202332181.persistencia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import pe.edu.i202332181.entity.City;
import pe.edu.i202332181.entity.Country;

import java.util.List;

public class JPAFind {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("world");
        EntityManager em = emf.createEntityManager();

        Country peru = em.find(Country.class, "PER");

        if (peru != null) {
            List<City> cities = peru.getCities();
            cities.stream()
                    .filter(city -> city.getPopulation() > 700000)
                    .forEach(city -> System.out.println("Ciudad: " + city.getName() + ", Población: " + city.getPopulation()));
        } else {
            System.out.println("pais no encontrado.");
        }

        em.close();
        emf.close();
    }
}
