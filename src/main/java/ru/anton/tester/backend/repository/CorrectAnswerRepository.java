package ru.anton.tester.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.anton.tester.backend.entity.CorrectAnswer;

public interface CorrectAnswerRepository extends JpaRepository<CorrectAnswer, Long> {
    CorrectAnswer findById(long id);
}
