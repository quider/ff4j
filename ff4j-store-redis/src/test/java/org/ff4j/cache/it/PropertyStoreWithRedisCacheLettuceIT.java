package org.ff4j.cache.it;

/*
 * #%L
 * ff4j-store-redis
 * %%
 * Copyright (C) 2021 FF4J
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

import io.lettuce.core.RedisClient;
import org.ff4j.cache.FF4JCacheManager;
import org.ff4j.cache.FF4jCacheManagerRedisLettuce;
import org.junit.Ignore;

/**
 * Test FF4jCacheManagerRedisLettuce caching of properties.
 *
 * @author <a href="https://github.com/mrgrew">Greg Wiley</a>
 *
 * Ignore because Docker may not be available in all cases.
 */
@Ignore
public class PropertyStoreWithRedisCacheLettuceIT extends RedisTestSupport {

    @Override
    protected FF4JCacheManager makeCache() {
        String redisUri = String.format("redis://%s:%d", redis.getHost(), redis.getFirstMappedPort());
        return new FF4jCacheManagerRedisLettuce( RedisClient.create(redisUri) );
    }

}