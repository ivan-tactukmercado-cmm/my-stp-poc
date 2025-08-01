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

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriBuilder;
import jakarta.ws.rs.core.UriInfo;
import jakarta.ws.rs.core.Response.Status;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.jbpm.util.JsonSchemaUtil;
import org.kie.kogito.process.Process;
import org.kie.kogito.process.ProcessInstance;
import org.kie.kogito.process.ProcessService;
import org.kie.kogito.process.workitem.TaskModel;
import org.kie.kogito.auth.IdentityProviderFactory;
import org.kie.kogito.auth.SecurityPolicy;

@Path("/loan")
@org.eclipse.microprofile.openapi.annotations.tags.Tag(name = "loan")
@jakarta.enterprise.context.ApplicationScoped()
public class LoanResource {

    @jakarta.inject.Inject()
    @jakarta.inject.Named("loan")
    Process<LoanModel> process;

    @Inject
    ProcessService processService;

    @Inject
    IdentityProviderFactory identityProviderFactory;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "loan", description = "")
    @jakarta.transaction.Transactional()
    @org.eclipse.microprofile.faulttolerance.Retry()
    public Response createResource_loan(@Context HttpHeaders httpHeaders, @Context UriInfo uriInfo, @QueryParam("businessKey") @DefaultValue("") String businessKey, @jakarta.validation.Valid() @jakarta.validation.constraints.NotNull() LoanModelInput resource) {
        ProcessInstance<LoanModel> pi = processService.createProcessInstance(process, businessKey, Optional.ofNullable(resource).orElse(new LoanModelInput()).toModel(), httpHeaders.getRequestHeaders(), httpHeaders.getHeaderString("X-KOGITO-StartFromNode"), null, httpHeaders.getHeaderString("X-KOGITO-ReferenceId"), null);
        return Response.created(uriInfo.getAbsolutePathBuilder().path(pi.id()).build()).entity(pi.checkError().variables().toModel()).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "loan", description = "")
    @jakarta.transaction.Transactional()
    @org.eclipse.microprofile.faulttolerance.Retry()
    public List<LoanModelOutput> getResources_loan() {
        return processService.getProcessInstanceOutput(process);
    }

    @GET
    @Path("schema")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "loan", description = "")
    @jakarta.transaction.Transactional()
    @org.eclipse.microprofile.faulttolerance.Retry()
    public Map<String, Object> getResourceSchema_loan() {
        return JsonSchemaUtil.load(this.getClass().getClassLoader(), process.id());
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "loan", description = "")
    @jakarta.transaction.Transactional()
    @org.eclipse.microprofile.faulttolerance.Retry()
    public LoanModelOutput getResource_loan(@PathParam("id") String id) {
        return processService.findById(process, id).orElseThrow(NotFoundException::new);
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "loan", description = "")
    @jakarta.transaction.Transactional()
    @org.eclipse.microprofile.faulttolerance.Retry()
    public LoanModelOutput deleteResource_loan(@PathParam("id") final String id) {
        return processService.delete(process, id).orElseThrow(NotFoundException::new);
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "loan", description = "")
    @jakarta.transaction.Transactional()
    @org.eclipse.microprofile.faulttolerance.Retry()
    public LoanModelOutput updateModel_loan(@PathParam("id") String id, @jakarta.validation.Valid() @jakarta.validation.constraints.NotNull() LoanModelInput resource) {
        return processService.update(process, id, resource.toModel()).orElseThrow(NotFoundException::new);
    }

    @PATCH
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "loan", description = "")
    @jakarta.transaction.Transactional()
    @org.eclipse.microprofile.faulttolerance.Retry()
    public LoanModelOutput updateModelPartial_loan(@PathParam("id") String id, @jakarta.validation.Valid() @jakarta.validation.constraints.NotNull() LoanModelInput resource) {
        return processService.updatePartial(process, id, resource.toModel()).orElseThrow(NotFoundException::new);
    }

    @GET
    @Path("/{id}/tasks")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "loan", description = "")
    @jakarta.transaction.Transactional()
    @org.eclipse.microprofile.faulttolerance.Retry()
    public List<TaskModel> getTasks_loan(@PathParam("id") String id, @QueryParam("user") final String user, @QueryParam("group") final List<String> groups) {
        return processService.getWorkItems(process, id, SecurityPolicy.of(identityProviderFactory.getOrImpersonateIdentity(user, groups))).orElseThrow(NotFoundException::new).stream().map(com.ibm.bamoe.myprojects.Loan_TaskModelFactory::from).collect(Collectors.toList());
    }

    @POST
    @Path("/{id}/Rest/{taskId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @jakarta.transaction.Transactional()
    @org.eclipse.microprofile.faulttolerance.Retry()
    public LoanModelOutput completeTask_Rest_0(@PathParam("id") final String id, @PathParam("taskId") final String taskId, @QueryParam("phase") @DefaultValue("complete") final String phase, @QueryParam("user") final String user, @QueryParam("group") final List<String> groups, final com.ibm.bamoe.myprojects.Loan__7DDEBFF4_B2C3_476B_9DB5_24D1646A3F8E_TaskOutput model) {
        return processService.transitionWorkItem(process, id, taskId, phase, SecurityPolicy.of(identityProviderFactory.getOrImpersonateIdentity(user, groups)), model).orElseThrow(NotFoundException::new);
    }

    @PUT
    @Path("/{id}/Rest/{taskId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @jakarta.transaction.Transactional()
    @org.eclipse.microprofile.faulttolerance.Retry()
    public com.ibm.bamoe.myprojects.Loan__7DDEBFF4_B2C3_476B_9DB5_24D1646A3F8E_TaskOutput saveTask_Rest_0(@PathParam("id") final String id, @PathParam("taskId") final String taskId, @QueryParam("user") final String user, @QueryParam("group") final List<String> groups, final com.ibm.bamoe.myprojects.Loan__7DDEBFF4_B2C3_476B_9DB5_24D1646A3F8E_TaskOutput model) {
        return processService.setWorkItemOutput(process, id, taskId, SecurityPolicy.of(identityProviderFactory.getOrImpersonateIdentity(user, groups)), model, com.ibm.bamoe.myprojects.Loan__7DDEBFF4_B2C3_476B_9DB5_24D1646A3F8E_TaskOutput::fromMap).orElseThrow(NotFoundException::new);
    }

    @POST
    @Path("/{id}/Rest/{taskId}/phases/{phase}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @jakarta.transaction.Transactional()
    @org.eclipse.microprofile.faulttolerance.Retry()
    public LoanModelOutput taskTransition_Rest_0(@PathParam("id") final String id, @PathParam("taskId") final String taskId, @PathParam("phase") final String phase, @QueryParam("user") final String user, @QueryParam("group") final List<String> groups, final com.ibm.bamoe.myprojects.Loan__7DDEBFF4_B2C3_476B_9DB5_24D1646A3F8E_TaskOutput model) {
        return processService.transitionWorkItem(process, id, taskId, phase, SecurityPolicy.of(identityProviderFactory.getOrImpersonateIdentity(user, groups)), model).orElseThrow(NotFoundException::new);
    }

    @GET
    @Path("/{id}/Rest/{taskId}")
    @Produces(MediaType.APPLICATION_JSON)
    @jakarta.transaction.Transactional()
    @org.eclipse.microprofile.faulttolerance.Retry()
    public com.ibm.bamoe.myprojects.Loan__7DDEBFF4_B2C3_476B_9DB5_24D1646A3F8E_TaskModel getWorkItem_Rest_0(@PathParam("id") String id, @PathParam("taskId") String taskId, @QueryParam("user") final String user, @QueryParam("group") final List<String> groups) {
        return processService.getWorkItem(process, id, taskId, SecurityPolicy.of(identityProviderFactory.getOrImpersonateIdentity(user, groups)), com.ibm.bamoe.myprojects.Loan__7DDEBFF4_B2C3_476B_9DB5_24D1646A3F8E_TaskModel::from).orElseThrow(NotFoundException::new);
    }

    @DELETE
    @Path("/{id}/Rest/{taskId}")
    @Produces(MediaType.APPLICATION_JSON)
    @jakarta.transaction.Transactional()
    @org.eclipse.microprofile.faulttolerance.Retry()
    public LoanModelOutput abortTask_Rest_0(@PathParam("id") final String id, @PathParam("taskId") final String taskId, @QueryParam("phase") @DefaultValue("abort") final String phase, @QueryParam("user") final String user, @QueryParam("group") final List<String> groups) {
        return processService.transitionWorkItem(process, id, taskId, phase, SecurityPolicy.of(identityProviderFactory.getOrImpersonateIdentity(user, groups)), null).orElseThrow(NotFoundException::new);
    }

    @GET
    @Path("Rest/schema")
    @Produces(MediaType.APPLICATION_JSON)
    @jakarta.transaction.Transactional()
    @org.eclipse.microprofile.faulttolerance.Retry()
    public Map<String, Object> getSchema_Rest_0() {
        return JsonSchemaUtil.load(this.getClass().getClassLoader(), process.id(), "Rest");
    }

    @GET
    @Path("/{id}/Rest/{taskId}/schema")
    @Produces(MediaType.APPLICATION_JSON)
    @jakarta.transaction.Transactional()
    @org.eclipse.microprofile.faulttolerance.Retry()
    public Map<String, Object> getSchemaAndPhases_Rest_0(@PathParam("id") final String id, @PathParam("taskId") final String taskId, @QueryParam("user") final String user, @QueryParam("group") final List<String> groups) {
        return processService.getWorkItemSchemaAndPhases(process, id, taskId, "Rest", SecurityPolicy.of(identityProviderFactory.getOrImpersonateIdentity(user, groups)));
    }
}
