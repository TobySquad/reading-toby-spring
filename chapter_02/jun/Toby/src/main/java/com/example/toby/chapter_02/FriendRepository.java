package com.example.toby.chapter_02;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class FriendRepository {

    private static final Map<Long, Friend> repository = new ConcurrentHashMap<>();
    private static final AtomicLong sequence = new AtomicLong(0L);

    public Friend join(Friend friend) {
        repository.put(friend.getId(), friend);
        return repository.get(friend.getId());
    }

    public static Long getSequence() {
        return sequence.incrementAndGet();
    }
}


