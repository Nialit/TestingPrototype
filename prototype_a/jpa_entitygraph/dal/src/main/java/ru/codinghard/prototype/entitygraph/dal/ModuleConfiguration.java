package ru.codinghard.prototype.entitygraph.dal;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import ru.codinghard.prototype.entitygraph.dal.model.Parent;

//This annotation needed for unit-test
@EnableAutoConfiguration
@Configuration
@ComponentScan({"ru.codinghard.prototype.entitygraph.dal"})
@EnableJpaRepositories
@EnableTransactionManagement
@EntityScan(basePackageClasses = Parent.class)
@PropertySource("classpath:dal.properties")
@ImportResource("classpath:tx-advice.xml")
public class ModuleConfiguration {
}
