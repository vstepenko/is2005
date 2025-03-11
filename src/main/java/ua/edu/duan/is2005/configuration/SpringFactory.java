package ua.edu.duan.is2005.configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ua.edu.duan.is2005.controller.StudentController;
import ua.edu.duan.is2005.repository.StudentRepository;
import ua.edu.duan.is2005.service.StudentService;


@Configuration
public class SpringFactory {

    @Bean
    public StudentController studentController( StudentService studentService){
        return new StudentController(studentService);
    }

    @Bean
    public StudentService studentService(){
        return new StudentService() {
            @Override
            protected StudentRepository getStudentRepository() {
                return new StudentRepository();
            }
        };
    }

}
