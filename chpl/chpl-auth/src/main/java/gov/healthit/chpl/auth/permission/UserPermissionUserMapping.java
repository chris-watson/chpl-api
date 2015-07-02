package gov.healthit.chpl.auth.permission;

import gov.healthit.chpl.auth.user.UserEntity;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.Where;


@Entity
@Table(name="global_user_permission_map")
@Where(clause = "NOT deleted")
public class UserPermissionUserMapping {
	
	
	@EmbeddedId
	private UserPermissionUserMappingPk pk = new UserPermissionUserMappingPk();
	
	@Column(name="deleted")
	private boolean deleted;
	
	@Column(name="last_modified_user")
	private Long lastModifiedUser;
	
	
	public Long getLastModifiedUser() {
		return lastModifiedUser;
	}

	public void setLastModifiedUser(Long lastModifiedUser) {
		this.lastModifiedUser = lastModifiedUser;
	}

	public boolean isDeleted() {
		return deleted;
	}
	
	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public UserEntity getUser() {
		return getPk().getUser();
	}
	
	public void setUser(UserEntity user) {
		this.getPk().setUser(user);
	}
	
	public UserPermissionEntity getPermission() {
		return this.getPk().getPermission();
	}
	
	public void setPermission(UserPermissionEntity permission) {
		this.getPk().setPermission(permission);
	}
	
	public UserPermissionUserMappingPk getPk() {
		return pk;
	}
	
	public void setPk(UserPermissionUserMappingPk pk) {
		this.pk = pk;
	}
	
}