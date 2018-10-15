package com.countries;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.countries.impl.ConfigLoaderImplTest;
import com.countries.impl.CountryApiImplTest;

@RunWith( Suite.class )
@SuiteClasses( {ConfigLoaderImplTest.class, CountryApiImplTest.class} )
public class UnitTestSuite {

}
