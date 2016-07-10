package ru.codinghard.prototype.entitygraph;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import ru.codinghard.prototype.entitygraph.dal.ModuleConfiguration;

@Configuration
@Import(ModuleConfiguration.class)
@ComponentScan
public class ServiceConfiguration {
}
