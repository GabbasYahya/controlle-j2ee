package ma.emsi.p2.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.emsi.p2.enumm.CampaignCategory;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "campaigns")
@Data
public class Campaign {
    public static Object CampaignStatus;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    private Double fundingGoal;
    private Double amountRaised = 0.0;

    @Enumerated(EnumType.STRING)
    private CampaignCategory category;

    private LocalDate startDate;
    private LocalDate endDate;
    private String location;

    @ManyToOne
    @JoinColumn(name = "organization_id", nullable = false)
    private Organization organization;

    @OneToMany(mappedBy = "campaign", cascade = CascadeType.ALL)
    private List<Donation> donations = new ArrayList<>();

    // Méthode pour calculer le pourcentage de complétion
    public Double getCompletionPercentage() {
        if (fundingGoal == 0) return 0.0;
        return (amountRaised / fundingGoal) * 100;
    }

    public static Object getCampaignStatus() {
        return CampaignStatus;
    }

    public static void setCampaignStatus(Object campaignStatus) {
        CampaignStatus = campaignStatus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getFundingGoal() {
        return fundingGoal;
    }

    public void setFundingGoal(Double fundingGoal) {
        this.fundingGoal = fundingGoal;
    }

    public Double getAmountRaised() {
        return amountRaised;
    }

    public void setAmountRaised(Double amountRaised) {
        this.amountRaised = amountRaised;
    }

    public CampaignCategory getCategory() {
        return category;
    }

    public void setCategory(CampaignCategory category) {
        this.category = category;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public List<Donation> getDonations() {
        return donations;
    }

    public void setDonations(List<Donation> donations) {
        this.donations = donations;
    }

    // Constructeurs, getters, setters
}

