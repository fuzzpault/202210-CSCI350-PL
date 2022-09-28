package CSCI350;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FA1Test {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() {
		assertTrue(FA1.validate("123"));
	}
	
	@Test
	void test1() {
		assertTrue(FA1.validate("1234123"));
	}
	
	@Test
	void test2() {
		assertFalse(FA1.validate("12341231"));
	}
	
	@Test
	void test3() {
		String a[] = {"123","12341234123"};
		for(String i : a) {
			assertTrue(FA1.validate(i));
		}
	}
	
	@Test
	void test4() {
		String a = "123";
		for(int i = 0; i < 100; i++) {
			assertTrue(FA1.validate(a));
			a = a + "4123";
		}
	}

}
