package ro.fasttrackit.tema12.student.service.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ro.fasttrackit.tema12.student.service.model.StudentFilters;
import ro.fasttrackit.tema12.student.service.model.domain.request.StudentRequestDto;
import ro.fasttrackit.tema12.student.service.model.domain.response.StudentResponseDto;
import ro.fasttrackit.tema12.student.service.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @GetMapping
    List<StudentResponseDto> getAll(StudentFilters filters) {
        return studentService.getAllByFilters(filters);
    }

    @PostMapping
    StudentResponseDto addStudent(@RequestBody StudentRequestDto request) {
        return studentService.addStudent(request);
    }

    @GetMapping("{studentId}")
    StudentResponseDto getStudentById(@PathVariable String studentId) {
        return studentService.getStudentById(studentId);

    }

    @DeleteMapping("{studentId}")
    void deleteStudentById(@PathVariable String studentId) {
        studentService.deleteStudentById(studentId);
    }
}
