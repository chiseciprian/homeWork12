package ro.fasttrackit.tema12.student.service.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ro.fasttrackit.tema12.student.service.controller.exceptions.EntityNotFoundException;
import ro.fasttrackit.tema12.student.service.model.StudentFilters;
import ro.fasttrackit.tema12.student.service.model.domain.request.StudentRequestDto;
import ro.fasttrackit.tema12.student.service.model.domain.response.StudentResponseDto;
import ro.fasttrackit.tema12.student.service.model.entity.Student;
import ro.fasttrackit.tema12.student.service.repository.StudentDao;
import ro.fasttrackit.tema12.student.service.repository.StudentRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;
    private final StudentDao studentDao;
    private final RabbitService rabbitService;
    private final StudentMapper studentMapper;


    public List<StudentResponseDto> getAllByFilters(StudentFilters filters) {
        return studentMapper.mapListEntityToListResponseDto(studentDao.getAll(filters));
    }

    public StudentResponseDto addStudent(StudentRequestDto requestDto) {
        Student student = studentRepository.save(studentMapper.mapRequestDtoToEntity(requestDto));
        return studentMapper.mapEntityToResponseDto(student);
    }

    public StudentResponseDto getStudentById(String studentId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new EntityNotFoundException("Student with id " + studentId + " not Found"));
        return studentMapper.mapEntityToResponseDto(student);
    }

    public void deleteStudentById(String studentId) {
        studentRepository.deleteById(studentId);
        rabbitService.notifyDeleteStudent(studentId);
    }
}
