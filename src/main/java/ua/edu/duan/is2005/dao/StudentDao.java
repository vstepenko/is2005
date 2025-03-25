package ua.edu.duan.is2005.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ua.edu.duan.is2005.entity.StudentEntity;

import java.util.List;
import java.util.Optional;

@Component
public class StudentDao {

    @PersistenceContext
    private EntityManager entityManager;

    public Optional<StudentEntity> findById(String id) {
       return Optional.ofNullable(entityManager.find(StudentEntity.class, id));
    }

    public StudentEntity findById2(String id) {
        return entityManager.find(StudentEntity.class, id);
    }

    public List<StudentEntity> findByName(String name) {
        return entityManager.createQuery("SELECT student FROM StudentEntity student WHERE student.firstName = :name ", StudentEntity.class)
                .setParameter("name", name)
                .getResultList();
    }

    @Transactional
    public void save(StudentEntity student) {
        entityManager.persist(student);
    }

}
