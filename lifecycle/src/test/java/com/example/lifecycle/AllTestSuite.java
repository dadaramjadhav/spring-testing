package com.example.lifecycle;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;


@Suite
 @SelectClasses({ParameterizedTest1.class})
//   @SelectClasses({ ArithmeticTest.class})
// @SelectClasses({ParameterizedTest1.class, ArithmeticTest.class})
public class AllTestSuite {
    
}
