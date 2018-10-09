package ru.ifmo.cet.javabasics;

/**
 * Нужно реализовать констурктор и метод, возвращающий слова песни про бутылки на стене.
 * <p>
 * Слова следующие:
 * <p>
 * 99 bottles of beer on the wall, 99 bottles of beer
 * Take one down, pass it around, 98 bottles of beer
 * 98 bottles of beer on the wall, 98 bottles of beer
 * Take one down, pass it around, 97 bottles of beer
 * 97 bottles of beer on the wall, 97 bottles of beer
 * Take one down, pass it around, 96 bottles of beer
 * 96 bottles of beer on the wall, 96 bottles of beer
 * Take one down, pass it around, 95 bottles of beer
 * 95 bottles of beer on the wall, 95 bottles of beer
 * ...
 * <p>
 * 3 bottles of beer on the wall, 3 bottles of beer
 * Take one down, pass it around, 2 bottles of beer
 * 2 bottles of beer on the wall, 2 bottles of beer
 * Take one down, pass it around, 1 bottles of beer
 * 1 bottle of beer on the wall, 1 bottle of beer
 * Take one down, pass it around, no more bottles of beer on the wall
 * No more bottles of beer on the wall, no more bottles of beer
 * Go to the store and buy some more, 99 bottles of beer on the wall
 * <p>
 * Дело усложняется тем, что текст песни переменный:
 * За раз может быть взято несколько бутылок.
 * Значение передается в качестве параметра конструктора
 * Нужно ограничить возможность взятия бутылок натуральным число не более 99 бутылок за раз.
 */
public class BottleSong {

    private int atOnes;
    private int bottles = 99;
    private static final String[] units = {
            "", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
            "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};

    private static final String[] tens = {
            "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};

    public BottleSong(int bottleTakenAtOnce) {
        this.atOnes = bottleTakenAtOnce;
        //TODO
    }

    public String getBottleSongLyrics() {
        //TODO
        //throw new UnsupportedOperationException();

        String s;
        String s1;
        if(atOnes < 1 || atOnes > 99) throw new IllegalArgumentException();
        StringBuffer buf = new StringBuffer();
        String count = "";
        if (atOnes < 20){
            count = units[atOnes];
        } else if ((atOnes > 19) && (atOnes < 100)){
            count = tens[atOnes/10 - 2] + ((atOnes%10 != 0) ? " " + units[atOnes%10] : "");
        }


        while (bottles > 0){
            if (atOnes < bottles){
                s1 = bottles + ((bottles!=1)? " bottles" : " bottle") + " of beer on the wall, " + bottles + ((bottles!=1)? " bottles" : " bottle") + " of beer.\n" + "Take " + count + " down and pass around, " + (bottles - atOnes) + ((bottles - atOnes !=1)? " bottles" : " bottle") + " of beer on the wall.\n"  ;
                buf.append(s1);
                bottles = bottles - atOnes;

            } else if (atOnes == bottles){
                s1 = bottles + ((bottles!=1)? " bottles" : " bottle") + " of beer on the wall, " + bottles + ((bottles!=1)? " bottles" : " bottle") + " of beer.\n" + "Take " + count + " down and pass around, no more bottles of beer on the wall.\n" +
                        "No more bottles of beer on the wall, no more bottles of beer.\n" + "Go to the store and buy some more, 99 bottles of beer on the wall.\n";
                buf.append(s1);
                bottles = bottles - atOnes;
            } else{
                if (bottles < 20){
                    count = units[bottles];
                } else if ((bottles > 19) && (bottles < 100)){
                    count = tens[bottles/10 - 2] + ((bottles%10 != 0) ? " " + units[bottles%10] : "");
                }
                s1 = bottles + ((bottles!=1)? " bottles" : " bottle") + " of beer on the wall, " + bottles + ((bottles!=1)? " bottles" : " bottle") + " of beer.\n" + "Take " + count + " down and pass around, no more bottles of beer on the wall.\n" +
                        "No more bottles of beer on the wall, no more bottles of beer.\n" + "Go to the store and buy some more, 99 bottles of beer on the wall.\n";
                buf.append(s1);
                bottles = 0;
            }
        }
        s = buf.toString();
        return s;

    }
}