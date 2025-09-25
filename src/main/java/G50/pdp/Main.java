package G50.pdp;

import G50.pdp.model.Student;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper   objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());

        Student value = new Student();
        value.setBirthDate(LocalDate.now());

        String json =objectMapper.writeValueAsString(value);
        System.out.println(json);
    }
}
