
public class TennisGame2 implements TennisGame
{
    public int player1Points = 0;
    public int player2Points = 0;
    public String score = "";
    
    public String player1LiteralScore = "";
    public String player2LiteralScore = "";
    private String player1Name;
    private String player2Name;
    

    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
        this.score = "";
    }

    public String getScore(){
    	tiedScores();    
    	literalScorePlayerWinningOtherNone();
        literalOfDifferentScoresAndBelowOrEqualToForty();
        
        advantagePlayer1();
        advantagePlayer2();
       
        gameForPlayer1();
        gameForPlayer2();
        return score;
    }
    
	private void gameForPlayer2() {
		if (player2Points>=4 && player1Points>=0 && (player2Points-player1Points)>=2)
        {
            score = "Win for player2";
        }
		
	}

	private void gameForPlayer1() {
		if (player1Points>=4 && player2Points>=0 && (player1Points-player2Points)>=2)
        {
            score = "Win for player1";
        }
		
	}

	private void advantagePlayer2() {
		if (player2Points > player1Points && player1Points >= 3)
        {
            score = "Advantage player2";
        }
		 
	}

	private void advantagePlayer1() {
		if (player1Points > player2Points && player2Points >= 3)
        {
            score = "Advantage player1";
        }
		 
	}

	

	private void literalOfDifferentScoresAndBelowOrEqualToForty()
	{
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
	
	private void literalScorePlayerWinningOtherNone() {
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
	
	
    
    public void SetP1Score(int number){
        
        for (int i = 0; i < number; i++)
        {
            P1Score();
        }
            
    }
    
    public void SetP2Score(int number){
        
        for (int i = 0; i < number; i++)
        {
            P2Score();
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