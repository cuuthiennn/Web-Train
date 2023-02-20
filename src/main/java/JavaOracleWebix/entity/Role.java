package JavaOracleWebix.entity;

import java.util.Iterator;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Role {
	private Long roleId;
	private String roleName;
	private String isuse;
	private String image;
	private String description;
		
}
 
