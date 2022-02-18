package it.dealercar.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ModelDTO implements Serializable {

    private Long id;
    private String Code;
    private String title;
    private BrandDTO brand;

}
