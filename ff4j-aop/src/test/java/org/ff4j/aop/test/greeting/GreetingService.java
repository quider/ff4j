package org.ff4j.aop.test.greeting;

/*-
 * #%L
 * ff4j-aop
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

import org.ff4j.aop.Flip;

public interface GreetingService {

	@Flip(name = "language-french", alterBean = "greeting.french")
	String sayHello(String name);

	@Flip(name = "language-french", alterClazz = GreetingServiceFrenchImpl.class)
	String sayHelloWithClass(String name);

}
