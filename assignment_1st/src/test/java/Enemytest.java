import org.example.Enemy;
import org.example.Player;

public class Enemytest {
    public static void main(String[] args) {
        //플레이어 객체 생성
        Player player=new Player(0,13);
        Enemy enemy=new Enemy(1);
//        //public void damaged(int damage)
//        System.out.println("public void damaged(int damage)");
//        enemy.damaged(3);
//        System.out.println(enemy.getHP());
//        //basic attack
//        System.out.println("public void basic_attack(Player player)");
//        enemy.basic_attack(player);
//        //heal
//        System.out.println("public void heal()");
//        enemy.heal();
        //action
        enemy.action(player);


    }
}
