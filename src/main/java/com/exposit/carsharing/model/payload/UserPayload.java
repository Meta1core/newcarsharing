package com.exposit.carsharing.model.payload;

import lombok.Data;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.Date;

@Data
public class UserPayload {

    private String username;

    @Email(message = "Email should be valid")
    private String email;

    private String lastname;

    private String firstname;

    private String passwordseries;

    private Integer passwordnumber;

    private Date passworddate;

    @Min(value = 18, message = "Age should not be less than 18")
    @Max(value = 150, message = "Age should not be greater than 150")
    private Integer age;

    private String address;
}
