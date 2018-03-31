package FunctionalTest;


import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CoreTestScript {

//	public static void main(String km[]) {
	
		private WebDriver driver;
		  
		  @Test(priority = 1)
		  public void verifyPageTitle() {
			 // System.out.println("1st test case");
			  driver.get("https://test.recruitcrm.io/");
			  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  String title = driver.getTitle();
			  System.out.println("Test Case 1 to get Page Title : " +title);
			  AssertJUnit.assertTrue(title.contains("R-CRM - LLogin to RecruitCRM"));
			 // Assert.assertTrue(title.contains("R-CRM - Sign Up on RecruitCRM"));
			 
		  }


		  
		 // @Test(enabled = true)
		  @Test(priority = 2)
		  public void userLogIn() throws InterruptedException {
			
			  driver.navigate().to("https://test.recruitcrm.io/");
			//  WebDriverWait wait = new WebDriverWait(driver, 10);
			  System.out.println("2nd test case");

				 WebDriverWait wait = new WebDriverWait(driver, 10);

			  wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("loginbtn")));

			  driver.findElement(By.id("loginbtn")).click();
			 try {
				 
			  wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[3]/form/fieldset/div/div[1]/ul/li[1]/div/input")));
				  driver.findElement(By.xpath("//div[3]/form/fieldset/div/div[1]/ul/li[1]/div/input")).sendKeys("rcrmtest3@gmail.com");
			//	  driver.findElement(By.cssSelector("input#session_key-login")).sendKeys("ykrishna019@gmail.com");
					driver.findElement(By.cssSelector("input#session_password-login")).sendKeys("km123456");
					driver.findElement(By.cssSelector("input.btn-signin")).click();
					Thread.sleep(3000);
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
				driver.findElement(By.cssSelector(".btn.btn-primary"));
				System.out.println("Login Success !!");
		 }
			catch(Exception e) { 
				System.out.println("Please enter valid credentioals");
				
			}  
		  }  
		  
		  @Test (priority =3)
		  
		  public void accountDeactivate() throws InterruptedException {
			  
			  driver.findElement(By.cssSelector("i.icon.icon-navbar-application-settings.navbar-primary-item-icon")).click();
			 // driver.findElement(By.cssSelector("i.icon.icon-list-user[p='Account']")).click();
			  driver.findElement(By.xpath("//main/div[2]/div/div/div/div/div/ul/li[2]/a")).click();
			  driver.findElement(By.cssSelector("button#accountdelet.btn.btn-primary.ajax-link")).click();
			  
			  driver.switchTo().activeElement();

			  Thread.sleep(3000);
			  WebDriverWait wait = new WebDriverWait(driver, 20);
			 // driver.findElement(By.cssSelector("button.btn.btn-primary.ladda-button")).click();
			 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[6]/div/div/div[3]/button[1]")));
			  driver.findElement(By.xpath("//div[6]/div/div/div[3]/button[1]")).click();
			//Thread.sleep(3000);
		  }
	
		  
		  
		  @Test (priority = 4)
		  
		  public void createNewAccount() {

				 WebDriverWait wait = new WebDriverWait(driver, 30);

			  wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("loginbtn")));
			  
			  driver.findElement(By.id("loginbtn")).click();
			  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				 
		/*			
			  wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[3]/form/fieldset/div/div[1]/ul/li[1]/div/input")));
			  driver.findElement(By.xpath("//div[3]/form/fieldset/div/div[1]/ul/li[1]/div/input")).sendKeys("rcrmtest3@gmail.com");
		//	  driver.findElement(By.cssSelector("input#session_key-login")).sendKeys("ykrishna019@gmail.com");
				driver.findElement(By.cssSelector("input#session_password-login")).sendKeys("km123456");
				driver.findElement(By.cssSelector("input.btn-signin")).click();
				// Thread.sleep(3000);
				 * 
				 * 
				 */
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
						//driver.navigate().refresh();
					//	String title = driver.getTitle();
					//	System.out.println(title);
						driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
						
						try {
							
						wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("input[placeholder='Enter company Name']")));
						driver.findElement(By.cssSelector("input[placeholder='Enter company Name']")).sendKeys("R-CRM Test");
						driver.findElement(By.cssSelector("button.ladda-button.btn-rounded.btn.btn-success.waves-effect.waves-light")).click();
						
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					
					driver.findElement(By.cssSelector(".btn.btn-primary"));
					System.out.println("Login Success !!");
			 }
				catch(Exception e) { 
					System.out.println("New Account/Login SignUp has been failed ! Check your test case");
					
				}  
			  }  

			@Test (priority = 5)
			public void addNewCandidate() {
				
				  driver.findElement(By.linkText("Add Candidate")).click();

					 WebDriverWait wait = new WebDriverWait(driver, 10);

				  // Add Candidate form
				    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='tblcandidate_firstname']")));
				   driver.findElement(By.xpath("//input[@id='tblcandidate_firstname']")).sendKeys("Vinesh");
