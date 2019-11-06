package spring;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PeopleRepository extends CrudRepository<People, Long> {
     List<People> findByGender(String gender);
     List<People> findAll();

     People findById(long id);
}
