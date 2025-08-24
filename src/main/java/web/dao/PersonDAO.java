package web.dao;

import org.springframework.stereotype.Repository;
import web.models.Person;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class PersonDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Person> index() {
        return entityManager.createQuery("FROM Person", Person.class).getResultList();
    }


    public Person show(int id) {
        return entityManager.find(Person.class, id);
    }

    @Transactional
    public void save(Person person) {
        entityManager.persist(person);
    }

    @Transactional
    public void update(int id, Person updatedPerson) {
        Person person = entityManager.find(Person.class, id);
        if (person != null) {
            person.setName(updatedPerson.getName());
            person.setAge(updatedPerson.getAge());
        }
    }

    @Transactional
    public void delete(int id) {
        Person person = entityManager.find(Person.class, id);
        if (person != null) {
            entityManager.remove(person);
        }
    }
}
