package com.twilightimperium.expansioncommand.application.startbattle;

public class StartBattleResponse {
    private final String winner;
    private final String message;

    public StartBattleResponse(String winner, String message) {
        this.winner = winner;
        this.message = message;
    }

    public String getWinner() {
        return winner;
    }

    public String getMessage() {
        return message;
    }
}