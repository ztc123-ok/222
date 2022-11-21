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

import com.impl.WaresImpl;
import com.vo.Seller;
import com.vo.Wares;
import com.vo.historyorder;

import au.com.bytecode.opencsv.CSVReader;

 // 测试运行器 
public class zidong_showgoods { 
	private static WebDriver d;
	String expected="购买并填写个人信息";
	private Wares w=new Wares();
	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.edge.driver", "C:\\Users\\周\\Desktop\\selenium_example\\edgedriver_win64 (2)\\msedgedriver.exe"); // replace with your geckodriver.exe csv file location
		d = new EdgeDriver();
		d.manage().window().maximize();
		WaresImpl wimp=new WaresImpl();
		List<Wares> wa=wimp.selectwares();
		w=wa.get(0);
	}
	@Test
	public void testAdvancedSearch() throws Exception {
		d.get("http://localhost:8080/test/cus_login.jsp");
		d.findElement(By.xpath("/html/body/a")).click();
		Thread.sleep(3000);
		d.findElement(By.xpath("/html/body/div/div/div[1]")).click();
		Thread.sleep(3000);
		//d.findElement(By.xpath("/html/body/div[1]/div[2]/div[3]/form/input[3]")).click();
		//d.findElement(By.name("submit")).click();
		//WebElement alignStr = d.findElement(By.xpath("//*[contains(@name,'submit')]"));
		WebElement alignStr1 = d.findElement(By.xpath("/html/body/div[1]/div[2]/form/input[3]"));
		String elementTest1=alignStr1.getAttribute("value");
		System.out.println(elementTest1+"*");
		assertEquals(expected,elementTest1);
		WebElement alignStr2 = d.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]"));
		String elementTest2=alignStr2.getText();
		System.out.println(elementTest2+"*");
		assertEquals("商品名："+w.getWaresname(),elementTest2);
		WebElement alignStr3 = d.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]"));
		String elementTest3=alignStr3.getText();
		System.out.println(elementTest3+"*");
		assertEquals("商品价格："+String.valueOf(w.getWaresprice())+"￥",elementTest3);
		WebElement alignStr4 = d.findElement(By.xpath("/html/body/div[2]"));
		String elementTest4=alignStr4.getText().substring(5);
		System.out.println(elementTest4+"*");
		assertEquals(w.getMatkering(),elementTest4);
		Thread.sleep(3000);
	}

	@After
	public void tearDown() throws Exception {
		d.quit();
	}
}
