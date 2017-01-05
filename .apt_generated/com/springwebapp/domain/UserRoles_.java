package com.springwebapp.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(UserRoles.class)
public abstract class UserRoles_ {

	public static volatile SingularAttribute<UserRoles, String> name;
	public static volatile SingularAttribute<UserRoles, Long> id;
	public static volatile SetAttribute<UserRoles, Users> users;

}