//				    Thread.sleep(3000);
				   wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='tblcandidate_lastname']")));
				   driver.findElement(By.xpath("//input[@id='tblcandidate_lastname']")).sendKeys("Ahuja");    
				  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='tblcandidate_emailid']")));
				   driver.findElement(By.xpath("//input[@id='tblcandidate_emailid']")).sendKeys("km15344@gmail.com");
				   
				   wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='tblcandidate_contactnumber']")));
				   driver.findElement(By.xpath("//input[@id='tblcandidate_contactnumber']")).sendKeys("9628512890");

				   driver.findElement(By.xpath("//input[@id='tblcandidate_contactnumber']")).sendKeys(Keys.ENTER);
				   driver.navigate().refresh();
			  }
			  
			@Test (priority = 6)
				
				public void addNewCompany() {
				
				WebDriverWait wait = new WebDriverWait (driver, 20);
			  driver.findElement(By.cssSelector("i.icon.icon-navbar-accounts.navbar-primary-item-icon[data-original-title='Companies']")).click();
// driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@data-title='Add Company']"))));
driver.findElement(By.xpath("//*[@data-title='Add Company']")).click();
// wait.until(ExpectedCondition)

wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("input#tblcompany_companyname")));
driver.findElement(By.cssSelector("input#tblcompany_companyname")).sendKeys("NIIT");
driver.findElement(By.xpath("//div[6]/div/div/div[1]/form/b/div[2]/div/input")).sendKeys("Pune");
                      
driver.findElement(By.xpath("//div[6]/div/div/div[1]/form/b/div[3]/div/input")).sendKeys("www.recruitcrm.io");
driver.findElement(By.xpath("//div[6]/div/div/div[1]/form/b/div[4]/div/textarea")).sendKeys("102 Siddh Icon, Baner, Pune (MH)");
driver.findElement(By.xpath("//div[6]/div/div/div[1]/form/b/div[5]/div/div/button")).click();

driver.findElement(By.xpath("//div[6]/div/div/div[1]/form/b/div[5]/div/div/div/ul/li[2]/a")).click();

//Contact at Company
driver.findElement(By.xpath("//div[6]/div/div/div[1]/form/b/b/div[1]/div/input")).sendKeys("QA Engineer");

JavascriptExecutor js = (JavascriptExecutor) driver;
// Find element by xpath
WebElement element = driver.findElement(By.xpath("//div[6]/div/div/div[1]/form/b/b/div[10]/div/div/input"));
//This will scroll the page till the element is found

js.executeScript("arguments[0].scrollIntoView();", element);


//Contact Stage
driver.findElement(By.xpath("//div[6]/div/div/div[1]/form/b/b/div[2]/div/div/button")).click();
driver.findElement(By.xpath("//div[6]/div/div/div[1]/form/b/b/div[2]/div/div/div/ul/li[2]/a")).click();

driver.findElement(By.xpath("//div[6]/div/div/div[1]/form/b/b/div[3]/div/input")).sendKeys("Krishnmohan");
driver.findElement(By.xpath("//div[6]/div/div/div[1]/form/b/b/div[4]/div/input")).sendKeys("Yadav");
driver.findElement(By.xpath("//div[6]/div/div/div[1]/form/b/b/div[5]/div/input")).sendKeys("km@recruitcrm.io");
driver.findElement(By.xpath("//div[6]/div/div/div[1]/form/b/b/div[6]/div/input")).sendKeys("+91 9628512890");
driver.findElement(By.xpath("//div[6]/div/div/div[1]/form/b/b/div[7]/div/input")).sendKeys("Gorakhpur");

driver.findElement(By.xpath("//div[6]/div/div/div[3]/button[1]")).click();
					
