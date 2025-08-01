/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package com.ibm.bamoe.myprojects;

import java.util.Map;
import org.kie.kogito.UserTask;
import org.kie.kogito.UserTaskParam.ParamType;
import org.kie.kogito.UserTaskParam;

@UserTask(taskName = "Rest", processName = "loan")
public class Loan__7DDEBFF4_B2C3_476B_9DB5_24D1646A3F8E_TaskInput {

    public static Loan__7DDEBFF4_B2C3_476B_9DB5_24D1646A3F8E_TaskInput fromMap(Map<String, Object> params) {
        Loan__7DDEBFF4_B2C3_476B_9DB5_24D1646A3F8E_TaskInput item = new Loan__7DDEBFF4_B2C3_476B_9DB5_24D1646A3F8E_TaskInput();
        item.Url = (java.lang.String) params.get("Url");
        return item;
    }

    @UserTaskParam(value = ParamType.INPUT)
    private java.lang.String Url;

    public java.lang.String getUrl() {
        return Url;
    }

    public void setUrl(java.lang.String Url) {
        this.Url = Url;
    }
}
//Task input for user task 'REST' in process 'loan'
