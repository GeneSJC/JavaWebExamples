package com.demo.qa;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.thoughtworks.selenium.SeleneseTestBase;

public class HtmlUnitDemo1 extends SeleneseTestBase
{
	static String url = "http://localhost:8080/JavaWebExamples/";

	private WebDriver driver;
	
	@Override
	@Before
	public void setUp()
	{
		driver = new HtmlUnitDriver(BrowserVersion.INTERNET_EXPLORER_9);
	}
	
	@Test
	public void pageTitleIndex()
	{
		driver.get(url);
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());

		String pageTitle = driver.getTitle();

		WebElement helloLink = driver.findElement(By.id("hello_servlet"));
		
		String href = helloLink.getAttribute("href");
		
		System.out.println("helloLink  = " + href);
		
		assertEquals("JavaWebExamples Home", pageTitle);
		assertEquals("http://localhost:8080/JavaWebExamples/HelloWorld", href);
		assertEquals("zz_http://localhost:8080/JavaWebExamples/HelloWorld", href);
	}
	
	
	@Test
	public void pageTitleGoogle()
	{
		driver.get("http://google.com");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		
		String pageTitle = driver.getTitle();
		
		assertEquals("Google", pageTitle);
	}
	

}
