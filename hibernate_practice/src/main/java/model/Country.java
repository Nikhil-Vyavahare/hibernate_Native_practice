package model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "countries")
public class Country {
	 	@Id
	    @Column(name = "country_id")
	    private String countryId;

	    @Column(name = "country_name")
	    private String countryName;
	    
	    @ManyToOne
	    @JoinColumn(name = "region_id")
	    private Region region;
}
