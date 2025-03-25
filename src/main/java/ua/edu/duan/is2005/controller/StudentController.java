package ua.edu.duan.is2005.controller;


import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import ua.edu.duan.is2005.dto.StudentDto;

import ua.edu.duan.is2005.service.StudentService;

import java.util.List;

@RestController("/")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @Operation(summary = "get Students", description = "Full Description of this endpoint")
    @GetMapping("/students")
    @ResponseBody
    public List<StudentDto> getStudent() {
        return studentService.getStudent();
    }
    @PostMapping("/student")
    @ResponseBody
    public void addStudent(@RequestBody  StudentDto dto) {
        studentService.sddStudent(dto);
    }

    @PutMapping("/student")
    @ResponseBody
    public void editStudent(@RequestParam String id, @RequestBody  StudentDto dto) {
        studentService.editStudent(id, dto);
    }

    @DeleteMapping("/student")
    @ResponseBody
    public void deleteStudent(@RequestParam String id) {
        studentService.deleteStudent(id);
    }
}
