package hello.core.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

public class NetworkClient {
// public class NetworkClient implements InitializingBean, DisposableBean {
	private String url;

	public NetworkClient() {
		System.out.println("생성자 호출, url = " + url);
		// connect();
		// call("초기화 연결 메시지");
	}

	public void setUrl(String url) {
		this.url = url;
	}

	// 서비스 시작 시 호출
	public void connect() {
		System.out.println("connect: " + url);
	}

	public void call(String message) {
		System.out.println("call: " + url + "message = " + message);
	}

	// 서비스 종료 시 호출
	public void disconnect() {
		System.out.println("close: " + url);
	}

	@PostConstruct
	public void init() {
		System.out.println("NetworkClient.init");
		connect();
		call("초기화 연결 메시지");
	}

	@PreDestroy
	public void close() {
		System.out.println("NetworkClient.close");
		disconnect();
	}

	/*// DisposableBean
	@Override
	public void destroy() throws Exception {
		disconnect();
	}

	// initializingBean
	@Override
	public void afterPropertiesSet() throws Exception {
		connect();
		call("초기화 연결 메시지");
	}*/
}
