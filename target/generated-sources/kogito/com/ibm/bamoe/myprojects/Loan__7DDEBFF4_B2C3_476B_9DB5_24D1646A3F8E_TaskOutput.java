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

import java.util.HashMap;
import java.util.Map;
import org.kie.kogito.MapOutput;
import org.kie.kogito.UserTask;
import org.kie.kogito.UserTaskParam.ParamType;
import org.kie.kogito.UserTaskParam;

@UserTask(taskName = "Rest", processName = "loan")
public class Loan__7DDEBFF4_B2C3_476B_9DB5_24D1646A3F8E_TaskOutput implements MapOutput {

    @Override
    public Map<String, Object> toMap() {
        Map<String, Object> params = new HashMap<>();
        params.put("Result", this.Result);
        return params;
    }

    public static Loan__7DDEBFF4_B2C3_476B_9DB5_24D1646A3F8E_TaskOutput fromMap(Map<String, Object> params) {
        com.ibm.bamoe.myprojects.Loan__7DDEBFF4_B2C3_476B_9DB5_24D1646A3F8E_TaskOutput result = new Loan__7DDEBFF4_B2C3_476B_9DB5_24D1646A3F8E_TaskOutput();
        result.Result = (java.lang.Object) params.get("Result");
        return result;
    }

    @UserTaskParam(value = ParamType.OUTPUT)
    private java.lang.Object Result;

    public java.lang.Object getResult() {
        return Result;
    }

    public void setResult(java.lang.Object Result) {
        this.Result = Result;
    }
}
//Task output for user task 'REST' in process 'loan'
