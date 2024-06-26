package org.ff4j.core;

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

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Pojo holding an execution context to perform {@link FlippingStrategy} evaluations.
 *
 * @author Cedrick Lunven (@clunven)
 */
public class FlippingExecutionContext {

    /** Current Parameter Map. */
    private transient Map<String, Object> parameters = new HashMap<String, Object>();

    /**
     * Default Constructor.
     */
    public FlippingExecutionContext() {}

    /**
     * Initializing context.
     * 
     * @param init
     *            initialisation for parameters.
     */
    public FlippingExecutionContext(Map<String, Object> init) {
        this.parameters = init;
    }

    /**
     * Initializing context.
     *
     * @param executionContext
     *            An existing execution context to copy.
     */
    public FlippingExecutionContext(FlippingExecutionContext executionContext) {
        this.parameters.putAll(executionContext.parameters);
    }

    /**
     * Get Raw value of the parameter map.
     * 
     * @param key
     *            current key
     * @return object if present in map
     */
    public Object getValue(String key, boolean required) {
        if (!parameters.containsKey(key)) {
            if (required) {
                throw new IllegalArgumentException("Parameter '" + key
                        + "' has not been found but it's required to evaluate strategy");
            }
            return null;
        }
        return parameters.get(key);
    }

    /**
     * Check inexistence of key within map
     * 
     * @param key
     *            target parameter key
     * @return if the parameter exist
     */
    public boolean containsKey(String key) {
        return parameters.containsKey(key);
    }

    /**
     * Add a value to the parameter list.
     * 
     * @param key
     *            target key
     * @param value
     *            target value
     */
    public void addValue(String key, Object value) {
        parameters.put(key, value);
    }

    /**
     * Convenient method to get a string value.
     * 
     * @param key
     *            current key
     * @param required
     *            if value is required
     */
    public String getString(String key, boolean required) {
        Object o = getValue(key, required);
        if (o != null && !(o instanceof String)) {
            throw new IllegalArgumentException("Cannot convert parameter to String");
        }
        return (String) o;
    }

    /**
     * Convenient method to get a string value.
     * 
     * @param key
     *            current key
     * @param required
     *            if value is required
     */
    public Boolean getBoolean(String key) {
        return this.getBoolean(key, false);
    }

    /**
     * Convenient method to get a string value.
     * 
     * @param key
     *            current key
     * @param required
     *            if value is required
     */
    public Boolean getBoolean(String key, boolean required) {
        Object o = getValue(key, required);
        if (o != null && !(o instanceof Boolean)) {
            throw new IllegalArgumentException("Cannot convert parameter to Boolean");
        }
        return (Boolean) o;
    }


    /**
     * Convenient method to get a string value.
     * 
     * @param key
     *            current key
     * @param required
     *            if value is required
     */
    public Integer getInt(String key) {
        return this.getInt(key, false);
    }

    /**
     * Convenient method to get a string value.
     * 
     * @param key
     *            current key
     * @param required
     *            if value is required
     */
    public Integer getInt(String key, boolean required) {
        Object o = getValue(key, required);
        if (o != null && !(o instanceof Integer)) {
            throw new IllegalArgumentException("Cannot convert parameter to Integer it");
        }
        return (Integer) o;
    }

    /**
     * Convenient method to get a string value.
     * 
     * @param key
     *            current key
     * @param required
     *            if value is required
     */
    public Double getDouble(String key) {
        return this.getDouble(key, false);
    }

    /**
     * Convenient method to get a string value.
     * 
     * @param key
     *            current key
     * @param required
     *            if value is required
     */
    public Double getDouble(String key, boolean required) {
        Object o = getValue(key, required);
        if (o != null && !(o instanceof Double)) {
            throw new IllegalArgumentException("Cannot convert parameter to Double");
        }
        return (Double) o;
    }

    /**
     * Convenient method to get a string value.
     * 
     * @param key
     *            current key
     * @param required
     *            if value is required
     */
    public Date getDate(String key) {
        return this.getDate(key, false);
    }

    /**
     * Convenient method to get a string value.
     * 
     * @param key
     *            current key
     * @param required
     *            if value is required
     */
    public Date getDate(String key, boolean required) {
        Object o = getValue(key, required);
        if (o != null && !(o instanceof Date)) {
            throw new IllegalArgumentException("Cannot convert parameter to Date");
        }
        return (Date) o;
    }

    /**
     * Default get Value.
     * 
     * @param key
     *            target key
     */
    public String getString(String key) {
        return getString(key, false);
    }

    /**
     * Convenient method to add a parameter of type {@link String}.
     * 
     * @param key
     *            current ley of the parameters
     * @param value
     *            value of the parameter
     */
    public void putString(String key, String value) {
        this.addValue(key, value);
    }

    /**
     * Convenient method to add a parameter of type {@link String}.
     * 
     * @param key
     *            current ley of the parameters
     * @param value
     *            value of the parameter
     */
    public void putBoolean(String key, Boolean value) {
        this.addValue(key, value);
    }

    /**
     * Convenient method to add a parameter of type {@link String}.
     * 
     * @param key
     *            current ley of the parameters
     * @param value
     *            value of the parameter
     */
    public void putDate(String key, Date value) {
        this.addValue(key, value);
    }

    /**
     * Convenient method to add a parameter of type {@link String}.
     * 
     * @param key
     *            current ley of the parameters
     * @param value
     *            value of the parameter
     */
    public void putInt(String key, Integer value) {
        this.addValue(key, value);
    }

    /**
     * Convenient method to add a parameter of type {@link String}.
     * 
     * @param key
     *            current ley of the parameters
     * @param value
     *            value of the parameter
     */
    public void putDouble(String key, Double value) {
        this.addValue(key, value);
    }

    /**
     * Check if the current flipping execution is empty or not.
     *
     * @return {@code true} if execution context is empty, false otherwise.
     */
    public boolean isEmpty() {
        return parameters.isEmpty();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (obj instanceof FlippingExecutionContext) {
            FlippingExecutionContext ctx = (FlippingExecutionContext) obj;
            return Objects.equals(parameters, ctx.parameters);
        }

        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(parameters);
    }
}
