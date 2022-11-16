//멤버서비스에 대한 구현체

package hello.core.member;

public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository ;     //생성자를 통해 memory멤버레포가 할당된다.

    public MemberServiceImpl(MemberRepository memberRepository) {   //생성자를 통해 memberRepository에 무엇이 들어갈지 선택한다.
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member) ;
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
