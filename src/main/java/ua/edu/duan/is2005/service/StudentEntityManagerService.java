package ua.edu.duan.is2005.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.edu.duan.is2005.dao.StudentDao;
import ua.edu.duan.is2005.dto.StudentDto;
import ua.edu.duan.is2005.entity.StudentEntity;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class StudentEntityManagerService {

    private final StudentDao studentDao;

    @PersistenceContext
    private EntityManager entityManager;

    public StudentDto getStudent(String id) {
        return studentDao.findById(id).map(this::convert)
                .orElseThrow(() -> new RuntimeException("Student not found"));
    }


    public void saveStudent(StudentDto studentDto) {

        StudentEntity studentEntity = convert(studentDto);
        studentEntity.setId(UUID.randomUUID().toString());
        studentDao.save(studentEntity);

    }


    @Transactional
    public void editStudent(String id, StudentDto studentDto) {
        studentDao.findById(id).ifPresentOrElse(
                studentEntity ->{
                    edit(studentEntity, studentDto);
                    entityManager.detach(studentEntity);
                    entityManager.merge(studentEntity);
                },
                () -> {
                    throw new RuntimeException("Student not found");
                }
        );
    }


    private StudentDto convert(StudentEntity entity) {
        StudentDto dto = new StudentDto();
        dto.setId(entity.getId());
        dto.setFirstName(entity.getFirstName());
        dto.setSecondName(entity.getSecondName());
        dto.setLastName(entity.getLastName());
        dto.setEmail(entity.getEmail());
        return dto;
    }


    private StudentEntity convert(StudentDto dto) {
        StudentEntity entity = new StudentEntity();
        edit(entity, dto);
        return entity;
    }

    private void edit(StudentEntity entity, StudentDto dto){
        entity.setFirstName(dto.getFirstName());
        entity.setSecondName(dto.getSecondName());
        entity.setLastName(dto.getLastName());
        entity.setEmail(dto.getEmail());
    }
}
