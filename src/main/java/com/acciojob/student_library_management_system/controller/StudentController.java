package com.acciojob.student_library_management_system.controller;

import com.acciojob.student_library_management_system.entities.Student;
import com.acciojob.student_library_management_system.requestdtos.StudentRequestDto;
import com.acciojob.student_library_management_system.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/apis/students")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/savestudent")
    public String saveStudent(@RequestBody StudentRequestDto studentdto){
         return studentService.saveStudent(studentdto);
    }

    @GetMapping("/getById/{studentId}")
    public Student getStudentById(@PathVariable int studentId){
        return studentService.getStudentById(studentId);
    }

    @DeleteMapping("/deleteById/{studentId}")
    public String deleteStudentById(@PathVariable int studentId){
        return studentService.deleteStudentById(studentId);
     }

    @GetMapping("/getAll")
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @PutMapping("/updatePut/{studentId}")
    public String updateStudentByPut(@PathVariable int studentId, @RequestBody  StudentRequestDto studentRequestDto){
        return studentService.updateStudentByIdPut(studentId,studentRequestDto);
    }

    @PatchMapping("/updatePatch/{studentId}")
    public String updateStudentByPatch(@PathVariable int studentId,@RequestParam String sem,@RequestParam String address){
        return studentService.updateStudentByIdPatch(studentId,sem,address);
    }


}
