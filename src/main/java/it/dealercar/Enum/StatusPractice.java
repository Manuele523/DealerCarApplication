package it.dealercar.Enum;

public enum StatusPractice {

    START("ST"),    // PRATICA AVVIATA
    ON_DISPLAY("OD"),   // PRATICA IN VISIONE
    CLOSE_AND_OWNED("CO");  // PRATICA CHIUSA

    private String status;

    StatusPractice(String od) {
    }

}
