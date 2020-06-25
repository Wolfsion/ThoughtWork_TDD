package Poker;

public class Card {
    static final int Size = 5;
    static final int Times = 3;
    private int[] pokerNums = new int[Size];
    private char[] pokerSuits = new char[Size];

    public Card() {
    }

    public int setter(String str) {
        int status = 1;
        if (str.length() != 14) {
            status = -1;
        } else {
            for(int temp = 0; temp < Size; ++temp) {
                this.pokerNums[temp] = this.transform(str.charAt(temp * 3));
                this.pokerSuits[temp] = str.charAt(temp * 3 + 1);
            }
        }
        return status;
    }

    private int transform(char ch) {
        if (ch >= '2' && ch <= '9') {
            return Character.getNumericValue(ch);
        } else {
            int ret = 0;
            switch(ch) {
            case 'A':
                ret = 13;
                break;
            case 'J':
                ret = 10;
                break;
            case 'K':
                ret = 12;
                break;
            case 'Q':
                ret = 11;
            }

            return ret;
        }
    }

    public int[] getNum() {
        this.sort(0, Size - 1);
        return this.pokerNums;
    }

    public char[] getSuit() {
        return this.pokerSuits;
    }

    private void sort(int left, int right) {
        if (left < right) {
            int i = left;
            int j = right;
            int present = this.pokerNums[left];

            while(i < j) {
                while(i < j && this.pokerNums[j] >= present) {
                    --j;
                }

                if (i < j) {
                    this.pokerNums[i++] = this.pokerNums[j];
                }

                while(i < j && this.pokerNums[i] <= present) {
                    ++i;
                }

                if (i < j) {
                    this.pokerNums[j--] = this.pokerNums[i];
                }
            }

            this.pokerNums[i] = present;
            this.sort(left, i - 1);
            this.sort(i + 1, right);
        }

    }
}