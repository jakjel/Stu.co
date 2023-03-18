package org.s3.individualassignment.backend.persistance.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.s3.individualassignment.backend.domain.UserRole;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "users")
@Builder
@Getter
@Setter
@AllArgsConstructor //helps with error could not be accesed from outside the package, it says it is private otherwise
@NoArgsConstructor
@EqualsAndHashCode
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long user_id;
    private String username;
    @NotBlank
    @Column(name = "email")
    private String email;
    @NotBlank
    @Column(name = "password")
    private String password;
    @NotBlank
    @Column(name = "firstName")
    private String firstName;
    @NotBlank
    @Column(name = "lastName")
    private String lastName;
//    @NotBlank
    @Column(name = "role_name")
    @Enumerated(EnumType.STRING)
    private UserRole role;
    @OneToMany(mappedBy="user")
    private List<ExpenseEntity> expenses;
    @ManyToMany(
            fetch=FetchType.EAGER,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },
            mappedBy = "users")
    @JsonIgnore
    private Set<GroupEntity> groups;
}
