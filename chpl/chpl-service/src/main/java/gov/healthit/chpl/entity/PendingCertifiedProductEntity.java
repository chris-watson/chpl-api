package gov.healthit.chpl.entity;


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;


/** 
 * Object mapping for hibernate-handled table: certified_product.
 * A product that has been Certified
 *
 * @author autogenerated / cwatson
 */

@Entity
@Table(name = "pending_certified_product")
public class PendingCertifiedProductEntity {
	
	/**
	 * fields we generate mostly from spreadsheet values
	 */
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic( optional = false )
	@Column( name = "pending_certified_product_id", nullable = false  )
	private Long id;
    
    @Column(name = "practice_type_id")
    private Long practiceTypeId;
    
    @Column(name = "vendor_id")
    private Long vendorId;
    
    @Basic( optional = true )
	@OneToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumn(name = "vendor_address_id", unique=true, nullable = true)
	private AddressEntity vendorAddress;
    
    @Column(name = "product_id")
    private Long productId;
    
    @Column(name = "product_version_id")
    private Long productVersionId;
    
    @Column(name = "certification_edition_id")
    private Long certificationEditionId;
    
    @Column(name = "certification_body_id")
    private Long certificationBodyId;
    
    @Column(name = "product_classification_id")
    private Long productClassificationId;
    
    @Column(name = "additional_software_id")
    private Long additionalSoftwareId;
    
	@Basic(optional = false) 
	@Column( name = "certification_status_id" , nullable = false)
	private Long status;
	
    /**
    * fields directly from the spreadsheet
    **/
    @Column(name = "unique_id")
    private String uniqueId;
    
    @Column(name = "record_status")
    private String recordStatus;
    
    @Column(name = "practice_type")
    private String practiceType;
    
    @Column(name="vendor_name")
    private String vendorName;
    
    @Column(name = "product_name")
    private String productName;
    
    @Column(name = "product_version")
    private String productVersion;
    
    @Column(name = "certification_edition")
    private String certificationEdition;
    
    @Column(name = "acb_certification_id")
    private String acbCertificationId;
    
    @Column(name = "certification_body_name")
    private String certificationBodyName;
    
    @Column(name = "product_classification_name")
    private String productClassificationName;
    
    //TODO: no field for this one
    @Column(name = "product_classification_module")
    private String productClassificationModule;
    
    @Column(name = "certification_date")
    private Date certificationDate;
    
    @Column(name = "vendor_street_address")
    private String vendorStreetAddress;
    
    @Column(name = "vendor_city")
    private String vendorCity;
    
    @Column(name = "vendor_state")
    private String vendorState;
    
    @Column(name = "vendor_zip_code")
    private String vendorZipCode;
    
    @Column(name = "vendor_website")
    private String vendorWebsite;
    
    //TODO: maps to nothing
    @Column(name = "vendor_email")
    private String vendorEmail;
    
    @Column(name = "additional_software")
    private String additionalSoftware;
    
    //TODO: maps to nothing
    @Column(name = "upload_notes")
    private String uploadNotes;
    
    @Column(name = "test_report_url")
    private String reportFileLocation;
    
	@Column(name = "ics")
	private String ics;
	
	@Column(name = "sed")
	private Boolean sedTesting;
	
