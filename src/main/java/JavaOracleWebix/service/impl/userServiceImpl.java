package JavaOracleWebix.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import JavaOracleWebix.entity.User;
import JavaOracleWebix.mapper.userMapper;
import JavaOracleWebix.service.userService;

@Service
public class userServiceImpl implements userService{
	
	@Autowired
	private userMapper usrMapper;
	
	@Override
	public List<User> getAllUser() throws SQLException{
		// TODO Auto-generated method stub
		return usrMapper.getAllUser();
	}


	@Override
	public List<User> getUserByRoleName(String roleName) throws SQLException {
		// TODO Auto-generated method stub
		return usrMapper.getUserByRoleName(roleName);
	}

	@Override
	public List<User> getUserisUseByRoleName(String roleName) throws SQLException {
		// TODO Auto-generated method stub
		return usrMapper.getUserisUseByRoleName(roleName);
	}

	@Override
	public List<User> getUserByIsUse(String isUse) throws SQLException {
		// TODO Auto-generated method stub
		return usrMapper.getUserByIsUse(isUse);
	}


	@Override
	public void saveUser(User userParam) {
		
		usrMapper.saveUser(userParam);
	}


	@Override
	public void deleteUser(Long userId) {
		// TODO Auto-generated method stub
		usrMapper.deleteUser(userId);
	}


	@Override
	public void updateUser(User userParam) {
		// TODO Auto-generated method stub
		usrMapper.updateUser(userParam);
	}


	@Override
	public List<User> getUserByName(String tenKh) {
		// TODO Auto-generated method stub
		return usrMapper.getUserByName(tenKh);
	}


	@Override
	public Long getMaxMakh() {
		// TODO Auto-generated method stub
		return usrMapper.getMaxMakh();
	}


//	@Override
//	public void uploadImageUser(MultipartFile image, Long maKh) {
//		// TODO Auto-generated method stub
//		usrMapper.uploadImageUser(image, maKh);
//	}

}
