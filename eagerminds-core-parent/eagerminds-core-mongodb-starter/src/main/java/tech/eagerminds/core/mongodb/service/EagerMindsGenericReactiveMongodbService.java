package tech.eagerminds.core.mongodb.service;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface EagerMindsGenericReactiveMongodbService<E, I> {

  ReactiveMongoRepository<E, I> getReactiveMongoRepository();

  default Flux<E> findAll() {
    return getReactiveMongoRepository().findAll();
  }

  default Mono<E> findById(I id) {
    return getReactiveMongoRepository().findById(id);
  }

  default Mono<E> save(E e) {
    return getReactiveMongoRepository().insert(e);
  }

  Mono<E> update(I id, E e);

  default Mono<Void> deleteById(I id) {
    return getReactiveMongoRepository().deleteById(id);
  }

  default Mono<Void> deleteAll() {
    return getReactiveMongoRepository().deleteAll();
  }
}
