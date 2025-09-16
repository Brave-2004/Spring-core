package G50.Model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Getter
@Setter
@ToString
public class Student {
    @Value("#{'John'}")
    private String firstName;

    @Value("#{'Doe'}")
    private String lastName;

    @Value("#{user.username}")
    private String username;

    @Value("#{user.password}")
    private String password;

    @Value("#{user.genUUID()}")
    private UUID id;

}
