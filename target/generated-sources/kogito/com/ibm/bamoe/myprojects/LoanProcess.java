package com.ibm.bamoe.myprojects;

import com.ibm.bamoe.myprojects.LoanModel;
import org.kie.api.definition.process.Process;
import org.jbpm.ruleflow.core.RuleFlowProcessFactory;
import org.jbpm.process.core.datatype.impl.type.ObjectDataType;
import org.drools.core.util.KieFunctions;
import org.jbpm.process.core.datatype.impl.type.IntegerDataType;
import org.jbpm.process.core.datatype.impl.type.BooleanDataType;

@jakarta.enterprise.context.ApplicationScoped()
@jakarta.inject.Named("loan")
@io.quarkus.runtime.Startup()
public class LoanProcess extends org.kie.kogito.process.impl.AbstractProcess<com.ibm.bamoe.myprojects.LoanModel> {

    public LoanProcess(org.kie.kogito.app.Application app, org.kie.kogito.correlation.CorrelationService correlations) {
        this(app, correlations, new org.kie.kogito.handlers.loanRestWorkItemHandler());
    }

    @jakarta.inject.Inject()
    public LoanProcess(org.kie.kogito.app.Application app, org.kie.kogito.correlation.CorrelationService correlations, org.kie.kogito.handlers.loanRestWorkItemHandler loanRestWorkItemHandler) {
        super(app, java.util.Arrays.asList(loanRestWorkItemHandler), correlations);
        activate();
    }

    public LoanProcess() {
    }

    @Override()
    public com.ibm.bamoe.myprojects.LoanProcessInstance createInstance(com.ibm.bamoe.myprojects.LoanModel value) {
        return new com.ibm.bamoe.myprojects.LoanProcessInstance(this, value, this.createProcessRuntime());
    }

    public com.ibm.bamoe.myprojects.LoanProcessInstance createInstance(java.lang.String businessKey, com.ibm.bamoe.myprojects.LoanModel value) {
        return new com.ibm.bamoe.myprojects.LoanProcessInstance(this, value, businessKey, this.createProcessRuntime());
    }

    public com.ibm.bamoe.myprojects.LoanProcessInstance createInstance(java.lang.String businessKey, org.kie.kogito.correlation.CompositeCorrelation correlation, com.ibm.bamoe.myprojects.LoanModel value) {
        return new com.ibm.bamoe.myprojects.LoanProcessInstance(this, value, businessKey, this.createProcessRuntime(), correlation);
    }

    @Override()
    public com.ibm.bamoe.myprojects.LoanModel createModel() {
        return new com.ibm.bamoe.myprojects.LoanModel();
    }

    public com.ibm.bamoe.myprojects.LoanProcessInstance createInstance(org.kie.kogito.Model value) {
        return this.createInstance((com.ibm.bamoe.myprojects.LoanModel) value);
    }

    public com.ibm.bamoe.myprojects.LoanProcessInstance createInstance(java.lang.String businessKey, org.kie.kogito.Model value) {
        return this.createInstance(businessKey, (com.ibm.bamoe.myprojects.LoanModel) value);
    }

    public com.ibm.bamoe.myprojects.LoanProcessInstance createInstance(org.kie.api.runtime.process.WorkflowProcessInstance wpi) {
        return new com.ibm.bamoe.myprojects.LoanProcessInstance(this, this.createModel(), this.createProcessRuntime(), wpi);
    }

    public com.ibm.bamoe.myprojects.LoanProcessInstance createReadOnlyInstance(org.kie.api.runtime.process.WorkflowProcessInstance wpi) {
        return new com.ibm.bamoe.myprojects.LoanProcessInstance(this, this.createModel(), wpi);
    }

