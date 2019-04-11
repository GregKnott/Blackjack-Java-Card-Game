/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deliverable3;

import static junit.framework.Assert.assertEquals;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Greg
 */
public class BlackjackTest {
    
    public BlackjackTest() {
    }
    
    /**
     * Testing for positive results of hit method, of class Blackjack.
     */
    @Test
    public void testHitGood() {
        System.out.println("hitGood");
        Hand testHand = new Hand();
        testHand.addCard(new BlackJackCard("EIGHT"));
        testHand.addCard(new BlackJackCard("EIGHT"));
        Blackjack instance = new Blackjack();
        boolean expResult = true;
        boolean result = instance.canHit(testHand);
        assertEquals(expResult, result);
    }
    
    /**
     * Testing for negative results of hit method, of class Blackjack.
     */
    @Test
    public void testHitBad() {
        System.out.println("hitBad");
        Hand testHand = new Hand();
        testHand.addCard(new BlackJackCard("KING"));
        testHand.addCard(new BlackJackCard("KING"));
        testHand.addCard(new BlackJackCard("QUEEN"));
        Blackjack instance = new Blackjack();
        boolean expResult = false;
        boolean result = instance.canHit(testHand);
        assertEquals(expResult, result);
    }
    
    /**
     * Testing for boundary results of hit method, of class Blackjack.
     */
    @Test
    public void testHitBoundary() {
        System.out.println("hitBad");
        Hand testHand = new Hand();
        testHand.addCard(new BlackJackCard("KING"));
        testHand.addCard(new BlackJackCard("KING"));
        Blackjack instance = new Blackjack();
        boolean expResult = true;
        boolean result = instance.canHit(testHand);
        assertEquals(expResult, result);
    }
    
    /**
     * Testing for positive results of doubleDown method, of class Blackjack.
     */
    @Test
    public void testDoubleDownGood() {
        System.out.println("doubleDownGood");
        Hand testHand = new Hand();
        testHand.addCard(new BlackJackCard("FIVE"));
        testHand.addCard(new BlackJackCard("FIVE"));
        
        Blackjack instance = new Blackjack();
        boolean expResult = true;
        boolean result = instance.canDoubleDown(testHand);
        assertEquals(expResult, result);
    }
    
    /**
     * Testing for negative results of doubleDown method, of class Blackjack.
     */
    @Test
    public void testDoubleDownBad() {
        System.out.println("doubleDownBad");
        Hand testHand = new Hand();
        testHand.addCard(new BlackJackCard("SEVEN"));
        testHand.addCard(new BlackJackCard("FIVE"));
        Blackjack instance = new Blackjack();
        
        boolean expResult = false;
        boolean result = instance.canDoubleDown(testHand);
        assertEquals(expResult, result);
    }
    
    /**
     * Testing for boundary results of doubleDown method, of class Blackjack.
     */
    @Test
    public void testDoubleDownBoundary() {
        System.out.println("doubleDownBoundary");
        Hand testHand = new Hand();
        testHand.addCard(new BlackJackCard("SIX"));
        testHand.addCard(new BlackJackCard("FIVE"));
        Blackjack instance = new Blackjack();
        
        boolean expResult = true;
        boolean result = instance.canDoubleDown(testHand);
        assertEquals(expResult, result);
    }

    /**
     * Testing for positive results of split method, of class Blackjack.
     */
    @Test
    public void testSplitGood() {
        System.out.println("splitGood");
        Hand testHand = new Hand(2);
        Blackjack instance = new Blackjack();
        
        boolean expResult = true;
        boolean result = instance.canSplit(testHand);
        assertEquals(expResult, result);
    }
    
    /**
     * Testing for negative results of split method, of class Blackjack.
     */
    @Test
    public void testSplitBad() {
        System.out.println("splitBad");
        Hand testHand = new Hand(1);
        Blackjack instance = new Blackjack();
        
        boolean expResult = false;
        boolean result = instance.canSplit(testHand);
        assertEquals(expResult, result);
    }

    /**
     * Testing for positive results of setBet method, of class Blackjack.
     */
    
    
    @Test
    public void testSetBetGood() {
        System.out.println("setBetGood");
        double givenBet = 10.0;
        Blackjack instance = new Blackjack();
        
        boolean expResult = true;
        boolean result = instance.canBet(givenBet);
        assertEquals(expResult, result);
    }
    
    /**
     * Testing for negative results of setBet method, of class Blackjack.
     */
    @Test
    public void testSetBetBad() {
        System.out.println("setBetBad");
        double givenBet = 0.0;
        Blackjack instance = new Blackjack();
        
        boolean expResult = false;
        boolean result = instance.canBet(givenBet);
        assertEquals(expResult, result);
    }
    
    /**
     * Testing for boundary results of setBet method, of class Blackjack.
     */
    @Test
    public void testSetBetBoundary() {
        System.out.println("setBetBoundary");
        double givenBet = 1.0;
        Blackjack instance = new Blackjack();
        
        boolean expResult = true;
        boolean result = instance.canBet(givenBet);
        assertEquals(expResult, result);
    }
    
    
    
}
