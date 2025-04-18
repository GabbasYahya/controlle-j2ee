package ma.emsi.p2.enumm;



public enum UserRole {
    USER("Utilisateur standard"),
    ORG_ADMIN("Administrateur d'organisation"),
    SUPER_ADMIN("Super administrateur");

    private final String description;

    UserRole(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}