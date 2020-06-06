# SEQUENCE GENERATOR
This is a small application used for nothing in particular, really. 
It assigns a unique 5-digit number for some assigned purpose.

The application is created using [Spring Boot 1.4.3], with front end written in [Thymeleaf].
For additional eye candy, table styling is handled by [DataTables] and a sprinkle of [Bootstrap]. 
Yes, jQuery was still going strong then. Different times...

Anyhow, [Maven] is handling all the hard work of managing packages, installation, deployment and packaging the application.

## Dependencies
To successfully start and/or continue development of an application, it is necessary to have installed at least [JDK 1.8] or newer.
Installed [Maven] is also a must.

## Installation
To successfully run the application, it is important to clean the project and install all the application dependencies by using command
```mvn clean install```

When dependencies are installed, start the application by entering
```mvn spring-boot:run```

That command will start the [Jetty] server on `http://localhost:8080/` and start [H2 database] filled with some dummy data.

There are two defined users in database, `jurica: password` and `pero: password`. The initial login users can be added to database manually.

## Deployment
We also support deployment to [Heroku] server, but it requires some tempering with application source and configuration.
1) in `application.properties` comment everything except Heroku-specific properties
1) in `src.main.java.com.springwebapp.configuration.DatabaseConfiguration` delete `h2servletRegistration` bean and uncomment `dataSource` bean
1) deploy application to Heroku server (as described in [Tutorial])

This process is necessary because [Heroku] uses [PostgreSQL] database, so [H2 database] must be disabled for deployment.

## Finally
I will maybe someday update this application, but I'd like to keep it as is. For sentimental reasons, of course.
It was only updated because I wanted to remove IDE config files and all other unecessary files. And also to add JAXB dependency, since it was moved to JavaEE starting Java 9 and completely deprecated in Java 11.

***
Thank you for reading so far.

Have a nice day,

__Martin Sinković__, *6 Jan 2017*

* Last update: *6 Jun 2020, 02:07 AM*

[Spring Boot 1.4.3]: https://docs.spring.io/autorepo/docs/spring-boot/1.4.3.BUILD-SNAPSHOT/reference/htmlsingle/
[Thymeleaf]: https://www.thymeleaf.org/
[DataTables]: https://datatables.net/
[Bootstrap]: http://getbootstrap.com
[Maven]: https://maven.apache.org/
[JDK 1.8]: https://openjdk.java.net/
[Jetty]: https://www.eclipse.org/jetty/
[H2 database]: https://www.h2database.com/html/main.html
[Heroku]: https://www.heroku.com/
[Tutorial]: https://devcenter.heroku.com/articles/heroku-cli#getting-started
[PostgreSQL]: https://www.postgresql.org/
