package com.back.domain.wiseSaying.service;

import com.back.WiseSaying;

import java.util.ArrayList;
import java.util.List;

public class WiseSayingService {
    private int lastId = 0;
    private final List<WiseSaying> wiseSayings = new ArrayList<>();

    public WiseSaying write(String content, String author) {

        int id = ++lastId;

        WiseSaying wiseSaying = new WiseSaying(id, content, author);

        wiseSayings.add(wiseSaying);

        return wiseSaying;
    }

    public List<WiseSaying> findAll() {
        return wiseSayings.reversed();
    }
}
