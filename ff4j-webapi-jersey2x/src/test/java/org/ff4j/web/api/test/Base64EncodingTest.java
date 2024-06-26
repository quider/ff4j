package org.ff4j.web.api.test;

/*-
 * #%L
 * ff4j-webapi-jersey2x
 * %%
 * Copyright (C) 2013 - 2024 FF4J
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import java.util.Base64;

import org.junit.Assert;

import org.junit.Test;


/**
 * Encoder to test basic authentication.
 *
 * @author <a href="mailto:cedrick.lunven@gmail.com">Cedrick LUNVEN</a>
 */
public class Base64EncodingTest {

    @Test
    public void testProduceHTTBasicHeader() {
        // Given
        String basicAuthCreds = "login:pwd";
        // When
        String base64 = new String(Base64.getEncoder().encodeToString(basicAuthCreds.getBytes()));
        // Then
        Assert.assertEquals("bG9naW46cHdk", base64);  
    }

}
