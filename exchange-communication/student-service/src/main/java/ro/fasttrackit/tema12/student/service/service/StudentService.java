package ro.fasttrackit.tema12.student.service.service;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import ro.fasttrackit.model.StudentEvent;
import ro.fasttrackit.tema12.student.service.model.StudentFilters;
import ro.fasttrackit.tema12.student.service.model.entity.Student;
import ro.fasttrackit.tema12.student.service.repository.StudentDao;
import ro.fasttrackit.tema12.student.service.repository.StudentRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;
    private final StudentDao studentDao;
    private final RabbitTemplate rabbitTemplate;
    private final FanoutExchange fanoutExchange;

    public List<Student> getAllByFilters(StudentFilters filters) {
        return studentDao.getAll(filters);
    }

    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    public Optional<Student> getStudentById(String studentId) {
        return studentRepository.findById(studentId);
    }

    public void deleteStudentById(String studentId) {
        studentRepository.deleteById(studentId);
        rabbitTemplate.convertAndSend(
                fanoutExchange.getName(),
                studentId,
                new StudentEvent(studentId));
    }
}
