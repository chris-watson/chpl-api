package gov.healthit.chpl.entity;

import gov.healthit.chpl.entity.CqmResult;
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
 * Object mapping for hibernate-handled table: certified_product_cqm_edition_map.
 * 
 *
 * @author autogenerated
 */

@Entity
@Table(name = "certified_product_cqm_edition_map", catalog = "openchpl", schema = "openchpl")
public class CertifiedProductCqmEditionMap implements Cloneable, Serializable {

	/** Serial Version UID. */
	private static final long serialVersionUID = -7739329779543085451L;

	/** Use a WeakHashMap so entries will be garbage collected once all entities 
		referring to a saved hash are garbage collected themselves. */
	private static final Map<Serializable, Long> SAVED_HASHES =
		Collections.synchronizedMap(new WeakHashMap<Serializable, Long>());
	
	/** hashCode temporary storage. */
	private volatile Long hashCode;
	

	/** Field mapping. */
	private CertifiedProduct certifiedProduct;
	/** Field mapping. */
	private Set<CqmResult> cqmResults = new HashSet<CqmResult>();

	/** Field mapping. */
	private CqmEdition cqmEdition;
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
	/**
	 * Default constructor, mainly for hibernate use.
	 */
	public CertifiedProductCqmEditionMap() {
		// Default constructor
	} 

	/** Constructor taking a given ID.
	 * @param id to set
	 */
	public CertifiedProductCqmEditionMap(Long id) {
		this.id = id;
	}
	
	/** Constructor taking a given ID.
	 * @param certifiedProduct CertifiedProduct object;
	 * @param cqmEdition CqmEdition object;
	 * @param creationDate Date object;
	 * @param deleted Boolean object;
	 * @param id Long object;
	 * @param lastModifiedDate Date object;
	 * @param lastModifiedUser Long object;
	 */
	public CertifiedProductCqmEditionMap(CertifiedProduct certifiedProduct, CqmEdition cqmEdition, Date creationDate, 					
			Boolean deleted, Long id, Date lastModifiedDate, 					
			Long lastModifiedUser) {

		this.certifiedProduct = certifiedProduct;
		this.cqmEdition = cqmEdition;
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
		return CertifiedProductCqmEditionMap.class;
	}
 

	 /**
	 * Return the value associated with the column: certifiedProduct.
	 * @return A CertifiedProduct object (this.certifiedProduct)
	 */
	@ManyToOne( cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.LAZY )
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
	@Basic( optional = false )
	@JoinColumn(name = "certified_product_id", nullable = false )
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
	 * Return the value associated with the column: cqmResult.
	 * @return A Set&lt;CqmResult&gt; object (this.cqmResult)
	 */
 	@OneToMany( fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "certifiedProductCqmEditionMap"  )
 	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
	@Basic( optional = false )
	@Column( name = "certified_product_cqm_edition_map_id", nullable = false  )
	public Set<CqmResult> getCqmResults() {
		return this.cqmResults;
		
	}
	
	/**
	 * Adds a bi-directional link of type CqmResult to the cqmResults set.
	 * @param cqmResult item to add
	 */
	public void addCqmResult(CqmResult cqmResult) {
		cqmResult.setCertifiedProductCqmEditionMap(this);
		this.cqmResults.add(cqmResult);
	}

  
	 /**  
	 * Set the value related to the column: cqmResult.
	 * @param cqmResult the cqmResult value you wish to set
	 */
	public void setCqmResults(final Set<CqmResult> cqmResult) {
		this.cqmResults = cqmResult;
	}

	 /**
	 * Return the value associated with the column: cqmEdition.
	 * @return A CqmEdition object (this.cqmEdition)
	 */
	@ManyToOne( cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.LAZY )
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
	@Basic( optional = false )
	@JoinColumn(name = "cqm_edition_id", nullable = false )
	public CqmEdition getCqmEdition() {
		return this.cqmEdition;
		
	}
	

  
	 /**  
	 * Set the value related to the column: cqmEdition.
	 * @param cqmEdition the cqmEdition value you wish to set
	 */
	public void setCqmEdition(final CqmEdition cqmEdition) {
		this.cqmEdition = cqmEdition;
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
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "certifiedProductCqmEditionMapCertified_product_cqm_edition_map_idGenerator")
	@Basic( optional = false )
	@Column( name = "certified_product_cqm_edition_map_id", nullable = false  )
	@SequenceGenerator(name = "certifiedProductCqmEditionMapCertified_product_cqm_edition_map_idGenerator", sequenceName = "openchpl.openchpl.certified_product_cqm_edition_certified_product_cqm_edition_seq", schema = "openchpl", catalog = "openchpl")
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
    * Deep copy.
	* @return cloned object
	* @throws CloneNotSupportedException on error
    */
    @Override
    public CertifiedProductCqmEditionMap clone() throws CloneNotSupportedException {
		
        final CertifiedProductCqmEditionMap copy = (CertifiedProductCqmEditionMap)super.clone();

		copy.setCertifiedProduct(this.getCertifiedProduct());
		if (this.getCqmResults() != null) {
			copy.getCqmResults().addAll(this.getCqmResults());
		}
		copy.setCqmEdition(this.getCqmEdition());
		copy.setCreationDate(this.getCreationDate());
		copy.setDeleted(this.isDeleted());
		copy.setId(this.getId());
		copy.setLastModifiedDate(this.getLastModifiedDate());
		copy.setLastModifiedUser(this.getLastModifiedUser());
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
		sb.append("lastModifiedUser: " + this.getLastModifiedUser());
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
		
		final CertifiedProductCqmEditionMap that; 
		try {
			that = (CertifiedProductCqmEditionMap) proxyThat;
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
		result = result && (((getCertifiedProduct() == null) && (that.getCertifiedProduct() == null)) || (getCertifiedProduct() != null && getCertifiedProduct().getId().equals(that.getCertifiedProduct().getId())));	
		result = result && (((getCqmEdition() == null) && (that.getCqmEdition() == null)) || (getCqmEdition() != null && getCqmEdition().getId().equals(that.getCqmEdition().getId())));	
		result = result && (((getCreationDate() == null) && (that.getCreationDate() == null)) || (getCreationDate() != null && getCreationDate().equals(that.getCreationDate())));
		result = result && (((isDeleted() == null) && (that.isDeleted() == null)) || (isDeleted() != null && isDeleted().equals(that.isDeleted())));
		result = result && (((getLastModifiedDate() == null) && (that.getLastModifiedDate() == null)) || (getLastModifiedDate() != null && getLastModifiedDate().equals(that.getLastModifiedDate())));
		result = result && (((getLastModifiedUser() == null) && (that.getLastModifiedUser() == null)) || (getLastModifiedUser() != null && getLastModifiedUser().equals(that.getLastModifiedUser())));
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