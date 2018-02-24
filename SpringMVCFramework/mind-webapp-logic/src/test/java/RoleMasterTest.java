import static org.junit.Assert.fail;

import java.util.List;
import java.util.Random;

import javax.annotation.Resource;

import org.junit.BeforeClass;
import org.junit.Test;

import com.mind.webapp.commom.dto.RoleDTO;
import com.mind.webapp.logic.RoleLogic;


public class RoleMasterTest extends AbstractTest {

	@Resource
	private RoleLogic roleLogic;
	private static RoleDTO roleDto;
	
	private static String roleNameForCreate;
	private static String roleNameForUpdate;

	@BeforeClass
	public static void roleSetUp() {
		roleNameForCreate = "Junit";
		roleNameForUpdate = "Junit_1";
		roleDto = new RoleDTO(null, roleNameForCreate, "Test","172.29.36.39", 1, 10, null, null, null, null);
	}

	@Test
	public void testCompanyCreate(){
		boolean isRoleSuccessfullyCreated = false;
		roleLogic.save(roleDto);
		List<RoleDTO> roleList = roleLogic.getList();
		if(roleList != null && !roleList.isEmpty()){
			for(RoleDTO dto : roleList){
				if(roleNameForCreate.equals(dto.getRoleName())){
					isRoleSuccessfullyCreated = true;
					break;
				}
			}
		}
		if(!isRoleSuccessfullyCreated){
			fail("Role is not created");
		}
	}

	@Test
	public void testCompanyUpdate(){
		boolean isRoleSuccessfullyUpdated = false;
		List<RoleDTO> roleList = roleLogic.getList();
		if(roleList != null && !roleList.isEmpty()){
			for(RoleDTO dto : roleList)
				if(dto.getRoleName().equals(roleNameForCreate))
					roleDto = dto;
		}
		roleDto.setRoleName(roleNameForUpdate);
		roleLogic.update(roleDto);
		List<RoleDTO> updatedRoleList = roleLogic.getList();
		if(updatedRoleList != null && !updatedRoleList.isEmpty()){
			for(RoleDTO dto : updatedRoleList){
				if(roleNameForUpdate.equals(dto.getRoleName())){
					isRoleSuccessfullyUpdated = true;
				}
			}
		}
		if(!isRoleSuccessfullyUpdated){
			fail("Company is not updated");
		}
	}

	@Test
	public void testCompanyList(){
		List<RoleDTO> roleList = roleLogic.getList();
		if(roleList == null || roleList.isEmpty()){
			fail("No Company is Exist in DB");
		}
		for(RoleDTO dto : roleList)
			if(dto.getRoleName().equals(roleNameForUpdate))
				roleDto = dto;

		if(roleDto == null)
			fail("Not fetching all records");
	}
	
	@Test
	public void testGetById(){
		List<RoleDTO> roleList = roleLogic.getList();
		final Integer roleId = roleList.get(getRandomNumber(roleList.size())).getRoleId();
		RoleDTO role = roleLogic.getDetailById(roleId);
		if(role == null)
			fail("Company is not found against Company Id..");
	}

	@Test
	public void testCompanyDelete(){
		boolean isRoleSuccessfullyDeleted = true;
		List<RoleDTO> roleList = roleLogic.getList();
		final Integer roleId = roleList.get(getRandomNumber(roleList.size())).getRoleId();
		roleLogic.delete(roleId);
		List<RoleDTO> updatedRoleList = roleLogic.getList();
		if(updatedRoleList != null && !updatedRoleList.isEmpty()){
			for(RoleDTO dto : updatedRoleList){
				if(roleId.equals(dto.getRoleId()) && dto.getStatus() != 30){
					isRoleSuccessfullyDeleted = false;
					break;
				}
			}
		}
		if(!isRoleSuccessfullyDeleted){
			fail("Company is not deleted");
		}
	}
	
	private static int getRandomNumber(int range){
		return new Random().nextInt(range);
	}
}
