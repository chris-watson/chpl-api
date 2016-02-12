package gov.healthit.chpl.manager.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.fasterxml.jackson.core.JsonProcessingException;

import gov.healthit.chpl.auth.Util;
import gov.healthit.chpl.dao.CQMCriterionDAO;
import gov.healthit.chpl.dao.CQMResultDAO;
import gov.healthit.chpl.dao.CertificationBodyDAO;
import gov.healthit.chpl.dao.CertificationCriterionDAO;
import gov.healthit.chpl.dao.CertificationEventDAO;
import gov.healthit.chpl.dao.CertificationResultDAO;
import gov.healthit.chpl.dao.CertificationStatusDAO;
import gov.healthit.chpl.dao.CertifiedProductDAO;
import gov.healthit.chpl.dao.CertifiedProductQmsStandardDAO;
import gov.healthit.chpl.dao.DeveloperDAO;
import gov.healthit.chpl.dao.EntityCreationException;
import gov.healthit.chpl.dao.EntityRetrievalException;
import gov.healthit.chpl.dao.EventTypeDAO;
import gov.healthit.chpl.domain.ActivityConcept;
import gov.healthit.chpl.domain.CQMResultDetails;
import gov.healthit.chpl.domain.CertificationResult;
import gov.healthit.chpl.domain.CertificationResultAdditionalSoftware;
import gov.healthit.chpl.domain.CertificationResultTestData;
import gov.healthit.chpl.domain.CertificationResultTestProcedure;
import gov.healthit.chpl.domain.CertificationResultTestStandard;
import gov.healthit.chpl.domain.CertificationResultTestTool;
import gov.healthit.chpl.domain.CertifiedProductQmsStandard;
import gov.healthit.chpl.domain.CertifiedProductSearchDetails;
import gov.healthit.chpl.domain.PendingCertifiedProductDetails;
import gov.healthit.chpl.dto.AddressDTO;
import gov.healthit.chpl.dto.CQMCriterionDTO;
import gov.healthit.chpl.dto.CQMResultDTO;
import gov.healthit.chpl.dto.CertificationBodyDTO;
import gov.healthit.chpl.dto.CertificationCriterionDTO;
import gov.healthit.chpl.dto.CertificationEventDTO;
import gov.healthit.chpl.dto.CertificationResultAdditionalSoftwareDTO;
import gov.healthit.chpl.dto.CertificationResultDTO;
import gov.healthit.chpl.dto.CertificationResultTestDataDTO;
import gov.healthit.chpl.dto.CertificationResultTestProcedureDTO;
import gov.healthit.chpl.dto.CertificationResultTestStandardDTO;
import gov.healthit.chpl.dto.CertificationResultTestToolDTO;
import gov.healthit.chpl.dto.CertificationStatusDTO;
import gov.healthit.chpl.dto.CertifiedProductDTO;
import gov.healthit.chpl.dto.CertifiedProductDetailsDTO;
import gov.healthit.chpl.dto.CertifiedProductQmsStandardDTO;
import gov.healthit.chpl.dto.DeveloperDTO;
import gov.healthit.chpl.dto.EventTypeDTO;
import gov.healthit.chpl.dto.ProductDTO;
import gov.healthit.chpl.dto.ProductVersionDTO;
import gov.healthit.chpl.manager.ActivityManager;
import gov.healthit.chpl.manager.CertificationBodyManager;
import gov.healthit.chpl.manager.CertificationResultManager;
import gov.healthit.chpl.manager.CertifiedProductDetailsManager;
import gov.healthit.chpl.manager.CertifiedProductManager;
import gov.healthit.chpl.manager.DeveloperManager;
import gov.healthit.chpl.manager.ProductManager;
import gov.healthit.chpl.manager.ProductVersionManager;

@Service
public class CertifiedProductManagerImpl implements CertifiedProductManager {

	@Autowired CertifiedProductDAO dao;
	@Autowired CertificationResultDAO certDao;
	@Autowired CertificationCriterionDAO certCriterionDao;
	@Autowired CertifiedProductQmsStandardDAO qmsDao;
	@Autowired CQMResultDAO cqmResultDAO;
	@Autowired CQMCriterionDAO cqmCriterionDao;
	@Autowired CertificationBodyDAO acbDao;
	@Autowired DeveloperDAO developerDao;
	@Autowired DeveloperManager developerManager;
	@Autowired ProductManager productManager;
	@Autowired ProductVersionManager versionManager;
	@Autowired CertificationEventDAO eventDao;
	@Autowired EventTypeDAO eventTypeDao;
	@Autowired CertificationResultManager certResultManager;
	
