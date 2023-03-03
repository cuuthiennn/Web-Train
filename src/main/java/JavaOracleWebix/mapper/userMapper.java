package JavaOracleWebix.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.multipart.MultipartFile;

import JavaOracleWebix.entity.User;
@Mapper
public interface userMapper {
	List<User> getAllUser() throws SQLException;
	
	List<User> getUserByRoleName(@Param("roleName") String roleName) throws SQLException;
	
	List<User> getUserisUseByRoleName(@Param("roleName") String roleName) throws SQLException;
	
	List<User> getUserByIsUse(@Param("isUse") String isUse) throws SQLException;

	void saveUser( User userParam);

	void deleteUser(@Param("maKh") Long maKh);

	void updateUser(User userParam);
	List<User> getUserByName(String tenKh);

	Long getMaxMakh();
	
	//void uploadImageUser(@Param("image") MultipartFile image, @Param("maKh") Long maKh);
}
