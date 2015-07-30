package gov.healthit.chpl.entity;

import gov.healthit.chpl.entity.CertificationCriterion;
import gov.healthit.chpl.entity.CertifiedProduct;
import gov.healthit.chpl.entity.TestTool;
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
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import org.hibernate.proxy.HibernateProxy;


/** 
 * Object mapping for hibernate-handled table: certification_edition.
 * 
 *
 * @author autogenerated
 */

@Entity
@Table(name = "certification_edition", catalog = "openchpl", schema = "openchpl")
public class CertificationEdition implements Cloneable, Serializable {

	/** Serial Version UID. */
	private static final long serialVersionUID = -365316096272783095L;

	/** Use a WeakHashMap so entries will be garbage collected once all entities 
		referring to a saved hash are garbage collected themselves. */
	private static final Map<Serializable, Long> SAVED_HASHES =
		Collections.synchronizedMap(new WeakHashMap<Serializable, Long>());
	
	/** hashCode temporary storage. */
	private volatile Long hashCode;
	

	/** Field mapping. */
	private Set<CertificationCriterion> certificationCriterions = new HashSet<CertificationCriterion>();

	/** Field mapping. */
	private Set<CertifiedProduct> certifiedProducts = new HashSet<CertifiedProduct>();

	/** Field mapping. */
	private Date creationDate;
	/** Field mapping. */
	private Boolean deleted;
	/** Field mapping. */
	private Long id;
	/** Field mapping. */
	private Date lastModifiedDate;
	/** Field mapping. */
	private Long lastModifiedUser;
	/** Field mapping. */
	private Set<TestTool> testTools = new HashSet<TestTool>();

	/** Field mapping. */
	private String year;
	/**
	 * Default constructor, mainly for hibernate use.
	 */
	public CertificationEdition() {
		// Default constructor
	} 

	/** Constructor taking a given ID.
	 * @param id to set
	 */
	public CertificationEdition(Long id) {
		this.id = id;
	}
	
	/** Constructor taking a given ID.
	 * @param creationDate Date object;
	 * @param deleted Boolean object;
	 * @param id Long object;
	 * @param lastModifiedDate Date object;
	 * @param lastModifiedUser Long object;
	 */
	public CertificationEdition(Date creationDate, Boolean deleted, Long id, 					
			Date lastModifiedDate, Long lastModifiedUser) {

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
		return CertificationEdition.class;
	}
 

	 /**
	 * Return the value associated with the column: certificationCriterion.
	 * @return A Set&lt;CertificationCriterion&gt; object (this.certificationCriterion)
	 */
 	@OneToMany( fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "certificationEdition"  )
 	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
	@Basic( optional = false )
	@Column( name = "certification_edition_id", nullable = false  )
	public Set<CertificationCriterion> getCertificationCriterions() {
		return this.certificationCriterions;
		
	}
	
