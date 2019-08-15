package com.srikanth.fullstackjava;

public class Player {
	private String PlayerId;
	private String PlayerName;
	private Country country;

	public String getPlayerId() {
		return PlayerId;
	}

	public void setPlayerId(String playerId) {
		PlayerId = playerId;
	}

	public String getPlayerName() {
		return PlayerName;
	}

	public void setPlayerName(String playerName) {
		PlayerName = playerName;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

}
