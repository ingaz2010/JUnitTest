package com.promineotech.test;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class TestDemoJUnitTest {
	private TestDemo testDemo;

	@BeforeEach
	void setUp() throws Exception {
		testDemo = new TestDemo();
	}

	@ParameterizedTest
	@MethodSource("com.promineotech.test.TestDemoJUnitTest#argumentsForAddPositive")
	void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected, boolean ExpectException) {
		if(!ExpectException) {
			assertThat(testDemo.addPositive(a,b)).isEqualTo(expected);
		} else {
			assertThatThrownBy(() -> testDemo.addPositive(a, b)).isInstanceOf(IllegalArgumentException.class);
		}
		
	}
	
	@Test
	//@MethodSource("com.promineotech.test.TestDemoJUnitTest#assertThatPairsOfPositiveNumbersAreAddedCorrectrly")
	void assertThatPairsOfPositiveNumbersAreAddedCorrectrly() {
		assertThat(testDemo.addPositive(4,  5)).isEqualTo(9);
		assertThat(testDemo.addPositive(40, 50)).isEqualTo(90);
		assertThat(testDemo.addPositive(90, 11)).isEqualTo(101);
	}

	static Stream<Arguments> argumentsForAddPositive(){
		//@formatter:off
		return Stream.of(
				Arguments.of(1, 1, 2, false),
				Arguments.of( 12, 15, 27, false),
				Arguments.of(0, 10, 0, true),
				Arguments.of(12, -5, 0, true)
				);
		//@formatter:on
	}
	
	static Stream<Arguments> argsForPairsAddedCorrectly(){
		return Stream.of(
				Arguments.of(4, 5, 9),
				Arguments.of(40, 50, 90),
				Arguments.of(0, 12, 0)
				);
	}


//Testing oddOrEven method
	@ParameterizedTest
	@MethodSource("com.promineotech.test.TestDemoJUnitTest#argumentsForOddOrEvenNumber")
	void assertThatEvenOrOddIsCorrect(int a, String result) {
		assertThat(testDemo.oddOrEvenNumber(a)).isEqualTo(result);
	}
	static Stream<Arguments> argumentsForOddOrEvenNumber(){
		return Stream.of(
				Arguments.of(2, "Even"),
				Arguments.of(11, "Odd"),
				Arguments.of(37, "Odd"),
				Arguments.of(0, "Even")
				);
	}
	
	//testing randomNumberSquared method
	@Test
	@MethodSource("com.promineotech.test.TestDemoJUnitTest#assertThatNumberSquaredIsCorrect")
	void assertThatNumberSquaredIsCorrect() {
		TestDemo mockDemo = spy(testDemo);
		doReturn(5).when(mockDemo).getRandomInt();
		int fiveSquared = mockDemo.randomNumberSquared();
		assertThat(fiveSquared).isEqualTo(25);
	}
}