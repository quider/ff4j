package org.ff4j.test;

/*-
 * #%L
 * ff4j-core
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

/**
 * For coherence, each store implementation will be tested with same dataset. Here are the constants contains in this DATASET.
 * 
 * @author Cedrick Lunven (@clunven)
 */
public interface TestConstantsFF4j {

    /** Initial feature number. */
    int EXPECTED_FEATURES_NUMBERS = 5;

    /** Feature Name. */
    String F1 = "first";

    /** Feature Name. */
    String F2 = "second";

    /** Feature Name. */
    String F3 = "third";

    /** Feature Name. */
    String F4 = "forth";

    /** Group Name. */
    String G0 = "GRP0";

    /** Group Name. */
    String G1 = "GRP1";

    /** Group Name. */
    String F_DOESNOTEXIST = "invalid-feature-id";

    /** Group Name. */
    String G_DOESNOTEXIST = "invalid-group-name";

    /** Feature Name. */
    String FEATURE_NEW = "new";

    /** Feature Name. */
    String ROLE_USER = "USER";

    /** Feature Name. */
    String ROLE_ADMIN = "ADMINISTRATOR";

    /** Feature Name. */
    String ROLE_TEST = "BETA-TESTER";

    /** Feature Name. */
    String ROLE_NEW = "ROLE_NEW";

}
