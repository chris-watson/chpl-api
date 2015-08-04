package gov.healthit.chpl.entity;


import java.io.Serializable;
import java.util.Collections;
import java.util.Date;
import java.util.Map;
import java.util.WeakHashMap;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

/** 
 * Object mapping for hibernate-handled table: certification_result.
 * 
 *
 * @author autogenerated / cwatson
 */

@Entity
@Table(name = "certification_result", catalog = "openchpl", schema = "openchpl")
public class CertificationResult implements Serializable {

	/** Serial Version UID. */
	private static final long serialVersionUID = -9050374846030066967L;

	/** Use a WeakHashMap so entries will be garbage collected once all entities 
		referring to a saved hash are garbage collected themselves. */
	private static final Map<Serializable, Long> SAVED_HASHES =
		Collections.synchronizedMap(new WeakHashMap<Serializable, Long>());
	
	/** hashCode temporary storage. */
	private volatile Long hashCode;
	

	/** Field mapping. */
	private Boolean automatedMeasureCapable;
	/** Field mapping. */
	private Boolean automatedNumerator;
	/** Field mapping. */
	private Long certificationCriterionId;
	/** Field mapping. */
	private CertifiedProduct certifiedProduct;
	/** Field mapping. */
	private Date creationDate;
	/** Field mapping. */
	private Boolean deleted;
	/** Field mapping. */
	private Boolean gap;
	/** Field mapping. */
	private Long id;
	/** Field mapping. */
	private Boolean inherited;
	/** Field mapping. */
	private Date lastModifiedDate;
	/** Field mapping. */
	private Long lastModifiedUser;

	/** Field mapping. */
	private Boolean sedInherited;
	/** Field mapping. */
	private Boolean sedSuccessful;
	/** Field mapping. */
	private Boolean successful;
	/** Field mapping. */
	private Long testDataVersionId;
	/** Field mapping. */
	private Long testProcedureVersionId;
	/**
	 * Default constructor, mainly for hibernate use.
	 */
	public CertificationResult() {
		// Default constructor
	} 

	/** Constructor taking a given ID.
	 * @param id to set
	 */
	public CertificationResult(Long id) {
		this.id = id;
	}
	
 	/** Return the type of this class. Useful for when dealing with proxies.
	* @return Defining class.
	*/
	@Transient
	public Class<?> getClassType() {
		return CertificationResult.class;
	}
 

	 /**
	 * Return the value associated with the column: automatedMeasureCapable.
	 * @return A Boolean object (this.automatedMeasureCapable)
	 */
	@Basic( optional = true )
	@Column( name = "automated_measure_capable"  )
	public Boolean isAutomatedMeasureCapable() {
		return this.automatedMeasureCapable;
		
	}
	

  
	 /**  
	 * Set the value related to the column: automatedMeasureCapable.
	 * @param automatedMeasureCapable the automatedMeasureCapable value you wish to set
	 */
	public void setAutomatedMeasureCapable(final Boolean automatedMeasureCapable) {
		this.automatedMeasureCapable = automatedMeasureCapable;
	}

	 /**
	 * Return the value associated with the column: automatedNumerator.
	 * @return A Boolean object (this.automatedNumerator)
	 */
	@Basic( optional = true )
	@Column( name = "automated_numerator"  )
	public Boolean isAutomatedNumerator() {
		return this.automatedNumerator;
		
	}
	

  
	 /**  
	 * Set the value related to the column: automatedNumerator.
	 * @param automatedNumerator the automatedNumerator value you wish to set
	 */
	public void setAutomatedNumerator(final Boolean automatedNumerator) {
		this.automatedNumerator = automatedNumerator;
	}

