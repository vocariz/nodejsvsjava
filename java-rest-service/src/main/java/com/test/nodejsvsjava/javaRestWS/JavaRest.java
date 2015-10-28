package com.test.nodejsvsjava.javaRestWS;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect(fieldVisibility = ANY)
public class JavaRest {

	private final long responseId;
	private final int requestId;
	private final int delayMillis;

	public JavaRest(long responseId, int requestId, int delayMillis) {
		this.responseId = responseId;
		this.requestId = requestId;
		this.delayMillis = delayMillis;
	}

	public long getResponseId() {
		return responseId;
	}

	public int getRequestId() {
		return requestId;
	}

	public int getDelayMillis() {
		return delayMillis;
	}

}
