package com.tasnporstcorp.test.suite;

import org.junit.platform.suite.api.ExcludeTags;
import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectPackages("com.tasnporstcorp.test.tests")
@IncludeTags("LogIn")
@ExcludeTags("Factory")
public class LogInTestSuite {
    
}
