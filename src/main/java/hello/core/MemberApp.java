package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;

public class MemberApp {

    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();        //memberservice 요청-> appconfig에서 memoryMemberRepo를 사용해서 impl 생성, 반환
//        MemberService memberService = new MemberServiceImpl();        //기존에 직접 memberService 객체 생성..
        Member member = new Member(1L, "memberA", Grade.VIP);        //1L = long  타입 지정
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("find Member = " + findMember.getName());
    }
}
