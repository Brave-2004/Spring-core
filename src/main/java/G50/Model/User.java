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
public class User {

    @Value("#{'brave'}")
    public String username;

    @Value("#{'0926'}")
    public String password;

    public  String genUUID() {
        return UUID.randomUUID().toString();
    }
}
