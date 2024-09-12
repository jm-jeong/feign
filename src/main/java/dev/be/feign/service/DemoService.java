package dev.be.feign.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import dev.be.feign.common.dto.BaseResponseInfo;
import dev.be.feign.feign.DemoFeignClient;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DemoService {
	private final DemoFeignClient demoFeignClient;

	public String get() {
		ResponseEntity<BaseResponseInfo> response = demoFeignClient.callGet("Custom header",
			"CustomName",
			1L);
		System.out.println("name = " + response.getBody().getName());
		System.out.println("Age : " + response.getBody().getAge());
		System.out.println("Header : " + response.getBody().getHeader());
		return "get";
	}
}
