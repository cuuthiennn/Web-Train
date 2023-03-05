package JavaOracleWebix.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.xssf.model.ThemesTable;
import org.apache.poi.xssf.model.ThemesTable.ThemeElement;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.extensions.XSSFCellBorder;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBorder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.context.Theme;

import JavaOracleWebix.entity.User;
import JavaOracleWebix.mapper.userMapper;
import JavaOracleWebix.service.userService;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;

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


	@Override
	public List<User> searchUser(String tenKh, List<Integer> arrayId) {
		// TODO Auto-generated method stub
		return usrMapper.searchUser(tenKh, arrayId);
	}


	@Override
	public void expotExcel(HttpServletResponse response, String tenKh, List<Integer> arrayId) throws Exception {
		// TODO Auto-generated method stub
		List<User> dataExport = usrMapper.searchUser(tenKh, arrayId);
		
		XSSFWorkbook workBook = new XSSFWorkbook();
		XSSFSheet sheet = workBook.createSheet();
		XSSFRow row = sheet.createRow(0);
		
		row.createCell(0).setCellValue("ID");
		row.createCell(1).setCellValue("Tên Khách Hàng");
		row.createCell(2).setCellValue("Vai Trò");
		row.createCell(3).setCellValue("Email");
		row.createCell(4).setCellValue("Phone");
		row.createCell(5).setCellValue("Birthday");
		row.createCell(6).setCellValue("Địa Chỉ");
		
		int dataRowIndex = 1;
		for(User x : dataExport) {
			XSSFRow dataRow = sheet.createRow(dataRowIndex);
			dataRow.createCell(0).setCellValue(x.getMaKh());
			dataRow.createCell(1).setCellValue(x.getTenKh());
			dataRow.createCell(2).setCellValue(x.getRoleName());
			dataRow.createCell(3).setCellValue(x.getMail());
			dataRow.createCell(4).setCellValue(x.getPhone());
			dataRow.createCell(5).setCellValue(x.getBirthday().toString());
			dataRow.createCell(6).setCellValue(x.getDiaChi());
			dataRowIndex++;
		} 
		//Lưu dữ liều vừa tạo vào output
		ServletOutputStream output = response.getOutputStream();
		workBook.write(output);
		workBook.close();
		output.close();
	}


	
}
