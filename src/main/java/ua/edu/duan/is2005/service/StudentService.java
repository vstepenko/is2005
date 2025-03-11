package ua.edu.duan.is2005.service;

import lombok.RequiredArgsConstructor;
import ua.edu.duan.is2005.repository.StudentRepository;

@RequiredArgsConstructor
public abstract class StudentService {

    protected abstract StudentRepository getStudentRepository();

    public String getStudent() {
        return getStudentRepository().toString();
    }
}