	 /**
	 * Return the value associated with the column: certificationCriterion.
	 * @return A CertificationCriterion object (this.certificationCriterion)
	 */
	public Long getCertificationCriterionId() {
		return this.certificationCriterionId;
	}
	

  
	 /**  
	 * Set the value related to the column: certificationCriterion.
	 * @param certificationCriterion the certificationCriterion value you wish to set
	 */
	public void setCertificationCriterion(final Long certificationCriterionId) {
		this.certificationCriterionId = certificationCriterionId;
	}

	 /**
	 * Return the value associated with the column: certifiedProduct.
	 * @return A CertifiedProduct object (this.certifiedProduct)
	 */
	public CertifiedProduct getCertifiedProduct() {
		return this.certifiedProduct;
		
	}
	

  
	 /**  
	 * Set the value related to the column: certifiedProduct.
	 * @param certifiedProduct the certifiedProduct value you wish to set
	 */
	public void setCertifiedProduct(final CertifiedProduct certifiedProduct) {
		this.certifiedProduct = certifiedProduct;
	}

	 /**
	 * Return the value associated with the column: creationDate.
	 * @return A Date object (this.creationDate)
	 */
	@Basic( optional = false )
	@Column( name = "creation_date", nullable = false  )
	public Date getCreationDate() {
		return this.creationDate;
		
	}
	

  
	 /**  
	 * Set the value related to the column: creationDate.
	 * @param creationDate the creationDate value you wish to set
	 */
	public void setCreationDate(final Date creationDate) {
		this.creationDate = creationDate;
	}

	 /**
	 * Return the value associated with the column: deleted.
	 * @return A Boolean object (this.deleted)
	 */
	@Basic( optional = false )
	@Column( nullable = false  )
	public Boolean isDeleted() {
		return this.deleted;
		
	}
	

  
	 /**  
	 * Set the value related to the column: deleted.
	 * @param deleted the deleted value you wish to set
	 */
	public void setDeleted(final Boolean deleted) {
		this.deleted = deleted;
	}

	 /**
	 * Return the value associated with the column: gap.
	 * @return A Boolean object (this.gap)
	 */
	public Boolean isGap() {
		return this.gap;
		
	}
	

  
	 /**  
	 * Set the value related to the column: gap.
	 * @param gap the gap value you wish to set
	 */
	public void setGap(final Boolean gap) {
		this.gap = gap;
	}

