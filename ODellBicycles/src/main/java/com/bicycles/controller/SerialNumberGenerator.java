package com.bicycles.controller;

/*Licensed to the Apache Software Foundation (ASF) under one
or more contributor license agreements.  See the NOTICE file
distributed with this work for additional information
regarding copyright ownership.  The ASF licenses this file
to you under the Apache License, Version 2.0 (the
"License"); you may not use this file except in compliance
with the License.  You may obtain a copy of the License at

  http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing,
software distributed under the License is distributed on an
"AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
KIND, either express or implied.  See the License for the
specific language governing permissions and limitations
under the License.
*/

/* Implementing the Singleton Pattern */
public class SerialNumberGenerator {

    private static SerialNumberGenerator generate;
    private int startValue;
    private String prefixValue;

    public static synchronized SerialNumberGenerator getInstance() {
        if(generate == null) {
            generate = new SerialNumberGenerator();
        }
        return generate;
    }

    private SerialNumberGenerator() {}

    public synchronized void startGeneration(String model, int startNumber) {
        prefixValue = model;
        startValue = startNumber;
    }

    public synchronized String getNextSerial() {
        return prefixValue + (++startValue);
    }

    public synchronized int getRecentNumber() {
        return startValue;
    }

}
