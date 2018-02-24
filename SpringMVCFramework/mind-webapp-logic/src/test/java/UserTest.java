import javax.annotation.Resource;

import org.junit.Test;

import com.mind.webapp.commom.dto.UserDTO;
import com.mind.webapp.dao.bean.User;
import com.mind.webapp.logic.UserLogic;


public class UserTest extends AbstractTest {

	@Resource
	private  UserLogic userLogic;
	private  User user;
	
	public UserTest() {
		user = new User(0, "Mind#1456", "sam_Mind", "Mind#1234", "Sandeep", "Malik",
				"sandeep.malik@mind-infotech.com", "sandeepmalik", "172.29.36.39");
	}

	@Test
	public void testUserCreation() {
		System.out.println(this.user);
		UserDTO userDTO = userLogic.getDetaiByUserName("admin");
		System.out.println(userDTO.getPassword());
		assert(userDTO != null );
	}
	
	/*@Test
	public void testUserUpdation(){
		user.setLastName("malik12");
		userDao.update(user);
		assertEquals(userDao.getById(user.getId()).getLastName(),"malik12");
	}*/

}
