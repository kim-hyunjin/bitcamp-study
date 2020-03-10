// 조인 데이터 가져오기 - 각 테이블의 데이터를 별도로 가져오기
package com.eomcs.mybatis.ex04;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Scanner;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


public class Exam0110 {

  public static void main(String[] args) throws Exception {

    InputStream mybatisConfigInputStream = new FileInputStream(//
        "./bin/main/com/eomcs/mybatis/ex04/mybatis-config.xml");

    SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
    SqlSessionFactory factory = sqlSessionFactoryBuilder.build(mybatisConfigInputStream);
    SqlSession sqlSession = factory.openSession();

    Scanner keyScan = new Scanner(System.in);
    System.out.print("번호? ");
    int no = Integer.parseInt(keyScan.nextLine());

    keyScan.close();

    Board board = sqlSession.selectOne("BoardMapper.selectBoard", no);
    System.out.println();
    System.out.println("[게시글 조회]");
    System.out.printf("번호: %d\n", board.getNo());
    System.out.printf("제목: %s\n", board.getTitle());
    System.out.printf("내용: %s\n", board.getContent());
    System.out.printf("등록일: %s\n", board.getRegisteredDate());
    System.out.printf("조회수: %d\n", board.getViewCount());
    System.out.println();

    // 조인을 사용하지 않으면 다음과 같이
    // 게시글의 첨부파일 데이터를 따로 조회해야 한다.
    List<AttachFile> files = sqlSession.selectList("BoardMapper.selectFile", no);
    System.out.println("[첨부파일]");
    for (AttachFile file : files) {
      System.out.printf("%d, %s\n", file.getNo(), file.getFilePath());
    }

    sqlSession.close();
  }

}


