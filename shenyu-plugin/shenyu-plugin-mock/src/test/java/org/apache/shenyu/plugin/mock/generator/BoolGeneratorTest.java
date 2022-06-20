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

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * The test case for {@link BoolGenerator}.
 */
public class BoolGeneratorTest {
    
    private final BoolGenerator boolGenerator = new BoolGenerator();
    
    @Test
    public void testGenerate() {
        boolGenerator.parseRule("bool");
        Boolean generate = boolGenerator.generate();
        Assertions.assertNotNull(generate);
        
    }
    
    @Test
    public void testMatch() {
        assertTrue(boolGenerator.match("bool"));
        assertFalse(boolGenerator.match("boolean"));
        
    }
}
