package ua.edu.duan.is2005.controller;


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
import ua.edu.duan.is2005.service.StudentEntityManagerService;

@RestController()
@RequiredArgsConstructor
public class StudentEntityManagerTestController {

    private final StudentEntityManagerService studentService;

    @GetMapping("/dao/student")
    @ResponseBody
    public StudentDto getStudent(@RequestParam String id) {
        return studentService.getStudent(id);
    }


    @PostMapping("/dao/student")
    @ResponseBody
    public void addStudent(@RequestBody StudentDto dto) {
        studentService.saveStudent(dto);
    }

    @PutMapping("/dao/student")
    @ResponseBody
    public void editStudent(@RequestParam String id, @RequestBody  StudentDto dto) {
        studentService.editStudent(id, dto);
    }

    @DeleteMapping("/dao/student")
    @ResponseBody
    public void deleteStudent(@RequestParam String id) {
   //     studentService.deleteStudent(id);
    }
}
