//멤버 서비스 인터페이스

package hello.core.member;

public interface MemberService {

    void join(Member member);   //회원가입

    Member findMember(Long memberId);   //조회
}
