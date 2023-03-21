package com.algos.algosfun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.algos.algosfun"})
@EntityScan({"com.algos.algosfun.model"})
public class AlgosfunApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlgosfunApplication.class, args);
	}

}
