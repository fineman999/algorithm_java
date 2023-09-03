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

    @Test
    @DisplayName("키값을 제거한 다음 Linear Probing에 의해 생성된 키 값을 가져올 경우")
    void remove() {
        LinearProbingHashTable<Object, Object> hashTable = new LinearProbingHashTable<>(10);
        hashTable.put("강호동", "010-1111-1111");
        hashTable.put("유재석", "010-2222-2222");
        hashTable.put("신동엽", "010-3333-3333");

        hashTable.remove("강호동");

        assertAll(
                () -> assertEquals("010-2222-2222", hashTable.get("유재석")),
                () -> assertEquals("010-3333-3333", hashTable.get("신동엽"))
        );
    }

    @Test
    @DisplayName("용량을 초과할 경우")
    void test2() {
        LinearProbingHashTable<Object, Object> hashTable = new LinearProbingHashTable<>(3);
        hashTable.put("강호동", "010-1111-1111");
        hashTable.put("유재석", "010-2222-2222");
        hashTable.put("신동엽", "010-3333-3333");
        hashTable.put("이수근", "010-4444-4444");

        assertAll(
                () -> assertEquals("010-1111-1111", hashTable.get("강호동")),
                () -> assertEquals("010-2222-2222", hashTable.get("유재석")),
                () -> assertEquals("010-3333-3333", hashTable.get("신동엽")),
                () -> assertEquals("010-4444-4444", hashTable.get("이수근"))
        );
    }
}