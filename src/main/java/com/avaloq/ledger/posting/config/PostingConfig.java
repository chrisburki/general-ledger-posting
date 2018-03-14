package com.avaloq.ledger.posting.config;

import org.drools.decisiontable.DecisionTableProviderImpl;
import org.kie.api.KieServices;
import org.kie.api.builder.*;
import org.kie.api.io.Resource;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.internal.builder.DecisionTableConfiguration;
import org.kie.internal.builder.DecisionTableInputType;
import org.kie.internal.builder.KnowledgeBuilderFactory;
import org.kie.internal.io.ResourceFactory;
import org.springframework.stereotype.Component;

@Component
public class PostingConfig {

  // 0. init: define path where rules can be found
  private static final String RULES_PATH = "rules/";
  private static final String drlFile = "POSTING_RULE.drl";
  private static final String excelFile = "POSTING_RULE.xls";
  private static final String ruleFile = excelFile;


  // 2. add KieModule to KieRepository
  private void getKieRepository(KieServices kieServices) {
    final KieRepository kieRepository = kieServices.getRepository();
    kieRepository.addKieModule(new KieModule() {
      public ReleaseId getReleaseId() {
        return kieRepository.getDefaultReleaseId();
      }
    });
  }

  public KieSession kieSession() {
    // 1. init: KieServices provides access to all the Kie build and runtime facilities
    KieServices kieServices = KieServices.Factory.get();

    // 2. add KieModule to KieRepository
    getKieRepository(kieServices);

    // 3. load excel spreadsheets and drl's
    KieFileSystem kieFileSystem = kieServices.newKieFileSystem();
    kieFileSystem.write(ResourceFactory.newClassPathResource(RULES_PATH + ruleFile));

    // 4. Pass KieFileSystem to KieBuilder
    KieBuilder kb = kieServices.newKieBuilder(kieFileSystem);
    kb.buildAll();

    // 5. get KieModule
    KieModule kieModule = kb.getKieModule();

    // 6. Create new Container with KieModule
    KieContainer kContainer = kieServices.newKieContainer(kieModule.getReleaseId());

    // 7. return KieSession
    return kContainer.newKieSession();

  }


  /*
   * Can be used for debugging
   * Input excelFile example: com/baeldung/drools/rules/Discount.xls
   */

    public String getDrlFromExcel(String excelFile) {
        DecisionTableConfiguration configuration = KnowledgeBuilderFactory.newDecisionTableConfiguration();
        configuration.setInputType(DecisionTableInputType.XLS);

        Resource dt = ResourceFactory.newClassPathResource(excelFile, getClass());

        DecisionTableProviderImpl decisionTableProvider = new DecisionTableProviderImpl();

        return decisionTableProvider.loadFromResource(dt, null);

    }

}
