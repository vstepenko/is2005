package ua.edu.duan.is2005.service;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.edu.duan.is2005.dto.StudentDto;
import ua.edu.duan.is2005.entity.StudentEntity;
import ua.edu.duan.is2005.repository.StudentRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

   private final StudentRepository studentRepository;

    public List<StudentDto> getStudent() {
        return studentRepository.findAll().stream()
                .map(this::convert)
                .toList();
    }

    public void sddStudent(StudentDto dto) {
        StudentEntity studentEntity = convert(dto);
        studentRepository.save(studentEntity);
    }

    @Transactional
    public void editStudent(String id, StudentDto dto) {
        studentRepository.findById(id)
                .ifPresentOrElse(
                        it -> edit(it, dto),
                        () -> {
                            throw new RuntimeException();
                        }
                );

    }

    public void deleteStudent(String id) {
        studentRepository.findById(id).ifPresent(studentRepository::delete);
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
        entity.setId(dto.getId());
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
