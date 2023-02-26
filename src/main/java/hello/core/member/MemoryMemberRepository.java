//멤버 레파지토리 메모리 버전 구현체

package hello.core.member;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();   //동시성 이슈가 있을수 있기때문에 실무에선 컨커러드 해쉬맵?을 사용해야한다.

    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
