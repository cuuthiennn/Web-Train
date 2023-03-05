package JavaOracleWebix.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import JavaOracleWebix.entity.Role;
import JavaOracleWebix.service.RoleService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/role")
public class roleAPI {
	@Autowired
	private RoleService roleSrv;
	
	@CrossOrigin
	@GetMapping("/getAllRole")
	ResponseEntity<?> doGetAllRole(){
		return ResponseEntity.ok(roleSrv.getAllRole());
	}
	
	@CrossOrigin
	@GetMapping("/getRoleIdIsUse")
	ResponseEntity<?> doGetRoleIdIsUse(){
		List<HashMap<String, Object>> result = new ArrayList<>();
		try {
			 result = roleSrv.getRoleIdIsUse();
		} catch (Exception e) {
			// TODO: handle exception
			log.error("Fail to call api getRoleIdIsUse!", e);
		}
		return ResponseEntity.ok(result);
	}
	
	@CrossOrigin
	@GetMapping("/richSelectData")
	ResponseEntity<?> doRichSelectData(){
		List<HashMap<String, Object>> result = new ArrayList<>();
		try {
			 result = roleSrv.richSelectData();
		} catch (Exception e) {
			// TODO: handle exception
			log.error("Fail to call api getRoleIdIsUse!", e);
		}
		return ResponseEntity.ok(result);
	}
	
	@CrossOrigin
	@PostMapping("/saveRole")
	ResponseEntity<?> doPostSaveRole(@RequestBody Role paramRole){
		HashMap<String, Object> result = new HashMap<>();
		try {
			roleSrv.saveRole(paramRole);
			result.put("success", true);
			result.put("message", "Success When Call API saveRole");
			result.put("data", paramRole);
		} catch (Exception e) {
			log.error("Fail When Call API saveRole : ", e);
			result.put("success", false);
			result.put("message", "Fail When Call API saveRole");
			result.put("data", null);
		}
		return ResponseEntity.ok(result);
	}
	@CrossOrigin
	@PutMapping("/updateRole")
	ResponseEntity<?> doUpdateRole(@RequestBody Role role){
		HashMap<String, Object> result = new HashMap<>();
		try {
			roleSrv.updateRole(role);
			result.put("success", true);
			result.put("message", "Success when call Api updateRole!");
			result.put("data", role);
		} catch (Exception e) {
			// TODO: handle exception
			log.error("Fail when call Api updateRole: ", e);
			result.put("success", false);
			result.put("message", "Fail when call API updateRole!");
			result.put("data", null);
		}
		return ResponseEntity.ok(result);
	}
	@CrossOrigin
	@DeleteMapping("/deleteRole")
	ResponseEntity<?> doDeleteRole(@RequestParam("roleId") Long roleId){
		HashMap<String, Object> result = new HashMap<>();
		try {
			roleSrv.deleteRole(roleId);
			result.put("success", true);
			result.put("massage", "Success when call Api deleteRole!");
			result.put("data", roleId);
		} catch (Exception e) {
			// TODO: handle exception
			log.error("Fail when call Api deleteRole!", e);
			result.put("success", false);
			result.put("massage", "Fail when call API deleteRole!");
			result.put("data", null);
		}
		return ResponseEntity.ok(result);
	}
	
	@CrossOrigin
	@PostMapping("/saveOrUpdateRole")
	ResponseEntity<?> doSaveOrUpdateRole(@RequestBody Role roleParam){
		HashMap<String, Object> result = new HashMap<>();
		try {
			if(roleParam.getRoleId() != 0) {
				roleSrv.updateRole(roleParam);
			}else {
				roleParam.setRoleId(roleSrv.getMaxRoleId());
				roleSrv.saveRole(roleParam);
			}
			result.put("success", true);
			result.put("message", "Success when call Api saveorupdateRole!");
			result.put("data", roleParam);
		} catch (Exception e) {
			// TODO: handle exception
			log.error("Fail when call Api updateRole: ", e);
			result.put("success", false);
			result.put("message", "Fail when call API saveorupdateRole!");
			result.put("data", null);
		}
		return ResponseEntity.ok(result);
	}
	
	@CrossOrigin
	@GetMapping("/getCountRole")
	ResponseEntity<?> doGetCountRole(){
		List<HashMap<String, Object>> result = new ArrayList<>();
		try {
			result = roleSrv.getCountRole();
		} catch (Exception e) {
			// TODO: handle exception
			log.error("Fail when call Api getCountRole", e);
		}
		return ResponseEntity.ok(result);
	}
	
	@CrossOrigin
	@GetMapping("/countRoleIsUse")
	ResponseEntity<?> docountRoleIsUse(){
		List<HashMap<String, Object>> result = new ArrayList<>();
		try {
			result = roleSrv.countRoleIsUse();
		} catch (Exception e) {
			// TODO: handle exception
			log.error("Fail when call Api countRoleIsUse", e);
		}
		return ResponseEntity.ok(result);
	}
}
