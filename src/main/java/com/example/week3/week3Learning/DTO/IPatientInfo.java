package com.example.week3.week3Learning.DTO;

import java.time.LocalDate;

public interface IPatientInfo {
//This interface can be empty also, still the query and repo method will give correct results, as when interface is
// empty, Spring falls back to Tuple / Map-based projection.
// But if we want to interact with any information, then we need these methods
    Integer getId();
    String getFirstName();
    String getLastName();
    String getEmail();

}
