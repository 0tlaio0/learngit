
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
class Skills{
    public void NormalAttack(Npc p1,Npc p2){//1普通攻击
        System.out.println("-------------------------------------------------------");
        System.out.println(p1.getName()+"使用了普通攻击");
        int a = p1.getATK()-p2.getDEF();
        if (a<0)a=0;
        System.out.println(p1.getName() + "对" + p2.getName() + "造成" + a + "点伤害");
        int b = p2.getHP() - a;
        System.out.println(p2.getName() + "还有" + b + "点生命值");
        p2.setHP(b);




    }
    public void ShieldSlam(Npc p1,Npc p2){//2盾牌猛击
        System.out.println("-------------------------------------------------------");
        System.out.println(p1.getName()+"使用了盾牌猛击");
        int a = p1.getDEF()-p2.getDEF();
        if (a<0)a=0;
        System.out.println(p1.getName() + "对" + p2.getName() + "造成" + a + "点伤害");
        int b = p2.getHP() - a;
        System.out.println(p2.getName() + "还有" + b + "点生命值");
        p2.setHP(b);
        System.out.println("-------------------------------------------------------");
    }
    public void bloodlust(Npc p1,Npc p2){//3嗜血
        System.out.println("-------------------------------------------------------");
        System.out.println(p1.getName()+"使用了嗜血");
        int a = p1.getATK()*3/2-p2.getDEF();
        if (a<0)a=0;
        System.out.println(p1.getName() + "对" + p2.getName() + "造成" + a + "点伤害");
        int b = p2.getHP() - a;
        System.out.println(p2.getName() + "还有" + b + "点生命值");
        p2.setHP(b);
        int c = a/5;
        System.out.println(p1.getName()+"回复了"+c+"点生命值");
        p1.setHP(p1.getHP()+c);



        System.out.println("-------------------------------------------------------");
    }
    public void ShieldBlock(Npc p1){//4盾牌格挡
        System.out.println("-------------------------------------------------------");
        System.out.println(p1.getName()+"使用了盾牌格挡");
        p1.setDEF(p1.getDEF()+p1.getDEF()/5);
        System.out.println(p1.getName()+"的防御力提高到"+p1.getDEF()+"点");
        System.out.println("-------------------------------------------------------");

    }
    public void WhirlWind(Npc p1,Npc[] npcs,int cd){//5旋风斩

        System.out.println(p1.getName()+"使用了旋风斩");
        if (cd-p1.getCD()<3){
            System.out.println("技能还未冷却");
            return;
        }
        for (int i=0;i<npcs.length;i++){if (p1==npcs[i]){continue;}
            int b = p1.getATK()-npcs[i].getDEF();
            if (b<0)b=0;
            System.out.println(p1.getName() + "对" + npcs[i].getName() + "造成" + b + "点伤害");
            int c = npcs[i].getHP() - b;
            System.out.println(npcs[i].getName() + "还有" + c + "点生命值");
            npcs[i].setHP(c);
        }
        npcs[0].setATK(npcs[0].getATK()-npcs[0].getATK()*3/10);
        System.out.println(npcs[0].getName()+"的攻击力下降到"+npcs[0].getATK()+"点");
p1.setCD(cd);
    }
}
class Npc{protected String name;
    private int HP;
    private int ATK;
    private int DEF;
    private int CODE;
    private int CD;
    private int PFS;

    public int getPFS() {
        return PFS;
    }

    public void setPFS(int PFS) {
        this.PFS = PFS;
    }

    public int getCD() {
        return CD;
    }

    public void setCD(int CD) {
        this.CD = CD;
    }

    public  Npc(String a, int b, int c, int d){
    this.name=a;
    this.HP=b;
    this.ATK=c;
    this.DEF=d;
}

    public int getCODE() {
        return CODE;
    }

    public void setCODE(int CODE) {
        this.CODE = CODE;
    }

    public void setATK(int a) {
        this.ATK = a;
    }



    public void setHP(int a) {

        this.HP = a;
    }

    public void setName(String a) {

        this.name = a;
    }

    public void setDEF(int DEF) {
        this.DEF = DEF;
    }

    public int getDEF() {
        return DEF;
    }

    public int getATK() {
        return ATK;
    }



    public int getHP() {
        return HP;
    }

    public String getName() {
        return name;
    }
    public void getInformation() {

        System.out.println("角色:" + this.name);
        System.out.println("HP:" + this.HP);
        System.out.println("ATK:" + this.ATK);
        System.out.println("DEF:" + this.DEF);
        System.out.println("-------------------------------------------------------");
    }
  }


