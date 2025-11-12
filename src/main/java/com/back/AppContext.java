package com.back;

import com.back.domain.wiseSaying.controller.WiseSayingController;

import java.util.Scanner;

public class AppContext {
    public static Scanner scanner;
    public static WiseSayingController wiseSayingController;

    public static void renew(Scanner scanner) {
        AppContext.scanner = scanner;
        AppContext.wiseSayingController = new WiseSayingController();
    }
}
