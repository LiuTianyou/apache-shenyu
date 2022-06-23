/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.shenyu.plugin.mock.generator;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.apache.shenyu.plugin.mock.generator.impl.ZhStringGenerator;
import org.junit.jupiter.api.Test;

/**
 * The test case for {@link ZhStringGenerator}.
 * @date 2022/6/20 15:44
 */
class ZhStringGeneratorTest {
    
    private final ZhStringGenerator generator = new ZhStringGenerator();
    
    @Test
    void generate() {
        int minLength = 10;
        int maxLength = 20;
        generator.parseRule(String.format("zh|%d-%d", minLength, maxLength));
        String generate = generator.generate();
        assertTrue(
            generate != null && generate.length() >= minLength && generate.length() <= maxLength);
    }
    
    @Test
    void match() {
    }
}
