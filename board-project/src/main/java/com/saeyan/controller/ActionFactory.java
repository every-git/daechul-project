package com.saeyan.controller;

import com.saeyan.controller.action.Action;
import com.saeyan.controller.action.member.*;
import com.saeyan.controller.action.board.*;
import com.saeyan.controller.action.admin.*;

/**
 * ActionFactory - Action 생성 팩토리 클래스
 * 
 * 역할:
 * - command 파라미터에 따라 적절한 Action 인스턴스를 생성하여 반환
 * - Servlet에서 요청을 받아 적절한 Action으로 라우팅
 * - 모든 Action 인스턴스 생성을 중앙 집중식으로 관리
 * 
 * 설계 패턴:
 * - Factory Pattern: 객체 생성을 담당하는 팩토리 클래스
 * - Singleton Pattern: 인스턴스를 하나만 생성하여 재사용
 * 
 * 처리 흐름:
 * 1. Servlet에서 command 파라미터 추출
 * 2. ActionFactory.getInstance()로 팩토리 인스턴스 획득
 * 3. getAction(command)로 적절한 Action 인스턴스 생성
 * 4. 생성된 Action의 execute() 메서드 호출
 * 
 * 지원하는 command 목록:
 * - 회원 관련: login_form, login, logout, join_form, join, id_check, update
 * - 게시판 관련: board_list, board_view, board_write_form, board_write, board_update_form, board_update, board_delete
 * - 관리자 관련: admin_main, member_list, member_detail, member_delete, board_manage_list, board_manage_delete
 * 
 * web-study-11 패턴 적용
 */
public class ActionFactory {

    /**
     * 싱글톤 인스턴스 (클래스 로드 시 한 번만 생성)
     */
    private static ActionFactory instance = new ActionFactory();

    /**
     * private 생성자 - 외부에서 인스턴스 생성 방지
     * 싱글톤 패턴 구현
     */
    private ActionFactory() {
        // Singleton 패턴
    }

    /**
     * 싱글톤 인스턴스를 반환하는 메서드
     * 
     * @return ActionFactory의 유일한 인스턴스
     */
    public static ActionFactory getInstance() {
        return instance;
    }

    /**
     * command에 따라 적절한 Action 인스턴스를 생성하여 반환하는 메서드
     * 
     * 처리 과정:
     * 1. command 파라미터를 받아서 문자열 비교
     * 2. 일치하는 command에 따라 해당 Action 클래스의 인스턴스 생성
     * 3. 생성된 Action 인스턴스 반환
     * 4. 일치하는 command가 없으면 null 반환
     * 
     * 주의사항:
     * - 각 요청마다 새로운 Action 인스턴스를 생성 (Thread-safe)
     * - command가 null이거나 일치하지 않으면 null 반환
     * 
     * @param command 요청 커맨드 (예: "board_list", "login", "admin_main" 등)
     * @return Action 인스턴스 (일치하는 command가 없으면 null)
     */
    public Action getAction(String command) {
        Action action = null;

        // ========== 회원 관련 Action ==========
        if (command.equals("login_form")) {
            action = new LoginFormAction();
        } else if (command.equals("login")) {
            action = new LoginAction();
        } else if (command.equals("logout")) {
            action = new LogoutAction();
        } else if (command.equals("join_form")) {
            action = new JoinFormAction();
        } else if (command.equals("join")) {
            action = new JoinAction();
        } else if (command.equals("id_check")) {
            action = new IdCheckAction();
        } else if (command.equals("update")) {
            action = new UpdateAction();
        }

        // ========== 게시판 관련 Action ==========
        else if (command.equals("board_list")) {
            action = new BoardListAction();
        } else if (command.equals("board_view")) {
            action = new BoardViewAction();
        } else if (command.equals("board_write_form")) {
            action = new BoardWriteFormAction();
        } else if (command.equals("board_write")) {
            action = new BoardWriteAction();
        } else if (command.equals("board_update_form")) {
            action = new BoardUpdateFormAction();
        } else if (command.equals("board_update")) {
            action = new BoardUpdateAction();
        } else if (command.equals("board_delete")) {
            action = new BoardDeleteAction();
        }

        // ========== 관리자 관련 Action ==========
        else if (command.equals("admin_main")) {
            action = new AdminMainAction();
        } else if (command.equals("member_list")) {
            action = new MemberListAction();
        } else if (command.equals("member_detail")) {
            action = new MemberDetailAction();
        } else if (command.equals("member_delete")) {
            action = new MemberDeleteAction();
        } else if (command.equals("board_manage_list")) {
            action = new BoardManageListAction();
        } else if (command.equals("board_manage_delete")) {
            action = new BoardManageDeleteAction();
        }

        return action;
    }
}
