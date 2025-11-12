package com.back.domain.wiseSaying.controller;

import com.back.AppContext;
import com.back.WiseSaying;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WiseSayingController {
    private int lastId = 0;
    private final List<WiseSaying> wiseSayings = new ArrayList<>();
    private final Scanner scanner = AppContext.scanner;

    public void actionWrite() {

        System.out.print("명언 : ");
        String content = scanner.nextLine().trim();
        System.out.print("작가 : ");
        String author = scanner.nextLine().trim();

        int id = ++lastId;

        wiseSayings.add(new WiseSaying(id, content, author));

        System.out.printf("%d번 명언이 등록되었습니다.\n", id);
    }

    public void actionList() {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------------");

        for (WiseSaying wiseSaying : wiseSayings.reversed()) {
            System.out.printf("%d / %s / %s\n", wiseSaying.getId(), wiseSaying.getAuthor(), wiseSaying.getContent());
        }
    }
}
