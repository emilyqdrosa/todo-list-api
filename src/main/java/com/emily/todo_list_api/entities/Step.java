package com.emily.todo_list_api.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@Table(schema = "todo_list_api", name = "steps")
public class Step {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_step", updatable = false, nullable = false)
    private UUID id;

    @NotBlank(message = "O nome da etapa é obrigatório")
    @Size(min = 3, max = 20)
    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User owner;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id")
    private Project project;
}