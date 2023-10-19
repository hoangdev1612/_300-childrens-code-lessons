package regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DetectValidIP {
    private static final String IP_PATTERN =
            "^(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\." +
                    "(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\." +
                    "(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\." +
                    "(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$";

    private boolean isIp(String str) {
        Pattern pattern = Pattern.compile(IP_PATTERN);
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String ip = scanner.nextLine();
            DetectValidIP detectValidIP = new DetectValidIP();
            System.out.println(detectValidIP.isIp(ip));
        }
        scanner.close();
    }
}
/*
    Write a class which will contain a string pattern.
        You need to write a regular expression and assign it
        to the pattern such that it can be used to validate an IP address.*/
//IP address is a string in the form "A.B.C.D", where the value of A, B, C, and D may range from 0 to 255.
// Leading zeros are allowed. The length of A, B, C, or D can't be greater than 3.
