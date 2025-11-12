package com.back;

import com.back.domain.wiseSaying.controller.WiseSayingController;
import com.back.domain.wiseSaying.service.WiseSayingService;

import java.util.Scanner;

public class AppContext {
    public static Scanner scanner;
    public static WiseSayingController wiseSayingController;
    public static WiseSayingService wiseSayingService;

    public static void renew(Scanner scanner) {
        AppContext.scanner = scanner;
        AppContext.wiseSayingService = new WiseSayingService();
        AppContext.wiseSayingController = new WiseSayingController();
    }
}
