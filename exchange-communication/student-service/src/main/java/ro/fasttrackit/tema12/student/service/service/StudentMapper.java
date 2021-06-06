package ro.fasttrackit.tema12.student.service.service;

import org.springframework.stereotype.Service;
import ro.fasttrackit.tema12.student.service.model.domain.request.StudentRequestDto;
import ro.fasttrackit.tema12.student.service.model.domain.response.StudentResponseDto;
import ro.fasttrackit.tema12.student.service.model.entity.Student;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentMapper {

    public List<StudentResponseDto> mapListEntityToListResponseDto(List<Student> entities) {
        return entities.stream()
                .map(this::mapEntityToResponseDto)
                .collect(Collectors.toList());
    }

    public StudentResponseDto mapEntityToResponseDto(Student entity) {
        StudentResponseDto studentResponseDto = new StudentResponseDto();
        studentResponseDto.setStudentId(entity.getStudentId());
        studentResponseDto.setName(entity.getName());
        studentResponseDto.setAge(entity.getAge());
        return studentResponseDto;
    }

    public Student mapRequestDtoToEntity(StudentRequestDto requestDto) {
        Student student = new Student();
        student.setAge(requestDto.getAge());
        student.setName(requestDto.getName());
        return student;
    }
}
