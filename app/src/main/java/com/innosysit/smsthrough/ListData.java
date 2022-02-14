package com.innosysit.smsthrough;

public class ListData {

    String fromPhoneNum;
    String toPhoneNum;
    String date;
    String contents;

    ListData(String fromPhoneNum, String toPhoneNum, String date, String contents)
    {
        this.fromPhoneNum = fromPhoneNum;
        this.toPhoneNum = toPhoneNum;
        this.date = date;
        this.contents = contents;
    }

}
