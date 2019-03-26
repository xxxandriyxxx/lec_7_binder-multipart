package owu2018.lec_7_bindermultipart.models;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@ToString(exclude = {"phoneList"})

public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Size(min = 3, max = 6, message = "hello {foo.message}")
    String name;
    String email;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "contact")
    List<Phone> phoneList = new ArrayList<>();
    private String avatar;

    public Contact(String name, String email) {
        this.name = name;
        this.email = email;
    }
}
