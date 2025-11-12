package com.back;

import com.back.domain.system.controller.SystemController;
import com.back.domain.wiseSaying.WiseSayingRepository;
import com.back.domain.wiseSaying.controller.WiseSayingController;
import com.back.domain.wiseSaying.service.WiseSayingService;

import java.util.Scanner;

public class AppContext {
    public static Scanner scanner;

    public static WiseSayingController wiseSayingController;
    public static WiseSayingService wiseSayingService;
    public static WiseSayingRepository wiseSayingRepository;

    public static SystemController systemController;

    public static void renew(Scanner scanner) {
        AppContext.scanner = scanner;

        AppContext.wiseSayingRepository = new WiseSayingRepository();
        AppContext.wiseSayingService = new WiseSayingService();
        AppContext.wiseSayingController = new WiseSayingController();

        AppContext.systemController = new SystemController();
    }
}
