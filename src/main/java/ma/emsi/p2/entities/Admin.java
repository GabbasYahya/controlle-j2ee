package ma.emsi.p2.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "admins")
@PrimaryKeyJoinColumn(name = "user_id")
@Data
public class Admin extends User {

    @OneToMany(mappedBy = "validatedBy")
    private List<Organization> validatedOrganizations = new ArrayList<>();

    // Méthodes spécifiques aux admins
    public void validateOrganization(Organization organization) {
        organization.setValidated(true);
        organization.setValidatedBy(this);
        validatedOrganizations.add(organization);
    }
}