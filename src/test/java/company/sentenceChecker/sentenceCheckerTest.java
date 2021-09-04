package test.java.company.sentenceChecker;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import main.java.com.company.sentenceChecker.SentenceChecker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

public class sentenceCheckerTest {

    SentenceChecker sentenceChecker;

    @BeforeEach
    void setUp() {
        sentenceChecker = new SentenceChecker();
    }

    @Test
    @DisplayName("Check first character is an uppercase letter.")
    void checkCharIsUppercaseTest() {
        char[] correctSentence = {'T', 'e', 's', 't', '.'};
        assertTrue(sentenceChecker.checkSentence(correctSentence), "Correct sentence should have an uppercase first letter.");
        char[] wrongSentence = {'t', 'e', 's', 't', '.'};
        assertFalse(sentenceChecker.checkSentence(wrongSentence), "Correct sentence should not have a lowercase first letter.");
        char[] wrongSentence2 = {'6', 'e', 's', 't', '.'};
        assertFalse(sentenceChecker.checkSentence(wrongSentence2), "Correct sentence should not have a number first.");
        char[] wrongSentence3 = {' ', 'e', 's', 't', '.'};
        assertFalse(sentenceChecker.checkSentence(wrongSentence3), "Correct sentence should not have an space first.");
        char[] wrongSentence4 = {'.', 'e', 's', 't', '.'};
        assertFalse(sentenceChecker.checkSentence(wrongSentence4), "Correct sentence should not have a full stop first.");
        char[] wrongSentence5 = {'@', 'e', 's', 't', '.'};
        assertFalse(sentenceChecker.checkSentence(wrongSentence5), "Correct sentence should not have a special character first.");
    }

    @Test
    @DisplayName("Check last character is a full stop.")
    void checkCharIsFullStop() {
        char[] correctSentence = {'T', 'e', 's', 't', '.'};
        assertTrue(sentenceChecker.checkSentence(correctSentence), "Correct sentence should end with a full stop.");
        char[] wrongSentence = {'T', 'e', 's', 't', 'g'};
        assertFalse(sentenceChecker.checkSentence(wrongSentence), "Correct sentence should not end with a letter.");
        char[] wrongSentence2 = {'T', 'e', 's', 't', '2'};
        assertFalse(sentenceChecker.checkSentence(wrongSentence2), "Correct sentence should not end with a number.");
        char[] wrongSentence3 = {'T', 'e', 's', 't', ' '};
        assertFalse(sentenceChecker.checkSentence(wrongSentence3), "Correct sentence should not end with a space.");
        char[] wrongSentence4 = {'@', 'e', 's', 't', '.'};
        assertFalse(sentenceChecker.checkSentence(wrongSentence4), "Correct sentence should not have a special character first.");
    }

    @Test
    @DisplayName("Check for an even number of quotation marks.")
    void checkForEvenQuotationMarks() {
        char[] correctSentence = {'T', 'e', 's', 't', '.'};
        assertTrue(sentenceChecker.checkSentence(correctSentence), "Correct sentence can have 0 quotation marks.");
        char[] correctSentence2 = {'T', '"', 's', '"', '.'};
        assertTrue(sentenceChecker.checkSentence(correctSentence2), "Correct sentence may have 2 quotation marks.");
        char[] wrongSentence = {'T', 'e', 's', '"', '.'};
        assertFalse(sentenceChecker.checkSentence(wrongSentence), "Correct sentence may not have 1 quotation mark.");
    }

    @Test
    @DisplayName("Check for only 1 full stop character.")
    void checkForOneFullStop() {
        char[] correctSentence = {'T', 'e', 's', 't', '.'};
        assertTrue(sentenceChecker.checkSentence(correctSentence), "Correct sentence should have 1 full stop character.");
        char[] wrongSentence = {'T', 'e', '.', 't', '.'};
        assertFalse(sentenceChecker.checkSentence(wrongSentence), "Correct sentence should not have 2 full stop characters.");
        char[] wrongSentence2 = {'T', 'e', 's', 't', 's'};
        assertFalse(sentenceChecker.checkSentence(wrongSentence2), "Correct sentence should not have 0 full stop characters.");
    }

    @Test
    @DisplayName("Check numbers below 13 are words.")
    void checkNumbersAreWordsBelow13AreWords() {
        char[] correctSentence = {'T', '1', '3', 't', '.'};
        assertTrue(sentenceChecker.checkSentence(correctSentence), "Correct sentence may have 13 as a number.");
        char[] correctSentence2 = {'T', '1', '0', '1', '.'};
        assertTrue(sentenceChecker.checkSentence(correctSentence), "Correct sentence may have 101 as a number.");
        char[] wrongSentence = {'T', 'e', '1', 't', '.'};
        assertFalse(sentenceChecker.checkSentence(wrongSentence), "Correct sentence should not have 1 as a number.");
        char[] wrongSentence2 = {'T', 'e', '1', '0', 's'};
        assertFalse(sentenceChecker.checkSentence(wrongSentence2), "Correct sentence should not have 10 as a number.");
    }
}
