/**
 * 
 */
package com.dynatrace.diagnostics.plugin;

/**
 * @author Jose.Colella
 *
 */
public class RangeGroup {
	
	private static final double oneThousandThreshold = 1000;
	private static final double twoThousandThreshold = 2000;
	private static final double threeThousandThreshold = 3000;
	private static final double fourThousandThreshold = 4000;
	private static final double fiveThousandThreshold = 5000;
	private static final double tenThousandThreshold = 10000;
	private static final double fifteenThousandThreshold = 15000;
	
	
	private Integer numberLessOneSecond;
	private Integer betweenOneTwoSecond;
	private Integer betweenTwoThreeSecond;
	private Integer betweenThreeFourSecond;
	private Integer betweenFourFiveSecond;
	private Integer betweenFiveTenSecond;
	private Integer betweenTenFifteenSecond;
	private Integer moreFifteenSecond;
	
	public RangeGroup() {
		this.resetGroup();
	}
	
	
	
	public Integer getNumberLessOneSecond() {
		return numberLessOneSecond;
	}
	/**
	 * @return the betweenOneTwoSecond
	 */
	public Integer getBetweenOneTwoSecond() {
		return betweenOneTwoSecond;
	}
	/**
	 * @return the betweenTwoThreeSecond
	 */
	public Integer getBetweenTwoThreeSecond() {
		return betweenTwoThreeSecond;
	}
	/**
	 * @return the betweenThreeFourSecond
	 */
	public Integer getBetweenThreeFourSecond() {
		return betweenThreeFourSecond;
	}
	/**
	 * @return the betweenFourFiveSecond
	 */
	public Integer getBetweenFourFiveSecond() {
		return betweenFourFiveSecond;
	}
	/**
	 * @return the betweenFiveTenSecond
	 */
	public Integer getBetweenFiveTenSecond() {
		return betweenFiveTenSecond;
	}
	/**
	 * @return the betweenTenFifteenSecond
	 */
	public Integer getBetweenTenFifteenSecond() {
		return betweenTenFifteenSecond;
	}
	/**
	 * @return the moreFifteenSecond
	 */
	public Integer getMoreFifteenSecond() {
		return moreFifteenSecond;
	}
	
	public void calculateGroup(double result) {
		if (result >= fifteenThousandThreshold) {
		    this.moreFifteenSecond+=1;
		} else if (result >= tenThousandThreshold && result < fifteenThousandThreshold) {
		    this.betweenTenFifteenSecond+=1;
		} else if (result >= fiveThousandThreshold && result < tenThousandThreshold) {
		    this.betweenFiveTenSecond+=1;
		} else if (result >= fourThousandThreshold && result < fiveThousandThreshold) {
		    this.betweenFourFiveSecond+=1;
		} else if (result >= threeThousandThreshold && result < fourThousandThreshold) {
		    this.betweenThreeFourSecond+=1;
		} else if (result >= twoThousandThreshold && result < threeThousandThreshold) {
		    this.betweenTwoThreeSecond+=1;
		} else if (result >= oneThousandThreshold && result < twoThousandThreshold) {
		    this.betweenOneTwoSecond+=1;
		} else if (result < oneThousandThreshold) {
		    this.numberLessOneSecond+=1;
		}
	}
	
	public void resetGroup() {
		this.numberLessOneSecond = 0;
		this.betweenOneTwoSecond = 0;
		this.betweenTwoThreeSecond = 0;
		this.betweenThreeFourSecond = 0;
		this.betweenFourFiveSecond = 0;
		this.betweenFiveTenSecond = 0;
		this.betweenTenFifteenSecond = 0;
		this.moreFifteenSecond = 0;
	}
	
	
}
