package G50.pdp.dto;

import G50.pdp.model.GenderEnum;
import G50.pdp.model.Group;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StudentDTO {

    private  Integer id;


    private String firstName;


    private String lastName;


    private String email;


    private GenderEnum gender;

    @JsonFormat(pattern = "dd.MM.yy")
    @Column(name = "birth_date")
    private LocalDate birthDate;


    private String password;


    private Integer groupId;


}
