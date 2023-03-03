package JavaOracleWebix.controller;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import JavaOracleWebix.entity.User;
import JavaOracleWebix.service.userService;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@RestController
@RequestMapping("/api/user")
public class userAPI {
	
	@Autowired
	private userService usrServ;
	
	@CrossOrigin
	@GetMapping("/getAllUser")
	ResponseEntity<?> doGetAllUser() {
		List<User> listUser = new ArrayList<>();
		HashMap<String, Object> result = new HashMap<>();
		try {
			listUser = usrServ.getAllUser();
			result.put("success", true);
			result.put("message", "Success When Call API getAllUser");
			result.put("data", listUser);
		} catch (Exception e) {
			log.error("Fail When Call API saveRole : ", e);
			result.put("success", false);
			result.put("message", "Fail When Call API getAllUser");
			result.put("data", null);
		}
		return ResponseEntity.ok(result);
	}
	
	@CrossOrigin
	@GetMapping("/getUserByName")
	ResponseEntity<?> doGetUserByName(@RequestParam("tenKh") String tenKh) {
		List<User> listUser = new ArrayList<>();
		HashMap<String, Object> result = new HashMap<>();
		try {
			listUser = usrServ.getUserByName(tenKh);
			result.put("success", true);
			result.put("message", "Success When Call API getUserByName");
			result.put("data", listUser);
		} catch (Exception e) {
			log.error("Fail When Call API saveRole : ", e);
			result.put("success", false);
			result.put("message", "Fail When Call API getUserByName");
			result.put("data", null);
		}
		return ResponseEntity.ok(result);
	}
	
	@CrossOrigin
	@GetMapping("/getUserByIsUse")
	ResponseEntity<?> doGetUserByUse(@RequestParam("isUse") String isUse) throws SQLException {
		List<User> listUser = new ArrayList<>();
		HashMap<String, Object> result = new HashMap<>();
		try {
			listUser = usrServ.getUserByIsUse(isUse);
			result.put("success", true);
			result.put("message", "Success When Call API getUserByIsUse");
			result.put("data", listUser);
		} catch (Exception e) {
			log.error("Fail When Call API saveRole : ", e);
			result.put("success", false);
			result.put("message", "Fail When Call API getUserByIsUse");
			result.put("data", null);
		}
		return ResponseEntity.ok(result);
	}
	

	@CrossOrigin
	@GetMapping("/getUserisUseByRoleName")
	ResponseEntity<?> doGetUserisUseByRoleName(@RequestParam("roleName") String roleName) throws SQLException{

		return ResponseEntity.ok(usrServ.getUserisUseByRoleName(roleName));
	}
	
	
	@CrossOrigin
	@PostMapping("/saveUser")
	ResponseEntity<?> saveUser(@RequestBody User userParam){
		HashMap<String, Object> result = new HashMap<>();
		try {
			usrServ.saveUser(userParam);
			result.put("success", true);
			result.put("massage", "Success when call Api saveUser!");
			result.put("data", userParam);
			
		} catch (Exception e) {
			// TODO: handle exception
			log.error("Fail When Call API saveRole : ", e);
			result.put("success", false);
			result.put("massage", "False when call Api saveUser!");
			result.put("data", null);
		}
		return ResponseEntity.ok(result);
	}
	
	@CrossOrigin
	@DeleteMapping("/deleteUser")
	ResponseEntity<?> doDeleteUser(@RequestParam("maKh") Long maKh){
		HashMap<String, Object> result = new HashMap<>();
		try {
			usrServ.deleteUser(maKh);
			result.put("success", true);
			result.put("massage", "Success when call Api deleteUser!");
			result.put("data", maKh);
		} catch (Exception e) {
			log.error("Fail when call Api deleteUser :", e);
			result.put("success", false);
			result.put("massage", "Success when call Api deleteUser!");
			result.put("data", null);
		}
		return ResponseEntity.ok(result);
	}
	
	@CrossOrigin
	@PostMapping("/saveOrUpdateUser")
	ResponseEntity<?> doSaveOrUpdateUser(@RequestBody User userParam) throws SQLException{
		HashMap<String, Object> result = new HashMap<>();
		try {
			if(userParam.getMaKh() == 0) {
				userParam.setMaKh(usrServ.getMaxMakh());
				usrServ.saveUser(userParam);
			}else {
				usrServ.updateUser(userParam);
			}
			result.put("success", true);
			result.put("massage", "Success when call Api deleteUser!");
			result.put("data", userParam);
		} catch (Exception e) {
			log.error("Fail when call Api deleteUser :", e);
			result.put("success", false);
			result.put("massage", "Success when call Api deleteUser!");
			result.put("data", userParam);
		}
		return ResponseEntity.ok(result);
	}
	
//	@CrossOrigin
//	@PostMapping("/uploadImageuser")
//	ResponseEntity<?> doUploadImageUser(@RequestParam("image") MultipartFile image, @RequestParam("maKh") Long maKh) throws IOException{
//		try {
//			usrServ.uploadImageUser(image, maKh);
//			String fileName = StringUtils.cleanPath(image.getOriginalFilename());
//			String uploadDir = "user-photos/" + maKh;
//			Path uploaPath = Paths.get(uploadDir);
//			if(!Files.exists(uploaPath)) {
//				Files.createDirectories(uploaPath);
//			}
//			InputStream inputStream = image.getInputStream();
//			Path filePath = uploaPath.resolve(fileName);
//			Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
//		} catch (Exception e) {
//			// TODO: handle exception
//			throw new IOException("Could not save image file: ", e);
//		}
//		return null;
//	}
}
