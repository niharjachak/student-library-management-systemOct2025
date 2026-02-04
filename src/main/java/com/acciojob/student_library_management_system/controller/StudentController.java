package com.acciojob.student_library_management_system.controller;

import com.acciojob.student_library_management_system.entities.Student;
import com.acciojob.student_library_management_system.requestdtos.StudentRequestDto;
import com.acciojob.student_library_management_system.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/lms/apis/students")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/createstudent")
    public String saveStudent(@RequestBody StudentRequestDto studentDto){
        UUID stdCardId = studentService.createStudent(studentDto);
        return "Student Registration Successfull! CardId: "+stdCardId;
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

    @GetMapping("/getByPage")
    public List<Student> getAllStudentsPageWise( @RequestParam int pageNumber, @RequestParam int pageSize){
        return studentService.getAllStudentsPageWise(pageNumber,pageSize);
    }

    @GetMapping("/getSortedByPage")
    public List<Student> getAllStudentsSortedPageWise( @RequestParam int pageNumber, @RequestParam int pageSize, @RequestParam String attribute ){
        return studentService.getAllStudentsSortedPageWise(pageNumber,pageSize,attribute);
    }


}
