public class Problem17
{
    private String[] units = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    private String[] decimals = {"twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
    private String[] tenToTwenty = {"eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
    private String hundred = "hundred";
    private String thousand = "thousand";
    private String and = "and";
    private String ten = "ten";

    public static void main(String[] args)
    {
        Problem17 obj = new Problem17();
        obj.controller();
    }

    public void controller()
    {
        int totalLetters = 0;
        totalLetters += countUnits();
        totalLetters += ten.length();
        totalLetters += countTens();
        totalLetters += countDecimals();
        totalLetters += countHundreds();
        totalLetters += units[0].length() + thousand.length();
        System.out.println(totalLetters);
    }

    public int countTens()
    {
        int letters = 0;
        for (int i = 0; i < tenToTwenty.length; i++)
        {
            letters += tenToTwenty[i].length();
        }
        return letters;
    }

    public int countDecimals()
    {
        int letters = 0;
        for (int i = 0; i < decimals.length; i++)
        {
            letters += decimals[i].length();
            letters += decimals[i].length() * units.length + countUnits();
        }
        return letters;
    }

    public int countUnits()
    {
        int numberOfLetters = 0;
        for (int i = 0; i < units.length; i++)
        {
            numberOfLetters = numberOfLetters + units[i].length();
        }
        return numberOfLetters;
    }

    public int countHundreds()
    {
        int letters = 0;
        for (int i = 0; i < units.length; i++)
        {
            int lettersInHundred = units[i].length() + hundred.length() + and.length();
            letters += units[i].length() + hundred.length();

            // Because it is the same for all units
            letters += lettersInHundred * units.length + countUnits();

            letters += lettersInHundred + ten.length();

            letters += lettersInHundred * tenToTwenty.length + countTens();

            letters += lettersInHundred * decimals.length * (units.length + 1) + countDecimals();
        }
        return letters;
    }


    // FIXME: 29-Dec-16 Another solution
    /** Creates a new instance of Problem17 */
    public Problem17() {
        int onetonine = "onetwothreefourfivesixseveneightnine".length();
        int tentonineteen = "teneleventwelvethirteenfourteenfifteensixteenseventeeneighteennineteen".length();
        int and = "and".length();
        int twentytoninety = "twentythirtyfortyfiftysixtyseventyeightyninety".length();
        int hundred = "hundred".length();
        int thousand = "thousand".length();
        count = "one".length() + thousand +
                900*hundred + 100*onetonine +
                100*twentytoninety + 891*and +
                80*onetonine + 10*(onetonine + tentonineteen);
    }

    int count;

    int getCount(){return count;}
}
