package com.example.service;

import com.example.model.Student;
import com.example.repository.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class StudentServiceTest {

    @InjectMocks
    StudentService studentService;

    @Mock
    StudentRepository studentRepository;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void getAllStudentsTest() {
        Student student1 = new Student();
        Student student2 = new Student();
        when(studentRepository.findAll()).thenReturn(Arrays.asList(student1, student2));

        List<Student> result = studentService.getAllStudents();

        assertEquals(2, result.size());
        verify(studentRepository, times(1)).findAll();
    }

    @Test
    public void getStudentByIdTest() {
        Student student = new Student();
        when(studentRepository.findById(1L)).thenReturn(Optional.of(student));

        Student result = studentService.getStudentById(1L);

        assertEquals(student, result);
        verify(studentRepository, times(1)).findById(1L);
    }

    @Test
    public void createStudentTest() {
        Student student = new Student();
        when(studentRepository.save(student)).thenReturn(student);

        Student result = studentService.createStudent(student);

        assertEquals(student, result);
        verify(studentRepository, times(1)).save(student);
    }

    @Test
    public void updateStudentTest() {
        Student oldStudent = new Student();
        oldStudent.setName("Old Name");
        oldStudent.setEmail("oldemail@example.com");
        oldStudent.setCourse("Old Course");

        Student newStudent = new Student();
        newStudent.setName("New Name");
        newStudent.setEmail("newemail@example.com");
        newStudent.setCourse("New Course");

        when(studentRepository.findById(1L)).thenReturn(Optional.of(oldStudent));
        when(studentRepository.save(oldStudent)).thenReturn(oldStudent);

        Student result = studentService.updateStudent(1L, newStudent);

        assertEquals("New Name", result.getName());
        assertEquals("newemail@example.com", result.getEmail());
        assertEquals("New Course", result.getCourse());
        verify(studentRepository, times(1)).findById(1L);
        verify(studentRepository, times(1)).save(oldStudent);
    }

    @Test
    public void deleteStudentTest() {
        Long id = 1L;
        studentService.deleteStudent(id);
        verify(studentRepository, times(1)).deleteById(id);
    }

    @Test
    public void updateStudentNotFoundTest() {
        Student newStudent = new Student();
        when(studentRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> studentService.updateStudent(1L, newStudent));
        verify(studentRepository, times(1)).findById(1L);
    }
}