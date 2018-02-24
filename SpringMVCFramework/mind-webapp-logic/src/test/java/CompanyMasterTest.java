

import static org.junit.Assert.fail;

import java.util.List;
import java.util.Random;

import javax.annotation.Resource;

import org.junit.BeforeClass;
import org.junit.Test;

import com.mind.webapp.commom.dto.CompanyDTO;
import com.mind.webapp.logic.CompanyLogic;

public class CompanyMasterTest extends AbstractTest{

	@Resource
	private CompanyLogic companyLogic;
	private static CompanyDTO companyDto;
	
	private static String companyNameForCreate;
	private static String companyNameForUpdate;

	@BeforeClass
	public static void companySetUp() {
		companyNameForCreate = "Junit*&%-$8";
		companyNameForUpdate = "Junit*&%-$8_1";
		companyDto = new CompanyDTO(null,companyNameForCreate,"This Company is create to test functionality",
				"172.29.36.39",null,null,null,null);
	}

	@Test
	public void testCompanyCreate(){
		boolean isCompanySuccessfullyCreated = false;
		companyLogic.save(companyDto);
		List<CompanyDTO> companyList = companyLogic.getList();
		if(companyList != null && !companyList.isEmpty()){
			for(CompanyDTO dto : companyList){
				if(companyNameForCreate.equals(dto.getCompanyName())){
					isCompanySuccessfullyCreated = true;
					break;
				}
			}
		}
		if(!isCompanySuccessfullyCreated){
			fail("Company is not created");
		}
	}

	@Test
	public void testCompanyUpdate(){
		boolean isCompanySuccessfullyUpdated = false;
		List<CompanyDTO> companyList = companyLogic.getList();
		if(companyList != null && !companyList.isEmpty()){
			for(CompanyDTO dto : companyList)
				if(dto.getCompanyName().equals(companyNameForCreate))
					companyDto = dto;
		}
		companyDto.setCompanyName(companyNameForUpdate);
		companyLogic.update(companyDto);
		List<CompanyDTO> updatedCompanyList = companyLogic.getList();
		if(updatedCompanyList != null && !updatedCompanyList.isEmpty()){
			for(CompanyDTO dto : updatedCompanyList){
				if(companyNameForUpdate.equals(dto.getCompanyName())){
					isCompanySuccessfullyUpdated = true;
				}
			}
		}
		if(!isCompanySuccessfullyUpdated){
			fail("Company is not updated");
		}
	}

	@Test
	public void testCompanyList(){
		List<CompanyDTO> companyList = companyLogic.getList();
		if(companyList == null || companyList.isEmpty()){
			fail("No Company is Exist in DB");
		}
		for(CompanyDTO dto : companyList)
			if(dto.getCompanyName().equals(companyNameForUpdate))
				companyDto = dto;

		if(companyDto == null)
			fail("Not fetching all records");
	}
	
	@Test
	public void testGetById(){
		List<CompanyDTO> companyList = companyLogic.getList();
		final Integer companyId = companyList.get(getRandomNumber(companyList.size())).getCompanyId();
		CompanyDTO company = companyLogic.getDetailById(companyId);
		if(company == null)
			fail("Company is not found against Company Id..");
	}

	@Test
	public void testCompanyDelete(){
		boolean isCompanySuccessfullyDeleted = true;
		List<CompanyDTO> companyList = companyLogic.getList();
		final Integer companyId = companyList.get(getRandomNumber(companyList.size())).getCompanyId();
		companyLogic.delete(companyId);
		List<CompanyDTO> updatedCompanyList = companyLogic.getList();
		if(updatedCompanyList != null && !updatedCompanyList.isEmpty()){
			for(CompanyDTO dto : updatedCompanyList){
				if(companyId.equals(dto.getCompanyId()) && dto.getStatus() != 30){
					isCompanySuccessfullyDeleted = false;
					break;
				}
			}
		}
		if(!isCompanySuccessfullyDeleted){
			fail("Company is not deleted");
		}
	}
	
	private static int getRandomNumber(int range){
		return new Random().nextInt(range);
	}
}
