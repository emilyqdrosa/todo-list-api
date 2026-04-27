package com.emily.todo_list_api.entities;

import com.emily.todo_list_api.entities.enums.UrgencyLevel;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@MappedSuperclass
public abstract class BaseTask {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_task", updatable = false, nullable = false)
    private UUID uuid;

    @NotBlank(message = "O nome é obrigatório")
    @Size(min = 3, max = 255)
    @Column(name = "name",nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "due_date")
    private LocalDateTime dueDate;

    @Builder.Default
    @Column(name = "active", nullable = false)
    private boolean active = true;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;

    @ManyToOne
    @JoinColumn(name = "step_id")
    private Step step;

    @Enumerated(EnumType.STRING)
    @Column(name = "urgency_level")
    private UrgencyLevel urgency;
}
