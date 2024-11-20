package pe.edu.i202332181.persistencia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import pe.edu.i202332181.entity.City;
import pe.edu.i202332181.entity.Country;
import pe.edu.i202332181.entity.CountryLanguage;

public class JPAPersist {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("world");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Country imaginaryCountry = new Country();
        imaginaryCountry.setCode("JVW");
        imaginaryCountry.setName("JavaWorld");
        imaginaryCountry.setContinent("Asia");
        imaginaryCountry.setRegion("jdk23");
        imaginaryCountry.setPopulation(1000000);
        imaginaryCountry.setGnp(1.0f);
        imaginaryCountry.setGnpOld(2.0f);
        imaginaryCountry.setIndepYear(3);
        imaginaryCountry.setLifeExpectancy(2.0f);
        imaginaryCountry.setSurfaceArea(4.0f);
        imaginaryCountry.setCode2("JW");
        imaginaryCountry.setGovernmentForm("Republic");
        imaginaryCountry.setLocalName("Argentina");


        // cities
        City city1 = new City();
        city1.setName("Ciudad1");
        city1.setDistrict("spring");
        city1.setPopulation(9904727);
        city1.setCountry(imaginaryCountry);

        City city2 = new City();
        city2.setName("Ciudad2");
        city2.setDistrict("springboot");
        city2.setPopulation(869351);
        city2.setCountry(imaginaryCountry);

        City city3 = new City();
        city3.setName("Ciudad3");
        city3.setDistrict("springcloud");
        city3.setPopulation(799550);
        city3.setCountry(imaginaryCountry);

        // languages
        CountryLanguage language1 = new CountryLanguage();
        language1.setCountryCode(imaginaryCountry.getCode());
        language1.setLanguage("Imagese");
        language1.setIsOfficial("T");
        language1.setPercentage(50.0f);
        language1.setCountry(imaginaryCountry);

        CountryLanguage language2 = new CountryLanguage();
        language2.setCountryCode(imaginaryCountry.getCode());
        language2.setLanguage("FantasyTalk");
        language2.setIsOfficial("F");
        language2.setPercentage(50.0f);
        language2.setCountry(imaginaryCountry);

        // Persist
        em.persist(imaginaryCountry);
        em.persist(city1);
        em.persist(city2);
        em.persist(city3);
        em.persist(language1);
        em.persist(language2);

        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}