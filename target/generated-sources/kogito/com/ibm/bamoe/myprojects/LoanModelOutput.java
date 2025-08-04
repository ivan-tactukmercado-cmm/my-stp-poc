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

import org.kie.kogito.MapInput;
import org.kie.kogito.MapInputId;
import org.kie.kogito.MapOutput;
import java.util.Map;
import java.util.HashMap;
import org.kie.kogito.MappableToModel;
import org.kie.kogito.Model;

@org.kie.kogito.codegen.Generated(value = "kogito-codegen", reference = "loan", name = "Loan", hidden = true)
public class LoanModelOutput implements org.kie.kogito.Model, MapInput, MapInputId, MapOutput, MappableToModel<LoanModel> {

    private String id;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

    @org.kie.kogito.codegen.VariableInfo(tags = "")
    @com.fasterxml.jackson.annotation.JsonProperty(value = "amount")
    @jakarta.validation.Valid()
    private java.lang.Integer amount;

    public java.lang.Integer getAmount() {
        return amount;
    }

    public void setAmount(java.lang.Integer amount) {
        this.amount = amount;
    }

    @org.kie.kogito.codegen.VariableInfo(tags = "")
    @com.fasterxml.jackson.annotation.JsonProperty(value = "creditScore")
    @jakarta.validation.Valid()
    private java.lang.Integer creditScore;

    public java.lang.Integer getCreditScore() {
        return creditScore;
    }

    public void setCreditScore(java.lang.Integer creditScore) {
        this.creditScore = creditScore;
    }

    @org.kie.kogito.codegen.VariableInfo(tags = "")
    @com.fasterxml.jackson.annotation.JsonProperty(value = "approved")
    @jakarta.validation.Valid()
    private java.lang.Boolean approved;

    public java.lang.Boolean getApproved() {
        return approved;
    }

    public void setApproved(java.lang.Boolean approved) {
        this.approved = approved;
    }

    @org.kie.kogito.codegen.VariableInfo(tags = "")
    @com.fasterxml.jackson.annotation.JsonProperty(value = "intrestRate")
    @jakarta.validation.Valid()
    private java.lang.Integer intrestRate;

    public java.lang.Integer getIntrestRate() {
        return intrestRate;
    }

    public void setIntrestRate(java.lang.Integer intrestRate) {
        this.intrestRate = intrestRate;
    }

    @org.kie.kogito.codegen.VariableInfo(tags = "")
    @com.fasterxml.jackson.annotation.JsonProperty(value = "drugsPing")
    @jakarta.validation.Valid()
    private java.lang.Object drugsPing;

    public java.lang.Object getDrugsPing() {
        return drugsPing;
    }

    public void setDrugsPing(java.lang.Object drugsPing) {
        this.drugsPing = drugsPing;
    }

    @Override()
    public LoanModel toModel() {
        LoanModel result = new LoanModel();
        result.setId(getId());
        result.setAmount(getAmount());
        result.setCreditScore(getCreditScore());
        result.setApproved(getApproved());
        result.setIntrestRate(getIntrestRate());
        result.setDrugsPing(getDrugsPing());
        return result;
    }
}
