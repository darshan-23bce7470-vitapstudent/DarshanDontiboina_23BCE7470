package com.school.controller;
import com.school.model.Teacher;
import com.school.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/teachers")
public class TeacherController {
    @Autowired
    private TeacherRepository teacherRepo;

    @PostMapping
    public Teacher addTeacher(@RequestBody Teacher teacher) {
        return teacherRepo.save(teacher);
    }

    @GetMapping
    public List<Teacher> getAllTeachers() {
        return teacherRepo.findAll();
    }

    @PutMapping("/{id}")
    public Teacher updateTeacher(@PathVariable String id, @RequestBody Teacher teacher) {
        teacher.setId(id);
        return teacherRepo.save(teacher);
    }

    @DeleteMapping("/{id}")
    public String deleteTeacher(@PathVariable String id) {
        teacherRepo.deleteById(id);
        return "Teacher deleted.";
    }
}