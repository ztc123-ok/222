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

import com.gargoylesoftware.htmlunit.javascript.host.History;
import com.impl.HistoryImpl;
import com.vo.Seller;
import com.vo.historyorder;

import au.com.bytecode.opencsv.CSVReader;

 // 测试运行器 
public class zidong_history { 
	private static WebDriver d;
	private historyorder his=new historyorder();
	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.edge.driver", "C:\\Users\\周\\Desktop\\selenium_example\\edgedriver_win64 (2)\\msedgedriver.exe"); // replace with your geckodriver.exe csv file location
		d = new EdgeDriver();
		d.manage().window().maximize();
		HistoryImpl himl=new HistoryImpl();
		List<historyorder> history=himl.selecthistoryorder();
		his=history.get(0);
	}
	@Test
	public void testAdvancedSearch() throws Exception {
		d.get("http://localhost:8080/test/cus_login.jsp");
		d.findElement(By.xpath("/html/body/a")).click();
		d.findElement(By.xpath("/html/body/div/a[2]")).click();
		d.findElement(By.name("uname")).sendKeys("1234");
		d.findElement(By.name("pwd")).sendKeys("12345ztc");
		d.findElement(By.name("submit")).click();
		d.findElement(By.xpath("/html/body/a[2]")).click();
		d.findElement(By.xpath("/html/body/div/div[7]/a")).click();
		Thread.sleep(3000);
		//d.findElement(By.xpath("/html/body/div[1]/div[2]/div[3]/form/input[3]")).click();
		//d.findElement(By.name("submit")).click();
		WebElement alignStr1 = d.findElement(By.xpath("/html/body/table/tbody/tr[1]/td[1]"));
		//WebElement alignStr = d.findElement(By.name("submit"));
		String elementTest1=alignStr1.getText();
		System.out.println(elementTest1+"*");
		Thread.sleep(3000);
		assertEquals("订单id",elementTest1);
		WebElement alignStr2 = d.findElement(By.xpath("/html/body/table/tbody/tr[1]/td[7]"));
		String elementTest2=alignStr2.getText();
		System.out.println(elementTest2+"*");
		assertEquals("交易结果",elementTest2);
		WebElement alignStr3 = d.findElement(By.xpath("/html/body/table/tbody/tr[2]/td[1]"));
		String elementTest3=alignStr3.getText();
		System.out.println(elementTest3+"*");
		assertEquals(String.valueOf(his.getHistoryid()),elementTest3);
		WebElement alignStr4 = d.findElement(By.xpath("/html/body/table/tbody/tr[2]/td[2]"));
		String elementTest4=alignStr4.getText();
		System.out.println(elementTest4+"*");
		assertEquals(String.valueOf(his.getWaresid()),elementTest4);
		WebElement alignStr5 = d.findElement(By.xpath("/html/body/table/tbody/tr[2]/td[3]"));
		String elementTest5=alignStr5.getText();
		System.out.println(elementTest5+"*");
		assertEquals(his.getBuyerid(),elementTest5);
		WebElement alignStr6 = d.findElement(By.xpath("/html/body/table/tbody/tr[2]/td[4]"));
		String elementTest6=alignStr6.getText();
		System.out.println(elementTest6+"*");
		assertEquals(his.getFinishtime(),elementTest6);
		WebElement alignStr7 = d.findElement(By.xpath("/html/body/table/tbody/tr[2]/td[5]"));
		String elementTest7=alignStr7.getText();
		System.out.println(elementTest7+"*");
		assertEquals(his.getBuyerphone(),elementTest7);
		WebElement alignStr8 = d.findElement(By.xpath("/html/body/table/tbody/tr[2]/td[6]"));
		String elementTest8=alignStr8.getText();
		System.out.println(elementTest8+"*");
		assertEquals(his.getBuyeraddress(),elementTest8);
		WebElement alignStr9 = d.findElement(By.xpath("/html/body/table/tbody/tr[2]/td[7]"));
		String elementTest9=alignStr9.getText();
		System.out.println(elementTest9+"*");
		assertEquals(his.getResult(),elementTest9);
		
	}

	@After
	public void tearDown() throws Exception {
		d.quit();
	}
}
