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
public class CarOwnerDTO implements Serializable {

    private Long id;
    private Long idModel;
    private Long idOwner;
    private Date purchaseDate;
    private Date sellDate;

}
