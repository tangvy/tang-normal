package com.tangv.demo.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QData is a Querydsl query type for Data
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QData extends EntityPathBase<Data> {

    private static final long serialVersionUID = 576389647L;

    public static final QData data1 = new QData("data1");

    public final StringPath data = createString("data");

    public final DateTimePath<java.time.LocalDateTime> gmtCreate = createDateTime("gmtCreate", java.time.LocalDateTime.class);

    public final DateTimePath<java.time.LocalDateTime> gmtModify = createDateTime("gmtModify", java.time.LocalDateTime.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public QData(String variable) {
        super(Data.class, forVariable(variable));
    }

    public QData(Path<? extends Data> path) {
        super(path.getType(), path.getMetadata());
    }

    public QData(PathMetadata metadata) {
        super(Data.class, metadata);
    }

}

