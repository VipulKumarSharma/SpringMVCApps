import static org.junit.Assert.fail;

import java.util.List;
import java.util.Random;

import javax.annotation.Resource;

import org.junit.BeforeClass;
import org.junit.Test;

import com.mind.webapp.commom.dto.CompanyDTO;
import com.mind.webapp.commom.dto.SiteDTO;
import com.mind.webapp.logic.SiteLogic;

public class SiteMasterTest extends AbstractTest {
	

	@Resource
	private SiteLogic siteLogic;
	private static SiteDTO siteDto;
	
	private static String siteNameForCreate;
	private static String siteNameForUpdate;
	
	@BeforeClass
	public static void companySetUp() {
		siteNameForCreate = "Junit*&85";
		siteNameForUpdate = "Junit*&85_1";
		siteDto = new SiteDTO(null,siteNameForCreate,"This Company is create to test functionality","172.29.36.39",
				5,null,null,null,null);
	}
	
	@Test
	public void testSiteCreate(){
		boolean isSiteSuccessfullyCreated = false;
		siteLogic.save(siteDto);
		List<SiteDTO> siteList = siteLogic.getList();
		if(siteList != null && !siteList.isEmpty()){
			for(SiteDTO dto : siteList){
				if(siteNameForCreate.equals(dto.getSiteName())){
					isSiteSuccessfullyCreated = true;
					break;
				}
			}
		}
		if(!isSiteSuccessfullyCreated){
			fail("Site is not created");
		}
	}

	@Test
	public void testSiteUpdate(){
		boolean isSiteSuccessfullyUpdated = false;
		List<SiteDTO> siteList = siteLogic.getList();
		if(siteList != null && !siteList.isEmpty()){
			for(SiteDTO dto : siteList)
				if(dto.getSiteName().equals(siteNameForCreate))
					siteDto = dto;
		}
		siteDto.setSiteName(siteNameForUpdate);
		siteLogic.update(siteDto);
		List<SiteDTO> updatedSiteList = siteLogic.getList();
		if(updatedSiteList != null && !updatedSiteList.isEmpty()){
			for(SiteDTO dto : updatedSiteList){
				if(siteNameForUpdate.equals(dto.getSiteName())){
					isSiteSuccessfullyUpdated = true;
					break;
				}
			}
		}
		if(!isSiteSuccessfullyUpdated){
			fail("Site is not updated");
		}
	}

	@Test
	public void testSiteList(){
		List<SiteDTO> siteList = siteLogic.getList();
		System.out.println("Site created in DB c: "+siteList.size());
		if(siteList == null || siteList.isEmpty()){
			fail("No Site is Exist in DB");
		}
	}
	
	@Test
	public void testGetById(){
		List<SiteDTO> siteList = siteLogic.getList();
		final Integer siteId = siteList.get(getRandomNumber(siteList.size())).getSiteId();
		SiteDTO site = siteLogic.getDetailById(siteId);
		if(site == null)
			fail("Site is not found against Site Id..");
	}

	@Test
	public void testSiteDelete(){
		boolean isSiteSuccessfullyDeleted = true;
		List<SiteDTO> siteList = siteLogic.getList();
		final Integer siteId = siteList.get(getRandomNumber(siteList.size())).getSiteId();
		siteLogic.delete(siteId);
		List<SiteDTO> updatedSiteList = siteLogic.getList();
		if(updatedSiteList != null && !updatedSiteList.isEmpty()){
			for(SiteDTO dto : updatedSiteList){
				if(siteId.equals(dto.getSiteId()) && dto.getStatus() != 30){
					isSiteSuccessfullyDeleted = false;
					break;
				}
			}
		}
		if(!isSiteSuccessfullyDeleted){
			fail("Site is not deleted");
		}
	}
	
	private static int getRandomNumber(int range){
		return new Random().nextInt(range);
	}
}
