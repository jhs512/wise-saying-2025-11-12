package com.back.domain.wiseSaying;

import com.back.WiseSaying;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class WiseSayingRepository {
    private int lastId = 0;
    private final List<WiseSaying> wiseSayings = new ArrayList<>();

    public void save(WiseSaying wiseSaying) {
        if (wiseSaying.isNew()) {
            wiseSaying.setId(++lastId);
            wiseSayings.add(wiseSaying);
        }
    }

    public List<WiseSaying> findAll(int pageSize, int pageNo) {
        return
                wiseSayings
                        .reversed()
                        .stream()
                        .skip((long) (pageNo - 1) * pageSize)
                        .limit(pageSize)
                        .toList();
    }

    public boolean deleteById(int id) {
        int index = findIndexById(id);

        if (index == -1) return false;

        wiseSayings.remove(index);

        return true;
    }

    private int findIndexById(int id) {
        return IntStream.range(0, wiseSayings.size())
                .filter(i -> wiseSayings.get(i).getId() == id)
                .findFirst()
                .orElse(-1);
    }

    public WiseSaying findById(int id) {
        return wiseSayings
                .stream()
                .filter(w -> w.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public List<WiseSaying> findByContentContaining(String keyword, int pageSize, int pageNo) {
        return wiseSayings
                .reversed()
                .stream()
                .filter(w -> w.getContent().contains(keyword))
                .skip((long) (pageNo - 1) * pageSize)
                .limit(pageSize)
                .toList();
    }

    public List<WiseSaying> findByAuthorContaining(String keyword, int pageSize, int pageNo) {
        return wiseSayings
                .reversed()
                .stream()
                .filter(w -> w.getAuthor().contains(keyword))
                .skip((long) (pageNo - 1) * pageSize)
                .limit(pageSize)
                .toList();
    }

    public List<WiseSaying> findByContentContainingOrAuthorContaining(String keyword, String _keyword, int pageSize, int pageNo) {
        return wiseSayings
                .reversed()
                .stream()
                .filter(w -> w.getContent().contains(keyword) || w.getAuthor().contains(keyword))
                .skip((long) (pageNo - 1) * pageSize)
                .limit(pageSize)
                .toList();
    }
}
