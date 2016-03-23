SET FOREIGN_KEY_CHECKS=0;

/*DROP TABLE IF EXISTS `api`;
CREATE TABLE `api` (
  `id` varchar(45) NOT NULL,
  `api_key` varchar(100) NOT NULL,
  `date_created` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  `last_updated` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `audit_trail_api` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `processing_server_ip` varchar(45),
  `device_id` varchar(45) DEFAULT NULL,
  `api_id` varchar(45) DEFAULT NULL,
  `os_version` varchar(45) DEFAULT NULL,
  `http_method` varchar(45) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `header` text,
  `body` text,
  `response_status` int(11) DEFAULT NULL,
  `type` varchar(255) NOT NULL,
  `date_created` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  `last_updated` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),  
  KEY `INDEX_api_id` (`api_id`),
  CONSTRAINT `FK_audit_trail_api_api_id` FOREIGN KEY (`api_id`) REFERENCES `api` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `audit_trail_api_gateway` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `gateway` varchar(45) DEFAULT NULL,
  `method_name` varchar(45) DEFAULT NULL,
  `body` text,
  `type` varchar(255) NOT NULL,
  `date_created` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  `last_modified_date` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `audit_trail_exception`;
CREATE TABLE `audit_trail_exception` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `stack_trace` text,
  `date_created` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  `last_updated` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `config`;
CREATE TABLE `config` (
  `id` varchar(45) NOT NULL,
  `description` varchar(255) NOT NULL,
  `value` varchar(255) NOT NULL,
  `type` varchar(10) NOT NULL,
  `date_created` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  `last_updated` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `scheduled_task` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `task_name` varchar(45)  NOT NULL,
  `second` varchar(45)  DEFAULT '*',
  `minute` varchar(45)  DEFAULT '*',
  `hour` varchar(45)  DEFAULT '*',
  `day_of_month` varchar(45) COLLATE DEFAULT '*',
  `month` varchar(45) COLLATE DEFAULT '*',
  `day_of_week` varchar(45) COLLATE DEFAULT '*',
  `year` varchar(45) COLLATE DEFAULT '*',
  `date_created` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  `last_updated` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `state` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `INDEX_state` (`state`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;*/

CREATE TABLE `User` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `mobile` varchar(45) NOT NULL,  
  `first_name` varchar(255) NOT NULL,  
  `last_name` varchar(255) DEFAULT NULL,  
  `email` varchar(100) DEFAULT NULL,
  `pin` varchar(255) NOT NULL,
  `date_of_birth` DATE DEFAULT NULL,
  `gender` varchar(10) DEFAULT NULL,
  `date_created` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  `status` varchar(25) NOT NULL,  
  PRIMARY KEY (`id`),
  UNIQUE KEY `UNIQUE_mobile` (`mobile`),
  UNIQUE KEY `UNIQUE_email` (`email`),
  KEY `INDEX_status` (`status`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--DROP TABLE IF EXISTS `user_credentials`;
--/*!40101 SET @saved_cs_client     = @@character_set_client */;
--/*!40101 SET character_set_client = utf8 */;
--CREATE TABLE `user_credentials` (
--  `user_id` int(10) unsigned NOT NULL,
--  `credentials_id` int(11) NOT NULL,
--  `session_expiry_date` datetime NOT NULL,
--  `session_key` varchar(45) COLLATE DEFAULT NULL,
--  `create_date` datetime NOT NULL,
--  `last_modified_date` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
--  PRIMARY KEY (`user_id`, `credentials_id`),
--  number_plate
--  CONSTRAINT `FK_user_credentials_credentials_id` FOREIGN KEY (`credentials_id`) REFERENCES `credentials` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
--) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

SET FOREIGN_KEY_CHECKS=1;
