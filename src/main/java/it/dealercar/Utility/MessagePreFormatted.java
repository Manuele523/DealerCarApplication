package it.dealercar.Utility;

import it.dealercar.Entity.BrandEntity;
import it.dealercar.Entity.ModelEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

public class MessagePreFormatted {

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    @ToString
    public enum ActionType {
        INSERT("Insert"), UPDATE("Update"), DELETE("Delete");

        private String code;
    }

    public static String buildOkMsgModel(ActionType type, ModelEntity model) throws Exception {
        return type.getCode().concat(Constant.SINGLE_SPACE).concat(model.getTitle()).concat(" of Brand ").concat(model.getBrand().getTitle());
    }
    public static String buildKoMsgModel(ActionType type, ModelEntity model) throws Exception {
        return "Error! - It wasn't possible to ".concat(type.getCode()).concat(" Model! ( ").concat(model.getTitle()).concat(" of Brand ").concat(model.getBrand().getTitle()).concat(" )");
    }

    public static String buildOkMsgBrand(ActionType type, BrandEntity brand) throws Exception {
        return type.getCode().concat(Constant.SINGLE_SPACE).concat(brand.getTitle());
    }

    public static String buildKoMsgBrand(ActionType type, BrandEntity brand) throws Exception {
        return "Error! - It wasn't possible to ".concat(type.getCode()).concat(" Brand! ( ").concat(brand.getTitle()).concat(" )");
    }

}
