--ddl
create table config_properties_repository (config_repository_config_key bigint not null, config_properties_list_properties_key bigint not null) ENGINE=InnoDB DEFAULT CHARSET=utf8;
create table config_properties (properties_key bigint not null auto_increment, content JSON, properties_name varchar(255), primary key (properties_key)) ENGINE=InnoDB DEFAULT CHARSET=utf8;
create table config_repository (config_key bigint not null auto_increment, application varchar(255), label varchar(255), profile varchar(255), version varchar(255), primary key (config_key)) ENGINE=InnoDB DEFAULT CHARSET=utf8;
alter table config_properties_repository add constraint FKoa6yu64ai6w6a7ww2km1ss8c7 foreign key (config_properties_list_properties_key) references config_properties (properties_key);
alter table config_properties_repository add constraint FKnhrfr2b8vid0nif6l04mqqmr2 foreign key (config_repository_config_key) references config_repository (config_key);

--dml
INSERT INTO `config_repository` (`config_key`, `application`, `label`, `profile`, `version`)
VALUES
	(1, 'config-client', 'master', 'prd', '1'),
	(2, 'config-client', 'master', 'dev', '1');
INSERT INTO `config_properties` (`properties_key`, `content`, `properties_name`)
VALUES
	(1, '{\"key\": \"value\", \"info.from\": \"config-server-db\"}', 'test'),
	(2, '{\"key2\": \"value2\"}', 'test2');
INSERT INTO `config_properties_repository`
VALUES
	(1, 1),
	(1, 2),
	(2, 1);