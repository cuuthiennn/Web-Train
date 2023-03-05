package JavaOracleWebix.service;

import java.sql.SQLException;
import java.util.List;

import JavaOracleWebix.entity.User;
import jakarta.servlet.http.HttpServletResponse;

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
	
	List<User> searchUser(String tenKh, List<Integer> arrayId);
	
	void expotExcel(HttpServletResponse response, String tenKh, List<Integer> arrayId) throws Exception;
}