    protected org.kie.api.definition.process.Process process() {
        RuleFlowProcessFactory factory = RuleFlowProcessFactory.createProcess("loan", true);
        factory.variable("amount", org.jbpm.process.core.datatype.DataTypeResolver.fromClass(java.lang.Integer.class), java.util.Map.of("amount", "amount", "ItemSubjectRef", "_amountItem"));
        factory.variable("creditScore", org.jbpm.process.core.datatype.DataTypeResolver.fromClass(java.lang.Integer.class), java.util.Map.of("creditScore", "creditScore", "ItemSubjectRef", "_creditScoreItem"));
        factory.variable("approved", org.jbpm.process.core.datatype.DataTypeResolver.fromClass(java.lang.Boolean.class), java.util.Map.of("approved", "approved", "ItemSubjectRef", "_approvedItem"));
        factory.variable("intrestRate", org.jbpm.process.core.datatype.DataTypeResolver.fromClass(java.lang.Integer.class), java.util.Map.of("intrestRate", "intrestRate", "ItemSubjectRef", "_intrestRateItem"));
        factory.variable("drugsPing", org.jbpm.process.core.datatype.DataTypeResolver.fromClass(java.lang.Object.class), java.util.Map.of("drugsPing", "drugsPing", "ItemSubjectRef", "_drugsPingItem"));
        factory.name("loan");
        factory.packageName("com.ibm.bamoe.myprojects");
        factory.dynamic(false);
        factory.version("1.0");
        factory.type("BPMN");
        factory.visibility("Public");
        factory.metaData("jbpm.enable.multi.con", null);
        factory.metaData("jbpm.transactions.enable", "true");
        factory.metaData("TargetNamespace", "http://www.omg.org/bpmn20");
        org.jbpm.ruleflow.core.factory.WorkItemNodeFactory<?> workItemNode_7DDEBFF4_B2C3_476B_9DB5_24D1646A3F8E = factory.workItemNode(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_7DDEBFF4-B2C3-476B-9DB5-24D1646A3F8E"));
        workItemNode_7DDEBFF4_B2C3_476B_9DB5_24D1646A3F8E.name("REST");
        workItemNode_7DDEBFF4_B2C3_476B_9DB5_24D1646A3F8E.workName("loanRestWorkItemHandler");
        workItemNode_7DDEBFF4_B2C3_476B_9DB5_24D1646A3F8E.workParameter("NodeName", "REST");
        workItemNode_7DDEBFF4_B2C3_476B_9DB5_24D1646A3F8E.workParameter("TaskName", "Rest");
        workItemNode_7DDEBFF4_B2C3_476B_9DB5_24D1646A3F8E.workParameter("UNIQUE_TASK_ID", "_7DDEBFF4-B2C3-476B-9DB5-24D1646A3F8E");
        workItemNode_7DDEBFF4_B2C3_476B_9DB5_24D1646A3F8E.mapDataInputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(), new org.jbpm.workflow.core.impl.DataDefinition("_7DDEBFF4-B2C3-476B-9DB5-24D1646A3F8E_UrlInputX", "Url", "String", null), java.util.Arrays.asList(new org.jbpm.workflow.core.node.Assignment(null, new org.jbpm.workflow.core.impl.DataDefinition("80ea67b2-ee23-4061-8ca5-0154cf1f50dd", "EXPRESSION (https://dog.ceo/api/breeds/image/random)", "java.lang.Object", "https://dog.ceo/api/breeds/image/random"), new org.jbpm.workflow.core.impl.DataDefinition("_7DDEBFF4-B2C3-476B-9DB5-24D1646A3F8E_UrlInputX", "Url", "String", null))), null));
        workItemNode_7DDEBFF4_B2C3_476B_9DB5_24D1646A3F8E.mapDataInputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(), new org.jbpm.workflow.core.impl.DataDefinition("_7DDEBFF4-B2C3-476B-9DB5-24D1646A3F8E_TaskNameInputX", "TaskName", "Object", null), java.util.Arrays.asList(new org.jbpm.workflow.core.node.Assignment(null, new org.jbpm.workflow.core.impl.DataDefinition("dbe19578-bf43-4755-8b7a-363e0121326f", "EXPRESSION (Rest)", "java.lang.Object", "Rest"), new org.jbpm.workflow.core.impl.DataDefinition("_7DDEBFF4-B2C3-476B-9DB5-24D1646A3F8E_TaskNameInputX", "TaskName", "Object", null))), null));
        workItemNode_7DDEBFF4_B2C3_476B_9DB5_24D1646A3F8E.mapDataOutputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(new org.jbpm.workflow.core.impl.DataDefinition("_7DDEBFF4-B2C3-476B-9DB5-24D1646A3F8E_ResultOutputX", "Result", "java.lang.Object", null)), new org.jbpm.workflow.core.impl.DataDefinition("drugsPing", "drugsPing", "java.lang.Object", null), null, null));
        workItemNode_7DDEBFF4_B2C3_476B_9DB5_24D1646A3F8E.done();
        workItemNode_7DDEBFF4_B2C3_476B_9DB5_24D1646A3F8E.metaData("UniqueId", "_7DDEBFF4-B2C3-476B-9DB5-24D1646A3F8E");
        workItemNode_7DDEBFF4_B2C3_476B_9DB5_24D1646A3F8E.metaData("elementname", "REST");
        workItemNode_7DDEBFF4_B2C3_476B_9DB5_24D1646A3F8E.metaData("x", 393);
        workItemNode_7DDEBFF4_B2C3_476B_9DB5_24D1646A3F8E.metaData("width", 154);
        workItemNode_7DDEBFF4_B2C3_476B_9DB5_24D1646A3F8E.metaData("y", 460);
        workItemNode_7DDEBFF4_B2C3_476B_9DB5_24D1646A3F8E.metaData("height", 102);
        org.jbpm.ruleflow.core.factory.RuleSetNodeFactory<?> ruleSetNode_128A32AA_6AE8_47D4_BCEB_84EA0C681F26 = factory.ruleSetNode(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_128A32AA-6AE8-47D4-BCEB-84EA0C681F26"));
        ruleSetNode_128A32AA_6AE8_47D4_BCEB_84EA0C681F26.name("Credit Check");
        ruleSetNode_128A32AA_6AE8_47D4_BCEB_84EA0C681F26.decision("https://kie.org/dmn/_49CA0FB1-9FAA-4672-8A0B-A787EB65E52E", "DMN_AECB2F1F-A849-44F7-9A49-53EA0E27DB0B", null, () -> {
            return app.get(org.kie.kogito.decision.DecisionModels.class).getDecisionModel("https://kie.org/dmn/_49CA0FB1-9FAA-4672-8A0B-A787EB65E52E", "DMN_AECB2F1F-A849-44F7-9A49-53EA0E27DB0B");
        });
        ruleSetNode_128A32AA_6AE8_47D4_BCEB_84EA0C681F26.mapDataInputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(), new org.jbpm.workflow.core.impl.DataDefinition("_128A32AA-6AE8-47D4-BCEB-84EA0C681F26_fileNameInputX", "fileName", "java.lang.String", null), java.util.Arrays.asList(new org.jbpm.workflow.core.node.Assignment(null, new org.jbpm.workflow.core.impl.DataDefinition("0690ddb5-b915-4751-9c0b-01147352e590", "EXPRESSION (InterestEvaluator.dmn)", "java.lang.Object", "InterestEvaluator.dmn"), new org.jbpm.workflow.core.impl.DataDefinition("_128A32AA-6AE8-47D4-BCEB-84EA0C681F26_fileNameInputX", "fileName", "java.lang.String", null))), null));
        ruleSetNode_128A32AA_6AE8_47D4_BCEB_84EA0C681F26.mapDataInputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(), new org.jbpm.workflow.core.impl.DataDefinition("_128A32AA-6AE8-47D4-BCEB-84EA0C681F26_namespaceInputX", "namespace", "java.lang.String", null), java.util.Arrays.asList(new org.jbpm.workflow.core.node.Assignment(null, new org.jbpm.workflow.core.impl.DataDefinition("fa6761e2-8259-4430-b69b-89459577bf5c", "EXPRESSION (https://kie.org/dmn/_49CA0FB1-9FAA-4672-8A0B-A787EB65E52E)", "java.lang.Object", "https://kie.org/dmn/_49CA0FB1-9FAA-4672-8A0B-A787EB65E52E"), new org.jbpm.workflow.core.impl.DataDefinition("_128A32AA-6AE8-47D4-BCEB-84EA0C681F26_namespaceInputX", "namespace", "java.lang.String", null))), null));
        ruleSetNode_128A32AA_6AE8_47D4_BCEB_84EA0C681F26.mapDataInputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(), new org.jbpm.workflow.core.impl.DataDefinition("_128A32AA-6AE8-47D4-BCEB-84EA0C681F26_modelInputX", "model", "java.lang.String", null), java.util.Arrays.asList(new org.jbpm.workflow.core.node.Assignment(null, new org.jbpm.workflow.core.impl.DataDefinition("4a2b08d7-ea7e-441c-8d96-3634c7399cbb", "EXPRESSION (DMN_AECB2F1F-A849-44F7-9A49-53EA0E27DB0B)", "java.lang.Object", "DMN_AECB2F1F-A849-44F7-9A49-53EA0E27DB0B"), new org.jbpm.workflow.core.impl.DataDefinition("_128A32AA-6AE8-47D4-BCEB-84EA0C681F26_modelInputX", "model", "java.lang.String", null))), null));
        ruleSetNode_128A32AA_6AE8_47D4_BCEB_84EA0C681F26.mapDataInputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(new org.jbpm.workflow.core.impl.DataDefinition("creditScore", "creditScore", "java.lang.Integer", null)), new org.jbpm.workflow.core.impl.DataDefinition("_128A32AA-6AE8-47D4-BCEB-84EA0C681F26_ExperianInputX", "Experian", "Integer", null), null, null));
        ruleSetNode_128A32AA_6AE8_47D4_BCEB_84EA0C681F26.mapDataInputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(new org.jbpm.workflow.core.impl.DataDefinition("creditScore", "creditScore", "java.lang.Integer", null)), new org.jbpm.workflow.core.impl.DataDefinition("_128A32AA-6AE8-47D4-BCEB-84EA0C681F26_EqufaxInputX", "Equfax", "Integer", null), null, null));
        ruleSetNode_128A32AA_6AE8_47D4_BCEB_84EA0C681F26.mapDataOutputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(new org.jbpm.workflow.core.impl.DataDefinition("_128A32AA-6AE8-47D4-BCEB-84EA0C681F26_InterestRateOutputX", "InterestRate", "Integer", null)), new org.jbpm.workflow.core.impl.DataDefinition("intrestRate", "intrestRate", "java.lang.Integer", null), null, null));
        ruleSetNode_128A32AA_6AE8_47D4_BCEB_84EA0C681F26.metaData("UniqueId", "_128A32AA-6AE8-47D4-BCEB-84EA0C681F26");
        ruleSetNode_128A32AA_6AE8_47D4_BCEB_84EA0C681F26.metaData("elementname", "Credit Check");
        ruleSetNode_128A32AA_6AE8_47D4_BCEB_84EA0C681F26.metaData("x", 673);
        ruleSetNode_128A32AA_6AE8_47D4_BCEB_84EA0C681F26.metaData("width", 154);
        ruleSetNode_128A32AA_6AE8_47D4_BCEB_84EA0C681F26.metaData("y", 281);
        ruleSetNode_128A32AA_6AE8_47D4_BCEB_84EA0C681F26.metaData("height", 102);
        ruleSetNode_128A32AA_6AE8_47D4_BCEB_84EA0C681F26.done();
        org.jbpm.ruleflow.core.factory.ActionNodeFactory<?> actionNode_CD98068D_7C61_42EC_8DED_DFFE1B3B3A9C = factory.actionNode(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_CD98068D-7C61-42EC-8DED-DFFE1B3B3A9C"));
        actionNode_CD98068D_7C61_42EC_8DED_DFFE1B3B3A9C.name("Passed");
        actionNode_CD98068D_7C61_42EC_8DED_DFFE1B3B3A9C.metaData("UniqueId", "_CD98068D-7C61-42EC-8DED-DFFE1B3B3A9C");
        actionNode_CD98068D_7C61_42EC_8DED_DFFE1B3B3A9C.metaData("elementname", "Passed");
        actionNode_CD98068D_7C61_42EC_8DED_DFFE1B3B3A9C.metaData("NodeType", "ScriptTask");
        actionNode_CD98068D_7C61_42EC_8DED_DFFE1B3B3A9C.metaData("x", 1002);
        actionNode_CD98068D_7C61_42EC_8DED_DFFE1B3B3A9C.metaData("width", 154);
        actionNode_CD98068D_7C61_42EC_8DED_DFFE1B3B3A9C.metaData("y", 281);
        actionNode_CD98068D_7C61_42EC_8DED_DFFE1B3B3A9C.metaData("height", 102);
        actionNode_CD98068D_7C61_42EC_8DED_DFFE1B3B3A9C.action(kcontext -> {
            System.out.println("User Passed Loan Approval");
        });
        actionNode_CD98068D_7C61_42EC_8DED_DFFE1B3B3A9C.done();
        org.jbpm.ruleflow.core.factory.EndNodeFactory<?> endNode_C4F9F656_E556_4F33_827F_CE7EEC54BB1D = factory.endNode(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_C4F9F656-E556-4F33-827F-CE7EEC54BB1D"));
        endNode_C4F9F656_E556_4F33_827F_CE7EEC54BB1D.name("End");
        endNode_C4F9F656_E556_4F33_827F_CE7EEC54BB1D.terminate(false);
        endNode_C4F9F656_E556_4F33_827F_CE7EEC54BB1D.metaData("UniqueId", "_C4F9F656-E556-4F33-827F-CE7EEC54BB1D");
        endNode_C4F9F656_E556_4F33_827F_CE7EEC54BB1D.metaData("x", 442);
        endNode_C4F9F656_E556_4F33_827F_CE7EEC54BB1D.metaData("width", 56);
        endNode_C4F9F656_E556_4F33_827F_CE7EEC54BB1D.metaData("y", 755);
        endNode_C4F9F656_E556_4F33_827F_CE7EEC54BB1D.metaData("height", 56);
        endNode_C4F9F656_E556_4F33_827F_CE7EEC54BB1D.done();
        org.jbpm.ruleflow.core.factory.ActionNodeFactory<?> actionNode_46E5647E_7432_43B6_A66A_5B090549BEFA = factory.actionNode(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_46E5647E-7432-43B6-A66A-5B090549BEFA"));
        actionNode_46E5647E_7432_43B6_A66A_5B090549BEFA.name("Failed");
        actionNode_46E5647E_7432_43B6_A66A_5B090549BEFA.metaData("UniqueId", "_46E5647E-7432-43B6-A66A-5B090549BEFA");
        actionNode_46E5647E_7432_43B6_A66A_5B090549BEFA.metaData("elementname", "Failed");
        actionNode_46E5647E_7432_43B6_A66A_5B090549BEFA.metaData("NodeType", "ScriptTask");
        actionNode_46E5647E_7432_43B6_A66A_5B090549BEFA.metaData("x", 400);
        actionNode_46E5647E_7432_43B6_A66A_5B090549BEFA.metaData("width", 154);
        actionNode_46E5647E_7432_43B6_A66A_5B090549BEFA.metaData("y", 611);
        actionNode_46E5647E_7432_43B6_A66A_5B090549BEFA.metaData("height", 102);
        actionNode_46E5647E_7432_43B6_A66A_5B090549BEFA.action(kcontext -> {
            java.lang.Object drugsPing = (java.lang.Object) kcontext.getVariable("drugsPing");
            System.out.println("User Failed Credit Check ");
            System.out.println("Ping branch: " + drugsPing);
        });
        actionNode_46E5647E_7432_43B6_A66A_5B090549BEFA.done();
        org.jbpm.ruleflow.core.factory.SplitFactory<?> splitNode_72BAA64C_0193_4E6B_9F15_D6FEAF9C5B42 = factory.splitNode(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_72BAA64C-0193-4E6B-9F15-D6FEAF9C5B42"));
        splitNode_72BAA64C_0193_4E6B_9F15_D6FEAF9C5B42.name("Split");
        splitNode_72BAA64C_0193_4E6B_9F15_D6FEAF9C5B42.type(2);
        splitNode_72BAA64C_0193_4E6B_9F15_D6FEAF9C5B42.metaData("UniqueId", "_72BAA64C-0193-4E6B-9F15-D6FEAF9C5B42");
        splitNode_72BAA64C_0193_4E6B_9F15_D6FEAF9C5B42.metaData("x", 442);
        splitNode_72BAA64C_0193_4E6B_9F15_D6FEAF9C5B42.metaData("width", 56);
        splitNode_72BAA64C_0193_4E6B_9F15_D6FEAF9C5B42.metaData("y", 304);
        splitNode_72BAA64C_0193_4E6B_9F15_D6FEAF9C5B42.metaData("Default", null);
        splitNode_72BAA64C_0193_4E6B_9F15_D6FEAF9C5B42.metaData("height", 56);
        splitNode_72BAA64C_0193_4E6B_9F15_D6FEAF9C5B42.constraint(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_128A32AA-6AE8-47D4-BCEB-84EA0C681F26"), "_BE5A1391-5BAD-4833-AA6E-BCAE91F266CD", "DROOLS_DEFAULT", "java", kcontext -> {
            java.lang.Boolean approved = (java.lang.Boolean) kcontext.getVariable("approved");
            return approved;
        }, 0, false);
        splitNode_72BAA64C_0193_4E6B_9F15_D6FEAF9C5B42.constraint(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_7DDEBFF4-B2C3-476B-9DB5-24D1646A3F8E"), "_B6EA8CC2-F7B9-4724-B998-C306BF059E76", "DROOLS_DEFAULT", "java", kcontext -> {
            java.lang.Boolean approved = (java.lang.Boolean) kcontext.getVariable("approved");
            return !approved;
        }, 0, false);
        splitNode_72BAA64C_0193_4E6B_9F15_D6FEAF9C5B42.done();
        splitNode_72BAA64C_0193_4E6B_9F15_D6FEAF9C5B42.constraint(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_128A32AA-6AE8-47D4-BCEB-84EA0C681F26"), "_BE5A1391-5BAD-4833-AA6E-BCAE91F266CD", "DROOLS_DEFAULT", "java", kcontext -> {
            java.lang.Boolean approved = (java.lang.Boolean) kcontext.getVariable("approved");
            return approved;
        }, 0, false);
        splitNode_72BAA64C_0193_4E6B_9F15_D6FEAF9C5B42.constraint(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_7DDEBFF4-B2C3-476B-9DB5-24D1646A3F8E"), "_B6EA8CC2-F7B9-4724-B998-C306BF059E76", "DROOLS_DEFAULT", "java", kcontext -> {
            java.lang.Boolean approved = (java.lang.Boolean) kcontext.getVariable("approved");
            return !approved;
        }, 0, false);
        org.jbpm.ruleflow.core.factory.EndNodeFactory<?> endNode_694F0DF6_D058_424E_A0D0_38D91447F8F5 = factory.endNode(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_694F0DF6-D058-424E-A0D0-38D91447F8F5"));
        endNode_694F0DF6_D058_424E_A0D0_38D91447F8F5.name("End");
        endNode_694F0DF6_D058_424E_A0D0_38D91447F8F5.terminate(false);
        endNode_694F0DF6_D058_424E_A0D0_38D91447F8F5.metaData("UniqueId", "_694F0DF6-D058-424E-A0D0-38D91447F8F5");
        endNode_694F0DF6_D058_424E_A0D0_38D91447F8F5.metaData("x", 1218);
        endNode_694F0DF6_D058_424E_A0D0_38D91447F8F5.metaData("width", 56);
        endNode_694F0DF6_D058_424E_A0D0_38D91447F8F5.metaData("y", 304);
        endNode_694F0DF6_D058_424E_A0D0_38D91447F8F5.metaData("height", 56);
        endNode_694F0DF6_D058_424E_A0D0_38D91447F8F5.done();
        org.jbpm.ruleflow.core.factory.RuleSetNodeFactory<?> ruleSetNode_CA4ED764_28F0_44D0_B9E5_8FAF79540530 = factory.ruleSetNode(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_CA4ED764-28F0-44D0-B9E5-8FAF79540530"));
        ruleSetNode_CA4ED764_28F0_44D0_B9E5_8FAF79540530.name("Credit Check");
        ruleSetNode_CA4ED764_28F0_44D0_B9E5_8FAF79540530.decision("https://kie.org/dmn/_1436A937-AE9A-4F01-98B4-334645FC4538", "DMN_404C597C-0053-4AC4-BD3D-D1B29072495E", null, () -> {
            return app.get(org.kie.kogito.decision.DecisionModels.class).getDecisionModel("https://kie.org/dmn/_1436A937-AE9A-4F01-98B4-334645FC4538", "DMN_404C597C-0053-4AC4-BD3D-D1B29072495E");
        });
        ruleSetNode_CA4ED764_28F0_44D0_B9E5_8FAF79540530.mapDataInputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(), new org.jbpm.workflow.core.impl.DataDefinition("_CA4ED764-28F0-44D0-B9E5-8FAF79540530_fileNameInputX", "fileName", "java.lang.String", null), java.util.Arrays.asList(new org.jbpm.workflow.core.node.Assignment(null, new org.jbpm.workflow.core.impl.DataDefinition("d16218f4-993d-4b7f-85fe-b22c75aa5776", "EXPRESSION (CreditEvaluator.dmn)", "java.lang.Object", "CreditEvaluator.dmn"), new org.jbpm.workflow.core.impl.DataDefinition("_CA4ED764-28F0-44D0-B9E5-8FAF79540530_fileNameInputX", "fileName", "java.lang.String", null))), null));
        ruleSetNode_CA4ED764_28F0_44D0_B9E5_8FAF79540530.mapDataInputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(), new org.jbpm.workflow.core.impl.DataDefinition("_CA4ED764-28F0-44D0-B9E5-8FAF79540530_namespaceInputX", "namespace", "java.lang.String", null), java.util.Arrays.asList(new org.jbpm.workflow.core.node.Assignment(null, new org.jbpm.workflow.core.impl.DataDefinition("3cd24e6a-57f4-44dc-8b6e-3c42cfe5324d", "EXPRESSION (https://kie.org/dmn/_1436A937-AE9A-4F01-98B4-334645FC4538)", "java.lang.Object", "https://kie.org/dmn/_1436A937-AE9A-4F01-98B4-334645FC4538"), new org.jbpm.workflow.core.impl.DataDefinition("_CA4ED764-28F0-44D0-B9E5-8FAF79540530_namespaceInputX", "namespace", "java.lang.String", null))), null));
        ruleSetNode_CA4ED764_28F0_44D0_B9E5_8FAF79540530.mapDataInputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(), new org.jbpm.workflow.core.impl.DataDefinition("_CA4ED764-28F0-44D0-B9E5-8FAF79540530_modelInputX", "model", "java.lang.String", null), java.util.Arrays.asList(new org.jbpm.workflow.core.node.Assignment(null, new org.jbpm.workflow.core.impl.DataDefinition("9a9f260b-e101-4b13-999a-9a992c8dc78f", "EXPRESSION (DMN_404C597C-0053-4AC4-BD3D-D1B29072495E)", "java.lang.Object", "DMN_404C597C-0053-4AC4-BD3D-D1B29072495E"), new org.jbpm.workflow.core.impl.DataDefinition("_CA4ED764-28F0-44D0-B9E5-8FAF79540530_modelInputX", "model", "java.lang.String", null))), null));
        ruleSetNode_CA4ED764_28F0_44D0_B9E5_8FAF79540530.mapDataInputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(new org.jbpm.workflow.core.impl.DataDefinition("creditScore", "creditScore", "java.lang.Integer", null)), new org.jbpm.workflow.core.impl.DataDefinition("_CA4ED764-28F0-44D0-B9E5-8FAF79540530_ExperianInputX", "Experian", "Integer", null), null, null));
        ruleSetNode_CA4ED764_28F0_44D0_B9E5_8FAF79540530.mapDataInputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(new org.jbpm.workflow.core.impl.DataDefinition("creditScore", "creditScore", "java.lang.Integer", null)), new org.jbpm.workflow.core.impl.DataDefinition("_CA4ED764-28F0-44D0-B9E5-8FAF79540530_EqufaxInputX", "Equfax", "Integer", null), null, null));
        ruleSetNode_CA4ED764_28F0_44D0_B9E5_8FAF79540530.mapDataOutputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(new org.jbpm.workflow.core.impl.DataDefinition("_CA4ED764-28F0-44D0-B9E5-8FAF79540530_validCreditOutputX", "validCredit", "Boolean", null)), new org.jbpm.workflow.core.impl.DataDefinition("approved", "approved", "java.lang.Boolean", null), null, null));
        ruleSetNode_CA4ED764_28F0_44D0_B9E5_8FAF79540530.metaData("UniqueId", "_CA4ED764-28F0-44D0-B9E5-8FAF79540530");
        ruleSetNode_CA4ED764_28F0_44D0_B9E5_8FAF79540530.metaData("elementname", "Credit Check");
        ruleSetNode_CA4ED764_28F0_44D0_B9E5_8FAF79540530.metaData("x", 208);
        ruleSetNode_CA4ED764_28F0_44D0_B9E5_8FAF79540530.metaData("width", 154);
        ruleSetNode_CA4ED764_28F0_44D0_B9E5_8FAF79540530.metaData("y", 281);
        ruleSetNode_CA4ED764_28F0_44D0_B9E5_8FAF79540530.metaData("height", 102);
        ruleSetNode_CA4ED764_28F0_44D0_B9E5_8FAF79540530.done();
        org.jbpm.ruleflow.core.factory.StartNodeFactory<?> startNode_998F4FCE_FCE6_4BA1_9C6D_B2010208BA17 = factory.startNode(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_998F4FCE-FCE6-4BA1-9C6D-B2010208BA17"));
        startNode_998F4FCE_FCE6_4BA1_9C6D_B2010208BA17.name("Start");
        startNode_998F4FCE_FCE6_4BA1_9C6D_B2010208BA17.interrupting(true);
        startNode_998F4FCE_FCE6_4BA1_9C6D_B2010208BA17.metaData("UniqueId", "_998F4FCE-FCE6-4BA1-9C6D-B2010208BA17");
        startNode_998F4FCE_FCE6_4BA1_9C6D_B2010208BA17.metaData("EventType", "none");
        startNode_998F4FCE_FCE6_4BA1_9C6D_B2010208BA17.metaData("x", 52);
        startNode_998F4FCE_FCE6_4BA1_9C6D_B2010208BA17.metaData("width", 56);
        startNode_998F4FCE_FCE6_4BA1_9C6D_B2010208BA17.metaData("y", 304);
        startNode_998F4FCE_FCE6_4BA1_9C6D_B2010208BA17.metaData("height", 56);
        startNode_998F4FCE_FCE6_4BA1_9C6D_B2010208BA17.done();
        factory.connection(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_72BAA64C-0193-4E6B-9F15-D6FEAF9C5B42"), org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_7DDEBFF4-B2C3-476B-9DB5-24D1646A3F8E"), "_B6EA8CC2-F7B9-4724-B998-C306BF059E76");
        factory.connection(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_72BAA64C-0193-4E6B-9F15-D6FEAF9C5B42"), org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_128A32AA-6AE8-47D4-BCEB-84EA0C681F26"), "_BE5A1391-5BAD-4833-AA6E-BCAE91F266CD");
        factory.connection(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_128A32AA-6AE8-47D4-BCEB-84EA0C681F26"), org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_CD98068D-7C61-42EC-8DED-DFFE1B3B3A9C"), "_82C018C0-3AAD-417B-9C90-148B97A0D77B");
        factory.connection(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_46E5647E-7432-43B6-A66A-5B090549BEFA"), org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_C4F9F656-E556-4F33-827F-CE7EEC54BB1D"), "_5F74D6B7-A92F-4976-87F9-AA292B0A9412");
        factory.connection(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_7DDEBFF4-B2C3-476B-9DB5-24D1646A3F8E"), org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_46E5647E-7432-43B6-A66A-5B090549BEFA"), "_0023EE04-B24B-4107-9506-689AEE072D35");
        factory.connection(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_CA4ED764-28F0-44D0-B9E5-8FAF79540530"), org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_72BAA64C-0193-4E6B-9F15-D6FEAF9C5B42"), "_7F73AF9B-02B7-4E04-A1A7-564872BDA1B0");
        factory.connection(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_CD98068D-7C61-42EC-8DED-DFFE1B3B3A9C"), org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_694F0DF6-D058-424E-A0D0-38D91447F8F5"), "_4C7B9FA5-0D0B-4042-A3FA-C8E5DD50850A");
        factory.connection(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_998F4FCE-FCE6-4BA1-9C6D-B2010208BA17"), org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_CA4ED764-28F0-44D0-B9E5-8FAF79540530"), "_A3FA15EE-1F9C-469F-A6BF-A633D2CD85EC");
        factory.validate();
        return factory.getProcess();
    }
}
