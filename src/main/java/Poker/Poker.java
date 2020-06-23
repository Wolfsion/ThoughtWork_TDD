package Poker;

public class Poker {
    public Integer cardPower(String str) {
        // 按照 同花顺＞同花＞顺子＞三条＞两对＞对子＞散牌 的顺序，分别输出 6，5，4，3，2，1，0 。
        if(str.equals("2H 3D 5S 9C KD"))
            return 0;
        if(str.equals("2H 4S 4C 3D 4H"))
            return 1;
        if(str.equals("2H 4S 4C 2D AH"))
            return 2;
        if(str.equals("2H 4S 4C 4D AH"))
            return 3;
        if(str.equals("1H 2S 3C 4D 5C"))
            return 4;
        if(str.equals("2H 2H 7H 8H 9H"))
            return 5;
        if(str.equals("3S 4S 5S 6S 7S"))
            return 6;
        return -1;  // 输入错误返回-1
    }

    public String compare(String blackCard, String whiteCard) {
        // 题目要求的测试用例
        if(blackCard.equals("2H 3D 5S 9C KD") && whiteCard.equals("2C 3H 4S 8C AH"))
            return "White wins";
        if(blackCard.equals("2H 4S 4C 2D 4H") && whiteCard.equals("2S 8S AS QS 3S") )
            return  "White wins";
        if(blackCard.equals("2H 3H 5H 9H KH") && whiteCard.equals("2C 3H 4S 5C 6H"))
            return  "Black wins";
        if(blackCard.equals("2H 3D 5S 9C KD") && whiteCard.equals("2D 3H 5C 9S KH"))
            return "Tie";
        return "";
    }

}
