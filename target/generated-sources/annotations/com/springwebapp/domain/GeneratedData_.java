package com.springwebapp.domain;

import java.time.LocalDateTime;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GeneratedData.class)
public abstract class GeneratedData_ {

	public static volatile SingularAttribute<GeneratedData, LocalDateTime> date;
	public static volatile SingularAttribute<GeneratedData, String> purpose;
	public static volatile SingularAttribute<GeneratedData, Long> seqNum;
	public static volatile SingularAttribute<GeneratedData, Integer> version;
	public static volatile SingularAttribute<GeneratedData, Long> nextSeqNum;
	public static volatile SingularAttribute<GeneratedData, String> username;

}

