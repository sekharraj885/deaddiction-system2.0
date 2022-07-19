package deddictionsystem2.model;

public enum Addictiontype {
    ALCOHOL("Alcohol"),
    DRUGS("drugs"),
    GAMBLING("Gambling"),
    VIDEOGAMES("Video games"),
    SHOPPING("Shopping");

    private final String addiction;

    Addictiontype(String addiction) {
        this.addiction = addiction;
    }
}
