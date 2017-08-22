/**
 * 
 */
package com.poc.pet.cms.app.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @author Eraine
 *
 */
@Entity
@Table(name = "pet")
public class Pet {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@Column(name = "date_added")
	private Date dateAdded;
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@Column(name = "update_date")
	private Date updateDate;

	@Column
	private String status;

	@OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
	@JoinColumn(name = "pet_details_id")
	private PetDetails petDetails;

	@OneToOne(cascade = {CascadeType.MERGE}, fetch = FetchType.EAGER)
	@JoinColumn(name = "pet_type_id")
	private PetType petType;

	public Pet() {
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the dateAdded
	 */
	public Date getDateAdded() {
		return dateAdded;
	}

	/**
	 * @param dateAdded
	 *            the dateAdded to set
	 */
	public void setDateAdded(Date dateAdded) {
		this.dateAdded = dateAdded;
	}

	/**
	 * @return the updateDate
	 */
	public Date getUpdateDate() {
		return updateDate;
	}

	/**
	 * @param updateDate the updateDate to set
	 */
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the petDetails
	 */
	public PetDetails getPetDetails() {
		return petDetails;
	}

	/**
	 * @param petDetails
	 *            the petDetails to set
	 */
	public void setPetDetails(PetDetails petDetails) {
		this.petDetails = petDetails;
	}

	/**
	 * @return the petType
	 */
	public PetType getPetType() {
		return petType;
	}

	/**
	 * @param petType
	 *            the petType to set
	 */
	public void setPetType(PetType petType) {
		this.petType = petType;
	}

	@Override
	public String toString() {
		return "Pet [id=" + id + ", dateAdded=" + dateAdded + ", status=" + status + ", petDetails=" + petDetails
				+ ", petType=" + petType + "]";
	}
	
	@PrePersist
	public void prePersist() {
		final Date dateNow = new Date();
		dateAdded = dateNow;
		updateDate = dateNow;
	}
	
	@PreUpdate
	public void preUpdate() {
		final Date dateNow = new Date();
		
		if (dateAdded == null) {
			dateAdded = dateNow;
		}
		
		updateDate = dateNow;
	}

}
