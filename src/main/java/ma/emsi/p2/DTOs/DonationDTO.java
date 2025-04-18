package ma.emsi.p2.DTOs;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Valid
public class DonationDTO {
    private Long id;

    @NotBlank
    private String campaignName;

    @NotBlank
    private String donorName;

    @Min(1)
    private BigDecimal amount;

    private LocalDateTime date;


    public Long getId() {
        return id;
    }
    public String getDonorName() {
        return donorName;
    }
    public  BigDecimal getAmount() {
        return amount;
    }
    public  LocalDateTime getDate() {
        return date;
    }
}