package ua.edu.duan.is2005.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.edu.duan.is2005.entity.StudentEntity;

import java.util.List;

public interface StudentRepository extends JpaRepository<StudentEntity,String> {

    List<StudentEntity> findByFirstName(String firstName);
}
