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

package org.apache.shenyu.plugin.mock.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.apache.shenyu.plugin.mock.generator.BoolGenerator;
import org.apache.shenyu.plugin.mock.generator.CnameGenerator;
import org.apache.shenyu.plugin.mock.generator.CurrentTimeGenerator;
import org.apache.shenyu.plugin.mock.generator.EmailGenerator;
import org.apache.shenyu.plugin.mock.generator.EnStringGenerator;
import org.apache.shenyu.plugin.mock.generator.IdCardNumGenerator;
import org.apache.shenyu.plugin.mock.generator.PhoneGenerator;
import org.apache.shenyu.plugin.mock.generator.RandomDoubleGenerator;
import org.apache.shenyu.plugin.mock.generator.RandomIntGenerator;
import org.apache.shenyu.plugin.mock.generator.RangeDataGenerator;
import org.apache.shenyu.plugin.mock.generator.ZhStringGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test case for {@link GenerateUtil}.
 */
class GenerateUtilTest {
    
    private final BoolGenerator boolGenerator = mock(BoolGenerator.class);
    
    private final CnameGenerator cnameGenerator = mock(CnameGenerator.class);
    
    private final CurrentTimeGenerator currentTimeGenerator = mock(CurrentTimeGenerator.class);
    
    private final EmailGenerator emailGenerator = mock(EmailGenerator.class);
    
    private final EnStringGenerator enStringGenerator = mock(EnStringGenerator.class);
    
    private final IdCardNumGenerator idCardNumGenerator = mock(IdCardNumGenerator.class);
    
    private final PhoneGenerator phoneGenerator = mock(PhoneGenerator.class);
    
    private final RangeDataGenerator rangeDataGenerator = mock(RangeDataGenerator.class);
    
    private final ZhStringGenerator zhStringGenerator = mock(ZhStringGenerator.class);
    
    private final RandomDoubleGenerator randomDoubleGenerator = mock(RandomDoubleGenerator.class);
    
    private final RandomIntGenerator randomIntGenerator = mock(RandomIntGenerator.class);
    
    @BeforeEach
    public void setUp() {
        when(boolGenerator.generate()).thenReturn(true);
        when(boolGenerator.match(any())).thenReturn(true);
        when(cnameGenerator.generate()).thenReturn("张小明");
        when(cnameGenerator.match(any())).thenReturn(true);
        when(currentTimeGenerator.generate()).thenReturn("2022-06-20");
        when(currentTimeGenerator.match(any())).thenReturn(true);
        when(emailGenerator.generate()).thenReturn("dev@test.org");
        when(emailGenerator.match(any())).thenReturn(true);
        when(enStringGenerator.generate()).thenReturn("hellohello");
        when(enStringGenerator.match(any())).thenReturn(true);
        when(zhStringGenerator.generate()).thenReturn("你好你好你好");
        when(zhStringGenerator.match(any())).thenReturn(true);
        when(idCardNumGenerator.generate()).thenReturn("110110202206203344");
        when(idCardNumGenerator.match(any())).thenReturn(true);
        when(phoneGenerator.generate()).thenReturn("13800000000");
        when(phoneGenerator.match(any())).thenReturn(true);
        when(rangeDataGenerator.generate()).thenReturn("man");
        when(rangeDataGenerator.match(any())).thenReturn(true);
        when(randomDoubleGenerator.generate()).thenReturn("￥505.50");
        when(randomDoubleGenerator.match(any())).thenReturn(true);
        when(randomIntGenerator.generate()).thenReturn(18);
        when(randomIntGenerator.match(any())).thenReturn(true);
        
        GenerateUtil.addGenerator("bool", boolGenerator);
        GenerateUtil.addGenerator("cname", cnameGenerator);
        GenerateUtil.addGenerator("current", currentTimeGenerator);
        GenerateUtil.addGenerator("email", emailGenerator);
        GenerateUtil.addGenerator("en", enStringGenerator);
        GenerateUtil.addGenerator("zh", zhStringGenerator);
        GenerateUtil.addGenerator("idcard", idCardNumGenerator);
        GenerateUtil.addGenerator("double", randomDoubleGenerator);
        GenerateUtil.addGenerator("phone", phoneGenerator);
        GenerateUtil.addGenerator("list", rangeDataGenerator);
        GenerateUtil.addGenerator("int", randomIntGenerator);
    }
    
    @Test
    public void testDealRule() {
        String content = "{\"name\":${cname},\"age\":${int|10-20},\"gender\":${list|[man,woman]},"
            + "\"registerDate\":${current|YYY-MM-dd},\"phone\":${phone},\"idcard\":${idcard},"
            + "\"email\":${email},\"money\":${double|300-500|￥%.2f},\"desc_en\":${en|5-20},"
            + "\"desc_zh\":${zh|5-20},\"isVip\":${bool}}";
        String s = GenerateUtil.dealRule(content);
        String expected = "{\"name\":\"张小明\",\"age\":18,\"gender\":\"man\","
            + "\"registerDate\":\"2022-06-20\",\"phone\":\"13800000000\","
            + "\"idcard\":\"110110202206203344\",\"email\":\"dev@test.org\","
            + "\"money\":\"￥505.50\",\"desc_en\":\"hellohello\",\"desc_zh\":\"你好你好你好\","
            + "\"isVip\":true}";
        assertEquals(expected, s);
        
    }
    
}
