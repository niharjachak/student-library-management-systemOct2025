package com.acciojob.student_library_management_system.requestdtos;

import com.acciojob.student_library_management_system.enums.Availability;
import com.acciojob.student_library_management_system.enums.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// RequestDto -- Data Transfer Objects -- used to take the inputs into APIS and passing
// them to the service layer.
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookRequestDto {

    private String bookName;
    private String bookPublisher;
    private String publishDate;
    private int pages;
    private Category category;
    private String rackNo;


}
