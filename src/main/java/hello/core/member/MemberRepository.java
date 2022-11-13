//인터페이스

package hello.core.member;

public interface MemberRepository
{
    void save(Member member);

    Member findById(Long memberId);
}
