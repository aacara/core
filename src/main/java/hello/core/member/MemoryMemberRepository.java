package hello.core.member;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
@Component // memoryMemberRepository
public class MemoryMemberRepository implements MemberRepository {


	// 실무에선 동시성 이슈 발생할 수 있기 때문에 ConcurrentHashMap<>() 사용
	private static Map<Long, Member> store = new HashMap<>();
	@Override
	public void save(Member member) {
		store.put(member.getId(), member);
	}

	@Override
	public Member findById(Long memberId) {
		return store.get(memberId);
	}
}
