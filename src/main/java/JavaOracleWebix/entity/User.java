package JavaOracleWebix.entity;

import java.sql.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
	private Long maKh;
	private String tenKh;
	private String diaChi;
	private String mail;
	private String phone;
	private String image;
	private Date birthday;
	private String isUse;
	private int roleId;
	private String roleName;
}