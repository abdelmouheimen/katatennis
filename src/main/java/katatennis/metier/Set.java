package katatennis.metier;

import org.apache.log4j.Logger;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Set {

	final static Logger logger = Logger.getLogger(Set.class);
	private String score;
	private Game game;

}
