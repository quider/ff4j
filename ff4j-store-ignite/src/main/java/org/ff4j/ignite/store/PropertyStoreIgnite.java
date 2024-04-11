package org.ff4j.ignite.store;

/*-
 * #%L
 * ff4j-store-ignite
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

import org.apache.ignite.Ignite;
import org.apache.ignite.configuration.IgniteConfiguration;
import org.ff4j.cache.FF4JCacheManager;
import org.ff4j.core.FeatureStore;
import org.ff4j.ignite.FF4jCacheManagerIgnite;
import org.ff4j.store.FeatureStoreJCache;
import org.ff4j.store.PropertyStoreJCache;


/**
 * Implementation of {@link FeatureStore} for ignite.
 *
 * @author Cedrick LUNVEN (@clunven)
 */
public class PropertyStoreIgnite extends PropertyStoreJCache {

    /**
     * Default constructor.
     */
    public PropertyStoreIgnite() {
        this(new FF4jCacheManagerIgnite());
    }
    
    /**
     * Default constructor.
     */
    public PropertyStoreIgnite(String xmlConfigFileName) {
        this(new FF4jCacheManagerIgnite(xmlConfigFileName));
    }
            
    /**
     * Leverage on JCACHE but initialize from ignite.
     *
     * @param cacheManager
     */
    public PropertyStoreIgnite(IgniteConfiguration igniteConfig) {
        this(new FF4jCacheManagerIgnite(igniteConfig));
    }
    
    /**
     * Leverage on JCACHE but initialize from ignite.
     *
     * @param cacheManager
     */
    public PropertyStoreIgnite(Ignite ignite) {
        this(new FF4jCacheManagerIgnite(ignite));
    }
    
    /**
     * Init from ignite, cast manager (logic in {@link FeatureStoreJCache}).
     * 
     * @param cacheManager
     *      implementation of {@link FF4JCacheManager} for hazel cast
     */
    private PropertyStoreIgnite(FF4jCacheManagerIgnite cacheManager) {
        super(cacheManager);
    }

}
