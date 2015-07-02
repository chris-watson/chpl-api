package gov.healthit.chpl.auth.permission;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gov.healthit.chpl.auth.permission.dao.UserPermissionDAO;
import gov.healthit.chpl.auth.permission.dao.UserPermissionUserMappingDAO;
import gov.healthit.chpl.auth.user.UserEntity;

@Service
public class PermissionMappingManagerImpl implements PermissionMappingManager {
	
	@Autowired
	UserPermissionUserMappingDAO userPermissionUserMappingDAO;
	
	@Autowired
	UserPermissionDAO userPermissionDAO;
	
	public void create(UserPermissionUserMapping userPermissionMapping){
		userPermissionUserMappingDAO.create(userPermissionMapping);
	}
	
	public void update(UserPermissionUserMapping userPermissionMapping){
		userPermissionUserMappingDAO.update(userPermissionMapping);
	}
	
	public void delete(UserPermissionUserMapping userPermissionMapping){
		userPermissionUserMappingDAO.deactivate(userPermissionMapping);
	}
	
	public void grant(UserEntity user, UserPermissionEntity permission){
		
		UserPermissionUserMapping permissionMapping = new UserPermissionUserMapping();
		permissionMapping.setPermission(permission);
		permissionMapping.setUser(user);
		create(permissionMapping);
		
	}
	
	@Override
	public void grant(UserEntity user, String authority) throws UserPermissionRetrievalException {
		
		UserPermissionEntity permission = userPermissionDAO.getPermissionFromAuthority(authority);
		if (permission == null){
			throw new UserPermissionRetrievalException("The permission you are trying to grant does not exist");
		}
		
		UserPermissionUserMapping permissionMapping = new UserPermissionUserMapping();
		permissionMapping.setPermission(permission);
		permissionMapping.setUser(user);
		userPermissionUserMappingDAO.create(permissionMapping);
		
	}
	
	public void revoke(UserEntity user, UserPermissionEntity permission){
		
		userPermissionUserMappingDAO.deactivate(user.getId(), permission.getId());
		
	}


	@Override
	public void revoke(UserEntity user, String authority) throws UserPermissionRetrievalException {
		
		UserPermissionEntity permission = userPermissionDAO.getPermissionFromAuthority(authority);
		if (permission == null){
			throw new UserPermissionRetrievalException("The permission you are trying to grant does not exist");
		}
		
		userPermissionUserMappingDAO.deactivate(user.getId(), permission.getId());
	}

	@Override
	public Set<UserPermission> getPermissions(UserEntity user) {
		
		Set<UserPermission> permissions = new HashSet<UserPermission>();
		List<UserPermissionUserMapping> mappings = userPermissionUserMappingDAO.findPermissionMappingsForUser(user.getId());
		
		for (UserPermissionUserMapping mapping : mappings){
			permissions.add(mapping.getPermission());
		}
		
		return permissions;
	}

	@Override
	public Set<UserPermissionEntity> getPermissionEntities(UserEntity user) {
		
		Set<UserPermissionEntity> permissions = new HashSet<UserPermissionEntity>();
		List<UserPermissionUserMapping> mappings = userPermissionUserMappingDAO.findPermissionMappingsForUser(user.getId());
		
		for (UserPermissionUserMapping mapping : mappings){
			permissions.add(mapping.getPermission());
		}
		
		return permissions;
	}
	
}