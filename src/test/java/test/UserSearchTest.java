package test;

import model.User;
import org.testng.annotations.Test;
import pages.CloudGooglePage;
import service.UserCreator;

public class UserSearchTest extends CommonConditions {

    @Test
    public void userSearch() {
        User testUser = UserCreator.withCredentialsFromProperty();
       new CloudGooglePage(driver)
                .openPage()
                .typeInSearch(testUser);
             //   .getFirstResult();

    }
}
