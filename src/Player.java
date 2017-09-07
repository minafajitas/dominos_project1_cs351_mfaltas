public class Player
{
    int playerId;
    Bundle hand;

    public Player(int playerId, Bundle hand)
    {
        this.playerId = playerId;
        this.hand = hand;
    }

    public Bundle getHand() {
        return hand;
    }

    public int getPlayerId()
    {
        return playerId;
    }
}