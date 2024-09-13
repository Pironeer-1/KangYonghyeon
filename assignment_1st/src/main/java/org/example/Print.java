package org.example;

public enum Print {
    LINE("------------------------------------------------------------------------------"),
    PLAYER_ADD_STATE("플레이어 이름과 13만큼의 스테이터스를 추가합니다. 이름, 체력, 공격력, 마법력 순으로 입력하세요\n(1 포인트 당 체력 = 3, 공격력 = 1, 마법력 = 1 증가)"),
    PLAYER_ADD_STATE_SUM_ERROR("총합이 13이 되어야 합니다"),
    PLAYER_ADD_STATE_TYPE_ERROR("hp, ad, ap는 정수로 입력해야 합니다. 다시 입력해주세요."),
    EXIT("프로그램을 종료합니다."),
    PLAYER_ACTION_NUM_ERROR("1~4 사이의 정수를 입력해주세요."),
    TYPE_ERROR("잘못된 입력입니다. 숫자를 입력해주세요."),
    ENEMY_HP_FULL("적이 회복했지만 적은 이미 최대체력입니다."),
    ENEMY_TURN("적의 차례입니다."),
    ENEMY_CANT_MOVE("적은 섣불리 움직이지 못하고 있습니다."),
    GAME_MEMBER_SETTING("플레이어 인원을 정하세요:"),
    GAME_MEMBER_SETTING_NUM_ERROR("플레이어 인원은 1 이상이어야 합니다."),
    WIN("축하합니다! 승리하셨습니다!"),
    LOSE("아쉽지만 패배하셨습니다.");



    private final String text;

    Print(String text) {
        this.text = text;
    }
    public String getText() {
        return text;
    }
}