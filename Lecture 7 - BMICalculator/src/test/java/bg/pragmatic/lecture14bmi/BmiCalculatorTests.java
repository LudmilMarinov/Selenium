package bg.pragmatic.lecture14bmi;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BmiCalculatorTests {

	BmiCalcPage bmiPage;


	@BeforeMethod
	public void setUp() {
		bmiPage = new BmiCalcPage();
		bmiPage.goTo();
	}

	@Test
	public void calculateOverweightBmiTest() {
		bmiPage.calculateBmi("150", "50");
		
		String actualBmi = bmiPage.getBmi();
		String actualBmiCategory = bmiPage.getBmiCategory();
		
		Assert.assertEquals(actualBmi, "22.2", "Ima buuuuug");
		Assert.assertEquals(actualBmiCategory, "Normal", "Ima buuuuug");

		bmiPage.quit();
	}

	@Test
	public void calculateObesityBmiTest() {
		bmiPage.calculateBmi("187", "187");
		String actualBmi = bmiPage.getBmi();
		String actualBmiCategory = bmiPage.getBmiCategory();

		Assert.assertEquals(actualBmi, "53.5");
		Assert.assertEquals(actualBmiCategory, "Obesity");

		bmiPage.quit();
	}

}
