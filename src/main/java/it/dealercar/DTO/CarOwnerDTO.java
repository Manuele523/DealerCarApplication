package it.dealercar.DTO;

import it.dealercar.Enum.StatusPractice;
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
    private OwnerDTO owner;
    private ModelDTO model;
    private Date purchaseDate;
    private Date sellDate;
    private Date dateLastEdit;
    private StatusPractice statusPractice;

}
