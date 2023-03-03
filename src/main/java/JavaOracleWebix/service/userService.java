package JavaOracleWebix.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import JavaOracleWebix.entity.User;

public interface userService {
	List<User> getAllUser() throws SQLException;
	
	List<User> getUserByRoleName(String roleName) throws SQLException;
	
	List<User> getUserisUseByRoleName(String roleName) throws SQLException;
	
	List<User> getUserByIsUse(String isUse) throws SQLException;
	
	void saveUser(User userParam);
	
	void deleteUser(Long userId);
	
	void updateUser(User userParam);
	
	List<User> getUserByName(String tenKh);
	
	Long getMaxMakh();
	
	//void uploadImageUser(MultipartFile image, Long maKh);
}
