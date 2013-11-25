/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.franklin.licensing.action;

import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.Resolution;

/**
 *
 * @author jesse
 */
public class CalculatorActionBean extends BaseActionBean {
    
    private double number1;
    private double number2;
    private double result;
    

    @DefaultHandler
    public Resolution index(){
        this.number1 = 0;
        this.number2 = 0;
        this.result = 0;
        return new ForwardResolution("/WEB-INF/jsp/calculator.jsp");
    }
    
    
    public Resolution addition(){
        this.setResult(this.getNumber1() + this.getNumber2());
        return new ForwardResolution("/WEB-INF/jsp/calculator.jsp");
    }
    
    public Resolution subtraction(){
        this.setResult(this.getNumber1() - this.getNumber2());
        return new ForwardResolution("/WEB-INF/jsp/calculator.jsp");
    }
    
    public Resolution multiply(){
        this.setResult(this.getNumber1() * this.getNumber2());
        return new ForwardResolution("/WEB-INF/jsp/calculator.jsp");
    }

    /**
     * @return the number1
     */
    public double getNumber1() {
        return number1;
    }

    /**
     * @param number1 the number1 to set
     */
    public void setNumber1(double number1) {
        this.number1 = number1;
    }

    /**
     * @return the number2
     */
    public double getNumber2() {
        return number2;
    }

    /**
     * @param number2 the number2 to set
     */
    public void setNumber2(double number2) {
        this.number2 = number2;
    }

    /**
     * @return the result
     */
    public double getResult() {
        return result;
    }

    /**
     * @param result the result to set
     */
    public void setResult(double result) {
        this.result = result;
    }
}
