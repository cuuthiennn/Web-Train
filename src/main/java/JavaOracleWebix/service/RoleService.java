package JavaOracleWebix.service;

import java.util.HashMap;
import java.util.List;

import JavaOracleWebix.entity.Role;

public interface RoleService {
	List<Role> getAllRole();

	void saveRole(Role paramRole);
	
	void updateRole(Role role);
	
	void deleteRole(Long roleId);
	
	List<HashMap<String, Object>> getRoleIdIsUse();
	
	Long getMaxRoleId();
	
	List<HashMap<String, Object>> getCountRole();
	
	List<HashMap<String, Object>> countRoleIsUse();
	
	List<HashMap<String, Object>> richSelectData();
}
