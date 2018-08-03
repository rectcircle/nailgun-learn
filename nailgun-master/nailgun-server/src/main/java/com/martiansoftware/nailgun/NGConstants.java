/*   

 Copyright 2004-2012, Martian Software, Inc.

 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.

 */
package com.martiansoftware.nailgun;

import java.io.InputStream;
import java.util.Properties;

/**
 * Just a simple holder for various NailGun-related contants.
 *
 * @author <a href="http://www.martiansoftware.com/contact.html">Marty Lamb</a>
 */
public class NGConstants {

    /**
     * The default NailGun port (2113)
     */
    public static final int DEFAULT_PORT = 2113;
    /**
     * The exit code sent to clients if nail completed successfully
     */
    public static final int EXIT_SUCCESS = 0;
    /**
     * The exit code sent to clients if an exception occurred on the server
     */
    public static final int EXIT_EXCEPTION = 899;
    /**
     * The exit code sent to clients if an invalid command is sent
     */
    public static final int EXIT_NOSUCHCOMMAND = 898;
    /**
     * Chunk type marker for command line arguments
     */
    public static final byte CHUNKTYPE_ARGUMENT = 'A';
    /**
     * Chunk type marker for client environment variables
     */
    public static final byte CHUNKTYPE_ENVIRONMENT = 'E';
    /**
     * Chunk type marker for the command (alias or class)
     */
    public static final byte CHUNKTYPE_COMMAND = 'C';
    /**
     * Chunk type marker for client working directory
     */
    public static final byte CHUNKTYPE_WORKINGDIRECTORY = 'D';
    /**
     * Chunk type marker for stdin
     */
    public static final byte CHUNKTYPE_STDIN = '0';
    /**
     * Chunk type marker for the end of stdin
     */
    public static final byte CHUNKTYPE_STDIN_EOF = '.';
    /**
     * Chunk type marker for stdout
     */
    public static final byte CHUNKTYPE_STDOUT = '1';
    /**
     * Chunk type marker for stderr
     */
    public static final byte CHUNKTYPE_STDERR = '2';
    /**
     * Chunk type marker for client exit chunks
     */
    public static final byte CHUNKTYPE_EXIT = 'X';
    /**
     * Chunk type marker for a "startinput" chunk. This chunk type is sent from
     * the server to the client and indicates that the client should begin
     * sending stdin to the server. It is automatically sent the first time the
     * client's inputstream is read.
     */
    public static final byte CHUNKTYPE_SENDINPUT = 'S';

    /**
     * Chunk type marker for heartbeats sent to let the server know the client is still alive.
     */
    public static final byte CHUNKTYPE_HEARTBEAT = 'H';

    /**
     * Server version number
     */
    public static final String VERSION;

    /**
     * Expected interval between heartbeats in milliseconds.
     */
    public static final short HEARTBEAT_INTERVAL_MILLIS = 1000;

    /**
     * Maximum interval to wait between heartbeats before considering client to have disconnected.
     */
    public static final short HEARTBEAT_TIMEOUT_MILLIS = 10000;

    /**
     * Maximum time to wait for a Nailgun session to terminate.
     */
    public static final int SESSION_TERMINATION_TIMEOUT_MILLIS = 30000;

    /**
     * Maximum chunk len sent from client.
     */
    public static final short MAXIMUM_CHUNK_LENGTH = 2048;

    /**
     * Returns the Nailgun version number
     *
     * @return the Nailgun version number
     */
    public static String getVersion() {
        String result = "[unknown]";
        return result;
    }

    /**
     * Loads the version number from a file generated by Maven.
     */
    static {
        Properties props = new Properties();
        try (InputStream is = NGConstants.class.getResourceAsStream("/META-INF/maven/com.martiansoftware/nailgun-server/pom.properties")) {
            props.load(is);
        } catch (Exception e) {
            System.err.println("Unable to load nailgun-version.properties.");
        }
        VERSION  = props.getProperty("version", "[UNKNOWN]");
    }
}
