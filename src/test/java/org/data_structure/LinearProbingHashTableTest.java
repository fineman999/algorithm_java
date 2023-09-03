package org.data_structure;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class LinearProbingHashTableTest {

    @Test
    @DisplayName("충돌이 발생할 경우 다음 버킷에 저장")
    void test() {
        LinearProbingHashTable<Object, Object> hashTable = new LinearProbingHashTable<>(10);
        hashTable.put("강호동", "010-1111-1111");
        hashTable.put("유재석", "010-2222-2222");
        hashTable.put("신동엽", "010-3333-3333");

        assertAll(
                () -> assertThat(hashTable.get("강호동")).isEqualTo("010-1111-1111"),
                () -> assertThat(hashTable.get("유재석")).isEqualTo("010-2222-2222"),
                () -> assertThat(hashTable.get("신동엽")).isEqualTo("010-3333-3333")
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
                () -> assertThat(hashTable.get("유재석")).isEqualTo("010-2222-2222"),
                () -> assertThat(hashTable.get("신동엽")).isEqualTo("010-3333-3333")
        );
    }

    @Test
    @DisplayName("용량을 초과할 경우")
    void test2() {
        LinearProbingHashTable<Object, Object> hashTable = new LinearProbingHashTable<>(5);
        hashTable.put("강호동", "010-1111-1111");
        hashTable.put("유재석", "010-2222-2222");
        hashTable.put("신동엽", "010-3333-3333");
        hashTable.put("이수근", "010-4444-4444");
        hashTable.put("이광수", "010-5555-5555");
        hashTable.put("송지효", "010-6666-6666");


        assertAll(
                () -> assertThat(hashTable.size()).isEqualTo(6),
                () -> assertThat(hashTable.getCapacity()).isEqualTo(10),
                () -> assertThat(hashTable.get("이수근")).isEqualTo("010-4444-4444"),
                () -> assertThat(hashTable.get("강호동")).isEqualTo("010-1111-1111"),
                () -> assertThat(hashTable.get("유재석")).isEqualTo("010-2222-2222"),
                () -> assertThat(hashTable.get("신동엽")).isEqualTo("010-3333-3333")
        );
    }
}