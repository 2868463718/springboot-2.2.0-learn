package zy.blue7.helloworld.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * @author blue7
 * @create 2020/12/31 15:04
 */
@RestController
public class HelloWorldController {
	@Autowired
	RestTemplate restTemplate;

	@GetMapping("index")
	public String index() {
//		a();
		return "hello world";
	}

	public void a() {
//		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		httpHeaders.set(HttpHeaders.USER_AGENT, "PostmanRuntime/7.26.8");
		List<MediaType> mediaTypes = new ArrayList<>();
		mediaTypes.add(MediaType.ALL);
		httpHeaders.setAccept(mediaTypes);
		httpHeaders.add("Host", "andata.somedata.top");
		httpHeaders.add("Accept-Encoding", "gzip, deflate, br");
		httpHeaders.add("Connection", "keep-alive");
		httpHeaders.add("Authorization", "123");
//
//		httpHeaders.set("Authorization","Bearer {2}");
//		httpHeaders.set("User-Agent","PostmanRuntime/7.26.8");
//		httpHeaders.set("Accept","*/*");
//		httpHeaders.set("Host","andata.somedata.top");
//		httpHeaders.set("Accept-Encoding","gzip, deflate, br");
//		httpHeaders.set("Connection","keep-alive");
		System.out.println(httpHeaders);
		HttpEntity<String> httpEntity = new HttpEntity<>(httpHeaders);
		//发送请求，封装结果数据
		String body = restTemplate
				.getForObject("https://andata.somedata.top/data-2020/char/data/char_123_fang.json", String.class, httpEntity);

		

	}
}
