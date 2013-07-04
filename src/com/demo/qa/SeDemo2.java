package com.demo.qa;

import org.junit.Test;
import org.openqa.selenium.server.RemoteControlConfiguration;
import org.openqa.selenium.server.SeleniumServer;
import org.testng.annotations.BeforeTest;

import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.SeleneseTestBase;
import com.thoughtworks.selenium.Selenium;

public class SeDemo2 extends SeleneseTestBase
{
	public static final String MAX_WAIT_TIME_IN_MS = "5000";
	public static final String TARGET_URL = "http://www.google.com";
	public static final String BROWSER_CONFIG = "*firefox /Applications/1_utils/Firefox.app/Contents/MacOS/firefox-bin";
	
	Selenium selenium;
	private SeleniumServer seleniumServer;

	@BeforeTest
	public void setUp() throws Exception
	{
		RemoteControlConfiguration rc = new RemoteControlConfiguration();
		rc.setAvoidProxy(true);
		rc.setSingleWindow(true);
		rc.setReuseBrowserSessions(true);

		seleniumServer = new SeleniumServer(rc);
		seleniumServer.start();
		
		selenium = new DefaultSelenium("localhost", 4444, BROWSER_CONFIG, TARGET_URL);
		selenium.setTimeout(MAX_WAIT_TIME_IN_MS);
		selenium.start();
	}
	
	@Test
	public void test1() throws Exception
	{
		selenium.open("http://www.google.com/");
	}
	
	@Test
	public void test2() throws Exception
	{
	//	selenium.open("http://www.google.com/news");
	}

	@Test
	public void test3() throws Exception
	{
	//	selenium.open("http://www.google.comnewzz");
	}
}