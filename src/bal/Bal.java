/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bal;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author TUYANDRE
 */
public class Bal {

        Map<String, Team> teams=new HashMap<>();
        Map<String, Player> plays=new HashMap<>();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scanner = new Scanner(System.in);
        System.out.println("urakaza neza kuri System Ya Basketbool Africa League");
        Bal league =new Bal();
        System.out.println("hitamo amahitamo yawe:\n 1:Kwinjizamo Ikipe \n 2:Kwinjiza Umukinnyi \n 3:Gukina \n 4:Gusoza irushanwa \n 5: Umukinnyi witwaye Neza \n 6:Exit");
        int choice=scanner.nextInt();
        switch(choice) {
           case 1:
            league.addTeam();
        break;
        case 2:
             league.addplayer();
        break;
        case 3:
           league.playGame();
            break;
        case 4:
            league.finishGame();
        case 5:
            
            league.bestPlayer();
            System.exit(0);
            break;
        case 6:
            league.finishGame();
           System.exit(0);
            break;
        
        default:
        
         
        }
        
    }
    public void finishGame(){
        System.out.println("Izina ryikipe"+"\t"+"Amanota");
        for (String j : teams.keySet()) {
           System.out.println(teams.get(j).tname+"\t"+teams.get(j).getMarks()); 
        }
        
    }
    public void bestPlayer(){
        Player ps=new Player();
        int mark=0;
        for (String j : plays.keySet()) {
            if(plays.get(j).getMark()>mark){
                mark=plays.get(j).getMark();
                ps=plays.get(j);
            }
        }
        System.out.println("Best Player:");
        System.out.println(ps.pname+" "+"afite amanota:"+ps.getMark()+" "+"Akinira ikipe ifite code:"+ps.teamCode);
        
    }
    public void addTeam(){
        Scanner scanner = new Scanner(System.in);
        String tname,tcode;
         System.out.println("Injiza izina ryikipe");
         tname=scanner.nextLine();
         System.out.println("Injiza Code yikipe");
         tcode=scanner.nextLine();
         Team t=new Team(tname,tcode);
         teams.put(tcode, t);
         
    }
    public void playGame(){
        Scanner scanner = new Scanner(System.in);
        String team1,team2;
        int mark1,mark2;
        if(teams.size()<2){
            System.out.println("Banza winjizemo amakipe ahagije nibura hejur ya 2");
        }else{
            System.out.println("Injiza Code yikipe yambere");
            team1=scanner.nextLine();
            Team getC1 = (Team)teams.get(team1);
            if(getC1==null){
                System.out.println("Iyi code nta kipe bihura ongera ukine");
                playGame();
            }
            System.out.println("Injiza Code yikipe ya kabiri");
            team2=scanner.nextLine();
            Team getC2 = (Team)teams.get(team2);
            if(getC2==null){
                System.out.println("Iyi code nta kipe bihura ongera ukine");
                playGame();
            }
            System.out.println("Injiza amanota yikimbe ya mbere");
            mark1=scanner.nextInt();
            getC1.setMark(mark1);
            System.out.println("Injiza amanota yikimbe ya kabiri");
            mark2=scanner.nextInt();
            getC2.setMark(mark2);
            System.out.println("Ugiye kwinjiza abakinnyi namanota batsinze");
            int choice;
            System.out.println("kwandika undi mukinnyi andika 1 gukomeza 0");
            choice=scanner.nextInt();
            if(choice==1){
                playerMark();
            }
            
        }
    }
    public void playerMark(){
        System.out.println("Injiza code yumukinnyi");
        Scanner scanner = new Scanner(System.in);
        String player;
        int mark;
        player=scanner.nextLine();
            Player play = (Player)plays.get(player);
            if(play==null){
                System.out.println("uy mukinnyi ntawe dufite ongera");
                playerMark();
            }
            System.out.println("Injiza amanota umukinnyi yatsinze");
            mark=scanner.nextInt();
            play.setMark(mark);
            
    }
    public void addplayer(){
        Scanner scanner = new Scanner(System.in);
        String pname,pcode,tcode;
         System.out.println("Injiza izina ryumukinnyi");
         pname=scanner.nextLine();
         System.out.println("Injiza Code yumukinnyi");
          pcode=scanner.nextLine();
         System.out.println("Injiza Code yikipe");
         tcode=scanner.nextLine();
         Player p=new Player(pname,pcode,tcode);
         plays.put(pcode, p);
         
    }
   public class Player{
    int marks;
//    double avg;
    String pname,pcode,teamCode;
    
    Player(){
        this.pname="";
        this.pcode="";
        this.teamCode="";
        this.marks=0;
    }
    Player(String name,String pcode,String tcode){
        this.pname=name;
        this.pcode=pcode;
        this.teamCode=tcode;
        this.marks=0;
    }
    public void setname(String m){
       this.pname =m;
   }
     public void setCode(String m){
       this.pcode =m;
   }
      
     
    public int getMark(){
        return this.marks;
    }
    public void setMark(int mark){
        this.marks +=mark;
    }
}
   public class Team{
       int marks;
//    double avg;
    String tname,teamCode;
   
   Team(String name,String code){
       this.tname=name;
       this.teamCode=code;
       this.marks=0;
   }
   public void setMark(int m){
       this.marks +=m;
   }
   
   public int getMarks(){
       return this.marks;
   }
}
}





