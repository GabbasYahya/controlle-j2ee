package ma.emsi.p2.enumm;



public enum CampaignStatus {
    DRAFT("Brouillon"),
    ACTIVE("Active"),
    SUSPENDED("Suspendue"),
    COMPLETED("Terminée"),
    ARCHIVED("Archivée");

    private final String displayName;

    CampaignStatus(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}