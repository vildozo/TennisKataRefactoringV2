
public class TennisSinglesGame implements TennisGame
{
    public int player1Points = 0;
    public int player2Points = 0;
    
    
    public String player1LiteralScore = "";
    public String player2LiteralScore = "";
    private String player1Name;
    private String player2Name;
    public String score = "";

    public TennisSinglesGame(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
        this.score = "";
    }

    public String getScore(){
    	tiedScores();    
    	literalScoreForPlayerWinningOtherNone();
        literalOfDifferentScoresThatAreBelowOrEqualToForty();        
        advantageScoreForPlayer();
        gameForPlayer();
        return score;
    }
    
    public boolean isGame(int pointsPlayer1, int pointsPlayer2){
    	return (pointsPlayer2>=4 && pointsPlayer1>=0 && (pointsPlayer2-pointsPlayer1)>=2);	
    }
    
    private void gameForPlayer(){
    	if (isGame(player1Points,player2Points))
    		score = "Win for player2";
    	if (isGame(player2Points,player1Points))
    		score = "Win for player1";
    }

	private boolean isAdvantage(int pointsPlayer1, int pointsPlayer2){
		return (pointsPlayer2 > pointsPlayer1 && pointsPlayer1 >= 3);		
	}
	
	private void advantageScoreForPlayer(){
		if ( isAdvantage(player1Points, player2Points) )
			score = "Advantage player2";
		if ( isAdvantage(player2Points, player1Points) )
			score = "Advantage player1";
	}

	private void literalOfDifferentScoresThatAreBelowOrEqualToForty(){
		if (player1Points!=player2Points && player1Points < 4 && player2Points < 4)
        {
			player1LiteralScore = literalScore(player1Points);
			player2LiteralScore = literalScore(player2Points);
            score = player1LiteralScore + "-" + player2LiteralScore;
        }		
	}
	
	public String literalScore(int playerPoints){
		String literal = "";
		if (playerPoints==0)
			literal = "Love";
		if (playerPoints==1)
			literal = "Fifteen";
        if (playerPoints==2)
        	literal = "Thirty";
        if (playerPoints==3)
        	literal = "Forty";
        return literal;
	}
	
	private void literalScoreForPlayerWinningOtherNone() {
		if ((player1Points != player2Points)&&(player2Points ==0 || player1Points==0))
        {
			if(player1Points>player2Points)
			{
				player1LiteralScore = literalScore(player1Points);
                player2LiteralScore = "Love";
			}
			else
			{
				player2LiteralScore = literalScore(player2Points);
                player1LiteralScore = "Love";
			}	
            score = player1LiteralScore + "-" + player2LiteralScore;
        }
 	}

	private void tiedScores(){
		if (player1Points == player2Points)
        {
			if( player1Points < 4)
			{
	            score = literalScore(player1Points);
	            score += "-All";
	        }
			if( player1Points >= 3)
				score = "Deuce";
        }
	}
	    
    public void P1Score(){
        player1Points++;
    }
    
    public void P2Score(){
        player2Points++;
    }

    public void wonPoint(String player) {
        if (player == "player1")
            P1Score();
        else
            P2Score();
    }
}