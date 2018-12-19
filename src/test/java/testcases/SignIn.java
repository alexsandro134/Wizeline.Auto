package testcases;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import actions.GalenHomePage;
import actions.MyNotesPage;
import io.github.bonigarcia.wdm.ChromeDriverManager;

public class SignIn {
	WebDriver driver;

	String galenSite = "http://testapp.galenframework.com/";
	String loginToInputXpath = "//button[text()='Login']";
	String usrInputXpath = "//input[@name='login.username']";
	String pwdInputXpath = "//input[@name='login.password']";
	String myNotesXpath = "//h2[text()='My Notes']";
	String titleXpath = "//input[@name='note.title']";
	String desXpath = "//textarea[@name='note.description']";
	String addNoteBtnXpath = "//button";
	String createNoteBtnXpath = "//button[text()='Add Note']";

	private String username = "testuser@example.com";
	private String password = "test123";
	private String titleRandom = "Title automation " + randomGenerate();
	private String descRandom = "Desc automation " + randomGenerate();

	String titleNoteXpath = "//a/h4[text()='%s']";
	String descNoteXpath = "//a/p[text()='%s']";;

	private GalenHomePage homePage;
	private MyNotesPage myNotesPage;

	@BeforeClass
	public void beforeTest() {
		ChromeDriverManager.getInstance().setup();
		driver = new ChromeDriver();
		driver.get(galenSite);
		driver.manage().window().maximize();
	}

	@Test
	public void TC_01_signInSuccessfully() {
		homePage = new GalenHomePage(driver);
		homePage.clickLoginBtn(loginToInputXpath);
		homePage.inputTextToInput(usrInputXpath, username);
		homePage.inputTextToInput(pwdInputXpath, password);
		homePage.clickLoginBtn(loginToInputXpath);

		myNotesPage = new MyNotesPage(driver);
		myNotesPage.verifyLoginSuccessful(myNotesXpath);
	}

	@Test
	public void TC_02_createNewNote() {
		myNotesPage.clickToAddNewNotes(addNoteBtnXpath);
		myNotesPage.inputTextToNewNote(titleXpath, titleRandom);
		myNotesPage.inputTextToNewNote(desXpath, descRandom);
		myNotesPage.clickToAddNewNotes(createNoteBtnXpath);
		myNotesPage.verifyNewNoteWasCreated(String.format(titleNoteXpath, titleRandom), String.format(descNoteXpath, descRandom));
	}

	@AfterClass
	public void afterTest() {
		driver.quit();
	}

	public int randomGenerate() {
		Random rand = new Random();
		return rand.nextInt(99999);
	}
}
