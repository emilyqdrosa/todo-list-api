package com.emily.todo_list_api.entities;

import com.emily.todo_list_api.entities.enums.UrgencyLevel;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@MappedSuperclass
public abstract class BaseTask {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID uuid;

    @NotBlank(message = "O nome é obrigatório")
    @Size(min = 3, max = 255)
    @Column(nullable = false)
    private String name;

    private String description;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    private LocalDateTime dueDate;

    @Column(nullable = false)
    private boolean active = true;

    private LocalDateTime deletedAt;

    @ManyToOne
    @JoinColumn(name = "step_id")
    private Step step;
    @Enumerated(EnumType.STRING)
    private UrgencyLevel urgency;
}
