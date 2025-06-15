package com.example.lifecycle;

import org.junit.platform.suite.api.IncludeTags;
 import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;


@Suite
@SelectPackages({"com.example.lifecycle"})
@IncludeTags("integration")

// @SelectClasses({ArithmeticTest.class, ParameterizedTest1.class})
//  @SelectClasses({ParameterizedTest1.class})
//   @SelectClasses({ ArithmeticTest.class})
// @SelectClasses({ParameterizedTest1.class, ArithmeticTest.class})
public class AllTestSuite {
}
