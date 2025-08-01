package com.ibm.bamoe.myprojects;

import com.ibm.bamoe.myprojects.LoanModel;

public class LoanProcessInstance extends org.kie.kogito.process.impl.AbstractProcessInstance<LoanModel> {

    public LoanProcessInstance(com.ibm.bamoe.myprojects.LoanProcess process, LoanModel value, org.kie.api.runtime.process.ProcessRuntime processRuntime) {
        super(process, value, processRuntime);
    }

    public LoanProcessInstance(com.ibm.bamoe.myprojects.LoanProcess process, LoanModel value, java.lang.String businessKey, org.kie.api.runtime.process.ProcessRuntime processRuntime) {
        super(process, value, businessKey, processRuntime);
    }

    public LoanProcessInstance(com.ibm.bamoe.myprojects.LoanProcess process, LoanModel value, org.kie.api.runtime.process.ProcessRuntime processRuntime, org.kie.api.runtime.process.WorkflowProcessInstance wpi) {
        super(process, value, processRuntime, wpi);
    }

    public LoanProcessInstance(com.ibm.bamoe.myprojects.LoanProcess process, LoanModel value, org.kie.api.runtime.process.WorkflowProcessInstance wpi) {
        super(process, value, wpi);
    }

    public LoanProcessInstance(com.ibm.bamoe.myprojects.LoanProcess process, LoanModel value, java.lang.String businessKey, org.kie.api.runtime.process.ProcessRuntime processRuntime, org.kie.kogito.correlation.CompositeCorrelation correlation) {
        super(process, value, businessKey, processRuntime, correlation);
    }

    protected java.util.Map<String, Object> bind(LoanModel variables) {
        if (null != variables)
            return variables.toMap();
        else
            return new java.util.HashMap();
    }

    protected void unbind(LoanModel variables, java.util.Map<String, Object> vmap) {
        variables.fromMap(this.id(), vmap);
    }
}
