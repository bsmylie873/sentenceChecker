package main.java.com.company.sentenceChecker;

public class SentenceChecker {
    // Check the first character is a capital letter, passing in a char parameter to check.
    private boolean checkCharIsUppercase(char chr){
        return Character.isUpperCase(chr);
    }

    // Check the first character is a capital letter, passing in a char parameter to check.
    private boolean checkCharIsFullStop(char chr){
        return chr == '.';
    }

    //Check if quotes are even, passing in a count integer calculated within the while loop below.
    private boolean checkQuoteCount(int quoteCount){
        if (quoteCount % 2 != 0 ) {
            return false;
        }
        return true;
    }

    //Check if there is one full stop/period, passing in a count integer calculated within the while loop below.
    private boolean checkFullStopCount(int fullStopCount){
        return fullStopCount == 1;
    }

    // Check the first character is a capital letter, passing in a char parameter to check.
    private boolean checkSentenceGrammar(char[] str){
        //Declare variables needed inside the while loop.
        //currState has the following values: 0 = not currently a number character, 1 = currently a number character.
        //prevState has the following values: 0 = previous char not a number, 1 = previous char was a number.
        //These two variables can be expanded upon, or reduced to booleans for efficiency.
        int currState = 0, index = 0, fullStopCount = 0, prevState = 0, quoteCount = 0, num1, num2;

        //Start while loop, using the length of the array minus 1 to account for index starting at 0.
        while (index <= str.length - 1){
            //Check if current character is a number.
            if ((Character.isDigit(str[index]))) {
                currState = 1;
            } else {
                //Check if previous character was a number, if so check the one before that was a number. This filters
                //out 0-9 numbers.
                if (prevState == 1) {
                    if (!(Character.isDigit(str[index-2]))){
                        return false;
                    }
                }
            }

            //Check if the current and last character are numbers.
            if (currState == 1 && prevState == 1){
                //Set local variables.
                num1 = Character.getNumericValue(str[index]);
                num2 = Character.getNumericValue(str[index-1]);

                //Check that the character before the previous isn't a number, that the next character also isn't
                //a number, and the two numbers together don't create a value of less than 13. This implementation keeps
                //values above 100 valid despite having '10' and '00' in its composition.
                if (!(Character.isDigit(str[index-2])) && !(Character.isDigit(str[index+1])) && num1<=2 && num2<=1){
                    return false;
                }
            }

            //Check if current char is a quotation mark, if so increment the quote counter.
            if (str[index] == '\"') {
                quoteCount++;

                //Check if current char is a full stop, if so increment the index counter.
            } else if (str[index] == '.') {
                fullStopCount++;
            }
            //Increment the index for the loop, set the previous state and reset the current state.
            index++;
            prevState = currState;
            currState = 0;
        }

        //Check if quotes are even, calling the checkQuoteCount method.
        if (!checkQuoteCount(quoteCount)) {
            return false;
        }
        //Check if periods are equal to 1, calling the checkQuoteCount method.
        if (!checkFullStopCount(fullStopCount)) {
            return false;
        }

        return true;
    }

    //This method will check the entered string for grammar, according to the specifications required.
    //The public access modifier allows this to be accessed from outside the package.
    //These methods are Unicode compatible.
    public boolean checkSentence(char[] str)
    {
        //Read length of the array of characters.
        int length = str.length;

        //Call method to check first character's case, passing in the first character from the array.
        if (!checkCharIsUppercase(str[0])) {
            return false;
        }

        //Call method to check last character is a ., passing in the last character from the array.
        if (!checkCharIsFullStop(str[length - 1])){
            return false;
        }

        //Call method to check grammar of sentence, passing in the array.
        if (!checkSentenceGrammar(str)){
            return false;
        }

        //If all checks have been passed, return a true value, i.e a valid string.
        return true;
    }
}
