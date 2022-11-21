package test_gongneng;

import static org.junit.Assert.*;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import au.com.bytecode.opencsv.CSVReader;

import com.vo.Iscontent;
import com.vo.Seller;

//测试运行器
@RunWith(Parameterized.class) 
public class test_login { 
	private String expected;
	Seller seller=new Seller();
@Parameters
@SuppressWarnings("unchecked") 
	public static Collection perpareData() throws IOException { 
		final String filepath="src/test_gongneng/ilogin.csv";
		CSVReader reader = new CSVReader(new FileReader(filepath));
		List<String[]> allElements = reader.readAll();
		return allElements; 
	}
	public test_login(String expected, String sellerid,String sellerpw){ 
		this.expected = String.valueOf(expected); 
		this.seller.setSellerid(sellerid);
		this.seller.setSellerpw(sellerpw);;
	} 
@Test 
	public void test(){ 
		ArrayList<Seller> sites = new ArrayList<Seller>();
		Seller data1=new Seller("zhangsan","1234","12345ztc","13999999999",1);
		sites.add(data1);

		Iterator<Seller> it = sites.iterator();
		Iscontent iscontent=new Iscontent();
		assertEquals(expected,iscontent.sjdl(it, seller)); 
	}
}

