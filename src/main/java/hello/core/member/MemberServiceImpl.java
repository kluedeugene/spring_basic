//멤버서비스에 대한 구현체

package hello.core.member;

public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();     //추상화에도 의존하고 구체화에도 의존하고있는것. dip위반

    @Override
    public void join(Member member) {
        memberRepository.save(member) ;
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
