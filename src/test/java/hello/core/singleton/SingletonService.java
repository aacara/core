package hello.core.singleton;

public class SingletonService {

	// static은 클래스 레벨에 존재하므로 딱 1개만 존재
	private static final SingletonService instance = new SingletonService();

	public static SingletonService getInstance() {
		return instance;
	}

	private SingletonService() {}

	public void logic() {
		System.out.println("싱글톤 객체 로직 호출");
	}
}
