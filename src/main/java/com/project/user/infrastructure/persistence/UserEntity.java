package com.project.user.infrastructure.persistence;

import io.quarkus.mongodb.panache.PanacheMongoEntityBase;
import io.quarkus.mongodb.panache.common.MongoEntity;
import java.time.LocalDateTime;
import java.util.UUID;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.codecs.pojo.annotations.BsonProperty;

@MongoEntity(collection = "users")
public class UserEntity extends PanacheMongoEntityBase {
  @BsonId public UUID id;
  public String name;
  public String email;
  public String phone;

  @BsonProperty("user-type")
  public String userType;

  @BsonProperty("created-at")
  public LocalDateTime createdAt;
}