	@Autowired
	public ActivityManager activityManager;
	
	@Autowired
	public CertifiedProductDetailsManager detailsManager;
		
	@Autowired 
	public CertificationBodyManager acbManager;
	
	public CertifiedProductManagerImpl() {
	}
	
	@Autowired CertificationStatusDAO statusDao;
	
	@Override
	@Transactional(readOnly = true)
	public CertifiedProductDTO getById(Long id) throws EntityRetrievalException {
		CertifiedProductDTO result = dao.getById(id);
		return result;
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<CertifiedProductDetailsDTO> getAll() {
		return dao.findAll();
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<CertifiedProductDetailsDTO> getAllWithEditPermission() {
		List<CertificationBodyDTO> userAcbs = acbManager.getAllForUser(false);
		if(userAcbs == null || userAcbs.size() == 0) {
			return new ArrayList<CertifiedProductDetailsDTO>();
		}
		List<Long> acbIdList = new ArrayList<Long>(userAcbs.size());
		for(CertificationBodyDTO dto : userAcbs) {
			acbIdList.add(dto.getId());
		}
		return dao.getDetailsByAcbIds(acbIdList);
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<CertifiedProductDetailsDTO> getByVersion(Long versionId) {
		return dao.getDetailsByVersionId(versionId);
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<CertifiedProductDetailsDTO> getByVersionWithEditPermission(Long versionId) {
		List<CertificationBodyDTO> userAcbs = acbManager.getAllForUser(false);
		if(userAcbs == null || userAcbs.size() == 0) {
			return new ArrayList<CertifiedProductDetailsDTO>();
		}
		List<Long> acbIdList = new ArrayList<Long>(userAcbs.size());
		for(CertificationBodyDTO dto : userAcbs) {
			acbIdList.add(dto.getId());
		}
		return dao.getDetailsByVersionAndAcbIds(versionId, acbIdList);
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<CertifiedProductDetailsDTO> getByVersions(List<Long> versionIds) {
		return dao.getDetailsByVersionIds(versionIds);
	}
	
	@Override
	@PreAuthorize("(hasRole('ROLE_ACB_STAFF') or hasRole('ROLE_ACB_ADMIN')) "
			+ "and hasPermission(#acbId, 'gov.healthit.chpl.dto.CertificationBodyDTO', admin)")
	@Transactional(readOnly = false)
	public CertifiedProductDTO createFromPending(Long acbId, PendingCertifiedProductDetails pendingCp) 
			throws EntityRetrievalException, EntityCreationException, JsonProcessingException {
		
		CertifiedProductDTO toCreate = new CertifiedProductDTO();
		toCreate.setAcbCertificationId(pendingCp.getAcbCertificationId());
		
		String certifyingBodyId = null;
		if(pendingCp.getCertifyingBody().get("id") == null) {
			CertificationBodyDTO acbDto = new CertificationBodyDTO();
			acbDto.setName(pendingCp.getCertifyingBody().get("name").toString());
			if(StringUtils.isEmpty(acbDto.getName())) {
				throw new EntityCreationException("Cannot create a certifying body without a name.");
			}
			acbDto = acbDao.create(acbDto);
			certifyingBodyId = acbDto.getId().toString();
		} else {
			certifyingBodyId = pendingCp.getCertifyingBody().get("id").toString();
		}
		toCreate.setCertificationBodyId(new Long(certifyingBodyId));
		
		if(pendingCp.getCertificationEdition().get("id") == null) {
			throw new EntityCreationException("The ID of an existing certification edition (year) must be provided. A new certification edition cannot be created via this process.");
		}
		String certificationEditionId = pendingCp.getCertificationEdition().get("id").toString();
		toCreate.setCertificationEditionId(new Long(certificationEditionId));
		
		String status = pendingCp.getRecordStatus();
		if(StringUtils.isEmpty(status)) {
			throw new EntityCreationException("Cannot determine certification status. Is this a new record? An update? A removal?");
		}
		if(status.trim().equalsIgnoreCase("new")) {
			CertificationStatusDTO statusDto = statusDao.getByStatusName("Active");
			toCreate.setCertificationStatusId(statusDto.getId());
		} //TODO: handle the other cases?
		
		toCreate.setCreationDate(new Date());
		toCreate.setDeleted(false);
		toCreate.setLastModifiedDate(new Date());
		toCreate.setLastModifiedUser(Util.getCurrentUser().getId());
		
		//can be null
		if(pendingCp.getPracticeType().get("id") != null) {
			String practiceTypeId = pendingCp.getPracticeType().get("id").toString();
			toCreate.setPracticeTypeId(new Long(practiceTypeId));
		}
		
		//can be null
		if(pendingCp.getClassificationType().get("id") != null) {
			String productClassificationTypeId = pendingCp.getClassificationType().get("id").toString();
			toCreate.setProductClassificationTypeId(new Long(productClassificationTypeId));
		}
		
		String developerId = null; 
		if(pendingCp.getDeveloper().get("id") == null) {
			DeveloperDTO newDeveloper = new DeveloperDTO();
			if(pendingCp.getDeveloper().get("name") == null) {
				throw new EntityCreationException("You must provide a developer name to create a new developer.");
			}
			newDeveloper.setName(pendingCp.getDeveloper().get("name").toString());
			newDeveloper.setWebsite(pendingCp.getDeveloper().get("website").toString());
			newDeveloper.setTransparencyAttestation(pendingCp.getTransparencyAttestation() == null ? Boolean.FALSE : pendingCp.getTransparencyAttestation());
			//TODO: add transparency attestation URl
			Map<String, Object> developerAddress = pendingCp.getDeveloperAddress();
			if(developerAddress != null) {
				AddressDTO address = new AddressDTO();
				if(developerAddress.get("line1") != null) {
					address.setStreetLineOne(developerAddress.get("line1").toString());
				}
				if(developerAddress.get("city") != null) {
					address.setCity(developerAddress.get("city").toString());
				}
				if(developerAddress.get("state") != null) {
					address.setState(developerAddress.get("state").toString());
				}
				if(developerAddress.get("zipcode") != null) {
					address.setZipcode(developerAddress.get("zipcode").toString());
				}
				address.setCountry("USA");
				newDeveloper.setAddress(address);
			}
			
			newDeveloper = developerManager.create(newDeveloper);
			developerId = newDeveloper.getId().toString();
		} else {
			developerId = pendingCp.getDeveloper().get("id").toString();
		}
		
		String productId = null;
		if(pendingCp.getProduct().get("id") == null) {
			ProductDTO newProduct = new ProductDTO();
			if(pendingCp.getProduct().get("name") == null) {
				throw new EntityCreationException("Either product name or ID must be provided.");
			}
			newProduct.setName(pendingCp.getProduct().get("name").toString());
			newProduct.setDeveloperId(new Long(developerId));
			newProduct.setReportFileLocation(pendingCp.getReportFileLocation());
			newProduct = productManager.create(newProduct);
			productId = newProduct.getId().toString();
		} else {
			productId = pendingCp.getProduct().get("id").toString();
		}
		
		String productVersionId = null;
		if(pendingCp.getProduct().get("versionId") == null) {
			ProductVersionDTO newVersion = new ProductVersionDTO();
			if(pendingCp.getProduct().get("version") == null) {
				throw new EntityCreationException("Either version id or version must be provided.");
			}
			newVersion.setVersion(pendingCp.getProduct().get("version").toString());
			newVersion.setProductId(new Long(productId));
			newVersion = versionManager.create(newVersion);
			productVersionId = newVersion.getId().toString();
		} else {
			productVersionId = pendingCp.getProduct().get("versionId").toString();
		}
		
		toCreate.setProductVersionId(new Long(productVersionId));
		toCreate.setReportFileLocation(pendingCp.getReportFileLocation());
		toCreate.setSedReportFileLocation(pendingCp.getSedReportFileLocation());
		toCreate.setVisibleOnChpl(true);
		toCreate.setIcs(pendingCp.getIcs());
		toCreate.setSedTesting(pendingCp.getSedTesting());
		toCreate.setQmsTesting(pendingCp.getQmsTesting());
		
		//TODO: this may have to be added to pending certified products if it's in the spreadsheet?
		toCreate.setPrivacyAttestation(false);
		
		String certificationEdition = pendingCp.getCertificationEdition().get("name").toString();
		CertifiedProductDTO newCertifiedProduct = dao.create(toCreate);
		
		//certs
		if(pendingCp.getCertificationResults() != null && pendingCp.getCertificationResults().size() > 0) {
			for(CertificationResult certResult : pendingCp.getCertificationResults()) {
				CertificationCriterionDTO criterion = certCriterionDao.getByName(certResult.getNumber());
				if(criterion == null) {
					throw new EntityCreationException("Could not find certification criterion with number " + certResult.getNumber());
				}
				CertificationResultDTO certResultToCreate = new CertificationResultDTO();
				certResultToCreate.setCertificationCriterionId(criterion.getId());
				certResultToCreate.setCertifiedProduct(newCertifiedProduct.getId());
				certResultToCreate.setCreationDate(new Date());
				certResultToCreate.setDeleted(false);
				certResultToCreate.setLastModifiedDate(new Date());
				certResultToCreate.setLastModifiedUser(Util.getCurrentUser().getId());
				certResultToCreate.setSuccessful(certResult.isSuccess());
				//TODO: set extra fields and relationships
				certDao.create(certResultToCreate);
			}
		}
		
		//cqms
		if(pendingCp.getCqmResults() != null && pendingCp.getCqmResults().size() > 0) {
			for(CQMResultDetails cqmResult : pendingCp.getCqmResults()) {
				CQMCriterionDTO criterion = null;
				if(StringUtils.isEmpty(cqmResult.getCmsId())) {
					criterion = cqmCriterionDao.getNQFByNumber(cqmResult.getNqfNumber());
					
					if(criterion == null) {
						throw new EntityCreationException("Could not find a CQM with number " + cqmResult.getNqfNumber());
					}
					
					CQMResultDTO cqmResultToCreate = new CQMResultDTO();
					cqmResultToCreate.setCqmCriterionId(criterion.getId());
					cqmResultToCreate.setCertifiedProductId(newCertifiedProduct.getId());
					cqmResultToCreate.setCreationDate(new Date());
					cqmResultToCreate.setDeleted(false);
					cqmResultToCreate.setLastModifiedDate(new Date());
					cqmResultToCreate.setLastModifiedUser(Util.getCurrentUser().getId());
					cqmResultToCreate.setSuccess(cqmResult.isSuccess());
					cqmResultDAO.create(cqmResultToCreate);
					
				} else if(cqmResult.getCmsId().startsWith("CMS")) {
					for(String version : cqmResult.getSuccessVersions()) {
						criterion = cqmCriterionDao.getCMSByNumberAndVersion(cqmResult.getCmsId(), version);
						
						if(criterion == null) {
							throw new EntityCreationException("Could not find a CQM with number " + cqmResult.getCmsId() + 
									"and version " + version + ".");
						}
						
						CQMResultDTO cqmResultToCreate = new CQMResultDTO();
						cqmResultToCreate.setCqmCriterionId(criterion.getId());
						cqmResultToCreate.setCertifiedProductId(newCertifiedProduct.getId());
						cqmResultToCreate.setCreationDate(new Date());
						cqmResultToCreate.setDeleted(false);
						cqmResultToCreate.setLastModifiedDate(new Date());
						cqmResultToCreate.setLastModifiedUser(Util.getCurrentUser().getId());
						cqmResultToCreate.setSuccess(cqmResult.isSuccess());
						cqmResultDAO.create(cqmResultToCreate);
					}
				}
			}
		}
		
		
		//if all this was successful, insert a certification_event for the certification date, and the date it went active in CHPL (right now)
		EventTypeDTO certificationEventType = eventTypeDao.getByName("Certification");
		CertificationEventDTO certEvent = new CertificationEventDTO();
		certEvent.setCreationDate(new Date());
		certEvent.setDeleted(false);
		Date certificationDate = new Date(new Long(pendingCp.getCertificationDate()));
		certEvent.setEventDate(certificationDate);
		certEvent.setEventTypeId(certificationEventType.getId());
		certEvent.setLastModifiedDate(new Date());
		certEvent.setLastModifiedUser(Util.getCurrentUser().getId());
		certEvent.setCertifiedProductId(newCertifiedProduct.getId());
		eventDao.create(certEvent);

		//active event
		EventTypeDTO activeEventType = eventTypeDao.getByName("Active");
		CertificationEventDTO activeEvent = new CertificationEventDTO();
		activeEvent.setCreationDate(new Date());
		activeEvent.setDeleted(false);
		activeEvent.setEventDate(new Date());
		activeEvent.setEventTypeId(activeEventType.getId());
		activeEvent.setLastModifiedDate(new Date());
		activeEvent.setLastModifiedUser(Util.getCurrentUser().getId());
		activeEvent.setCertifiedProductId(newCertifiedProduct.getId());
		eventDao.create(activeEvent);
		
		CertifiedProductSearchDetails details = detailsManager.getCertifiedProductDetails(newCertifiedProduct.getId());
		activityManager.addActivity(ActivityConcept.ACTIVITY_CONCEPT_CERTIFIED_PRODUCT, details.getId(), "Created "+newCertifiedProduct.getChplProductNumberForActivity(), null, details);
		
		return newCertifiedProduct;
	}
	
	@Override
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@Transactional(readOnly = false) 
	public CertifiedProductDTO changeOwnership(Long certifiedProductId, Long acbId) throws EntityRetrievalException, JsonProcessingException, EntityCreationException {
		
		CertifiedProductDTO toUpdate = dao.getById(certifiedProductId);
		toUpdate.setCertificationBodyId(acbId);
		return update(acbId, toUpdate);
	}
	
	@Override
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_ACB_ADMIN') or hasRole('ROLE_ACB_STAFF')")
	@Transactional(readOnly = false)
	public CertifiedProductDTO updateCertifiedProductVersion(Long certifiedProductId, Long newVersionId) 
		throws EntityRetrievalException {
		CertifiedProductDTO toUpdate = dao.getById(certifiedProductId);
		toUpdate.setProductVersionId(newVersionId);
		return dao.update(toUpdate);
	}
	
	@Override
	@PreAuthorize("hasRole('ROLE_ADMIN') or "
			+ "( (hasRole('ROLE_ACB_STAFF') or hasRole('ROLE_ACB_ADMIN'))"
			+ "  and hasPermission(#acbId, 'gov.healthit.chpl.dto.CertificationBodyDTO', admin)"
			+ ")")
	@Transactional(readOnly = false)
	public CertifiedProductDTO update(Long acbId, CertifiedProductDTO dto) throws EntityRetrievalException, JsonProcessingException, EntityCreationException {
		
		CertifiedProductDTO before = dao.getById(dto.getId());
		CertifiedProductDTO result = dao.update(dto);
		
		activityManager.addActivity(ActivityConcept.ACTIVITY_CONCEPT_CERTIFIED_PRODUCT, result.getId(), "Updated " + result.getChplProductNumberForActivity() , before , result);
		return result;
	}	
	
	@Override
	@PreAuthorize("hasRole('ROLE_ADMIN') or "
			+ "( (hasRole('ROLE_ACB_STAFF') or hasRole('ROLE_ACB_ADMIN'))"
			+ "  and hasPermission(#acbId, 'gov.healthit.chpl.dto.CertificationBodyDTO', admin)"
			+ ")")
	@Transactional(readOnly = false)
	public void updateQmsStandards(Long acbId, CertifiedProductDTO productDto, List<CertifiedProductQmsStandardDTO> newQmsStandards)
		throws EntityCreationException, EntityRetrievalException, JsonProcessingException {
		
		List<CertifiedProductQmsStandardDTO> beforeQms = qmsDao.getQmsStandardsByCertifiedProductId(productDto.getId());
		
		List<CertifiedProductQmsStandardDTO> qmsToAdd = new ArrayList<CertifiedProductQmsStandardDTO>();
		List<CertifiedProductQmsStandardDTO> qmsToRemove = new ArrayList<CertifiedProductQmsStandardDTO>();
		
		for (CertifiedProductQmsStandardDTO newQmsStandard : newQmsStandards){
			if(newQmsStandard.getId() == null) {
				qmsToAdd.add(newQmsStandard);
			} 
		}
		
		for(CertifiedProductQmsStandardDTO currQms : beforeQms) {
			boolean isInUpdate = false;
			for (CertifiedProductQmsStandardDTO newQms : newQmsStandards){
				if(newQms.getId() != null && 
						newQms.getId().longValue() == currQms.getId().longValue()) {
					isInUpdate = true;
				}
			}
			if(!isInUpdate) {
				qmsToRemove.add(currQms);
			}
		}
			
		for(CertifiedProductQmsStandardDTO toAdd : qmsToAdd) {
			qmsDao.createCertifiedProductQms(toAdd);
		}
		for(CertifiedProductQmsStandardDTO toRemove : qmsToRemove) {
			qmsDao.deleteCertifiedProductQms(toRemove.getId());
		}	
		
		//only put in activity if something changed
		if( (qmsToAdd != null && qmsToAdd.size() > 0) ||
				(qmsToRemove != null && qmsToRemove.size() > 0) )
		{
			List<CertifiedProductQmsStandardDTO> afterQms = qmsDao.getQmsStandardsByCertifiedProductId(productDto.getId());
			activityManager.addActivity(ActivityConcept.ACTIVITY_CONCEPT_CERTIFIED_PRODUCT, productDto.getId(), "QMS Standards Used for "+productDto.getChplProductNumberForActivity() + " were updated." , beforeQms , afterQms);
		}
	}
	
	/**
	 * both successes and failures are passed in
	 * @throws JsonProcessingException 
	 */
	@Override
	@PreAuthorize("hasRole('ROLE_ADMIN') or "
			+ "( (hasRole('ROLE_ACB_STAFF') or hasRole('ROLE_ACB_ADMIN'))"
			+ "  and hasPermission(#acbId, 'gov.healthit.chpl.dto.CertificationBodyDTO', admin)"
			+ ")")
	@Transactional(readOnly = false)
	public void updateCertifications(Long acbId, CertifiedProductDTO productDto, List<CertificationResult> newCertResults)
		throws EntityCreationException, EntityRetrievalException, JsonProcessingException {
		
		CertifiedProductSearchDetails before = detailsManager.getCertifiedProductDetails(productDto.getId());
		List<CertificationResultDTO> oldCertificationResults = certDao.findByCertifiedProductId(productDto.getId());
		
		for (CertificationResultDTO oldResult : oldCertificationResults){
			CertificationCriterionDTO criterionDTO = certCriterionDao.getById(oldResult.getCertificationCriterionId());
			
			for (CertificationResult newCertResult : newCertResults){
				//update whether the certification criterion was met or not
				if (newCertResult.getNumber().equals(criterionDTO.getNumber())){	
					// replace the value of the result. we shouldn't have to add or delete any cert results
					// because for certification criteria, all results are always there whether they were
					// successful or not
					oldResult.setSuccessful(newCertResult.isSuccess());
					oldResult.setGap(newCertResult.isGap());
					oldResult.setG1Success(newCertResult.isG1Success());
					oldResult.setG2Success(newCertResult.isG2Success());
					oldResult.setSed(newCertResult.isSed());
					oldResult.setUcdProcessDetails(newCertResult.getUcdProcessDetails());
					oldResult.setUcdProcessSelected(newCertResult.getUcdProcessSelected());

					if(newCertResult.getAdditionalSoftware() == null || newCertResult.getAdditionalSoftware().size() == 0) {
						oldResult.setAdditionalSoftware(new ArrayList<CertificationResultAdditionalSoftwareDTO>());
					} else {
						for(CertificationResultAdditionalSoftware newAdditionalSoftware : newCertResult.getAdditionalSoftware()) {
							CertificationResultAdditionalSoftwareDTO software = new CertificationResultAdditionalSoftwareDTO();
							software.setId(newAdditionalSoftware.getId());
							software.setCertificationResultId(oldResult.getId());
							software.setCertifiedProductId(newAdditionalSoftware.getCertifiedProductId());
							software.setName(newAdditionalSoftware.getName());
							software.setVersion(newAdditionalSoftware.getVersion());
							software.setJustification(newAdditionalSoftware.getJustification());
							oldResult.getAdditionalSoftware().add(software);
						}
					}
					
					if(newCertResult.getTestStandards() == null || newCertResult.getTestStandards().size() == 0) {
						oldResult.setTestStandards(new ArrayList<CertificationResultTestStandardDTO>());
					} else {
						for(CertificationResultTestStandard newTestStandard : newCertResult.getTestStandards()) {
							CertificationResultTestStandardDTO testStandard = new CertificationResultTestStandardDTO();
							testStandard.setId(newTestStandard.getId());
							testStandard.setTestStandardId(newTestStandard.getTestStandardId());
							testStandard.setTestStandardName(newTestStandard.getTestStandardName());
							testStandard.setCertificationResultId(oldResult.getId());
							testStandard.setDeleted(false);
							oldResult.getTestStandards().add(testStandard);
						}
					}
					
					if(newCertResult.getTestToolsUsed() == null || newCertResult.getTestToolsUsed().size() == 0) {
						oldResult.setTestTools(new ArrayList<CertificationResultTestToolDTO>());
					} else {
						for(CertificationResultTestTool newTestTool : newCertResult.getTestToolsUsed()) {
							CertificationResultTestToolDTO testTool = new CertificationResultTestToolDTO();
							testTool.setId(newTestTool.getId());
							testTool.setTestToolId(newTestTool.getTestToolId());
							testTool.setTestToolName(newTestTool.getTestToolName());
							testTool.setTestToolVersion(newTestTool.getTestToolVersion());
							testTool.setCertificationResultId(oldResult.getId());
							oldResult.getTestTools().add(testTool);
						}
					}
					
					if(newCertResult.getTestDataUsed() == null || newCertResult.getTestDataUsed().size() == 0) {
						oldResult.setTestData(new ArrayList<CertificationResultTestDataDTO>());
					} else {
						for(CertificationResultTestData newTestData : newCertResult.getTestDataUsed()) {
							CertificationResultTestDataDTO testData = new CertificationResultTestDataDTO();
							testData.setId(newTestData.getId());
							testData.setVersion(newTestData.getVersion());
							testData.setAlteration(newTestData.getAlteration());
							testData.setCertificationResultId(oldResult.getId());
							oldResult.getTestData().add(testData);
						}
					}
					
					if(newCertResult.getTestProcedures() == null || newCertResult.getTestProcedures().size() == 0) {
						oldResult.setTestProcedures(new ArrayList<CertificationResultTestProcedureDTO>());
					} else {
						for(CertificationResultTestProcedure newTestProcedure : newCertResult.getTestProcedures()) {
							CertificationResultTestProcedureDTO testTool = new CertificationResultTestProcedureDTO();
							testTool.setId(newTestProcedure.getId());
							testTool.setTestProcedureId(newTestProcedure.getTestProcedureId());
							testTool.setTestProcedureVersion(newTestProcedure.getTestProcedureVersion());
							testTool.setCertificationResultId(oldResult.getId());
							oldResult.getTestProcedures().add(testTool);
						}
					}
					
					certResultManager.update(acbId, oldResult);
					break;
				}
			}
		}
		CertifiedProductSearchDetails after = detailsManager.getCertifiedProductDetails(productDto.getId());
		activityManager.addActivity(ActivityConcept.ACTIVITY_CONCEPT_CERTIFIED_PRODUCT, productDto.getId(), "Certifications for "+productDto.getChplProductNumberForActivity() + " were updated." , before , after);
	}
	
	@Override
	@PreAuthorize("hasRole('ROLE_ADMIN') or "
			+ "( (hasRole('ROLE_ACB_STAFF') or hasRole('ROLE_ACB_ADMIN'))"
			+ "  and hasPermission(#acbId, 'gov.healthit.chpl.dto.CertificationBodyDTO', admin)"
			+ ")")
	@Transactional(readOnly = false)
	public void updateCqms(Long acbId, CertifiedProductDTO productDto, Map<CQMCriterionDTO, Boolean> cqmResults)
		throws EntityCreationException, EntityRetrievalException, JsonProcessingException {
		
		CertifiedProductSearchDetails before = detailsManager.getCertifiedProductDetails(productDto.getId());
		
		Boolean dataHasChanged = false;
		
		List<CQMResultDTO> beforeCQMs = cqmResultDAO.findByCertifiedProductId(productDto.getId());
		
		// Handle NQFs and Additions:
		for (Map.Entry<CQMCriterionDTO, Boolean> cqm : cqmResults.entrySet()){
			
			Boolean isNQF = (cqm.getKey().getCmsId() == null);
			if (isNQF){
				for (CQMResultDTO beforeCQM : beforeCQMs){
					
					Long beforeCQMCriterionID = beforeCQM.getCqmCriterionId();
					CQMCriterionDTO beforeCriterionDTO = cqmCriterionDao.getById(beforeCQMCriterionID);
					
					if ((beforeCriterionDTO.getCmsId() == null) && (beforeCriterionDTO.getNqfNumber().equals(cqm.getKey().getNqfNumber()) ) ){
						beforeCQM.setSuccess(cqm.getValue());
						cqmResultDAO.update(beforeCQM);
						dataHasChanged = true;
						break;
					}
				}
			} else {
				
				Boolean found = false;
				
				for (CQMResultDTO beforeCQM : beforeCQMs){
					
					Long beforeCQMCriterionID = beforeCQM.getCqmCriterionId();
					CQMCriterionDTO beforeCriterionDTO = cqmCriterionDao.getById(beforeCQMCriterionID);
					
					if (beforeCriterionDTO.getCmsId().equals(cqm.getKey().getCmsId()) && 
							beforeCriterionDTO.getCqmVersion().equals(cqm.getKey().getCqmVersion())) {
						found = true;
						break;
					}
				}
				if (!found){
					
					CQMCriterionDTO criterion = null;
					if(StringUtils.isEmpty(cqm.getKey().getCmsId())) {
						criterion = cqmCriterionDao.getNQFByNumber(cqm.getKey().getNumber());
					} else if(cqm.getKey().getCmsId().startsWith("CMS")) {
						criterion = cqmCriterionDao.getCMSByNumberAndVersion(cqm.getKey().getCmsId(), cqm.getKey().getCqmVersion());
					}
					if(criterion == null) {
						throw new EntityRetrievalException("Could not find CQM with number " + cqm.getKey().getCmsId() + " and version " + cqm.getKey().getCqmVersion());
					}
					
					CQMResultDTO newCQMResult = new CQMResultDTO();
					
					newCQMResult.setCertifiedProductId(productDto.getId());
					newCQMResult.setCqmCriterionId(criterion.getId());
					newCQMResult.setCreationDate(new Date());
					newCQMResult.setDeleted(false);
					newCQMResult.setSuccess(true);
					cqmResultDAO.create(newCQMResult);
					dataHasChanged = true;
				}
			}
		}
		
		// Handle CQM deletions:
		for (CQMCriterionDTO criterion : cqmCriterionDao.findAll()){
			
			Boolean isDeletion = true;
			Boolean isNQF = (criterion.getCmsId() == null);
			
			if (isNQF){
				isDeletion = false;
			} else {
							
				for (Map.Entry<CQMCriterionDTO, Boolean> cqm : cqmResults.entrySet()){
					
					Boolean cqmIsNQF = (cqm.getKey().getCmsId() == null);
					if (!cqmIsNQF){
						if (cqm.getKey().getCmsId().equals(criterion.getCmsId())){
							isDeletion = false;
							break;
						}
					}
				}
			}
			if (isDeletion){
				deleteCqmResult(productDto.getId(), criterion.getId());
				dataHasChanged = true;
			}
			
		}
		
		CertifiedProductSearchDetails after = detailsManager.getCertifiedProductDetails(productDto.getId());
		
		if (dataHasChanged){
			activityManager.addActivity(ActivityConcept.ACTIVITY_CONCEPT_CERTIFIED_PRODUCT, productDto.getId(), "Certifications for "+productDto.getChplProductNumberForActivity()+" were updated." , before , after);
		}
		
	}
	
	private void deleteCqmResult(Long certifiedProductId, Long cqmId){
		
		List<CQMResultDTO> cqmResults = cqmResultDAO.findByCertifiedProductId(certifiedProductId);
		
		for (CQMResultDTO cqmResult : cqmResults){
			if (cqmResult.getCqmCriterionId().equals(cqmId)){
				cqmResultDAO.delete(cqmResult.getId());
			}
		}
	}	
}
