package reactAppAutomation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class buggyCars {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		https://buggy.justtestit.org/
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Shima\\Documents\\chromedriver.exe");
	    WebDriver driver= new ChromeDriver();
	    driver.get("https://buggy.justtestit.org/");
	    System.out.println(driver.getCurrentUrl());
	    System.out.println(driver.getTitle());
	    driver.manage().window().maximize();
	    buggyCars obj=new buggyCars();
	    obj.register(driver);
	    //obj.invalidLogin(driver);
	    obj.login(driver);
	    obj.voteForCar(driver);
	    obj.editProfile(driver);
	    obj.quit(driver);
	    }
	@Test(priority=1)
	public void register(WebDriver driver) {
		driver.findElement(By.xpath("//*[@href='/register']")).click();
		System.out.println("Registration started");
		WebElement username= driver.findElement(By.xpath("//input[@id='username']"));
		username.click();
		username.sendKeys("testshima071@gmail.com");
		WebElement firstname= driver.findElement(By.xpath("//*[@id='firstName']"));
		firstname.click();
		firstname.sendKeys("Shima");
		WebElement lastName= driver.findElement(By.xpath("//*[@id='lastName']"));
		lastName.click();
		lastName.sendKeys("Kolladath");
		WebElement password=driver.findElement(By.xpath("//*[@id='password']"));
		password.click();
		password.sendKeys("Shima@123");
		WebElement confirmPassword=driver.findElement(By.xpath("//*[@id='confirmPassword']"));
		confirmPassword.click();
		confirmPassword.sendKeys("Shima@123");
		WebElement register= driver.findElement(By.xpath("//*[@class='btn btn-default']"));
		register.click();
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
       // WebElement resultMessage = driver.findElement(By.className("result"));
		
	}
	@Test(priority=2)
	public void invalidLogin(WebDriver driver) {
		WebElement loginID= driver.findElement(By.xpath("//*[@name='login']"));
		loginID.click();
		loginID.sendKeys("test@gmail.com");
		WebElement pswd= driver.findElement(By.xpath("/html[1]/body[1]/my-app[1]/header[1]/nav[1]/div[1]/my-login[1]/div[1]/form[1]/div[1]/input[2]"));		
		pswd.sendKeys("Shima@123");
		WebElement loginButton= driver.findElement(By.xpath("//*[@class='btn btn-success']"));
		loginButton.click();
		
		loginID.clear();
		pswd.clear();
		loginButton.clear();
		}
	
	@Test(priority=3)
	
	public void login(WebDriver driver) {
		WebElement loginID= driver.findElement(By.xpath("//*[@name='login']"));
		loginID.click();
		loginID.sendKeys("testshima071@gmail.com");
		WebElement pswd= driver.findElement(By.xpath("/html[1]/body[1]/my-app[1]/header[1]/nav[1]/div[1]/my-login[1]/div[1]/form[1]/div[1]/input[2]"));		
		pswd.sendKeys("Shima@123");
		WebElement loginButton= driver.findElement(By.xpath("//*[@class='btn btn-success']"));
		loginButton.click();
		   System.out.println("Logged in");
	}
	
	
	@Test(priority = 4)
	public void voteForCar(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;

		
		driver.findElement(By.xpath("/html[1]/body[1]/my-app[1]/header[1]/nav[1]/div[1]/a[1]")).click();
		   System.out.println("Logo clicked");
	    //driver.findElement(By.linkText("Overall")).click();
	  //  WebElement voteButton = driver.findElement(By.xpath("//a[contains(text(),'Vote!')]"));
		   js.executeScript("window.scrollBy(0, 1000);");
		   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		   driver.findElement(By.xpath("//a[@href='/make/ckl2phsabijs71623vk0']")).click();
		   js.executeScript("window.scrollBy(0, 1000);");
		   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		   driver.findElement(By.xpath("//*[contains(text(), 'Reventón')]")).click();
		   System.out.println("Reventon selected");
		   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
           driver.findElement(By.xpath("//button[@class='btn btn-success']")).click();
	   
	    System.out.println("Voted for a car.");
	}
	@Test(priority = 5)
	public void editProfile(WebDriver driver) {
	    driver.findElement(By.linkText("Profile")).click();
	    WebElement genderField = driver.findElement(By.id("gender"));
	    genderField.clear();
	    genderField.sendKeys("Female");
	    driver.findElement(By.xpath("//button[contains(text(),'Save')]")).click();
	    System.out.println("Profile edited.");
	}
	
	
	
	@aftertest
	void quit(WebDriver driver) {
		driver.quit();
	}

}
