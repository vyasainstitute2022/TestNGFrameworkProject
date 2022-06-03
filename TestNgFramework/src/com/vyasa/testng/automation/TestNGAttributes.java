package com.vyasa.testng.automation;

import org.testng.annotations.Test;

public class TestNGAttributes {
	
	@Test(priority=1,groups="sanity")
	void test1()
	{
		System.out.println("from test 1");
	}
	
	@Test(groups="Regression")
	void test2()
	{
		System.out.println("from test 2");
	}
	
	@Test(priority=2,groups="Regression")
	void test3()
	{
		System.out.println("from test 3");
	}
	
	@Test(groups={"sanity","Regression","Retest"})
	void atest4()
	{
		
		System.out.println("from test 4");
		System.out.println("sanity executed without reg retest");
	}
	
	@Test(dependsOnMethods={"atest4"})
	void test5()
	{
		System.out.println("from test 5");
	}
	
	@Test(priority=-3)
	void test6()
	{
		System.out.println("from test 6");
	}
	
	
	@Test(priority=5)
	void test7()
	{
		System.out.println("from test 7");
	}
}
