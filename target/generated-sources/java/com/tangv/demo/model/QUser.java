package com.tangv.demo.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QUser is a Querydsl query type for User
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QUser extends EntityPathBase<User> {

    private static final long serialVersionUID = 576912944L;

    public static final QUser user = new QUser("user");

    public final StringPath authority = createString("authority");

    public final StringPath password = createString("password");

    public final StringPath userAvatar = createString("userAvatar");

    public final StringPath userEmail = createString("userEmail");

    public final NumberPath<Integer> userId = createNumber("userId", Integer.class);

    public final StringPath userLastLoginIp = createString("userLastLoginIp");

    public final DateTimePath<java.util.Date> userLastLoginTime = createDateTime("userLastLoginTime", java.util.Date.class);

    public final StringPath username = createString("username");

    public final StringPath userNickname = createString("userNickname");

    public final DateTimePath<java.util.Date> userRegisterTime = createDateTime("userRegisterTime", java.util.Date.class);

    public final NumberPath<Integer> userStatus = createNumber("userStatus", Integer.class);

    public final StringPath userUrl = createString("userUrl");

    public QUser(String variable) {
        super(User.class, forVariable(variable));
    }

    public QUser(Path<? extends User> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUser(PathMetadata metadata) {
        super(User.class, metadata);
    }

}

