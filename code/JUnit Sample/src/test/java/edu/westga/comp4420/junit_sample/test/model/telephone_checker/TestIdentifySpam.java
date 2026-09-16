package edu.westga.comp4420.junit_sample.test.model.telephone_checker;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.provider.CsvSource;
import edu.westga.comp4420.junit_sample.model.TelephoneChecker;

class TestIdentifySpam {
	
	@ParameterizedTest
	@CsvSource({"9990000000, true", "9980000000, false", "9000000000, true", "9010000000, false", "8880000000, true", "8890000000, false", "8000000000, true", "8010000000, false", "9110000000, true", "9120000000, false", "4110000000, true", "4100000000, false"})
	void testIdentifySpam(long number, boolean expectedResult) {
		TelephoneChecker checker = new TelephoneChecker();
		
		boolean result = checker.identifySpam(number);
		
		assertEquals(expectedResult, result, "checkingif number (" + number + ") was reported as spam");
	}
		
}
