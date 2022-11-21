package test_zidong;

import static org.junit.Assert.assertEquals; 

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays; 
import java.util.Collection; 
import java.util.HashMap;
import java.util.List;

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

import com.impl.WaresImpl;
import com.vo.Wares;

import au.com.bytecode.opencsv.CSVReader;

 // 测试运行器 
@RunWith(Parameterized.class) 
public class zidong_fabu { 
	private static WebDriver d;
	private String expected;
	private String waresname;
	private String waresprice;
	private String picture;
	private String matketing;
	@Parameters
	@SuppressWarnings("unchecked") 
	public static Collection perpareData() throws IOException { 
		final String filepath="src/test_zidong/z_fabu.csv";
		CSVReader reader = new CSVReader(new FileReader(filepath));
		List<String[]> allElements = reader.readAll();
		return allElements; 
	}
	public zidong_fabu(String expected, String waresname,String waresprice,String picture,String matkering){ 
		this.expected = expected; 
		this.waresname=waresname;
		this.waresprice=waresprice;
		this.picture=picture;
		this.matketing=matkering;
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
		d.findElement(By.xpath("/html/body/a[5]")).click();
		//d.findElement(By.xpath("/html/body/form/a")).click();
		//String elementTest=alignStr.getText();
		//System.out.println(elementTest+"*");
		Thread.sleep(1000);
		if(picture.equals("1")){
			d.findElement(By.xpath("/html/body/div[2]/div/div[2]/form/a")).click();
			Thread.sleep(1000);
			Actions actions=new Actions(d);
			WebElement w1=d.findElement(By.name( "upfile" ));
			actions.click(w1).perform();
			//d.findElement(By.id( "upfile" )).click();
			Thread.sleep(3000);
			Runtime runtime = Runtime.getRuntime();
			try {
			    runtime.exec("src/test_zidong/上传商品图片.exe");
			    System.out.println("yes!!!!!!!!!!!!!!!!!!!!!!!");
			} catch (IOException e) {
				System.out.println("erro!!!!!!!!!!!!!!!!!!!!!!!");
			   e.printStackTrace();
			}
			Thread.sleep(6000);
			d.findElement(By.name("sub1")).click();
		}
		d.findElement(By.name("waresname")).sendKeys(waresname);
		d.findElement(By.name("waresprice")).sendKeys(waresprice);
		d.findElement(By.name("matketing")).sendKeys(matketing);
		Thread.sleep(3000);
		d.findElement(By.name("submit")).click();
		String elementTest=d.switchTo().alert().getText();
		Thread.sleep(2000);
	    d.switchTo().alert().accept();
		System.out.println(elementTest+"*");
		Thread.sleep(3000);
		assertEquals(expected,elementTest);
		if(expected.equals("发布成功")){
			WaresImpl wimp=new WaresImpl();
			Wares w=new Wares();
			w.setWaresname(waresname);
			wimp.deleteware_name(w);
			Thread.sleep(1000);
		}
	}

	@After
	public void tearDown() throws Exception {
		d.quit();
	}
}
