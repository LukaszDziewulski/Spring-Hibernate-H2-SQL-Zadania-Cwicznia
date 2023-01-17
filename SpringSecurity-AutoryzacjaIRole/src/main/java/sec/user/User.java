package sec.user;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
@Data
@Entity
@Table(name = "application_user") // Słowo "USER" jest zarezerwowanym słowem standardu SQL i słowem kluczowym w H2,
// dlatego dodałem adnotację @Table, wskazując tabelę o nazwie "application_user".
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    @ManyToMany(fetch = FetchType.EAGER) // Domyślnie kolekcje stanowiące relację jeden do wielu i wiele do
    // wielu wczytywane są leniwie. Z tego powodu dodałem atrybut fetch = FetchType.EAGER,
    // dzięki któremu role zawsze będą doczytane zachłannie wraz z użytkownikiem
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id")

    )
    private Set<UserRole> roles = new HashSet<>();
}
