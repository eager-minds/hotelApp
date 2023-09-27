package tech.eagerminds.core.mongodb;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.Instant;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoOperations;
import tech.eagerminds.core.mongodb.domain.entity.EagerMindsMessageEntity;
import tech.eagerminds.core.mongodb.domain.entity.EagerMindsMetadataEntity;
import tech.eagerminds.core.mongodb.service.EagerMindsGenericReactiveMongodbService;

@SpringBootTest
class EagermindsCoreStarterMongoDbApplicationTest {

  @Autowired
  private EagerMindsGenericReactiveMongodbService<EagerMindsMessageEntity, String> eagerMindsMessageService;

  @Autowired
  private MongoOperations mongoOperations;

  @BeforeEach
  public void cleanCollections() {
    mongoOperations.dropCollection("eagermindsMessages");
    mongoOperations.dropCollection("eagermindsMetadatas");
  }

  @Test
  void eagerMindsServiceTest() {
    EagerMindsMetadataEntity metadata = new EagerMindsMetadataEntity(UUID.randomUUID().toString(),
        Instant.now().toString(), "eagerminds-core-mongodb-starter", "1", "javier@eagerminds.tech");

    EagerMindsMessageEntity message = new EagerMindsMessageEntity(
        UUID.randomUUID().toString(), "example", metadata
    );
    eagerMindsMessageService.save(message).block();

    List<EagerMindsMessageEntity> messageList =
        mongoOperations.findAll(EagerMindsMessageEntity.class);
    assertThat(messageList)
        .hasSize(1);
    assertThat(messageList.get(0))
        .isEqualToComparingFieldByFieldRecursively(message);

    List<EagerMindsMetadataEntity> metadataList =
        mongoOperations.findAll(EagerMindsMetadataEntity.class);
    assertThat(metadataList)
        .hasSize(1);
    assertThat(metadataList.get(0))
        .isEqualToComparingFieldByFieldRecursively(metadata);
  }

  @Test
  void contextLoads() {
  }
}


