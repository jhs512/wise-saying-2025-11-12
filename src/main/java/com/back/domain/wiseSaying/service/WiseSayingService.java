package com.back.domain.wiseSaying.service;

import com.back.AppContext;
import com.back.WiseSaying;
import com.back.domain.wiseSaying.WiseSayingRepository;
import com.back.standard.dto.Pageable;

import java.util.List;

public class WiseSayingService {
    private final WiseSayingRepository wiseSayingRepository = AppContext.wiseSayingRepository;

    public WiseSaying write(String content, String author) {
        WiseSaying wiseSaying = new WiseSaying(content, author);

        wiseSayingRepository.save(wiseSaying);

        return wiseSaying;
    }

    public List<WiseSaying> findForList(String keywordType, String keyword, Pageable pageable) {
        if (keyword.isBlank()) {
            return wiseSayingRepository.findAll(pageable);
        }

        return switch (keywordType) {
            case "content" -> wiseSayingRepository.findByContentContaining(keyword, pageable);
            case "author" -> wiseSayingRepository.findByAuthorContaining(keyword, pageable);
            default ->
                    wiseSayingRepository.findByContentContainingOrAuthorContaining(keyword, keyword, pageable);
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
