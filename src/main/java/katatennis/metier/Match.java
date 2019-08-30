package katatennis.metier;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Match {
	final static Logger logger = Logger.getLogger(Match.class);
	private Map<String, String> sets;
	private Set set;
	
	public Match(Set set) {
		super();
		this.sets = new LinkedHashMap<String, String>();
		this.set = set;
	}

	
}
