package JavaOracleWebix.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import JavaOracleWebix.entity.Role;
import JavaOracleWebix.mapper.RoleMapper;
import JavaOracleWebix.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService{
	@Autowired
	private RoleMapper mapper;
	@Override
	public List<Role> getAllRole() {
		// TODO Auto-generated method stub
		return mapper.getAllRole();
	}
	@Override
	public void saveRole(Role paramRole) {
		// TODO Auto-generated method stub
		mapper.saveRole(paramRole);
	}
	@Override
	public void updateRole(Role role) {
		// TODO Auto-generated method stub
		mapper.updateRole(role);
	}
	@Override
	public void deleteRole(Long roleId) {
		// TODO Auto-generated method stub
		mapper.deleteRole(roleId);
	}
	@Override
	public List<HashMap<String, Object>> getRoleIdIsUse() {
		// TODO Auto-generated method stub
		return mapper.getRoleIdIsUse();
	}
	@Override
	public Long getMaxRoleId() {
		// TODO Auto-generated method stub
		return mapper.getMaxRoleId();
	}
	@Override
	public List<HashMap<String, Object>> getCountRole() {
		// TODO Auto-generated method stub
		return mapper.getCountRole();
	}
	@Override
	public List<HashMap<String, Object>> countRoleIsUse() {
		// TODO Auto-generated method stub
		return mapper.countRoleIsUse();
	}
	@Override
	public List<HashMap<String, Object>> richSelectData() {
		// TODO Auto-generated method stub
		return mapper.richSelectData();
	}
}
