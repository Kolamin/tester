package ru.anton.tester.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.anton.tester.backend.entity.Question;

public interface QuestionRepository extends JpaRepository<Question, Long> {
    Question findById(long id);
}
