package web.dao;

import org.springframework.stereotype.Repository;
import web.models.Person;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class PersonDAOImpl implements PersonDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Person> index() {
        return entityManager.createQuery("FROM Person", Person.class).getResultList();
    }

    @Override
    public Person show(int id) {
        return entityManager.find(Person.class, id);
    }

    @Override
    public void save(Person person) {
        entityManager.persist(person);
    }

    @Override
    public void update(int id, Person updatedPerson) {
        Person person = entityManager.find(Person.class, id);
        if (person != null) {
            person.setName(updatedPerson.getName());
            person.setAge(updatedPerson.getAge());
        }
    }

    @Override
    public void delete(int id) {
        Person person = entityManager.find(Person.class, id);
        if (person != null) {
            entityManager.remove(person);
        }
    }
}
