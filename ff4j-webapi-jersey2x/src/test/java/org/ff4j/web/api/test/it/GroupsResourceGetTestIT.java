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

import java.util.List;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.ff4j.web.api.resources.domain.GroupDescApiBean;
import org.junit.Assert;
import org.junit.Test;

/**
 * Unit testing of resource 'Groups'
 * 
 * @author <a href="mailto:cedrick.lunven@gmail.com">Cedrick LUNVEN</a>
 */
public class GroupsResourceGetTestIT extends AbstractWebResourceTestIT {

    /**
     * TDD.
     */
    @Test
    public void getGroups() {
        // Given
        Assert.assertEquals(2, ff4j.getFeatureStore().readAllGroups().size());
        // When
        WebTarget wResFeatures = resourceGroups();
        Response resHttp = wResFeatures.request().get();
        List<GroupDescApiBean> groupApiBeans = resHttp.readEntity(new GenericType<List<GroupDescApiBean>>() {});
        // Then, HTTPResponse
        Assert.assertEquals("Expected status is 200", Status.OK.getStatusCode(), resHttp.getStatus());
        // Then, Entity Object
        Assert.assertNotNull(groupApiBeans);
        Assert.assertEquals(2, groupApiBeans.size());
    }

}
