package basicetest;

import org.testng.annotations.Test;

import scenario.CardModule;

public class CardTest extends CardModule{
	
	@Test(priority=1, description="to verfiy Add Card button ")
	public void TC_AC_001() {
		addCard(1);
		cardBadge();
	}
	@Test(priority=2, description="to verfiy multiple item Add Card button ")
	public void TC_AC_002() {
		addCard(1);
		addCard(2);
		addCard(3);
		cardBadge();
	}
}
