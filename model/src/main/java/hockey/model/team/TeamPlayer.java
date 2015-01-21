package hockey.model.team;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@IdClass(TeamPlayer.TeamPlayerId.class)
public class TeamPlayer {

    @Id
    private Team team;

    @Id
    private Player player;
    
    public static class TeamPlayerId implements Serializable{
        private static final long serialVersionUID = 1L;

        private long team;
        
        private long player;

        public TeamPlayerId() {
            super();
        }

        public TeamPlayerId(Team team, Player player) {
            this();
            this.team = team.getId();
            this.player = player.getId();
        }

        public long getTeam() {
            return team;
        }

        public void setTeam(long team) {
            this.team = team;
        }

        public long getPlayer() {
            return player;
        }

        public void setPlayer(long player) {
            this.player = player;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + (int) (player ^ (player >>> 32));
            result = prime * result + (int) (team ^ (team >>> 32));
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            TeamPlayerId other = (TeamPlayerId) obj;
            if (player != other.player)
                return false;
            if (team != other.team)
                return false;
            return true;
        }
        
        
    }
}