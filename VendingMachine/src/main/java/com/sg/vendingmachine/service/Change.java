/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.service;

import java.math.BigDecimal;
import java.util.Objects;

/**
 *
 * @author noahbosa1
 */
public class Change {
    
    private BigDecimal quarters;
    private BigDecimal dimes;
    private BigDecimal nickles;
    private BigDecimal pennies;
    private BigDecimal cash;

    public BigDecimal getCash() {
        return cash;
    }

    public void setCash(BigDecimal cash) {
        this.cash = cash;
    }
    public BigDecimal getQuarters() {
        return quarters;
    }

    public void setQuarters(BigDecimal quarters) {
        this.quarters = quarters;
    }

    public BigDecimal getDimes() {
        return dimes;
    }

    public void setDimes(BigDecimal dimes) {
        this.dimes = dimes;
    }

    public BigDecimal getNickles() {
        return nickles;
    }

    public void setNickles(BigDecimal nickles) {
        this.nickles = nickles;
    }

    public BigDecimal getPennies() {
        return pennies;
    }

    public void setPennies(BigDecimal pennies) {
        this.pennies = pennies;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.quarters);
        hash = 89 * hash + Objects.hashCode(this.dimes);
        hash = 89 * hash + Objects.hashCode(this.nickles);
        hash = 89 * hash + Objects.hashCode(this.pennies);
        hash = 89 * hash + Objects.hashCode(this.cash);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Change other = (Change) obj;
        if (!Objects.equals(this.quarters, other.quarters)) {
            return false;
        }
        if (!Objects.equals(this.dimes, other.dimes)) {
            return false;
        }
        if (!Objects.equals(this.nickles, other.nickles)) {
            return false;
        }
        if (!Objects.equals(this.pennies, other.pennies)) {
            return false;
        }
        if (!Objects.equals(this.cash, other.cash)) {
            return false;
        }
        return true;
    }
    
}
 