	/**
	 * Adds a bi-directional link of type CertificationCriterion to the certificationCriterions set.
	 * @param certificationCriterion item to add
	 */
	public void addCertificationCriterion(CertificationCriterion certificationCriterion) {
		certificationCriterion.setCertificationEdition(this);
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
	 * Return the value associated with the column: certifiedProduct.
	 * @return A Set&lt;CertifiedProduct&gt; object (this.certifiedProduct)
	 */
 	@OneToMany( fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "certificationEdition"  )
 	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
	@Basic( optional = false )
	@Column( name = "certification_edition_id", nullable = false  )
	public Set<CertifiedProduct> getCertifiedProducts() {
		return this.certifiedProducts;
		
	}
	
	/**
	 * Adds a bi-directional link of type CertifiedProduct to the certifiedProducts set.
	 * @param certifiedProduct item to add
	 */
	public void addCertifiedProduct(CertifiedProduct certifiedProduct) {
		certifiedProduct.setCertificationEditionId(this.getId());
		this.certifiedProducts.add(certifiedProduct);
	}

  
	 /**  
	 * Set the value related to the column: certifiedProduct.
	 * @param certifiedProduct the certifiedProduct value you wish to set
	 */
	public void setCertifiedProducts(final Set<CertifiedProduct> certifiedProduct) {
		this.certifiedProducts = certifiedProduct;
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
	 * Return the value associated with the column: id.
	 * @return A Long object (this.id)
	 */
    @Id 
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "certificationEditionCertification_edition_idGenerator")
	@Basic( optional = false )
	@Column( name = "certification_edition_id", nullable = false  )
	@SequenceGenerator(name = "certificationEditionCertification_edition_idGenerator", sequenceName = "openchpl.openchpl.certification_edition_certification_edition_id_seq", schema = "openchpl", catalog = "openchpl")
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
	 * Return the value associated with the column: testTool.
	 * @return A Set&lt;TestTool&gt; object (this.testTool)
	 */
 	@OneToMany( fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "certificationEdition"  )
 	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
	@Basic( optional = false )
	@Column( name = "certification_edition_id", nullable = false  )
	public Set<TestTool> getTestTools() {
		return this.testTools;
		
	}
	
	/**
	 * Adds a bi-directional link of type TestTool to the testTools set.
	 * @param testTool item to add
	 */
	public void addTestTool(TestTool testTool) {
		testTool.setCertificationEdition(this);
		this.testTools.add(testTool);
	}

  
	 /**  
	 * Set the value related to the column: testTool.
	 * @param testTool the testTool value you wish to set
	 */
	public void setTestTools(final Set<TestTool> testTool) {
		this.testTools = testTool;
	}

	 /**
	 * Return the value associated with the column: year.
	 * @return A String object (this.year)
	 */
	@Basic( optional = true )
	@Column( length = 10  )
	public String getYear() {
		return this.year;
		
	}
	

  
	 /**  
	 * Set the value related to the column: year.
	 * @param year the year value you wish to set
	 */
	public void setYear(final String year) {
		this.year = year;
	}


   /**
    * Deep copy.
	* @return cloned object
	* @throws CloneNotSupportedException on error
    */
    @Override
    public CertificationEdition clone() throws CloneNotSupportedException {
		
        final CertificationEdition copy = (CertificationEdition)super.clone();

		if (this.getCertificationCriterions() != null) {
			copy.getCertificationCriterions().addAll(this.getCertificationCriterions());
		}
		if (this.getCertifiedProducts() != null) {
			copy.getCertifiedProducts().addAll(this.getCertifiedProducts());
		}
		copy.setCreationDate(this.getCreationDate());
		copy.setDeleted(this.isDeleted());
		copy.setId(this.getId());
		copy.setLastModifiedDate(this.getLastModifiedDate());
		copy.setLastModifiedUser(this.getLastModifiedUser());
		if (this.getTestTools() != null) {
			copy.getTestTools().addAll(this.getTestTools());
		}
		copy.setYear(this.getYear());
		return copy;
	}
	


	/** Provides toString implementation.
	 * @see java.lang.Object#toString()
	 * @return String representation of this class.
	 */
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		
		sb.append("creationDate: " + this.getCreationDate() + ", ");
		sb.append("deleted: " + this.isDeleted() + ", ");
		sb.append("id: " + this.getId() + ", ");
		sb.append("lastModifiedDate: " + this.getLastModifiedDate() + ", ");
		sb.append("lastModifiedUser: " + this.getLastModifiedUser() + ", ");
		sb.append("year: " + this.getYear());
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
		
		final CertificationEdition that; 
		try {
			that = (CertificationEdition) proxyThat;
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
		result = result && (((getCreationDate() == null) && (that.getCreationDate() == null)) || (getCreationDate() != null && getCreationDate().equals(that.getCreationDate())));
		result = result && (((isDeleted() == null) && (that.isDeleted() == null)) || (isDeleted() != null && isDeleted().equals(that.isDeleted())));
		result = result && (((getLastModifiedDate() == null) && (that.getLastModifiedDate() == null)) || (getLastModifiedDate() != null && getLastModifiedDate().equals(that.getLastModifiedDate())));
		result = result && (((getLastModifiedUser() == null) && (that.getLastModifiedUser() == null)) || (getLastModifiedUser() != null && getLastModifiedUser().equals(that.getLastModifiedUser())));
		result = result && (((getYear() == null) && (that.getYear() == null)) || (getYear() != null && getYear().equals(that.getYear())));
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