	@Column(name = "qms")
	private Boolean qmsTesting;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy="pendingCertifiedProductId")
	@Basic( optional = false )
	@Column( name = "pending_certified_product_id", nullable = false  )
	private Set<PendingCertificationCriterionEntity> certificationCriterion;
    
	@OneToMany(fetch = FetchType.LAZY, mappedBy="pendingCertifiedProductId")
	@Basic( optional = false )
	@Column( name = "pending_certified_product_id", nullable = false  )
	private Set<PendingCqmCriterionEntity> cqmCriterion;
	
	@Basic( optional = false )
	@Column( name = "last_modified_date", nullable = false  )
	private Date lastModifiedDate;
	
	@Basic( optional = false )
	@Column( name = "last_modified_user", nullable = false  )
	private Long lastModifiedUser;
	
	@Basic( optional = false )
	@Column( name = "creation_date", nullable = false  )
	private Date creationDate;
	
	@Basic( optional = false )
	@Column(name = "deleted", nullable = false  )
	private Boolean deleted;
	
	public PendingCertifiedProductEntity() {
		certificationCriterion = new HashSet<PendingCertificationCriterionEntity>();
		cqmCriterion = new HashSet<PendingCqmCriterionEntity>();
	} 

	public PendingCertifiedProductEntity(Long id) {
		this.id = id;
		certificationCriterion = new HashSet<PendingCertificationCriterionEntity>();
		cqmCriterion = new HashSet<PendingCqmCriterionEntity>();
	}
	
	@Transient
	public Class<?> getClassType() {
		return PendingCertifiedProductEntity.class;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getPracticeTypeId() {
		return practiceTypeId;
	}

	public void setPracticeTypeId(Long practiceTypeId) {
		this.practiceTypeId = practiceTypeId;
	}

	public Long getVendorId() {
		return vendorId;
	}

	public void setVendorId(Long vendorId) {
		this.vendorId = vendorId;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Long getProductVersionId() {
		return productVersionId;
	}

	public void setProductVersionId(Long productVersionId) {
		this.productVersionId = productVersionId;
	}

	public Long getCertificationEditionId() {
		return certificationEditionId;
	}

	public void setCertificationEditionId(Long certificationEditionId) {
		this.certificationEditionId = certificationEditionId;
	}

	public Long getCertificationBodyId() {
		return certificationBodyId;
	}

	public void setCertificationBodyId(Long certificationBodyId) {
		this.certificationBodyId = certificationBodyId;
	}

	public Long getProductClassificationId() {
		return productClassificationId;
	}

	public void setProductClassificationId(Long productClassificationId) {
		this.productClassificationId = productClassificationId;
	}

	public String getUniqueId() {
		return uniqueId;
	}

	public void setUniqueId(String uniqueId) {
		this.uniqueId = uniqueId;
	}

	public String getRecordStatus() {
		return recordStatus;
	}

	public void setRecordStatus(String recordStatus) {
		this.recordStatus = recordStatus;
	}

	public String getPracticeType() {
		return practiceType;
	}

	public void setPracticeType(String practiceType) {
		this.practiceType = practiceType;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductVersion() {
		return productVersion;
	}

	public void setProductVersion(String productVersion) {
		this.productVersion = productVersion;
	}

	public String getCertificationEdition() {
		return certificationEdition;
	}

	public void setCertificationEdition(String certificationEdition) {
		this.certificationEdition = certificationEdition;
	}

	public String getAcbCertificationId() {
		return acbCertificationId;
	}

	public void setAcbCertificationId(String acbCertificationId) {
		this.acbCertificationId = acbCertificationId;
	}

	public String getCertificationBodyName() {
		return certificationBodyName;
	}

	public void setCertificationBodyName(String certificationBodyName) {
		this.certificationBodyName = certificationBodyName;
	}

	public String getProductClassificationName() {
		return productClassificationName;
	}

	public void setProductClassificationName(String productClassificationName) {
		this.productClassificationName = productClassificationName;
	}

	public String getProductClassificationModule() {
		return productClassificationModule;
	}

	public void setProductClassificationModule(String productClassificationModule) {
		this.productClassificationModule = productClassificationModule;
	}

	public Date getCertificationDate() {
		return certificationDate;
	}

	public void setCertificationDate(Date certificationDate) {
		this.certificationDate = certificationDate;
	}

	public String getVendorStreetAddress() {
		return vendorStreetAddress;
	}

	public void setVendorStreetAddress(String vendorStreetAddress) {
		this.vendorStreetAddress = vendorStreetAddress;
	}

	public String getVendorCity() {
		return vendorCity;
	}

	public void setVendorCity(String vendorCity) {
		this.vendorCity = vendorCity;
	}

	public String getVendorState() {
		return vendorState;
	}

	public void setVendorState(String vendorState) {
		this.vendorState = vendorState;
	}

	public String getVendorZipCode() {
		return vendorZipCode;
	}

	public void setVendorZipCode(String vendorZipCode) {
		this.vendorZipCode = vendorZipCode;
	}

	public String getVendorWebsite() {
		return vendorWebsite;
	}

	public void setVendorWebsite(String vendorWebsite) {
		this.vendorWebsite = vendorWebsite;
	}

	public String getVendorEmail() {
		return vendorEmail;
	}

	public void setVendorEmail(String vendorEmail) {
		this.vendorEmail = vendorEmail;
	}

	public String getAdditionalSoftware() {
		return additionalSoftware;
	}

	public void setAdditionalSoftware(String additionalSoftware) {
		this.additionalSoftware = additionalSoftware;
	}

	public String getUploadNotes() {
		return uploadNotes;
	}

	public void setUploadNotes(String uploadNotes) {
		this.uploadNotes = uploadNotes;
	}

	public String getReportFileLocation() {
		return reportFileLocation;
	}

	public void setReportFileLocation(String reportFileLocation) {
		this.reportFileLocation = reportFileLocation;
	}

	public Set<PendingCertificationCriterionEntity> getCertificationCriterion() {
		return certificationCriterion;
	}

	public void setCertificationCriterion(Set<PendingCertificationCriterionEntity> certificationCriterion) {
		this.certificationCriterion = certificationCriterion;
	}

	public Set<PendingCqmCriterionEntity> getCqmCriterion() {
		return cqmCriterion;
	}

	public void setCqmCriterion(Set<PendingCqmCriterionEntity> cqmCriterion) {
		this.cqmCriterion = cqmCriterion;
	}

	public AddressEntity getVendorAddress() {
		return vendorAddress;
	}

	public void setVendorAddress(AddressEntity vendorAddress) {
		this.vendorAddress = vendorAddress;
	}

	public Long getAdditionalSoftwareId() {
		return additionalSoftwareId;
	}

	public void setAdditionalSoftwareId(Long additionalSoftwareId) {
		this.additionalSoftwareId = additionalSoftwareId;
	}

	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public Long getLastModifiedUser() {
		return lastModifiedUser;
	}

	public void setLastModifiedUser(Long lastModifiedUser) {
		this.lastModifiedUser = lastModifiedUser;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

	public Long getStatus() {
		return status;
	}

	public void setStatus(Long status) {
		this.status = status;
	}

	public String getIcs() {
		return ics;
	}

	public void setIcs(String ics) {
		this.ics = ics;
	}

	public Boolean getSedTesting() {
		return sedTesting;
	}

	public void setSedTesting(Boolean sedTesting) {
		this.sedTesting = sedTesting;
	}

	public Boolean getQmsTesting() {
		return qmsTesting;
	}

	public void setQmsTesting(Boolean qmsTesting) {
		this.qmsTesting = qmsTesting;
	}
}
