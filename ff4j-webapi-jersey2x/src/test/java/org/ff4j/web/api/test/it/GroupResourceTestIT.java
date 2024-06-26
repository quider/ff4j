package org.ff4j.web.api.test.it;

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

import static org.ff4j.test.TestsFf4jConstants.F3;
import static org.ff4j.test.TestsFf4jConstants.F4;
import static org.ff4j.test.TestsFf4jConstants.G1;
import static org.ff4j.utils.json.FeatureJsonParser.parseFeatureArray;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.ff4j.core.Feature;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Unit testing of resource Groups/group
 *
 * @author <a href="mailto:cedrick.lunven@gmail.com">Cedrick LUNVEN</a>
 */
public class GroupResourceTestIT extends AbstractWebResourceTestIT {

	/** Logger. */
	private static Logger LOGGER = LoggerFactory.getLogger(GroupResourceTestIT.class);
	
    /**
     * TDD
     */
    @Test
    public void testGetReadGroup() {
        // Given
        assertFF4J.assertThatGroupExist(G1);
        assertFF4J.assertThatGroupHasSize(2, G1);
        assertFF4J.assertThatFeatureIsInGroup(F3, G1);
        assertFF4J.assertThatFeatureIsInGroup(F4, G1);
        // When
        WebTarget wResFeatures = resourceGroups().path(G1);
        Response resHttp = wResFeatures.request().get();
        String resEntity = resHttp.readEntity(String.class);
        // Then, HTTPResponse
        Assert.assertEquals("Expected status is 200", Status.OK.getStatusCode(), resHttp.getStatus());
        // Then, Entity Object
        Assert.assertNotNull(resEntity);
        Feature[] f = parseFeatureArray(resEntity);
        Set<String> features = new HashSet<String>();
        for (Feature feature : f) {
            features.add(feature.getUid());
        }
        Assert.assertEquals(2, features.size());
        Assert.assertTrue(features.contains(F3));
        Assert.assertTrue(features.contains(F4));
    }
    
    @Test
    public void getGroupNotFound() {
    	LOGGER.debug("TODO [getGroupNotFound]");
    }
    
    @Test
    public void testPostEnableGroup() {
    	LOGGER.debug("TODO [testPostEnableGroup]");
    }

    @Test
    public void testPostEnableGroupNotFound() {
    	LOGGER.debug("TODO [testPostEnableGroupNotFound]");
    }

    @Test
    public void testPostDisableGroup() {
    	LOGGER.debug("TODO [testPostDisableGroup]");
    }
    
    @Test
    public void testPostDisableGroupNotFound() {
    	LOGGER.debug("TODO [testPostDisableGroupNotFound]");
    }
}
