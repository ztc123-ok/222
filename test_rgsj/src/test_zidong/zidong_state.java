package test_zidong;

import static org.junit.Assert.assertEquals; 

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays; 
import java.util.Collection; 
import java.util.HashMap;
import java.util.List;

import org.apache.bcel.generic.Select;
import org.junit.After;
import org.junit.Before;
import org.junit.Test; 
import org.junit.runner.RunWith; 
import org.junit.runners.Parameterized; 
import org.junit.runners.Parameterized.Parameters; 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import com.vo.Seller;

import au.com.bytecode.opencsv.CSVReader;

 // 测试运行器 
@RunWith(Parameterized.class) 
public class zidong_state { 
	private static WebDriver d;
	private String expected;
	private String model;
	@Parameters
	@SuppressWarnings("unchecked") 
	public static Collection perpareData() throws IOException { 
		final String filepath="src/test_zidong/z_state.csv";
		CSVReader reader = new CSVReader(new FileReader(filepath));
		List<String[]> allElements = reader.readAll();
		return allElements; 
	}
	public zidong_state(String expected,String model){ 
		this.expected = String.valueOf(expected); 
		this.model=model;
	}
	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.edge.driver", "C:\\Users\\周\\Desktop\\selenium_example\\edgedriver_win64 (2)\\msedgedriver.exe"); // replace with your geckodriver.exe csv file location
		d = new EdgeDriver();
		d.manage().window().maximize();
	}
	@Test
	public void testAdvancedSearch() throws Exception {
		
		d.get("http://localhost:8080/test/cus_login.jsp");
		d.findElement(By.xpath("/html/body/a")).click();
		d.findElement(By.xpath("/html/body/div/a[2]")).click();
		d.findElement(By.name("uname")).sendKeys("1234");
		d.findElement(By.name("pwd")).sendKeys("12345ztc");
		d.findElement(By.name("submit")).click();
		d.findElement(By.xpath("/html/body/a[3]")).click();
		Thread.sleep(3000);
		String elementTest=null;
		if(model.equals("冻结")){
			//d.findElement(By.xpath("/html/body/table/tbody/tr[2]/td[9]/form/input[3]")).click();
			d.findElement(By.xpath("//*[contains(@name,'freeze')]")).click();
			Thread.sleep(3000);	
			WebElement alignStr1 = d.findElement(By.xpath("/html/body/div[1]/div[2]/form"));
			elementTest=alignStr1.getText();
			Thread.sleep(2000);
			System.out.println(elementTest+"*");
		}
		else if(model.equals("解冻")){
			d.findElement(By.xpath("//*[contains(@name,'unfreeze')]")).click();
			Thread.sleep(3000);
			WebElement alignStr1 = d.findElement(By.xpath("/html/body/div[1]/div[2]/form"));
			elementTest=alignStr1.getText();
			Thread.sleep(2000);
			System.out.println(elementTest+"*");
		}
		else if(model.equals("下架")){
			d.findElement(By.xpath("//*[contains(@name,'remove')]")).click();
			Thread.sleep(3000);
			WebElement alignStr1 = d.findElement(By.xpath("/html/body/h1"));
			elementTest=alignStr1.getText();
			Thread.sleep(2000);
			System.out.println(elementTest+"*");
		}
		Thread.sleep(3000);
		assertEquals(expected,elementTest);
	}

	@After
	public void tearDown() throws Exception {
		d.quit();
	}
}
