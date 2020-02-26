package com.eomcs.lms.servlet;

import java.io.PrintStream;
import java.util.Scanner;
import com.eomcs.lms.dao.MemberDao;
import com.eomcs.lms.domain.Member;
import com.eomcs.util.Prompt;

public class MemberAddServlet implements Servlet {

  MemberDao memberDao;

  public MemberAddServlet(MemberDao memberDao) {
    this.memberDao = memberDao;
  }

  @Override
  public void service(Scanner in, PrintStream out) throws Exception {
    Member member = new Member();
    member.setName(Prompt.getString(in, out, "이름?"));
    member.setEmail(Prompt.getString(in, out, "이메일?"));
    member.setPassword(Prompt.getString(in, out, "암호?"));
    member.setTel(Prompt.getString(in, out, "전화?"));
    member.setPhoto(Prompt.getString(in, out, "사진?"));

    if (memberDao.insert(member) > 0) {
      out.println("회원 정보를 입력했습니다.");

    } else {
      out.println("회원 정보 입력을 실패했습니다.");
    }
  }
}
