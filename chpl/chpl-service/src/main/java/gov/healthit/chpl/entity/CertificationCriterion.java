package gov.healthit.chpl.entity;

import gov.healthit.chpl.entity.CertificationCriterion;
import gov.healthit.chpl.entity.CertificationResult;
import gov.healthit.chpl.entity.CriterionOptionalFunctionality;
import gov.healthit.chpl.entity.CriterionStandard;
import gov.healthit.chpl.entity.NewerStandardsMet;
import gov.healthit.chpl.entity.TestDataVersion;
import gov.healthit.chpl.entity.TestProcedureVersion;
import gov.healthit.chpl.entity.TestTask;
import java.io.Serializable;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import org.hibernate.proxy.HibernateProxy;


/** 
 * Object mapping for hibernate-handled table: certification_criterion.
 * 
 *
 * @author autogenerated
 */

@Entity
@Table(name = "certification_criterion", catalog = "openchpl", schema = "openchpl")
public class CertificationCriterion implements Cloneable, Serializable {

	/** Serial Version UID. */
	private static final long serialVersionUID = 5366674516357955978L;

	/** Use a WeakHashMap so entries will be garbage collected once all entities 
		referring to a saved hash are garbage collected themselves. */
	private static final Map<Serializable, Long> SAVED_HASHES =
		Collections.synchronizedMap(new WeakHashMap<Serializable, Long>());
	
	/** hashCode temporary storage. */
	private volatile Long hashCode;
	

	/** Field mapping. */
	private Boolean automatedMeasureCapable;
	/** Field mapping. */
	private Boolean automatedNumeratorCapable;
	/** Field mapping. */
	private Set<CertificationCriterion> certificationCriterions = new HashSet<CertificationCriterion>();

	/** Field mapping. */
	private Set<CertificationResult> certificationResults = new HashSet<CertificationResult>();

	/** Field mapping. */
	private CertificationEdition certificationEdition;
	/** Field mapping. */
	private Date creationDate;
	/** Field mapping. */
	private Set<CriterionOptionalFunctionality> criterionOptionalFunctionalities = new HashSet<CriterionOptionalFunctionality>();

	/** Field mapping. */
	private Set<CriterionStandard> criterionStandards = new HashSet<CriterionStandard>();

	/** Field mapping. */
	private Boolean deleted;
	/** Field mapping. */
	private String description;
	/** Field mapping. */
	private Long id;
	/** Field mapping. */
	private Date lastModifiedDate;
	/** Field mapping. */
	private Long lastModifiedUser;
	/** Field mapping. */
	private Set<NewerStandardsMet> newerStandardsMets = new HashSet<NewerStandardsMet>();

	/** Field mapping. */
	private String number;
	/** Field mapping. */
	private CertificationCriterion parentCriterion;
	/** Field mapping. */
	private Boolean requiresSed;
	/** Field mapping. */
	private Set<TestDataVersion> testDataVersions = new HashSet<TestDataVersion>();

	/** Field mapping. */
	private Set<TestProcedureVersion> testProcedureVersions = new HashSet<TestProcedureVersion>();

	/** Field mapping. */
	private Set<TestTask> testTasks = new HashSet<TestTask>();

	/** Field mapping. */
	private String title;
	/**
	 * Default constructor, mainly for hibernate use.
	 */
	public CertificationCriterion() {
		// Default constructor
	} 

	/** Constructor taking a given ID.
	 * @param id to set
	 */
	public CertificationCriterion(Long id) {
		this.id = id;
	}
	
