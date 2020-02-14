create table if not exists `T_SHORT_URL`(
`ID` int(11) not null  auto_increment,
`SHORT_URL` varchar(100),
`ORIGIN_URL` varchar(2000),
`CREATE_TIME` timestamp not null default CURRENT_TIMESTAMP,
`MODIFY_TIME` timestamp not null default CURRENT_TIMESTAMP,
 PRIMARY KEY (`ID`)
)