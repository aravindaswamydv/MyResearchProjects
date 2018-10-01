package managers;

import org.openqa.selenium.WebDriver;

import pageObjects.DashboardPage;
import pageObjects.LoginPage;

public class PageObjectManager {

	private WebDriver driver;
	private LoginPage loginPage;
	private DashboardPage dashboardPage;

	public PageObjectManager(WebDriver driver) {

		this.driver = driver;

	}

	public LoginPage getLoginPage() {

		return (loginPage == null) ? loginPage = new LoginPage(driver) : loginPage;

	}

	public DashboardPage getDashboardPage() {

		return (dashboardPage == null) ? dashboardPage = new DashboardPage(driver) : dashboardPage;

	}
}