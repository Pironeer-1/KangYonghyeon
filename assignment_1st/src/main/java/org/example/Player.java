package org.example;

import java.util.Random;
import java.util.Scanner;

public class Player {
    private int id;
    private String name;
    private int HP=50;
    private int AD=10;
    private int AP=5;

    Scanner sc = new Scanner(System.in);

    public Player(int id,int state_point) {
        //id 생성
        this.id = id+1;
        //자바 생성자 안에도 if 문 사용가능
        //숫자입력 안될시 예외 처리
        System.out.println(Print.LINE.getText());
        System.out.println(Print.PLAYER_ADD_STATE.getText());
        this.name = sc.next();
        while (true) {
                try {
                    int hp = sc.nextInt();
                    int ad = sc.nextInt();
                    int ap = sc.nextInt();

                    if (hp + ad + ap == state_point) {
                        this.HP += hp * 3;
                        this.AD += ad;
                        this.AP += ap;
                        System.out.println("플레이어: " + this.name + "체력: " + this.HP + ", 공격력: " + this.AD + ", 마법력: " + this.AP);
                        break;
                    } else {
                        System.out.println(Print.PLAYER_ADD_STATE_SUM_ERROR.getText());
                    }
                } catch (Exception e) {
                    System.out.println(Print.TYPE_ERROR.getText());
                    sc.nextLine();
                }
        }


    }

    //id getter
    public int getId() {
        return id;
    }

    //HP getter
    public int getHP() {
        return HP;
    }
    //이름 getter
    public String getName() {
        return name;
    }

    //데미지 받는 함수
    public void damaged(int damage){
        if(this.HP-damage<0){
            this.HP=0;
        }else this.HP-=damage;
    }
    //상태 확인 + 일반공격
    public void check_status(Enemy enemy){
        System.out.println("현재유저"+this.name+":체력:"+this.HP+", 공격력 "+this.AD+", 마법력 "+this.AP);
        System.out.println("적:체력"+enemy.getHP()+", 공격력"+ enemy.getAD()+", 방어력 "+enemy.getAd_def()+", 마법방어력"+enemy.getAp_def());
        //공격
        int damage=this.AD-enemy.getAd_def();
        enemy.damaged(damage);
        System.out.println("일반 공격으로 "+damage+"의 데미지를 주었습니다.");
    }

    //기본 공격
    public void basic_attack(Enemy enemy){
        Random rand = new Random();
        int action_Num= rand.nextInt(11);
        int damage;
        if (action_Num>2){
            damage=this.AD-enemy.getAd_def();
            enemy.damaged(damage);
            System.out.println("일반 공격으로"+damage+"의 데미지를 주었습니다.");
        }else {
            damage=(this.AD-enemy.getAd_def())*2;
            enemy.damaged(damage);
            System.out.println("치명타가 적용되어"+damage+"의 데미지를 주었습니다.");
        }
    }
    //마법 공격
    public void magic_attack(Enemy enemy){
        int damage=this.AP*2-enemy.getAp_def();
        enemy.damaged(damage);
        System.out.println("마법 공격으로 "+damage+"의 데미지를 주었습니다.");
    }
    // 체력 회복
    public void heal(){
        Random rand = new Random();
        //이거 맞겠지?
        int amount_heal=rand.nextInt(5,11);
        this.HP+=amount_heal;
        System.out.println("체력을 회복합니다. 현재 hp는 "+ this.HP+"입니다.");
    }
    public void action(Enemy enemy,int player_index){
        System.out.println("------------------------------------------------------------------------------");
        System.out.println(player_index+"번 플레이어 "+this.name+"의 차례입니다. 행동을 선택하세요. (1: 스테이터스 확인 + 일반 공격, 2: 기본 공격, 3: 마법 공격, 4: 체력 회복, exit: 종료)");
        while (true){
                String input_key=sc.next();
                if (input_key.equals("exit")){
                    System.out.println(Print.EXIT.getText());
                    //시스템 종료 까지 되는지 확인
                    System.exit(0);
                    //이걸로 시스템 종료
                    break;
                }else {
                    try {
                        switch (Integer.parseInt(input_key)){
                            case 1:
                                check_status(enemy);
                                break;
                            case 2:
                                basic_attack(enemy);
                                break;
                            case 3:
                                magic_attack(enemy);
                                break;
                            case 4:
                                heal();
                                break;
                            default:
                                System.out.println(Print.PLAYER_ACTION_NUM_ERROR.getText());
                        }
                        break;
                    }catch (Exception e){
                        System.out.println(Print.TYPE_ERROR.getText());
                    }


            }
        }


    }
}
