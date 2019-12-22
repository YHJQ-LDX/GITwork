package com.yhjqsw.wm.common;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 启动器
 * @author Louis
 * @date Oct 29, 2018
 */
//@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages={"com.yhjqsw.wm"})
@EnableScheduling//启动定时
//@MapperScan("com.yhjqsw.wm.*.dao")
public class WMAdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(WMAdminApplication.class, args);
	}
}