	 /**
	 * Return the value associated with the column: id.
	 * @return A Long object (this.id)
	 */
    @Id 
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "certificationResultCertification_result_idGenerator")
	@Basic( optional = false )
	@Column( name = "certification_result_id", nullable = false  )
	@SequenceGenerator(name = "certificationResultCertification_result_idGenerator", sequenceName = "openchpl.openchpl.certification_result_certification_result_id_seq", schema = "openchpl", catalog = "openchpl")
	public Long getId() {
		return this.id;
		
	}
	

  
	 /**  
	 * Set the value related to the column: id.
	 * @param id the id value you wish to set
	 */
	public void setId(final Long id) {
		// If we've just been persisted and hashCode has been
		// returned then make sure other entities with this
		// ID return the already returned hash code
		if ( (this.id == null || this.id == 0L) &&
				(id != null) &&
				(this.hashCode != null) ) {
		SAVED_HASHES.put( id, this.hashCode );
		}
		this.id = id;
	}

	 /**
	 * Return the value associated with the column: inherited.
	 * @return A Boolean object (this.inherited)
	 */
	public Boolean isInherited() {
		return this.inherited;
		
	}
	

  
	 /**  
	 * Set the value related to the column: inherited.
	 * @param inherited the inherited value you wish to set
	 */
	public void setInherited(final Boolean inherited) {
		this.inherited = inherited;
	}

	 /**
	 * Return the value associated with the column: lastModifiedDate.
	 * @return A Date object (this.lastModifiedDate)
	 */
	@Basic( optional = false )
	@Column( name = "last_modified_date", nullable = false  )
	public Date getLastModifiedDate() {
		return this.lastModifiedDate;
		
	}
	

  
	 /**  
	 * Set the value related to the column: lastModifiedDate.
	 * @param lastModifiedDate the lastModifiedDate value you wish to set
	 */
	public void setLastModifiedDate(final Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	 /**
	 * Return the value associated with the column: lastModifiedUser.
	 * @return A Long object (this.lastModifiedUser)
	 */
	@Basic( optional = false )
	@Column( name = "last_modified_user", nullable = false  )
	public Long getLastModifiedUser() {
		return this.lastModifiedUser;
		
	}
	

  
	 /**  
	 * Set the value related to the column: lastModifiedUser.
	 * @param lastModifiedUser the lastModifiedUser value you wish to set
	 */
	public void setLastModifiedUser(final Long lastModifiedUser) {
		this.lastModifiedUser = lastModifiedUser;
	}
	
	 /**
	 * Return the value associated with the column: sedInherited.
	 * @return A Boolean object (this.sedInherited)
	 */
	@Basic( optional = true )
	@Column( name = "sed_inherited"  )
	public Boolean isSedInherited() {
		return this.sedInherited;
		
	}
	

  
	 /**  
	 * Set the value related to the column: sedInherited.
	 * @param sedInherited the sedInherited value you wish to set
	 */
	public void setSedInherited(final Boolean sedInherited) {
		this.sedInherited = sedInherited;
	}

	 /**
	 * Return the value associated with the column: sedSuccessful.
	 * @return A Boolean object (this.sedSuccessful)
	 */
	@Basic( optional = true )
	@Column( name = "sed_successful"  )
	public Boolean isSedSuccessful() {
		return this.sedSuccessful;
		
	}
	

	 /**  
	 * Set the value related to the column: sedSuccessful.
	 * @param sedSuccessful the sedSuccessful value you wish to set
	 */
	public void setSedSuccessful(final Boolean sedSuccessful) {
		this.sedSuccessful = sedSuccessful;
	}


	 /**
	 * Return the value associated with the column: successful.
	 * @return A Boolean object (this.successful)
	 */
	@Basic( optional = false )
	@Column( nullable = false  )
	public Boolean isSuccessful() {
		return this.successful;
		
	}
	

  
	 /**  
	 * Set the value related to the column: successful.
	 * @param successful the successful value you wish to set
	 */
	public void setSuccessful(final Boolean successful) {
		this.successful = successful;
	}

	 /**
	 * Return the value associated with the column: testDataVersion.
	 * @return A TestDataVersion object (this.testDataVersion)
	 */
	public Long getTestDataVersionId() {
		return this.testDataVersionId;
		
	}
	

  
	 /**  
	 * Set the value related to the column: testDataVersion.
	 * @param testDataVersion the testDataVersion value you wish to set
	 */
	public void setTestDataVersion(final Long testDataVersionId) {
		this.testDataVersionId = testDataVersionId;
	}

	 /**
	 * Return the value associated with the column: testProcedureVersion.
	 * @return A TestProcedureVersion object (this.testProcedureVersion)
	 */
	public Long getTestProcedureVersionId() {
		return this.testProcedureVersionId;
		
	}
	
	 /**  
	 * Set the value related to the column: testProcedureVersion.
	 * @param testProcedureVersion the testProcedureVersion value you wish to set
	 */
	public void setTestProcedureVersion(Long testProcedureVersion) {
		this.testProcedureVersionId = testProcedureVersion;
	}
	
	/** Equals implementation. 
	 * @see java.lang.Object#equals(java.lang.Object)
	 * @param aThat Object to compare with
	 * @return true/false
	 */
	@Override
	public boolean equals(final Object aThat) {
		Object proxyThat = aThat;
		
		if ( this == aThat ) {
			 return true;
		}
		
		if (aThat == null)  {
			 return false;
		}
		
		final CertificationResult that; 
		try {
			that = (CertificationResult) proxyThat;
			if ( !(that.getClassType().equals(this.getClassType()))){
				return false;
			}
		} catch (org.hibernate.ObjectNotFoundException e) {
				return false;
		} catch (ClassCastException e) {
				return false;
		}
		
		
		boolean result = true;
		result = result && (((this.getId() == null) && ( that.getId() == null)) || (this.getId() != null  && this.getId().equals(that.getId())));
		result = result && (((isAutomatedMeasureCapable() == null) && (that.isAutomatedMeasureCapable() == null)) || (isAutomatedMeasureCapable() != null && isAutomatedMeasureCapable().equals(that.isAutomatedMeasureCapable())));
		result = result && (((isAutomatedNumerator() == null) && (that.isAutomatedNumerator() == null)) || (isAutomatedNumerator() != null && isAutomatedNumerator().equals(that.isAutomatedNumerator())));
		result = result && (((getCertificationCriterionId() == null) && (that.getCertificationCriterionId() == null)) || (getCertificationCriterionId() != null && getCertificationCriterionId().equals(that.getCertificationCriterionId())));	
		result = result && (((getCertifiedProduct() == null) && (that.getCertifiedProduct() == null)) || (getCertifiedProduct() != null && getCertifiedProduct().getId().equals(that.getCertifiedProduct().getId())));	
		result = result && (((getCreationDate() == null) && (that.getCreationDate() == null)) || (getCreationDate() != null && getCreationDate().equals(that.getCreationDate())));
		result = result && (((isDeleted() == null) && (that.isDeleted() == null)) || (isDeleted() != null && isDeleted().equals(that.isDeleted())));
		result = result && (((isGap() == null) && (that.isGap() == null)) || (isGap() != null && isGap().equals(that.isGap())));
		result = result && (((isInherited() == null) && (that.isInherited() == null)) || (isInherited() != null && isInherited().equals(that.isInherited())));
		result = result && (((getLastModifiedDate() == null) && (that.getLastModifiedDate() == null)) || (getLastModifiedDate() != null && getLastModifiedDate().equals(that.getLastModifiedDate())));
		result = result && (((getLastModifiedUser() == null) && (that.getLastModifiedUser() == null)) || (getLastModifiedUser() != null && getLastModifiedUser().equals(that.getLastModifiedUser())));
		result = result && (((isSedInherited() == null) && (that.isSedInherited() == null)) || (isSedInherited() != null && isSedInherited().equals(that.isSedInherited())));
		result = result && (((isSedSuccessful() == null) && (that.isSedSuccessful() == null)) || (isSedSuccessful() != null && isSedSuccessful().equals(that.isSedSuccessful())));
		result = result && (((isSuccessful() == null) && (that.isSuccessful() == null)) || (isSuccessful() != null && isSuccessful().equals(that.isSuccessful())));
		result = result && (((getTestDataVersionId() == null) && (that.getTestDataVersionId() == null)) || (getTestDataVersionId() != null && getTestDataVersionId().equals(that.getTestDataVersionId())));	
		result = result && (((getTestProcedureVersionId() == null) && (that.getTestProcedureVersionId() == null)) || (getTestProcedureVersionId() != null && getTestProcedureVersionId().equals(that.getTestProcedureVersionId())));	
		return result;
	}
	
	/** Calculate the hashcode.
	 * @see java.lang.Object#hashCode()
	 * @return a calculated number
	 */
	@Override
	public int hashCode() {
		if ( this.hashCode == null ) {
			synchronized ( this ) {
				if ( this.hashCode == null ) {
					Long newHashCode = null;

					if ( getId() != null ) {
					newHashCode = SAVED_HASHES.get( getId() );
					}
					
					if ( newHashCode == null ) {
						if ( getId() != null && getId() != 0L) {
							newHashCode = getId();
						} else {
							newHashCode = (long) super.hashCode();

						}
					}
					
					this.hashCode = newHashCode;
				}
			}
		}
		return (int) (this.hashCode & 0xffffff);
	}
	

	
}