	/** Constructor taking a given ID.
	 * @param certificationEdition CertificationEdition object;
	 * @param creationDate Date object;
	 * @param deleted Boolean object;
	 * @param id Long object;
	 * @param lastModifiedDate Date object;
	 * @param lastModifiedUser Long object;
	 */
	public CertificationCriterion(CertificationEdition certificationEdition, Date creationDate, Boolean deleted, 					
			Long id, Date lastModifiedDate, Long lastModifiedUser) {

		this.certificationEdition = certificationEdition;
		this.creationDate = creationDate;
		this.deleted = deleted;
		this.id = id;
		this.lastModifiedDate = lastModifiedDate;
		this.lastModifiedUser = lastModifiedUser;
	}
	
 


 
	/** Return the type of this class. Useful for when dealing with proxies.
	* @return Defining class.
	*/
	@Transient
	public Class<?> getClassType() {
		return CertificationCriterion.class;
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
	 * Return the value associated with the column: automatedNumeratorCapable.
	 * @return A Boolean object (this.automatedNumeratorCapable)
	 */
	@Basic( optional = true )
	@Column( name = "automated_numerator_capable"  )
	public Boolean isAutomatedNumeratorCapable() {
		return this.automatedNumeratorCapable;
		
	}
	

  
	 /**  
	 * Set the value related to the column: automatedNumeratorCapable.
	 * @param automatedNumeratorCapable the automatedNumeratorCapable value you wish to set
	 */
	public void setAutomatedNumeratorCapable(final Boolean automatedNumeratorCapable) {
		this.automatedNumeratorCapable = automatedNumeratorCapable;
	}

	 /**
	 * Return the value associated with the column: certificationCriterion.
	 * @return A Set&lt;CertificationCriterion&gt; object (this.certificationCriterion)
	 */
 	@OneToMany( fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "parentCriterion"  )
 	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
	@Basic( optional = false )
	@Column( name = "certification_criterion_id", nullable = false  )
	public Set<CertificationCriterion> getCertificationCriterions() {
		return this.certificationCriterions;
		
	}
	
	/**
	 * Adds a bi-directional link of type CertificationCriterion to the certificationCriterions set.
	 * @param certificationCriterion item to add
	 */
	public void addCertificationCriterion(CertificationCriterion certificationCriterion) {
		certificationCriterion.setParentCriterion(this);
		this.certificationCriterions.add(certificationCriterion);
	}

  
	 /**  
	 * Set the value related to the column: certificationCriterion.
	 * @param certificationCriterion the certificationCriterion value you wish to set
	 */
	public void setCertificationCriterions(final Set<CertificationCriterion> certificationCriterion) {
		this.certificationCriterions = certificationCriterion;
	}

	 /**
	 * Return the value associated with the column: certificationResult.
	 * @return A Set&lt;CertificationResult&gt; object (this.certificationResult)
	 */
 	@OneToMany( fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "certificationCriterion"  )
 	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
	@Basic( optional = false )
	@Column( name = "certification_criterion_id", nullable = false  )
	public Set<CertificationResult> getCertificationResults() {
		return this.certificationResults;
		
	}
	
	/**
	 * Adds a bi-directional link of type CertificationResult to the certificationResults set.
	 * @param certificationResult item to add
	 */
	public void addCertificationResult(CertificationResult certificationResult) {
		certificationResult.setCertificationCriterion(this);
		this.certificationResults.add(certificationResult);
	}

  
	 /**  
	 * Set the value related to the column: certificationResult.
	 * @param certificationResult the certificationResult value you wish to set
	 */
	public void setCertificationResults(final Set<CertificationResult> certificationResult) {
		this.certificationResults = certificationResult;
	}

	 /**
	 * Return the value associated with the column: certificationEdition.
	 * @return A CertificationEdition object (this.certificationEdition)
	 */
	@ManyToOne( cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.LAZY )
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
	@Basic( optional = false )
	@JoinColumn(name = "certification_edition_id", nullable = false )
	public CertificationEdition getCertificationEdition() {
		return this.certificationEdition;
		
	}
	

  
	 /**  
	 * Set the value related to the column: certificationEdition.
	 * @param certificationEdition the certificationEdition value you wish to set
	 */
	public void setCertificationEdition(final CertificationEdition certificationEdition) {
		this.certificationEdition = certificationEdition;
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
	 * Return the value associated with the column: criterionOptionalFunctionality.
	 * @return A Set&lt;CriterionOptionalFunctionality&gt; object (this.criterionOptionalFunctionality)
	 */
 	@OneToMany( fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "certificationCriterion"  )
 	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
	@Basic( optional = false )
	@Column( name = "certification_criterion_id", nullable = false  )
	public Set<CriterionOptionalFunctionality> getCriterionOptionalFunctionalities() {
		return this.criterionOptionalFunctionalities;
		
	}
	
	/**
	 * Adds a bi-directional link of type CriterionOptionalFunctionality to the criterionOptionalFunctionalities set.
	 * @param criterionOptionalFunctionality item to add
	 */
	public void addCriterionOptionalFunctionality(CriterionOptionalFunctionality criterionOptionalFunctionality) {
		criterionOptionalFunctionality.setCertificationCriterion(this);
		this.criterionOptionalFunctionalities.add(criterionOptionalFunctionality);
	}

  
	 /**  
	 * Set the value related to the column: criterionOptionalFunctionality.
	 * @param criterionOptionalFunctionality the criterionOptionalFunctionality value you wish to set
	 */
	public void setCriterionOptionalFunctionalities(final Set<CriterionOptionalFunctionality> criterionOptionalFunctionality) {
		this.criterionOptionalFunctionalities = criterionOptionalFunctionality;
	}

	 /**
	 * Return the value associated with the column: criterionStandard.
	 * @return A Set&lt;CriterionStandard&gt; object (this.criterionStandard)
	 */
 	@OneToMany( fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "certificationCriterion"  )
 	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
	@Basic( optional = false )
	@Column( name = "certification_criterion_id", nullable = false  )
	public Set<CriterionStandard> getCriterionStandards() {
		return this.criterionStandards;
		
	}
	
	/**
	 * Adds a bi-directional link of type CriterionStandard to the criterionStandards set.
	 * @param criterionStandard item to add
	 */
	public void addCriterionStandard(CriterionStandard criterionStandard) {
		criterionStandard.setCertificationCriterion(this);
		this.criterionStandards.add(criterionStandard);
	}

  
	 /**  
	 * Set the value related to the column: criterionStandard.
	 * @param criterionStandard the criterionStandard value you wish to set
	 */
	public void setCriterionStandards(final Set<CriterionStandard> criterionStandard) {
		this.criterionStandards = criterionStandard;
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
	 * Return the value associated with the column: description.
	 * @return A String object (this.description)
	 */
	@Basic( optional = true )
	@Column( length = 1000  )
	public String getDescription() {
		return this.description;
		
	}
	

  
	 /**  
	 * Set the value related to the column: description.
	 * @param description the description value you wish to set
	 */
	public void setDescription(final String description) {
		this.description = description;
	}

	 /**
	 * Return the value associated with the column: id.
	 * @return A Long object (this.id)
	 */
    @Id 
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "certificationCriterionCertification_criterion_idGenerator")
	@Basic( optional = false )
	@Column( name = "certification_criterion_id", nullable = false  )
	@SequenceGenerator(name = "certificationCriterionCertification_criterion_idGenerator", sequenceName = "openchpl.openchpl.certification_criterion_certification_criterion_id_seq", schema = "openchpl", catalog = "openchpl")
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
	 * Return the value associated with the column: newerStandardsMet.
	 * @return A Set&lt;NewerStandardsMet&gt; object (this.newerStandardsMet)
	 */
 	@OneToMany( fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "certificationCriterion"  )
 	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
	@Basic( optional = false )
	@Column( name = "certification_criterion_id", nullable = false  )
	public Set<NewerStandardsMet> getNewerStandardsMets() {
		return this.newerStandardsMets;
		
	}
	
	/**
	 * Adds a bi-directional link of type NewerStandardsMet to the newerStandardsMets set.
	 * @param newerStandardsMet item to add
	 */
	public void addNewerStandardsMet(NewerStandardsMet newerStandardsMet) {
		newerStandardsMet.setCertificationCriterion(this);
		this.newerStandardsMets.add(newerStandardsMet);
	}

  
	 /**  
	 * Set the value related to the column: newerStandardsMet.
	 * @param newerStandardsMet the newerStandardsMet value you wish to set
	 */
	public void setNewerStandardsMets(final Set<NewerStandardsMet> newerStandardsMet) {
		this.newerStandardsMets = newerStandardsMet;
	}

	 /**
	 * Return the value associated with the column: number.
	 * @return A String object (this.number)
	 */
	@Basic( optional = true )
	@Column( length = 15  )
	public String getNumber() {
		return this.number;
		
	}
	

  
	 /**  
	 * Set the value related to the column: number.
	 * @param number the number value you wish to set
	 */
	public void setNumber(final String number) {
		this.number = number;
	}

	 /**
	 * Return the value associated with the column: parentCriterion.
	 * @return A CertificationCriterion object (this.parentCriterion)
	 */
	@ManyToOne( cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.LAZY )
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
	@Basic( optional = true )
	@JoinColumn(name = "parent_criterion_id", nullable = true )
	public CertificationCriterion getParentCriterion() {
		return this.parentCriterion;
		
	}
	

  
	 /**  
	 * Set the value related to the column: parentCriterion.
	 * @param parentCriterion the parentCriterion value you wish to set
	 */
	public void setParentCriterion(final CertificationCriterion parentCriterion) {
		this.parentCriterion = parentCriterion;
	}

	 /**
	 * Return the value associated with the column: requiresSed.
	 * @return A Boolean object (this.requiresSed)
	 */
	@Basic( optional = true )
	@Column( name = "requires_sed"  )
	public Boolean isRequiresSed() {
		return this.requiresSed;
		
	}
	

  
	 /**  
	 * Set the value related to the column: requiresSed.
	 * @param requiresSed the requiresSed value you wish to set
	 */
	public void setRequiresSed(final Boolean requiresSed) {
		this.requiresSed = requiresSed;
	}

	 /**
	 * Return the value associated with the column: testDataVersion.
	 * @return A Set&lt;TestDataVersion&gt; object (this.testDataVersion)
	 */
 	@OneToMany( fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "certificationCriterion"  )
 	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
	@Basic( optional = false )
	@Column( name = "certification_criterion_id", nullable = false  )
	public Set<TestDataVersion> getTestDataVersions() {
		return this.testDataVersions;
		
	}
	
	/**
	 * Adds a bi-directional link of type TestDataVersion to the testDataVersions set.
	 * @param testDataVersion item to add
	 */
	public void addTestDataVersion(TestDataVersion testDataVersion) {
		testDataVersion.setCertificationCriterion(this);
		this.testDataVersions.add(testDataVersion);
	}

  
	 /**  
	 * Set the value related to the column: testDataVersion.
	 * @param testDataVersion the testDataVersion value you wish to set
	 */
	public void setTestDataVersions(final Set<TestDataVersion> testDataVersion) {
		this.testDataVersions = testDataVersion;
	}

	 /**
	 * Return the value associated with the column: testProcedureVersion.
	 * @return A Set&lt;TestProcedureVersion&gt; object (this.testProcedureVersion)
	 */
 	@OneToMany( fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "certificationCriterion"  )
 	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
	@Basic( optional = false )
	@Column( name = "certification_criterion_id", nullable = false  )
	public Set<TestProcedureVersion> getTestProcedureVersions() {
		return this.testProcedureVersions;
		
	}
	
	/**
	 * Adds a bi-directional link of type TestProcedureVersion to the testProcedureVersions set.
	 * @param testProcedureVersion item to add
	 */
	public void addTestProcedureVersion(TestProcedureVersion testProcedureVersion) {
		testProcedureVersion.setCertificationCriterion(this);
		this.testProcedureVersions.add(testProcedureVersion);
	}

  
	 /**  
	 * Set the value related to the column: testProcedureVersion.
	 * @param testProcedureVersion the testProcedureVersion value you wish to set
	 */
	public void setTestProcedureVersions(final Set<TestProcedureVersion> testProcedureVersion) {
		this.testProcedureVersions = testProcedureVersion;
	}

	 /**
	 * Return the value associated with the column: testTask.
	 * @return A Set&lt;TestTask&gt; object (this.testTask)
	 */
 	@OneToMany( fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "certificationCriterion"  )
 	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
	@Basic( optional = false )
	@Column( name = "certification_criterion_id", nullable = false  )
	public Set<TestTask> getTestTasks() {
		return this.testTasks;
		
	}
	
	/**
	 * Adds a bi-directional link of type TestTask to the testTasks set.
	 * @param testTask item to add
	 */
	public void addTestTask(TestTask testTask) {
		testTask.setCertificationCriterion(this);
		this.testTasks.add(testTask);
	}

  
	 /**  
	 * Set the value related to the column: testTask.
	 * @param testTask the testTask value you wish to set
	 */
	public void setTestTasks(final Set<TestTask> testTask) {
		this.testTasks = testTask;
	}

	 /**
	 * Return the value associated with the column: title.
	 * @return A String object (this.title)
	 */
	@Basic( optional = true )
	@Column( length = 250  )
	public String getTitle() {
		return this.title;
		
	}
	

  
	 /**  
	 * Set the value related to the column: title.
	 * @param title the title value you wish to set
	 */
	public void setTitle(final String title) {
		this.title = title;
	}


   /**
    * Deep copy.
	* @return cloned object
	* @throws CloneNotSupportedException on error
    */
    @Override
    public CertificationCriterion clone() throws CloneNotSupportedException {
		
        final CertificationCriterion copy = (CertificationCriterion)super.clone();

		copy.setAutomatedMeasureCapable(this.isAutomatedMeasureCapable());
		copy.setAutomatedNumeratorCapable(this.isAutomatedNumeratorCapable());
		if (this.getCertificationCriterions() != null) {
			copy.getCertificationCriterions().addAll(this.getCertificationCriterions());
		}
		if (this.getCertificationResults() != null) {
			copy.getCertificationResults().addAll(this.getCertificationResults());
		}
		copy.setCertificationEdition(this.getCertificationEdition());
		copy.setCreationDate(this.getCreationDate());
		if (this.getCriterionOptionalFunctionalities() != null) {
			copy.getCriterionOptionalFunctionalities().addAll(this.getCriterionOptionalFunctionalities());
		}
		if (this.getCriterionStandards() != null) {
			copy.getCriterionStandards().addAll(this.getCriterionStandards());
		}
		copy.setDeleted(this.isDeleted());
		copy.setDescription(this.getDescription());
		copy.setId(this.getId());
		copy.setLastModifiedDate(this.getLastModifiedDate());
		copy.setLastModifiedUser(this.getLastModifiedUser());
		if (this.getNewerStandardsMets() != null) {
			copy.getNewerStandardsMets().addAll(this.getNewerStandardsMets());
		}
		copy.setNumber(this.getNumber());
		copy.setParentCriterion(this.getParentCriterion());
		copy.setRequiresSed(this.isRequiresSed());
		if (this.getTestDataVersions() != null) {
			copy.getTestDataVersions().addAll(this.getTestDataVersions());
		}
		if (this.getTestProcedureVersions() != null) {
			copy.getTestProcedureVersions().addAll(this.getTestProcedureVersions());
		}
		if (this.getTestTasks() != null) {
			copy.getTestTasks().addAll(this.getTestTasks());
		}
		copy.setTitle(this.getTitle());
		return copy;
	}
	


	/** Provides toString implementation.
	 * @see java.lang.Object#toString()
	 * @return String representation of this class.
	 */
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		
		sb.append("automatedMeasureCapable: " + this.isAutomatedMeasureCapable() + ", ");
		sb.append("automatedNumeratorCapable: " + this.isAutomatedNumeratorCapable() + ", ");
		sb.append("creationDate: " + this.getCreationDate() + ", ");
		sb.append("deleted: " + this.isDeleted() + ", ");
		sb.append("description: " + this.getDescription() + ", ");
		sb.append("id: " + this.getId() + ", ");
		sb.append("lastModifiedDate: " + this.getLastModifiedDate() + ", ");
		sb.append("lastModifiedUser: " + this.getLastModifiedUser() + ", ");
		sb.append("number: " + this.getNumber() + ", ");
		sb.append("requiresSed: " + this.isRequiresSed() + ", ");
		sb.append("title: " + this.getTitle());
		return sb.toString();		
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

		
		if (aThat instanceof HibernateProxy) {
 			// narrow down the proxy to the class we are dealing with.
 			try {
				proxyThat = ((HibernateProxy) aThat).getHibernateLazyInitializer().getImplementation(); 
			} catch (org.hibernate.ObjectNotFoundException e) {
				return false;
		   	}
		}
		if (aThat == null)  {
			 return false;
		}
		
		final CertificationCriterion that; 
		try {
			that = (CertificationCriterion) proxyThat;
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
		result = result && (((isAutomatedNumeratorCapable() == null) && (that.isAutomatedNumeratorCapable() == null)) || (isAutomatedNumeratorCapable() != null && isAutomatedNumeratorCapable().equals(that.isAutomatedNumeratorCapable())));
		result = result && (((getCertificationEdition() == null) && (that.getCertificationEdition() == null)) || (getCertificationEdition() != null && getCertificationEdition().getId().equals(that.getCertificationEdition().getId())));	
		result = result && (((getCreationDate() == null) && (that.getCreationDate() == null)) || (getCreationDate() != null && getCreationDate().equals(that.getCreationDate())));
		result = result && (((isDeleted() == null) && (that.isDeleted() == null)) || (isDeleted() != null && isDeleted().equals(that.isDeleted())));
		result = result && (((getDescription() == null) && (that.getDescription() == null)) || (getDescription() != null && getDescription().equals(that.getDescription())));
		result = result && (((getLastModifiedDate() == null) && (that.getLastModifiedDate() == null)) || (getLastModifiedDate() != null && getLastModifiedDate().equals(that.getLastModifiedDate())));
		result = result && (((getLastModifiedUser() == null) && (that.getLastModifiedUser() == null)) || (getLastModifiedUser() != null && getLastModifiedUser().equals(that.getLastModifiedUser())));
		result = result && (((getNumber() == null) && (that.getNumber() == null)) || (getNumber() != null && getNumber().equals(that.getNumber())));
		result = result && (((getParentCriterion() == null) && (that.getParentCriterion() == null)) || (getParentCriterion() != null && getParentCriterion().getId().equals(that.getParentCriterion().getId())));	
		result = result && (((isRequiresSed() == null) && (that.isRequiresSed() == null)) || (isRequiresSed() != null && isRequiresSed().equals(that.isRequiresSed())));
		result = result && (((getTitle() == null) && (that.getTitle() == null)) || (getTitle() != null && getTitle().equals(that.getTitle())));
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