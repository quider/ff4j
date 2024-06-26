package org.ff4j.utils;

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


import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Utilities to work with IO and Networking.
 *
 * @author Cedrick Lunven (@clunven)</a>
 */
public class IOUtil {

    /** Would like to use the Inet Component. */
    private static boolean useInetAddress = true;
    
    /**
     * Static
     */
    private IOUtil() {        
    }
     
    /**
     * Read hostName from JDK.
     * 
     * @return
     *      current hostname
     */
    public static String resolveHostName() {
        try {
            if (useInetAddress) {
                return InetAddress.getLocalHost().getHostName();
            }
            throw new UnknownHostException("Do not use the Inet Adress");
        } catch (UnknownHostException e) {
            throw new IllegalArgumentException("Cannot find the target host by itself", e);
        }
    }

    public static boolean isUseInetAddress() {
        return useInetAddress;
    }

    public static void setUseInetAddress(boolean useInetAddress) {
        IOUtil.useInetAddress = useInetAddress;
    }
}
