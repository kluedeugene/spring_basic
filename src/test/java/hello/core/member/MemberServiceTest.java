package hello.core.member;

import hello.core.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {
//join 데이터와 find데이터가 일치하는가?

    MemberService memberService ;

    @BeforeEach //각 테스트 수행전 실행되는
    public void beforeEach(){
        AppConfig appConfig = new AppConfig();
         memberService = appConfig.memberService();

    }

    @Test
    void join(){
        //given
        Member member = new Member(1L, "memberA,", Grade.VIP);

        //when
        memberService.join(member);
        Member findMember = memberService.findMember(1L);


        //then
        Assertions.assertThat(member).isEqualTo(findMember);



    }
}
