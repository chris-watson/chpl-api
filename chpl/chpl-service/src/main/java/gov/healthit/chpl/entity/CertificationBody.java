package gov.healthit.chpl.entity;

import gov.healthit.chpl.entity.AcbContactMap;
import gov.healthit.chpl.entity.CertifiedProduct;
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
 * Object mapping for hibernate-handled table: certification_body.
 * 
 *
 * @author autogenerated
 */

@Entity
@Table(name = "certification_body", catalog = "openchpl", schema = "openchpl")
public class CertificationBody implements Cloneable, Serializable {

	/** Serial Version UID. */
	private static final long serialVersionUID = -2523808818373860307L;

	/** Use a WeakHashMap so entries will be garbage collected once all entities 
		referring to a saved hash are garbage collected themselves. */
	private static final Map<Serializable, Long> SAVED_HASHES =
		Collections.synchronizedMap(new WeakHashMap<Serializable, Long>());
	
	/** hashCode temporary storage. */
	private volatile Long hashCode;
	

	/** Field mapping. */
	private Set<AcbContactMap> acbContactMaps = new HashSet<AcbContactMap>();

	/** Field mapping. */
	private Address address;
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
	private Integer lastModifiedUser;
	/** Field mapping. */
	private String name;
	/** Field mapping. */
	private String website;
	/**
	 * Default constructor, mainly for hibernate use.
	 */
	public CertificationBody() {
		// Default constructor
	} 

	/** Constructor taking a given ID.
	 * @param id to set
	 */
	public CertificationBody(Long id) {
		this.id = id;
	}
	
	/** Constructor taking a given ID.
	 * @param creationDate Date object;
	 * @param deleted Boolean object;
	 * @param id Long object;
	 * @param lastModifiedDate Date object;
	 * @param lastModifiedUser Integer object;
	 */
	public CertificationBody(Date creationDate, Boolean deleted, Long id, 					
			Date lastModifiedDate, Integer lastModifiedUser) {

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
		return CertificationBody.class;
	}
 

	 /**
	 * Return the value associated with the column: acbContactMap.
	 * @return A Set&lt;AcbContactMap&gt; object (this.acbContactMap)
	 */
 	@OneToMany( fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "id.certificationBodyIdCertificationBody"  )
 	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
	@Basic( optional = false )
	@Column( name = "certification_body_id", nullable = false  )
	public Set<AcbContactMap> getAcbContactMaps() {
		return this.acbContactMaps;
		
	}
	
	/**
	 * Adds a bi-directional link of type AcbContactMap to the acbContactMaps set.
	 * @param acbContactMap item to add
	 */
	public void addAcbContactMap(AcbContactMap acbContactMap) {
		acbContactMap.getId().setCertificationBodyIdCertificationBody(this);
		this.acbContactMaps.add(acbContactMap);
	}

  
	 /**  
	 * Set the value related to the column: acbContactMap.
	 * @param acbContactMap the acbContactMap value you wish to set
	 */
	public void setAcbContactMaps(final Set<AcbContactMap> acbContactMap) {
		this.acbContactMaps = acbContactMap;
	}

	 /**
	 * Return the value associated with the column: address.
	 * @return A Address object (this.address)
	 */
	@ManyToOne( cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.LAZY )
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
	@Basic( optional = true )
	@JoinColumn(name = "address_id", nullable = true )
	public Address getAddress() {
		return this.address;
		
	}
	

  
	 /**  
	 * Set the value related to the column: address.
	 * @param address the address value you wish to set
	 */
	public void setAddress(final Address address) {
		this.address = address;
	}

	 /**
	 * Return the value associated with the column: certifiedProduct.
	 * @return A Set&lt;CertifiedProduct&gt; object (this.certifiedProduct)
	 */
 	@OneToMany( fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "certificationBody"  )
 	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
	@Basic( optional = false )
	@Column( name = "certification_body_id", nullable = false  )
	public Set<CertifiedProduct> getCertifiedProducts() {
		return this.certifiedProducts;
		
	}
	
