package com.test.nodejsvsjava.javaRestWS;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.concurrent.atomic.AtomicLong;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.AbstractJsonpResponseBodyAdvice;

@RestController
public class JavaRestController {

	private final AtomicLong counter = new AtomicLong();

	private Logger log = LoggerFactory.getLogger(JavaRestController.class);

	@ControllerAdvice
	static class JsonpAdvice extends AbstractJsonpResponseBodyAdvice {
		public JsonpAdvice() {
			super("callback");
		}
	}

//	@Bean
//	public HttpMessageConverters customConverters() {
//		return new HttpMessageConverters(false, Collections.<HttpMessageConverter<?>> singleton(new MappingJackson2HttpMessageConverter()));
//	}

	@RequestMapping(value = "/javaRest/{requestId}/{delayMillis}", produces = APPLICATION_JSON_VALUE)
	public JavaRest javaRest(@PathVariable int requestId, @PathVariable int delayMillis) throws Exception {
		log.info("javaRest; requestId=" + requestId + "; delayMillis=" + delayMillis + ";");
		if (delayMillis > 0) {
			Thread.sleep(delayMillis);
		}
		return new JavaRest(counter.incrementAndGet(), requestId, delayMillis);
	}

	@RequestMapping(value = "/javaRest2", produces = APPLICATION_JSON_VALUE)
	public JavaRest javaRest2(@RequestParam int requestId, @RequestParam int delayMillis) throws Exception {
		log.info("javaRest2; requestId=" + requestId + "; delayMillis=" + delayMillis + ";");
		if (delayMillis > 0) {
			Thread.sleep(delayMillis);
		}
		return new JavaRest(counter.incrementAndGet(), requestId, delayMillis);
	}
}
