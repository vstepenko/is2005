package ua.edu.duan.is2005.repository;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = ConfigurableBeanFactory. SCOPE_PROTOTYPE)
public class StudentRepository {
    public String findById(){
        return "Student";
    }
}
