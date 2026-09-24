package service;

import entity.Member;
import repository.MemberRepository;


import java.sql.Date;
import java.time.Instant;
import java.util.List;

public class MemberService {
    MemberRepository memberRepository = new MemberRepository();

    public void addMember(Member member) throws IllegalAccessException {
        if (member.getMemberName() == null) {
            throw new IllegalAccessException("member is null");
        }
        Member member1 = new Member();
        member1.setMemberName(member.getMemberName());
        member1.setMemberDate(Date.from(Instant.now()));
        memberRepository.addMember(member1);
    }


    public void update(int id, String name) {
        if (!memberRepository.existById(id)) {
            throw new RuntimeException("member not found!");
        }
        memberRepository.update(id, name);

    }


    public void delete(int id) {
        if (!memberRepository.existById(id)) {
            throw new RuntimeException("member not found!");
        }
        memberRepository.delete(id);

    }

    public List<Member> membersList() {
        return memberRepository.membersList();
    }

}
