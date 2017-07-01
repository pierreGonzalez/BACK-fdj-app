package com.springBootPackage.domain;

import java.util.Calendar;



public class EquationDroiteDTL {
	private Double a;
	private Double b;
	public EquationDroiteDTL() {
		super();
	}
	public EquationDroiteDTL(Double a, Double b) {
		super();
		this.a = a;
		this.b = b;
	}
	
	public EquationDroiteDTL getEquation(Long x1, Long y1,Long x2, Long y2){
		EquationDroiteDTL equation = new EquationDroiteDTL();

		equation.setA(((Double.valueOf((double)(y2-y1)/(double)(x2-x1)))));
		equation.setB((y2 - equation.getA()*x2));
		
		
		return equation;
	}
	public Long getYdistance(EquationDroiteDTL equation, Calendar date){
		
		Long distance = Long.valueOf((long)(date.getTimeInMillis()*equation.getA()+equation.getB()));
		return distance;
	}
	public Double getA() {
		return a;
	}
	public void setA(Double a) {
		this.a = a;
	}
	public Double getB() {
		return b;
	}
	public void setB(Double b) {
		this.b = b;
	}
	
	@Override
	public String toString() {
		return "EquationDroiteDTL [y="+a+"x+"+b+"]";
	}
	
	
}