public class homework2 {
      public static void battle(){}
      public static void monsterAtk(Npc p1,Npc p2,Npc[] all){Skills skills=new Skills();
          Random random=new Random();
          int a = random.nextInt(4)+1;
          switch (a){
              case 1:{skills.NormalAttack(p1, p2);break;}
              case 2:{skills.bloodlust(p1, p2);break;}
              case 3:{skills.ShieldBlock(p1);break;}
              case 4:{skills.ShieldSlam(p1, p2);break;}
              case 5:{skills.WhirlWind(p1,all,0);}
      }}
    public static  void playerAtk(Npc p1,Npc p2,Npc[] all,int cd){Skills skills=new Skills();
        System.out.println("请选择要使用的技能");
        switch (p1.getPFS()){
            case 1:{System.out.println("1.普通攻击\n2.嗜血\n3.盾牌格挡\n4.盾牌猛击\n5.旋风斩 ");}
        }
        Scanner sc=new Scanner(System.in);
        int a= sc.nextInt()+p1.getCODE();
        switch (a){
            case 1:{skills.NormalAttack(p1, p2);break;}
            case 2:{skills.bloodlust(p1, p2);break;}
            case 3:{skills.ShieldBlock(p1);break;}
            case 4:{skills.ShieldSlam(p1, p2);break;}
            case 5:{skills.WhirlWind(p1,all,cd);}
        }
    }




    public static void main(String[] args) {
        Random random=new Random();
        Scanner sc = new Scanner(System.in);
        Npc monster1 = new Npc("张涛",random.nextInt(100)+1,random.nextInt(100)+1,random.nextInt(100)+1);
        Npc monster2 = new Npc("林潼(BOSS)",random.nextInt(100)+1,random.nextInt(100)+1,random.nextInt(100)+1);
        Npc monster3=new Npc("张煜",random.nextInt(100)+1,random.nextInt(100)+1,random.nextInt(100)+1);
        Npc monster4=new Npc("张哲",random.nextInt(100)+1,random.nextInt(100)+1,random.nextInt(100)+1);

        Npc player=new Npc(null,0,0,0);



        System.out.println("请输入玩家名称:");
        String a=sc.nextLine();

        boolean zy;
        do {zy=false;
            System.out.println("请选择职业");
            System.out.println("1\n战士\n技能: 普通攻击、盾牌猛击、嗜血、盾牌格挡、旋风斩 ");
            System.out.println("2\n法师\n技能: 普通攻击、火球术、寒冰屏障、奥数飞弹、暴风雪 ");
            System.out.println("3\n牧师\n技能: 普通攻击、惩击、真言术：韧、暗言术：痛、神圣新星 ");
            int c=sc.nextInt();
            switch (c){
                case 1:{player.setName(a);
                player.setATK(random.nextInt(100)+1);
                player.setHP(random.nextInt(100)+1);
                player.setDEF(random.nextInt(100)+1);
                player.setCODE(0);
                player.setPFS(1);
                break;}
                case 2:{player.setName(a);
                    player.setATK(5);
                    player.setHP(5);
                    player.setDEF(5);
                    player.setCODE(5);
                    break;}
                case 3:{player.setName(a);
                    player.setATK(5);
                    player.setHP(5);
                    player.setDEF(5);
                    player.setCODE(10);
                    break;}
                default:{zy=true;
                    System.out.println("请输入正确的序号");
                    System.out.println("-------------------------------------------------------");}
            }
            System.out.println("您的属性为(随机):");
            player.getInformation();
        }while (zy);
        ArrayList<Npc> list = new ArrayList<Npc>();
        list.add(player);
        list.add(monster1);
        list.add(monster2);
        list.add(monster3);
        list.add(monster4);

        System.out.println("按回车开始战斗");
        new Scanner(System.in).nextLine();
boolean battle=true;
        int t=1;
        do {Npc[] m = new Npc[list.size()];

            list.toArray(m);
            System.out.println("第"+t+"回合");
            for (int i=0;i<list.size();i++){
                System.out.println(i+1);
                list.get(i).getInformation();
            }

            System.out.println("请选择攻击目标");
            int b=sc.nextInt();
            if (b>list.size()|b<=1){
                System.out.println("请输入正确的序号");
                sc.next();
                continue;
            }
            playerAtk(player,list.get(b-1),m,t+3);
            for (int i=1;i<list.size();++i){

                if (list.get(i).getHP()<=0){
                    System.out.println(list.get(i).getName()+"死了");
                    list.remove(i);
                i=1;

                }

            }

            if (list.size()==1){
                System.out.println("游戏结束，你赢了");
                break;
            }
            for (int i=1;i<list.size();i++){
                monsterAtk(list.get(i),player,m);
                if (player.getHP()<=0){
                    System.out.println(player.getName()+"死了");
                    System.out.println("游戏结束，你输了");
                    battle=false;
                    break;

                }
            }

t++;
        }while (battle);



}}
