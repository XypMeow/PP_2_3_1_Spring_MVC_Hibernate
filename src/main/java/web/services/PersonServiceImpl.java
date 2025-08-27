package web.services;

import org.springframework.transaction.annotation.Transactional;
import web.dao.PersonDao;
import web.models.Person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class PersonServiceImpl implements PersonService {
    private final PersonDao personDao;

    @Autowired
    public PersonServiceImpl(PersonDao personDao) {
        this.personDao = personDao;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Person> index() {
        return personDao.index();
    }

    @Override
    @Transactional(readOnly = true)
    public Person show(int id) {
        return personDao.show(id);
    }

    @Override
    public void save(Person person) {
        personDao.save(person);
    }

    @Override
    public void update(int id, Person person) {
        personDao.update(id, person);
    }

    @Override
    public void delete(int id) {
        personDao.delete(id);
    }
}