driver.navigate().refresh();
				}
			
			@Test (priority = 7)
			
			public void addNewContact() {
				WebDriverWait wait = new WebDriverWait (driver, 20);
				// .icon.icon-hex-user.navbar-primary-item-icon
				wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("i[data-original-title='Contacts']"))));
				driver.findElement(By.cssSelector("i[data-original-title='Contacts']")).click();
				
				// driver.findElement(By.xpath("html/body/nav[2]/ul[1]/li[4]/a/i")).click();
				driver.findElement(By.linkText("Add Contact")).click();
				
				try{
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[6]/div/div/div[1]/form/div[1]/div[1]/div/button"))));
					driver.findElement(By.xpath("//div[6]/div/div/div[1]/form/div[1]/div[1]/div/button")).click();
					driver.findElement(By.xpath("//div[6]/div/div/div[1]/form/div[1]/div[1]/div/div/ul/li/a")).click();
					}catch(Exception e){
						System.out.println("Company doesn't selectd");
					}
					wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("input#tblcontact_firstname"))));
					driver.findElement(By.cssSelector("input#tblcontact_firstname")).sendKeys("Krishnmohan");
					driver.findElement(By.cssSelector("input#tblcontact_lastname")).sendKeys("Yadav");
					driver.findElement(By.cssSelector("input#tblcontact_email")).sendKeys("er.km15344@gmail.com");
					driver.findElement(By.cssSelector("input#tblcontact_contactnumber")).sendKeys("8806984490");
					driver.findElement(By.cssSelector("button[form=form_create_contact]")).click();
					
					driver.navigate().refresh();
			}
			
			@Test (priority = 8)
			
			public void addNewJob() {
				
				// System.out.println("'Add New Job' Test script under construction");
				WebDriverWait wait = new WebDriverWait(driver, 20);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("i[data-original-title='Jobs']")));
				driver.findElement(By.cssSelector("i[data-original-title='Jobs']")).click();
				
				driver.findElement(By.linkText("Add Job")).click();
				driver.findElement(By.xpath("//form/div[2]/div[1]/div/button")).click();
				driver.findElement(By.xpath("//form/div[2]/div[1]/div/div/ul/li[2]/a")).click();
				
				driver.findElement(By.xpath("//form/div[3]/div[1]/div/button")).click();
				driver.findElement(By.xpath("//form/div[3]/div[1]/div/div/ul/li[2]/a")).click();
				
				driver.findElement(By.xpath("//form/div[5]/div/input")).sendKeys("SQA");
				driver.findElement(By.xpath("//form/div[6]/div/textarea")).sendKeys("A candidate have good knowledge of Selenium & Java");
				driver.findElement(By.xpath("//form/div[7]/div/div/button")).click();
				driver.findElement(By.xpath("//form/div[7]/div/div/div/ul/li[5]/a")).click();
				driver.findElement(By.xpath("//form/div[8]/div/input")).sendKeys("Selenium");
				driver.findElement(By.xpath("//form/div[9]/div/input")).sendKeys("3");
				
				WebElement scroll = driver.findElement(By.xpath("//form/div[18]/div/label/span"));
				
				JavascriptExecutor js1 = (JavascriptExecutor) driver;
				js1.executeAsyncScript("arguments[0].scrollIntoView();", scroll);
				
				
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//form/div[9]/div/input")));
				driver.findElement(By.xpath("//form/div[9]/div/input")).sendKeys("400000");
				driver.findElement(By.xpath("//form/div[12]/div/input")).sendKeys("600000");
				driver.findElement(By.xpath("//form/div[13]/div/input")).sendKeys("Gorakhpur");
				driver.findElement(By.xpath("//form/div[14]/div/input")).sendKeys("Taramandal");
				driver.findElement(By.xpath("//form/div[15]/div/input")).sendKeys("5");
			 
				// Checkbox
				WebElement km = driver.findElement(By.xpath("//form/div[17]/div/label/span"));
				km.click();
				
				System.out.println("The output is selected" + km.isSelected());

				System.out.println("The output is enabled" + km.isEnabled());

				System.out.println("The output is displayed" + km.isDisplayed());
				
				// Checkbox 2
				wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//form/div[18]/div/label/span")));
				WebElement k = driver.findElement(By.xpath("//form/div[18]/div/label/span"));
				k.click();
				System.out.println("The output is selected" + km.isSelected());

				System.out.println("The output is enabled" + km.isEnabled());

				System.out.println("The output is displayed" + km.isDisplayed());
				
			driver.findElement(By.xpath("//div[6]/div/div/div[3]/button[1]")).click();
			}
		
				  @BeforeTest
		  public void beforeTest() {
			//  final FirefoxProfile firefoxProfile = new FirefoxProfile();
			  //  firefoxProfile.setPreference("xpinstall.signatures.required", false);
			 // capabilities.setCapability("marionette", true);

			//  driver = new FirefoxDriver();
					  System.setProperty("webdriver.chrome.driver", "/home/earnest/Downloads/chromedriver");
				 ChromeOptions option = new ChromeOptions();
				 option.addArguments("disable-infobars");
				 option.addArguments("--start-maximized");
				 driver = new ChromeDriver(option);
			//	 WebDriverWait wait = new WebDriverWait(driver, 10);
				 
		  }
		  
				  

		  @AfterTest
		  public void afterTest() {
			//  driver.quit();
		
	}
	
}
