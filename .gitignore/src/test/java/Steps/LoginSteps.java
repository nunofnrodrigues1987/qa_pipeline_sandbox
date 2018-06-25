package Steps;

import Base.BaseUtil;
import Transformations.EmailTransform;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.Transform;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.apache.http.util.Asserts;
import org.junit.Assert;
import org.openqa.selenium.By;
import pages.LoginPage;

import java.util.ArrayList;
import java.util.List;

public class LoginSteps extends BaseUtil {

    private BaseUtil base;

    public LoginSteps(BaseUtil base) {
        this.base = base;
    }

    @Given("^I navigate to the login page$")
    public void iNavigateToTheLoginPage() throws Throwable {
        // Write code here that turns the phrase above into concrete actions

        System.out.println("I navigate to the login page");

        base.driver.navigate().to("http://executeautomation.com/demosite/Login.html");

        //throw new PendingException();
    }

    @And("^I enter the username as \"([^\"]*)\" and password as \"([^\"]*)\"$")
    public void iEnterTheUsernameAsAndPasswordAs(String username, String password) throws Throwable {

        System.out.println("Username = " + username + " and Password = " + password);
    }


    @And("^I click login button$")
    public void iClickLoginButton() throws Throwable {
        // Write code here that turns the phrase above into concrete actions

        //base.driver.findElement(By.name("Login")).submit();

        LoginPage page = new LoginPage(base.driver);

        page.ClickLogin();
    }

    @Then("^I should see the user form page$")
    public void iShouldSeeTheUserFormPage() throws Throwable {
        // Write code here that turns the phrase above into concrete actions

        System.out.print("CHEGOU");

        //Assert.assertEquals("Error message",base.driver.findElement(By.name("Initial")).isDisplayed(),true);

    }


    @And("^I enter the following details for login$")
    public void iEnterTheFollowingDetailsForLogin(DataTable table) throws Throwable {

        /*List<List<String>> data = table.raw();

        System.out.println("The value is: " + data.get(0).get(0));
        System.out.println("The value is: " + data.get(0).get(1)); */

        //Create an ArrayList
        List<User> users = new ArrayList<User>();
        //Store all the users
        users = table.asList(User.class);

        /*for (User user: users) {
            System.out.println("The UserName is: " + user.username);
            System.out.println("The Password is: " + user.password);
        }*/

        /*for (User user: users) {

            base.driver.findElement(By.name("UserName")).sendKeys(user.username);
            base.driver.findElement(By.name("Password")).sendKeys(user.password);
        }*/

        LoginPage page = new LoginPage(base.driver);

        for (User user: users) {

            page.Login(user.username,user.password);
        }
    }

    @And("^I enter the ([^\"]*) and ([^\"]*)$")
    public void iEnterTheUsenameAndPassword(String userName, String password) throws Throwable {

        System.out.println("Username is " + userName);
        System.out.println("Password is " + password);

    }

    @And("^I enter the users email address as Email:([^\"]*)$")
    public void iEnterTheUsersEmailAddressAsEmailAdmin(@Transform(EmailTransform.class) String email) throws Throwable {

        System.out.println("The email address is " + email);
    }

    //Nested class
    public class User {

        public String username;
        public String password;

        public User(String userName, String passWord) {
            username = userName;
            password = passWord;
        }
    }
}
