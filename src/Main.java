import entity.Member;
import service.MemberService;

void main() {

    MemberService memberService = new MemberService();

    //memberService.addMember("maryam");
    //memberService.update(2, "sara");
    // memberService.delete(3);
    List<Member> members = memberService.membersList();
    for(Member member:members){
        System.out.println("member = " + member);
    }


}
