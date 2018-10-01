package stepDefinitions;

import cucumber.TestContext;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.LoginPage;

public class LoginPageSteps {
	
	TestContext testContext;
	LoginPage loginPage;
	
	public LoginPageSteps(TestContext context){
		testContext=context;
		loginPage=testContext.getPageObjectManager().getLoginPage();
		
	}
	
	@Given("^user is on the login page$")
	public void user_is_on_the_login_page(){
		loginPage.navigateTo_LoginPage();
	}

	@When("^he enters username and password$")
	public void he_enters_username_and_password() throws Exception {
		loginPage.login();
		//loginPage.enter_Username();
		///loginPage.enter_Password();
		//loginPage.click_Login();
		
	}


}
