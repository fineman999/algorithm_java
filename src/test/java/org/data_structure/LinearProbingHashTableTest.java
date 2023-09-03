package org.data_structure;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LinearProbingHashTableTest {

    @Test
    @DisplayName("충돌이 발생할 경우 다음 버킷에 저장")
    void test() {
        LinearProbingHashTable<Object, Object> hashTable = new LinearProbingHashTable<>(10);
        hashTable.put("강호동", "010-1111-1111");
        hashTable.put("유재석", "010-2222-2222");
        hashTable.put("신동엽", "010-3333-3333");

        assertAll(
                () -> assertEquals("010-1111-1111", hashTable.get("강호동")),
                () -> assertEquals("010-2222-2222", hashTable.get("유재석")),
                () -> assertEquals("010-3333-3333", hashTable.get("신동엽"))
        );
    }
}