package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

	WebDriver driver;
	
	BasePage (WebDriver diver){
		this.driver = driver;
		PageFactory.initElements(diver, this);
	}
}
