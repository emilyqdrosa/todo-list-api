package com.emily.todo_list_api.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(schema = "todo_list_api", name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_user", updatable = false, nullable = false)
    private UUID id;

    @NotBlank(message = "O nome é obrigatório")
    private String name;

    @Email(message = "E-mail inválido")
    @NotBlank(message = "O e-mail é obrigatório")
    @Column(unique = true, nullable = false)
    private String email;

    @NotBlank
    @Size(min = 8)
    private String password;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
    private List<IndividualTask> individualTasks;

    @ManyToMany(mappedBy = "members")
    private List<Project> projects;

    @ManyToMany(mappedBy = "responsibles")
    private List<ProjectTask> projectTasks;
}
