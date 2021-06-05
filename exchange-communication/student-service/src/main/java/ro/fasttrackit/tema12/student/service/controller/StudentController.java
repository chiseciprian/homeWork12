package ro.fasttrackit.tema12.student.service.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ro.fasttrackit.tema12.student.service.controller.exceptions.EntityNotFoundException;
import ro.fasttrackit.tema12.student.service.model.StudentFilters;
import ro.fasttrackit.tema12.student.service.model.entity.Student;
import ro.fasttrackit.tema12.student.service.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @GetMapping
    List<Student> getAll(StudentFilters filters) {
        return studentService.getAllByFilters(filters);
    }

    @PostMapping
    Student addStudent(@RequestBody Student student) {
        return studentService.addStudent(student);
    }

    @GetMapping("{studentId}")
    Student getStudentById(@PathVariable String studentId) {
        return studentService.getStudentById(studentId)
                .orElseThrow(() -> new EntityNotFoundException("Student with id " + studentId + " not Found"));
    }

    @DeleteMapping("{studentId}")
    void deleteStudentById(@PathVariable String studentId) {
        studentService.deleteStudentById(studentId);
    }
}
