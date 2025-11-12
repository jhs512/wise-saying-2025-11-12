package com.back.domain.wiseSaying.service;

import com.back.AppContext;
import com.back.WiseSaying;
import com.back.domain.wiseSaying.WiseSayingRepository;

import java.util.List;

public class WiseSayingService {
    private final WiseSayingRepository wiseSayingRepository = AppContext.wiseSayingRepository;

    public WiseSaying write(String content, String author) {
        WiseSaying wiseSaying = new WiseSaying(content, author);

        wiseSayingRepository.save(wiseSaying);

        return wiseSaying;
    }

    public List<WiseSaying> findForList(String keywordType, String keyword, int pageSize, int pageNo) {
        if (keyword.isBlank()) {
            return wiseSayingRepository.findAll(pageSize, pageNo);
        }

        return switch (keywordType) {
            case "content" -> wiseSayingRepository.findByContentContaining(keyword, pageSize, pageNo);
            case "author" -> wiseSayingRepository.findByAuthorContaining(keyword, pageSize, pageNo);
            default ->
                    wiseSayingRepository.findByContentContainingOrAuthorContaining(keyword, keyword, pageSize, pageNo);
        };
    }

    public boolean delete(int id) {
        return wiseSayingRepository.deleteById(id);
    }

    public void modify(WiseSaying wiseSaying, String content, String author) {
        wiseSaying.setContent(content);
        wiseSaying.setAuthor(author);

        wiseSayingRepository.save(wiseSaying);
    }

    public WiseSaying findById(int id) {
        return wiseSayingRepository.findById(id);
    }
}
