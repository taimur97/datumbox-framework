/**
 * Copyright (C) 2013-2015 Vasilis Vryniotis <bbriniotis@datumbox.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.datumbox.common.persistentstorage.inmemory;

import com.datumbox.common.persistentstorage.interfaces.DatabaseConfiguration;
import com.datumbox.common.persistentstorage.interfaces.DatabaseConnector;
import java.util.Properties;

/**
 * The InMemoryConfiguration class is used to configure the InMemory persistence
 * storage and generate new storage connections. InMemory storage loads all the
 * data in memory and persists them in serialized files.
 * 
 * @author Vasilis Vryniotis <bbriniotis@datumbox.com>
 */
public class InMemoryConfiguration implements DatabaseConfiguration {
    
    //Mandatory constants
    private static final String DBNAME_SEPARATOR = "_"; //NOT permitted characters are: <>:"/\|?*

    //DB specific properties
    private String outputFolder = "./";
    
    /**
     * It initializes a new connector to the Database.
     * 
     * @param database
     * @return 
     */
    @Override
    public DatabaseConnector getConnector(String database) {
        return new InMemoryConnector(database, this);
    }
    
    /**
     * Returns the separator that is used in the DB names.
     * 
     * @return 
     */
    @Override
    public String getDBnameSeparator() {
        return DBNAME_SEPARATOR;
    }
    
    /**
     * Initializes the InMemoryConfiguration object by using a property file.
     * 
     * @param properties 
     */
    @Override
    public void load(Properties properties) {
        outputFolder = properties.getProperty("dbConfig.InMemoryConfiguration.outputFolder");
    }
    
    /**
     * Getter for the output folder where the InMemory data files are stored.
     * 
     * @return 
     */
    public String getOutputFolder() {
        return outputFolder;
    }
    
    /**
     * Setter for the output folder where the InMemory data files are stored.
     * 
     * @param outputFolder 
     */
    public void setOutputFolder(String outputFolder) {
        this.outputFolder = outputFolder;
    }
}
