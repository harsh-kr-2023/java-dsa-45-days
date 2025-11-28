package com.project.chat.repository;

import com.project.chat.model.Project;
import com.project.chat.model.Task;
import com.project.chat.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByProject(Project project);

    // ADD THESE METHODS:
    long countByProjectOwner(User owner);
    long countByProjectOwnerAndStatus(User owner, Task.Status status);

    // Search method
    @Query("SELECT t FROM Task t WHERE t.project.owner.username = :username AND " +
            "(LOWER(t.title) LIKE LOWER(CONCAT('%', :query, '%')) OR " +
            "LOWER(t.description) LIKE LOWER(CONCAT('%', :query, '%')))")
    List<Task> searchTasks(@Param("username") String username, @Param("query") String query);
}