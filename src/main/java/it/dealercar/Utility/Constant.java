package it.dealercar.Utility;

import lombok.*;

public class Constant {

    public static String EMPTY_STRING = "";
    public static String SINGLE_SPACE = " ";


    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public enum CodeStatWarning {
        BRAND_ASSOCIATED_FOUND("010", "Brand can't be deleted because have model associated to Owner"),
        MODEL_ASSOCIATED_FOUND("011", "Model can't be deleted because is purchased by owner!");

        private String code;
        private String description;

    }

}
