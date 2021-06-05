package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="experiences")
@NoArgsConstructor
@AllArgsConstructor
public class Experience {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name="working_place")
	@NotNull
    @NotBlank
	private String workingPlace;
	
	@Column(name="position")
	@NotNull
    @NotBlank
	private String position;
	
	@Column(name="started_date")
	@NotNull
	private LocalDate startDate;
	
	@Column(name="finish_date")
	private LocalDate finishDate;
	
	@JsonIgnore
	@Column(name="created_date",nullable = true)
	private LocalDate createdDate = LocalDate.now();
	
	@JsonIgnore
	@Column(name="is_active")
	private boolean isActive;
	
	@JsonIgnore
	@Column(name="is_deleted")
	private boolean isDeleted;
	
	@ManyToOne
	@JoinColumn(name="job_seeker_id")
	//@JsonIgnore
	private JobSeeker jobSeeker;
}