	/**
	 * Adds a bi-directional link of type CertifiedProduct to the certifiedProducts set.
	 * @param certifiedProduct item to add
	 */
	public void addCertifiedProduct(CertifiedProduct certifiedProduct) {
		certifiedProduct.setCertificationBodyId(this.getId());
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
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "certificationBodyCertification_body_idGenerator")
	@Basic( optional = false )
	@Column( name = "certification_body_id", nullable = false  )
	@SequenceGenerator(name = "certificationBodyCertification_body_idGenerator", sequenceName = "openchpl.openchpl.certification_body_certification_body_id_seq", schema = "openchpl", catalog = "openchpl")
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
	 * @return A Integer object (this.lastModifiedUser)
	 */
	@Basic( optional = false )
	@Column( name = "last_modified_user", nullable = false  )
	public Integer getLastModifiedUser() {
		return this.lastModifiedUser;
		
	}
	

  
	 /**  
	 * Set the value related to the column: lastModifiedUser.
	 * @param lastModifiedUser the lastModifiedUser value you wish to set
	 */
	public void setLastModifiedUser(final Integer lastModifiedUser) {
		this.lastModifiedUser = lastModifiedUser;
	}

	 /**
	 * Return the value associated with the column: name.
	 * @return A String object (this.name)
	 */
	@Basic( optional = true )
	@Column( length = 250  )
	public String getName() {
		return this.name;
		
	}
	

  
	 /**  
	 * Set the value related to the column: name.
	 * @param name the name value you wish to set
	 */
	public void setName(final String name) {
		this.name = name;
	}

	 /**
	 * Return the value associated with the column: website.
	 * @return A String object (this.website)
	 */
	@Basic( optional = true )
	@Column( length = 300  )
	public String getWebsite() {
		return this.website;
		
	}
	

  
	 /**  
	 * Set the value related to the column: website.
	 * @param website the website value you wish to set
	 */
	public void setWebsite(final String website) {
		this.website = website;
	}


   /**
    * Deep copy.
	* @return cloned object
	* @throws CloneNotSupportedException on error
    */
    @Override
    public CertificationBody clone() throws CloneNotSupportedException {
		
        final CertificationBody copy = (CertificationBody)super.clone();

		if (this.getAcbContactMaps() != null) {
			copy.getAcbContactMaps().addAll(this.getAcbContactMaps());
		}
		copy.setAddress(this.getAddress());
		if (this.getCertifiedProducts() != null) {
			copy.getCertifiedProducts().addAll(this.getCertifiedProducts());
		}
		copy.setCreationDate(this.getCreationDate());
		copy.setDeleted(this.isDeleted());
		copy.setId(this.getId());
		copy.setLastModifiedDate(this.getLastModifiedDate());
		copy.setLastModifiedUser(this.getLastModifiedUser());
		copy.setName(this.getName());
		copy.setWebsite(this.getWebsite());
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
		sb.append("name: " + this.getName() + ", ");
		sb.append("website: " + this.getWebsite());
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
		
		final CertificationBody that; 
		try {
			that = (CertificationBody) proxyThat;
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
		result = result && (((getAddress() == null) && (that.getAddress() == null)) || (getAddress() != null && getAddress().getId().equals(that.getAddress().getId())));	
		result = result && (((getCreationDate() == null) && (that.getCreationDate() == null)) || (getCreationDate() != null && getCreationDate().equals(that.getCreationDate())));
		result = result && (((isDeleted() == null) && (that.isDeleted() == null)) || (isDeleted() != null && isDeleted().equals(that.isDeleted())));
		result = result && (((getLastModifiedDate() == null) && (that.getLastModifiedDate() == null)) || (getLastModifiedDate() != null && getLastModifiedDate().equals(that.getLastModifiedDate())));
		result = result && (((getLastModifiedUser() == null) && (that.getLastModifiedUser() == null)) || (getLastModifiedUser() != null && getLastModifiedUser().equals(that.getLastModifiedUser())));
		result = result && (((getName() == null) && (that.getName() == null)) || (getName() != null && getName().equals(that.getName())));
		result = result && (((getWebsite() == null) && (that.getWebsite() == null)) || (getWebsite() != null && getWebsite().equals(that.getWebsite())));
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