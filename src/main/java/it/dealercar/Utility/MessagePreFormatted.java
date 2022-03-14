package it.dealercar.Utility;

import it.dealercar.Entity.BrandEntity;
import it.dealercar.Entity.ModelEntity;

public class MessagePreFormatted {

    public enum ActionType {
        INSERT("Insert"), UPDATE("Update"), DELETE("Delete");

        ActionType(String type) {
        }
    }

    public static String buildOkMsgModel(ActionType type, ModelEntity model) throws Exception {
        return type.name().concat(Constant.SINGLE_SPACE).concat(model.getTitle()).concat(" of Brand ").concat(model.getBrand().getTitle());
    }
    public static String buildKoMsgModel(ActionType type, ModelEntity model) throws Exception {
        return "It wasn't possible to ".concat(type.name()).concat(" Model! ( ").concat(model.getTitle()).concat(" of Brand ").concat(model.getBrand().getTitle()).concat(" )");
    }

    public static String buildOkMsgBrand(ActionType type, BrandEntity brand) throws Exception {
        return type.name().concat(Constant.SINGLE_SPACE).concat(brand.getTitle());
    }

    public static String buildKoMsgBrand(ActionType type, BrandEntity brand) throws Exception {
        return "It wasn't possible to ".concat(type.name()).concat(" Brand! ( ").concat(brand.getTitle()).concat(" )");
    }

}
