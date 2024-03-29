import java.util.*;

class Player
{
    private String name;
    private ArrayList<Piece> captured;
    Player(String name)
    {
        this.name=name;
        this.captured=new ArrayList<>();
    }
    String getName()
    {
        return this.name;
    }
    ArrayList<Piece> getCaptured()
    {
        return captured;
    }
    void capturePiece(Piece p)
    {
        this.captured.add(p);
    }
    void remove_captured(Piece p)
    {
        captured.remove(p);
    }
    void print_win_message(String reason)
    {
        System.out.println(this.name+" player wins."+reason);
    }
    void print_captured_list()
    {
        System.out.print("Captures "+this.name+": ");
        for(Piece p : captured)
        {
            System.out.print(p+" "); //Remember to change case of captured while adding to this list
        }
        System.out.println();
    }
    boolean piece_in_promote_row(Position pos)
    {
        int y = pos.getY();
        if(this.name.equals("UPPER") && y==0)
        {
            return true;
        }
        else return this.name.equals("lower") && y == 4;
    }
    Piece captured_piece(String name)
    {

        for(Piece p : this.captured)
        {
            String str=p.toString().toLowerCase();
            if(name.charAt(0)==str.charAt(0))
            {
                return p;
            }
        }
        return null;
    }

    ArrayList<Position> all_possible_moves(Board b)
    {
        Set<Position> set = new LinkedHashSet<>();
        ArrayList<Position> all_moves;
        for(int i=0;i<5;i++)
        {
            for(int j=0;j<5;j++)
            {
                Piece temp =b.getPiece(i,j);
                Position p = new Position(i,j);
                if(temp==null)
                {
                    continue;
                }
                if(temp.belongsTo(this))
                {
                    temp.generateMoves(b,p);
                    all_moves=temp.all_moves();
                    set.addAll(all_moves);
                }
            }
        }
        return new ArrayList<>(set);
    }
}
