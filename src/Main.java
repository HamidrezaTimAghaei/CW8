import entity.Book;
import entity.Member;
import service.BookService;
import service.MemberService;

void main() throws IllegalAccessException {

    MemberService memberService = new MemberService();
    BookService bookService = new BookService();

    memberService.addMember(new Member(1, "hamidreza"));
    memberService.addMember(new Member("mahla",new Date()));
//    bookService.addBook(new Book(1, "java", "hamidreza", "123"));

//    //memberService.addMember("maryam");
//    //memberService.update(2, "sara");
//    // memberService.delete(3);
//    List<Member> members = memberService.membersList();
//    for (Member member : members) {
//        System.out.println("member = " + member);
//    }


}
