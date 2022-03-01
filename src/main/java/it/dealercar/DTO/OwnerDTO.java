package it.dealercar.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class OwnerDTO implements Serializable {

    private Long id;
    private String firstname;
    private String lastname;
    private Date birthdate;
    private String mail;

}
