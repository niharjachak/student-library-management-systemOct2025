package com.acciojob.student_library_management_system.service;

import com.acciojob.student_library_management_system.entities.Card;
import com.acciojob.student_library_management_system.entities.Student;
import com.acciojob.student_library_management_system.enums.CardStatus;
import com.acciojob.student_library_management_system.repository.IStudentRepository;
import com.acciojob.student_library_management_system.requestdtos.StudentRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    IStudentRepository studentRepository;


    public String saveStudent(StudentRequestDto studentdto){
        Student student = new Student();

        student.setStudentName(studentdto.getStudentName());
        student.setEmail(studentdto.getEmail());
        student.setGender(studentdto.getGender());
        student.setMobile(studentdto.getMobileNumber());
        student.setSem(studentdto.getSem());
        student.setDob(studentdto.getDob());
        student.setDept(studentdto.getDept());
        student.setAddress(studentdto.getAddress());

        //  Whenever a new Student is Created then his/her card is created automatically
        Card card = new Card();
        card.setCardStatus(CardStatus.ACTIVE);
        // an expiry-date is set : 3 years after the Current Date
        card.setExpiryDate(LocalDate.now().plusYears(3).toString());
        // THE STUDENT IS ASSIGNED WITH THE CARD
        student.setCard(card);
        // THE CARD IS MAPPED TO STUDENT
        card.setStudent(student);
        // no need to write card repository.save because CascadeType.ALL handles creation and
        //deletion
        studentRepository.save(student);
        return "Student Saved Successfully !";
    }

    public String updateStudentByIdPut(int studentId, StudentRequestDto updatestudentdto) {
        Student student = getStudentById(studentId);

        if(student!=null){
            student.setStudentName(updatestudentdto.getStudentName());
            student.setEmail(updatestudentdto.getEmail());
            student.setGender(updatestudentdto.getGender());
            student.setMobile(updatestudentdto.getMobileNumber());
            student.setSem(updatestudentdto.getSem());
            student.setDob(updatestudentdto.getDob());
            student.setDept(updatestudentdto.getDept());
            student.setAddress(updatestudentdto.getAddress());

            studentRepository.save(student);
            return "Student Updated Successfully!"+student.toString();

        }
        return "Student with studentId: "+studentId+" does not exist!";

    }

    public String updateStudentByIdPatch(int studentId,String sem,String address ) {
        Student student = getStudentById(studentId);

        if(student!=null){
            student.setSem(sem);
            student.setAddress(address);

            studentRepository.save(student);
            return "Student with studentId: "+studentId+" Updated Successfully!";

        }
        return "Student with studentId: "+studentId+" does not exist!";

    }


    public Student getStudentById(int studentId){
        Optional<Student> optionalStudent = studentRepository.findById(studentId);

        if(optionalStudent.isPresent()){
            return optionalStudent.get();
        }
        else{
            throw new RuntimeException("Student with id: "+studentId+" not found!");
        }
    }

    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    public String deleteStudentById(int studentId){
        // The corresponding card for the Student will automatically delete when a student
        // is deleted
        studentRepository.deleteById(studentId);
        return "Student with studentId: "+studentId+" Deleted Successfully !";
    }


}
