package com.acciojob.student_library_management_system.requestdtos;

// RequestDto -- Data Transfer Objects -- used to take the inputs into APIS and passing
// them to the service layer.

import lombok.Data;

@Data
public class StudentRequestDto {

    private String studentName;
    private String email;
    private String mobileNumber;
    private String dept;
    private String sem;
    private String gender;
    private String address;
    private String dob;


}
