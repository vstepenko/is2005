package ua.edu.duan.is2005.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.edu.duan.is2005.entity.StudentEntity;

public interface StudentRepository extends JpaRepository<StudentEntity,String> {

}
