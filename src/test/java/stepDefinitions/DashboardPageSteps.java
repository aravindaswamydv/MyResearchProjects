package stepDefinitions;

import java.io.IOException;

import cucumber.TestContext;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.DashboardPage;
import pageObjects.LoginPage;

public class DashboardPageSteps {

	TestContext testContext;
	LoginPage loginPage;
	DashboardPage dashboardPage;

	public DashboardPageSteps(TestContext context) {
		testContext = context;
		dashboardPage = testContext.getPageObjectManager().getDashboardPage();

	}

	@Then("^Dashboard page displays$")
	public void dashboard_page_displays() throws Throwable {
		if (!dashboardPage.isBuildingListPresent()) {

		}

	}

	@When("^user select \"([^\"]*)\" from Properties list$")
	public void user_select_from_Properties_list(String arg1) throws Throwable {
		String bldngName = arg1;
		dashboardPage.click_AllProperties();
		dashboardPage.select_Building(bldngName);
	}

	
	@Then("^The occupancy value for selected building shows \"([^\"]*)\"$")
	public void the_occupancy_value_for_selected_building_shows(String arg1) throws Throwable {
		String occupancyValue = arg1;
		dashboardPage.verify_OccupancyValue(occupancyValue);
		dashboardPage.uploadDoc();
	}
	
	@Given("^user navigates to Document Library$")
	public void user_navigates_to_Document_Library() throws Throwable  {
	   		
		dashboardPage.navigateToDocumentLibrary();
	    
	}

	@When("^user click on Add New Document button$")
	public void user_click_on_Add_New_Document_button()  {
	    // Write code here that turns the phrase above into concrete actions
		dashboardPage.click_AddNewDocumentButton();
	   
	}

	@Then("^Add New Document Page opens$")
	public void add_New_Document_Page_opens()  {
	    // Write code here that turns the phrase above into concrete actions
	   
	}

	@When("^user click on Browse button$")
	public void user_click_on_Browse_button()  {
		dashboardPage.click_BrowseButton();
	   
	}

	@Then("^upload file window opens$")
	public void upload_file_window_opens()  {
	    // Write code here that turns the phrase above into concrete actions
	    
	}
	
	@When("^user provide the file path to upload and hit Enter key$")
	public void user_provide_the_file_path_to_upload_and_hit_Enter_key() throws Throwable {
		dashboardPage.uploadDoc();
	    
	}

	@Then("^provided file name displayed next to Browse button$")
	public void provided_file_name_displayed_next_to_Browse_button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		dashboardPage.clickbutton();
	    
	}
	
	   @When("^user enter \"([^\"]*)\" in property name Search column$")
	    public void user_enter_something_in_property_name_search_column(String propertyname) throws Throwable {
		   String propName = propertyname;
			dashboardPage.filterTableBy(" Property Name ",propName);
	    }

	    @Then("^resultatant property record display in the table$")
	    public void resultatant_property_record_display_in_the_table() throws Throwable {
	        
	    }

}
