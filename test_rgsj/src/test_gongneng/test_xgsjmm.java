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
public class test_xgsjmm { 
	private String expected;
	private String pwd1;
	private String pwd2;
	private String pwd3;
@Parameters
@SuppressWarnings("unchecked") 
	public static Collection perpareData() throws IOException { 
		final String filepath="src/test_gongneng/xjsjmm.csv";
		CSVReader reader = new CSVReader(new FileReader(filepath));
		List<String[]> allElements = reader.readAll();
		return allElements; 
	}
	public test_xgsjmm(String expected, String pwd1,String pwd2,String pwd3){ 
		this.expected = String.valueOf(expected); 
		this.pwd1=pwd1;
		this.pwd2=pwd2;
		this.pwd3=pwd3;
	} 
@Test 
	public void test(){ 
		Seller seller=new Seller("zhangsan","1234","12345ztc","13999999999",1);

		Iscontent iscontent=new Iscontent();
		assertEquals(expected,iscontent.xgsjmm(seller, pwd1, pwd2, pwd3)); 
		System.out.println(iscontent.xgsjmm(seller, pwd1, pwd2, pwd3));
	}
}

