/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pwbdblackjack;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author admin
 */
public class PWBDBlackJackTest {
    
    public PWBDBlackJackTest() {
    }
    

    @Test
    public void testCheckPlayerHandGood() {
        System.out.println("CheckPlayerMoney Good");
        double PlayerBet = 99;
        double PlayerMoney = 100;
        boolean expResult = true;
        boolean result = PWBDBlackJack.checkPlayerHand(PlayerBet, PlayerMoney);
        assertEquals(expResult, result);
    }
    
        @Test
    public void testCheckPlayerHandBad() {
        System.out.println("CheckPlayerMoney Bad");
        double PlayerBet = 101;
        double PlayerMoney = 100;
        boolean expResult = true;
        boolean result = PWBDBlackJack.checkPlayerHand(PlayerBet, PlayerMoney);
        assertEquals(expResult, result);
    }
    
        @Test
    public void testCheckPlayerHandBoundary() {
        System.out.println("CheckPlayerMoney Boundary");
        double PlayerBet = 100;
        double PlayerMoney = 100;
        boolean expResult = true;
        boolean result = PWBDBlackJack.checkPlayerHand(PlayerBet, PlayerMoney);
        assertEquals(expResult, result);
    }
    
        @Test
        public void testCheckHandValueGood() {
        System.out.println("CheckHandValue Good");
        double PlayerValue = 20;
        double AiValue=19;
        boolean expResult = true;
        boolean result = PWBDBlackJack.checkHandValue(PlayerValue, AiValue);
        assertEquals(expResult, result);
    }
 
        @Test
        public void testCheckHandValueBad() {
        System.out.println("CheckHandValue Bad");
        double PlayerValue = 19;
        double AiValue=20;
        boolean expResult = false;
        boolean result = PWBDBlackJack.checkHandValue(PlayerValue, AiValue);
        assertEquals(expResult, result);
    }
        @Test
        public void testCheckHandValueBoundary() {
        System.out.println("CheckHandValue Boundary");
        double PlayerValue = 21;
        double AiValue=20;
        boolean expResult = true;
        boolean result = PWBDBlackJack.checkHandValue(PlayerValue, AiValue);
        assertEquals(expResult, result);
    }
                
}
