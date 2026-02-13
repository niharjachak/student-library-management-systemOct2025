package com.acciojob.student_library_management_system.controller;

import com.acciojob.student_library_management_system.entities.Student;
import com.acciojob.student_library_management_system.requestdtos.StudentRequestDto;
import com.acciojob.student_library_management_system.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/lms/apis/students")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/createstudent")
    public ResponseEntity<String> saveStudent(@RequestBody StudentRequestDto studentDto){
        UUID stdCardId = studentService.createStudent(studentDto);
        return new ResponseEntity<>("Welcome "+studentDto.getStudentName()+"! CARD ID: "+stdCardId, HttpStatus.CREATED);

    }

    @GetMapping("/getById/{studentId}")
    public ResponseEntity<Student> getStudentById(@PathVariable UUID studentId){
         Student student= studentService.getStudentById(studentId);
        return new ResponseEntity<>(student,HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteById/{studentId}")
    public String deleteStudentById(@PathVariable UUID studentId){
        return studentService.deleteStudentById(studentId);
     }

    @GetMapping("/getAll")
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @PutMapping("/updatePut/{studentId}")
    public String updateStudentByPut(@PathVariable UUID studentId, @RequestBody  StudentRequestDto studentRequestDto){
        return studentService.updateStudentByIdPut(studentId,studentRequestDto);
    }

    @PatchMapping("/updatePatch/{studentId}")
    public String updateStudentByPatch(@PathVariable UUID studentId,@RequestParam String sem,@RequestParam String address){
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
