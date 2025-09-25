package G50.pdp.controller;

import G50.pdp.dto.StudentDTO;
import G50.pdp.model.Group;
import G50.pdp.model.Student;
import G50.pdp.server.DataSource;
import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.persistence.EntityManager;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@ResponseBody
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {

    private final DataSource dataSource;

    @GetMapping(produces = "application/json")
    public List<Student> read(HttpServletRequest req, HttpServletResponse resp) throws JsonProcessingException {
        EntityManager entityManager = dataSource.getEntityManager();

        List<Student> students = entityManager.createQuery("from Student", Student.class).getResultList();

        return students;

    }



    @PostMapping
    public StudentDTO create(@RequestBody StudentDTO studentDTO){
        EntityManager entityManager = dataSource.getEntityManager();
        entityManager.getTransaction().begin();

        Group group = entityManager.find(Group.class, studentDTO.getGroupId());
        Student student = new Student(
                null,
                studentDTO.getFirstName(),
                studentDTO.getLastName(),
                studentDTO.getEmail(),
                studentDTO.getGender(),
                studentDTO.getBirthDate(),
                studentDTO.getPassword(),
                group
        );

        entityManager.persist(student);
        studentDTO.setId(student.getId());
        entityManager.getTransaction().commit();
        return studentDTO;
    }


    @PutMapping("/{id}")
    public Student update(@PathVariable(name = "id") Integer id,
                          @RequestBody   Student student){
        EntityManager entityManager = dataSource.getEntityManager();
        entityManager.getTransaction().begin();
        student.setId(id);
        entityManager.merge(student);
        entityManager.getTransaction().commit();
        return student;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(name = "id") Integer id){
        EntityManager entityManager = dataSource.getEntityManager();
        entityManager.getTransaction().begin();
        Student student = entityManager.find(Student.class, id);
        entityManager.remove(student);
        entityManager.getTransaction().commit();
    }


}
