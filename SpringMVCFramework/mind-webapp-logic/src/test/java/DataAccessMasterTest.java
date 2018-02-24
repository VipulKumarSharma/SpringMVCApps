import static org.junit.Assert.fail;

import java.util.List;
import java.util.Random;

import javax.annotation.Resource;

import org.junit.BeforeClass;
import org.junit.Test;

import com.mind.webapp.commom.dto.DataAccessDTO;
import com.mind.webapp.logic.DataAccessLogic;


public class DataAccessMasterTest extends AbstractTest {

	@Resource
	private DataAccessLogic dataAccessLogic;
	private static DataAccessDTO dataAccessDto;
	
	private static String dataAccessNameForCreate;
	private static String dataAccessNameForUpdate;

	@BeforeClass
	public static void roleSetUp() {
		dataAccessNameForCreate = "Junit*&%-$8";
		dataAccessNameForUpdate = "Junit*&%-$8_1";
		dataAccessDto = new DataAccessDTO(null, dataAccessNameForCreate, "Test","172.29.36.39", 10, null, null, null, null);
	}

	@Test
	public void testCompanyCreate(){
		boolean isDASuccessfullyCreated = false;
		dataAccessLogic.save(dataAccessDto);
		List<DataAccessDTO> daList = dataAccessLogic.getList();
		if(daList != null && !daList.isEmpty()){
			for(DataAccessDTO dto : daList){
				if(dataAccessNameForCreate.equals(dto.getDataAccessName())){
					isDASuccessfullyCreated = true;
					break;
				}
			}
		}
		if(!isDASuccessfullyCreated){
			fail("Data Access is not created");
		}
	}

	@Test
	public void testCompanyUpdate(){
		boolean isDASuccessfullyUpdated = false;
		List<DataAccessDTO> daList = dataAccessLogic.getList();
		if(daList != null && !daList.isEmpty()){
			for(DataAccessDTO dto : daList)
				if(dto.getDataAccessName().equals(dataAccessNameForCreate))
					dataAccessDto = dto;
		}
		dataAccessDto.setDataAccessName(dataAccessNameForUpdate);
		dataAccessLogic.update(dataAccessDto);
		List<DataAccessDTO> updatedDAList = dataAccessLogic.getList();
		if(updatedDAList != null && !updatedDAList.isEmpty()){
			for(DataAccessDTO dto : updatedDAList){
				if(dataAccessNameForUpdate.equals(dto.getDataAccessName())){
					isDASuccessfullyUpdated = true;
				}
			}
		}
		if(!isDASuccessfullyUpdated){
			fail("Data Access is not updated");
		}
	}

	@Test
	public void testCompanyList(){
		List<DataAccessDTO> daList = dataAccessLogic.getList();
		if(daList == null || daList.isEmpty()){
			fail("No Data Access is Exist in DB");
		}
		for(DataAccessDTO dto : daList)
			if(dto.getDataAccessName().equals(dataAccessNameForUpdate))
				dataAccessDto = dto;

		if(dataAccessDto == null)
			fail("Not fetching all records");
	}
	
	@Test
	public void testGetById(){
		List<DataAccessDTO> daList = dataAccessLogic.getList();
		final Integer daId = daList.get(getRandomNumber(daList.size())).getDataAccessId();
		DataAccessDTO dto = dataAccessLogic.getDetailById(daId);
		if(dto == null)
			fail("Data Access is not found against DA Id..");
	}

	@Test
	public void testCompanyDelete(){
		boolean isDASuccessfullyDeleted = true;
		List<DataAccessDTO> daList = dataAccessLogic.getList();
		final Integer daId = daList.get(getRandomNumber(daList.size())).getDataAccessId();
		dataAccessLogic.delete(daId);
		List<DataAccessDTO> updatedDAList = dataAccessLogic.getList();
		if(updatedDAList != null && !updatedDAList.isEmpty()){
			for(DataAccessDTO dto : updatedDAList){
				if(daId.equals(dto.getDataAccessId()) && dto.getStatus() != 30){
					isDASuccessfullyDeleted = false;
					break;
				}
			}
		}
		if(!isDASuccessfullyDeleted){
			fail("Data Access is not deleted");
		}
	}
	
	private static int getRandomNumber(int range){
		return new Random().nextInt(range);
	}
}
