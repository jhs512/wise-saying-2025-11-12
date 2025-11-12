package com.back;

import com.back.domain.wiseSaying.controller.WiseSayingController;

import java.util.Scanner;

public class App {
    private final Scanner scanner = AppContext.scanner;

    public void run() {
        System.out.println("== 명언 앱 ==");

        WiseSayingController wiseSayingController = AppContext.wiseSayingController;

        while (true) {
            System.out.print("명령) ");
            String cmd = scanner.nextLine().trim();

            switch (cmd) {
                case "종료" -> {
                    System.out.println("프로그램이 종료되었습니다.");
                    return;
                }
                case "등록" -> {
                    wiseSayingController.actionWrite();
                }
                case "목록" -> {
                    wiseSayingController.actionList();
                }
            }
        }
    }
}
