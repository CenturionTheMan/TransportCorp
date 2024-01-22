package com.tasnporstcorp.test.suite;

import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

import com.tasnporstcorp.test.tests.ApplicationTest;
import com.tasnporstcorp.test.tests.UserCreatorTest;

@Suite
@SelectClasses({UserCreatorTest.class, ApplicationTest.class})
@IncludeTags("AccountCreation")
public class AccountCreationTestSuite{

}