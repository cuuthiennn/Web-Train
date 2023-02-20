package JavaOracleWebix.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import JavaOracleWebix.entity.Role;

@Mapper
public interface RoleMapper {
	List<Role> getAllRole();
	
	void saveRole(Role paramRole);
	
	void updateRole(Role role);
	
	void deleteRole(@Param(value = "roleId") Long roleId);

	List<HashMap<String, Object>> getRoleIdIsUse();
	
	Long getMaxRoleId();
	
	List<HashMap<String, Object>> getCountRole();
	
	List<HashMap<String, Object>> countRoleIsUse();
}
