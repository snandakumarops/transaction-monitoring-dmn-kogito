/*
 * Copyright 2021 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.kie.kogito.app;

@javax.enterprise.context.ApplicationScoped()
// <-- Required to force full reload during hot reload
@io.quarkus.runtime.Startup()
public class DecisionModels extends org.kie.kogito.dmn.AbstractDecisionModels {

    static {
        init(null, null, null, readResource(Application.class.getResourceAsStream("/TransactionMonitoringDMN.dmn")), readResource(Application.class.getResourceAsStream("/AmlDecisions.dmn")), readResource(Application.class.getResourceAsStream("/staticFraudRules.dmn")));
    }

    @javax.inject.Inject
    protected org.kie.kogito.Application application;

    public DecisionModels() {
        super();
    }

    @javax.annotation.PostConstruct
    protected void init() {
        initApplication(application);
    }
}
