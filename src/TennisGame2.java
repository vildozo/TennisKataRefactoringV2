
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
        literalScorePlayer1WinningOverNone();
        literalScorePlayer2WinningOverNone();
        
        player1IsWinningAndScoreLessThanOrEqual40();
        player2IsWinningAndScoreLessThanOrEqual40();
        
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

	private void player2IsWinningAndScoreLessThanOrEqual40() {
		if (player2Points>player1Points && player2Points < 4)
        {
            if (player2Points==2)
                player2LiteralScore="Thirty";
            if (player2Points==3)
                player2LiteralScore="Forty";
            if (player1Points==1)
                player1LiteralScore="Fifteen";
            if (player1Points==2)
                player1LiteralScore="Thirty";
            score = player1LiteralScore + "-" + player2LiteralScore;
        }
		 
	}

	private void player1IsWinningAndScoreLessThanOrEqual40() {
		if (player1Points>player2Points && player1Points < 4)
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
	
	
	
	private void literalScorePlayer2WinningOverNone() {
		if (player2Points > 0 && player1Points==0)
        {
            player2LiteralScore = literalScore(player2Points);
                        
            player1LiteralScore = "Love";
            score = player1LiteralScore + "-" + player2LiteralScore;
        }
 	}

	private void literalScorePlayer1WinningOverNone() {
		if (player1Points > 0 && player2Points==0)
        {
			player1LiteralScore = literalScore(player1Points);

            
            player2LiteralScore = "Love";
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