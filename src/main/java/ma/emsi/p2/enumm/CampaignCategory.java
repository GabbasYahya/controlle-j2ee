package ma.emsi.p2.enumm;



public enum CampaignCategory {
    EDUCATION("Éducation"),
    HEALTH("Santé"),
    ENVIRONMENT("Environnement"),
    POVERTY("Lutte contre la pauvreté"),
    ANIMAL_WELFARE("Protection animale"),
    HUMANITARIAN("Aide humanitaire"),
    OTHER("Autre");

    private final String displayName;

    CampaignCategory(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
