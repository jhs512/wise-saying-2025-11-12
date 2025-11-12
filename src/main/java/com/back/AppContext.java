package com.back;

import java.util.Scanner;

public class AppContext {
    public static Scanner scanner;

    public static void renew(Scanner scanner) {
        AppContext.scanner = scanner;
    }
}
