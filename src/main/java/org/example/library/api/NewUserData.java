package org.example.library.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewUserData {

    private String login;
    private String password;
    private String name;
    private String email;
    private String postalCode;
    private String city;
    private String street;
    private String apartmentNo;
    private String buildingNo;
}
