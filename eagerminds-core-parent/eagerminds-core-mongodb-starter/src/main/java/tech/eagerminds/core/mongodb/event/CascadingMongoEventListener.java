package tech.eagerminds.core.mongodb.event;

import java.lang.reflect.Field;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.mapping.MappingException;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;
import tech.eagerminds.core.mongodb.annotation.CascadeSave;

@Component
public class CascadingMongoEventListener<T> extends AbstractMongoEventListener<T> {

  private final MongoOperations mongoOperations;

  @Autowired
  public CascadingMongoEventListener(MongoOperations mongoOperations) {
    this.mongoOperations = mongoOperations;
  }

  @Override
  public void onBeforeConvert(final BeforeConvertEvent beforeConvertEvent) {
    Object source = beforeConvertEvent.getSource();
    ReflectionUtils.doWithFields(source.getClass(), field -> {
      ReflectionUtils.makeAccessible(field);

      if (field.isAnnotationPresent(DBRef.class) && field.isAnnotationPresent(CascadeSave.class)
          && field.get(source) != null) {
        final Object fieldValue = field.get(source);

        DbRefFieldCallback callback = new DbRefFieldCallback();

        ReflectionUtils.doWithFields(fieldValue.getClass(), callback);

        if (!callback.isIdFound()) {
          throw new MappingException("Cannot perform cascade save on child object without id set");
        }

        mongoOperations.save(fieldValue);
      }
    });
  }

  private static class DbRefFieldCallback implements ReflectionUtils.FieldCallback {

    private boolean idFound;

    public void doWith(@NonNull Field field) throws IllegalArgumentException {
      ReflectionUtils.makeAccessible(field);

      if (field.isAnnotationPresent(Id.class)) {
        idFound = true;
      }
    }

    public boolean isIdFound() {
      return idFound;
    }
  }
}