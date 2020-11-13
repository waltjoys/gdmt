package com.joys.gdmt.Mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RoleMapperTest {
    @Autowired
    RoleMapper mapper;

    @Test
    void test() {
        mapper.getresid(1).forEach(e -> {
            System.out.println(e);
        });
    }
}