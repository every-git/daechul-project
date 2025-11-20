package com.saeyan.controller;

import com.saeyan.controller.action.Action;
import com.saeyan.controller.action.member.*;
import com.saeyan.controller.action.board.*;
import com.saeyan.controller.action.admin.*;

/**
 * ActionFactory - Action 생성 팩토리 클래스 (Singleton 패턴)
 * web-study-11 패턴 적용
 */
public class ActionFactory {

    private static ActionFactory instance = new ActionFactory();

    private ActionFactory() {
        // Singleton 패턴
    }

    public static ActionFactory getInstance() {
        return instance;
    }

    /**
     * command에 따라 적절한 Action 인스턴스를 생성하여 반환
     * 
     * @param command 요청 커맨드
     * @return Action 인스턴스
     */
    public Action getAction(String command) {
        Action action = null;

        // 회원 관련 Action
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
        } else if (command.equals("update")) {
            action = new UpdateAction();
        }

        // 게시판 관련 Action
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

        // 관리자 관련 Action
        else if (command.equals("admin_main")) {
            action = new AdminMainAction();
        } else if (command.equals("member_list")) {
            action = new MemberListAction();
        } else if (command.equals("member_detail")) {
            action = new MemberDetailAction();
        } else if (command.equals("board_manage_list")) {
            action = new BoardManageListAction();
        } else if (command.equals("board_manage_delete")) {
            action = new BoardManageDeleteAction();
        } else if (command.equals("board_manage_update")) {
            action = new BoardManageUpdateAction();
        }

        return action;
    }
}
