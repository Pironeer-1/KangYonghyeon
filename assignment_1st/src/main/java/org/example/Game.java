package org.example;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Game {
    private int state_point=13;
    private ArrayList<Player> players;
    private Enemy enemy;
    //input 받기
    Scanner sc=new Scanner(System.in);

    //생성자? 그냥 기본 생성자 이면 될듯

    //set_players
    public void set_players() {
        System.out.println(Print.GAME_MEMBER_SETTING.getText());
        players=new ArrayList<>();
        int player_num;
        while (true){
            try {
                player_num=sc.nextInt();
                if (player_num<=0){
                    System.out.println(Print.GAME_MEMBER_SETTING_NUM_ERROR.getText());
                }else break;
            }catch (Exception e){
                System.out.println(Print.TYPE_ERROR.getText());
                sc.nextLine();
            }
        }

        for(int i=0;i<player_num;i++){
            this.players.add(new Player(i,state_point));
        }
    }
    //enemy 생성
    public void set_Enemy(){
        this.enemy=new Enemy(this.players.size());
    }
    //turn_check-> fillter로 가져와 보기
    public Boolean turn_check(){
        players.removeIf(player -> player.getHP()==0);
        return !this.players.isEmpty() && this.enemy.getHP() != 0;
    }
    //player 선택
    public Player select_player(){
        Random rand=new Random();
        int player_num=rand.nextInt(this.players.size());//n-1 반환
        return players.get(player_num);
    }
    //start
    public void start(){
        //플레이어 설정
        set_players();
        //적 설정
        set_Enemy();
        while(turn_check()){
            for (Player player : this.players) {
                player.action(enemy, player.getId());
                if (enemy.getHP() == 0) break;
            }
            //몬스터 공격 차례
            if (turn_check()){
                enemy.action(select_player());
            }else break;
        }
        if (enemy.getHP()<=0) System.out.println(Print.WIN.getText());
        else System.out.println(Print.LOSE.getText());
    }


}
