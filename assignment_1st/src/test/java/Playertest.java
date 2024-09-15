import org.example.Enemy;
import org.example.Player;

public class Playertest {
    //player 객체 초기화 함수 있어야 하지 않을까..?
    public static void main(String[] args) {
        //Player 객체 생성
        Player player = new Player(0);
        //getHP함수
        System.out.println(player.getHP());
        //damaged 함수
        player.damaged(3);
        System.out.println(player.getHP());
        // 상태 확인 일반 공격
        //일단 Enemy 객체 생성
        Enemy enemy=new Enemy(1);
        //상태 확인+일반 공격
        //player.check_status(enemy);
        //기본 공격
        //player.basic_attack(enemy);
        //마법 공격
        //player.magic_attack(enemy);
        //체력 회복
        //player.heal();
        //action 함수
        player.action(enemy,0);
    }
}
