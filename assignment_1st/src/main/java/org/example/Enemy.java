package org.example;

import java.util.Random;

public class Enemy {
    private final int Max_HP;
    private int HP;
    private final int AD;
    private final int ad_def;
    private final int ap_def;

    //생성자
    public Enemy(int player_num){
        this.Max_HP = 100*player_num;
        this.HP=100*player_num;
        this.AD=25;
        this.ad_def=7;
        this.ap_def=7;
    }
    //Getter
    public int getHP() {
        return HP;
    }

    public int getAD() {
        return AD;
    }

    public int getAd_def() {
        return ad_def;
    }

    public int getAp_def() {
        return ap_def;
    }
    //데미지 함수
    public void damaged(int damage) {
        if(this.HP-damage<0){
            this.HP=0;
        }else this.HP-=damage;
    }
    //일반공격
    public void basic_attack(Player player) {
        int damage=this.AD;
        player.damaged(damage);
        System.out.println(player.getId()+"번 유저("+player.getName()+")에게 "+damage+"의 데미지. 적의 공격으로 남은 체력은 "+player.getHP()+"입니다.");
    }
    //heal
    public void heal(){
        int heal_amount=7;
        if(this.Max_HP<(this.HP+heal_amount)){
            System.out.println(Print.ENEMY_HP_FULL.getText());
        }
        else{
            this.HP+=heal_amount;
            System.out.println("적의 회복으로 현재 적의 체력은" +this.HP+"입니다.");
        }
    }
    //액션
    public void action(Player player){
        System.out.println(Print.LINE.getText());
        System.out.println(Print.ENEMY_TURN.getText());
        Random random=new Random();
        int action_Num=random.nextInt(1,11);
        if(action_Num==1){
            System.out.println(Print.ENEMY_CANT_MOVE.getText());
        }else if(2<=action_Num && action_Num<=8){
            basic_attack(player);
        }
        else heal();
    }


}
